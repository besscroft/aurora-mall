package com.besscroft.aurora.mall.gateway.filter;

import cn.hutool.core.util.StrUtil;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.nimbusds.jose.JWSObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.text.ParseException;

/**
 * 全局token过滤器
 *
 * @Author Bess Croft
 * @Date 2021/1/25 15:55
 */
@Slf4j
@Component
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    /**
     * 过滤器
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = exchange.getRequest().getHeaders().getFirst(AuthConstants.JWT_TOKEN_HEADER);
//        if (exchange.getRequest().getURI().getPath().contains("/v2/api-docs")) {
//            // 放行
//            return chain.filter(exchange);
//        }
        log.info("请求进来了，打印token：{}", token);
        // hasEmpty只判断是否为null或者空字符串（""），hasBlank则会把不可见字符也算做空，isEmpty和isBlank同理。
        if (StrUtil.isBlank(token)) {
            return chain.filter(exchange);
        }
        try {
            String repToken = token.replace(AuthConstants.JWT_TOKEN_PREFIX, "");
            JWSObject jwsObject = JWSObject.parse(repToken);
            String user = jwsObject.getPayload().toString();
            log.info("token中获取的user为：{}", user);
            ServerHttpRequest request = exchange.getRequest().mutate().header(AuthConstants.USER_TOKEN_HEADER, user).build();
            exchange = exchange.mutate().request(request).build();
        } catch (ParseException e) {
            log.error(e.getMessage());
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器执行顺序，数值越小，优先级越高
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }

}
