package com.besscroft.aurora.mall.gateway.authorization;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.gateway.config.IgnoreUrlsConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import reactor.core.publisher.Mono;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Besscroft
 * @Date 2021/2/4 17:27
 */
@Slf4j
@Component
public class AuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> mono, AuthorizationContext authorizationContext) {
        ServerHttpRequest request = authorizationContext.getExchange().getRequest();
        String path = request.getURI().getPath();
        PathMatcher pathMatcher = new AntPathMatcher();

        log.info("访问路径:{}",path);

        // 对应跨域的预检请求直接放行
        if (request.getMethod() == HttpMethod.OPTIONS) {
            log.info("预检请求放行！");
            return Mono.just(new AuthorizationDecision(true));
        }

        // 白名单路径直接放行
        List<String> ignoreUrls = ignoreUrlsConfig.getUrls();
        for (String ignoreUrl : ignoreUrls) {
            if (pathMatcher.match(ignoreUrl, path)) {
                log.info("白名单路径放行！");
                return Mono.just(new AuthorizationDecision(true));
            }
        }

        // 非管理端路径无需鉴权直接放行
        if (!pathMatcher.match(AuthConstants.ADMIN_URL_PATTERN, path)) {
            log.info("非管理端路径无需鉴权放行！");
            return Mono.just(new AuthorizationDecision(true));
        }

        // token为空拒绝访问
        String token = request.getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
        if (StrUtil.isBlank(token)) {
            log.error("token为空拒绝访问！");
            return Mono.just(new AuthorizationDecision(false));
        }

        // 从Redis获取资源角色关系列表（即角色能访问的对应接口）
        Map<Object, Object> permissionRoles = redisTemplate.opsForHash().entries(AuthConstants.PERMISSION_RULES_KEY);
        Iterator<Object> iterator = permissionRoles.keySet().iterator();

        // 接口需要的角色权限集合authorities统计
        List<String> authorities = new ArrayList<>();
        while (iterator.hasNext()) {
            String pattern = (String) iterator.next();
            if (pathMatcher.match(pattern, path)) {
                authorities.addAll(Convert.toList(String.class, permissionRoles.get(pattern)));
            }
        }
        authorities = authorities.stream().map(i -> i = AuthConstants.JWT_TOKEN_PREFIX + i).collect(Collectors.toList());

        return mono
                .filter(Authentication::isAuthenticated)
                .flatMapIterable(Authentication::getAuthorities)
                .map(GrantedAuthority::getAuthority)
                .any(authorities::contains)
                .map(AuthorizationDecision::new)
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

}
