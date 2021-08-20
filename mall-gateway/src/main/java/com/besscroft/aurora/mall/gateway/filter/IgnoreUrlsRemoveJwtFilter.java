package com.besscroft.aurora.mall.gateway.filter;

import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.gateway.config.IgnoreUrlsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

/**
 * 白名单路径移除JWT请求头
 *
 * @Author Besscroft
 * @Date 2021/2/4 20:32
 */
@Component
public class IgnoreUrlsRemoveJwtFilter implements WebFilter {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        URI uri = request.getURI();
        PathMatcher pathMatcher = new AntPathMatcher();
        // 白名单路径移除JWT请求头
        List<String> urls = ignoreUrlsConfig.getUrls();
        for (String url: urls) {
            // 退出登录不移除请求头
            if (pathMatcher.match("/mall-admin/user/logout", uri.getPath())) {
                return webFilterChain.filter(serverWebExchange);
            }
            if (pathMatcher.match(url, uri.getPath())) {
                request = serverWebExchange.getRequest().mutate().header(AuthConstants.JWT_TOKEN_HEADER, "").build();
                serverWebExchange = serverWebExchange.mutate().request(request).build();
                return webFilterChain.filter(serverWebExchange);
            }
        }
        return webFilterChain.filter(serverWebExchange);
    }

}
