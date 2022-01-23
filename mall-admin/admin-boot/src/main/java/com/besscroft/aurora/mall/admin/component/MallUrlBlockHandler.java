package com.besscroft.aurora.mall.admin.component;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2022/1/22 20:19
 */
@Component
public class MallUrlBlockHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, BlockException e) throws Exception {
        httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
        String message = "{\"code\":999,\"message\":\"您的访问太频繁啦！请稍后再试！\"}";
        httpServletResponse.getWriter().write(message);
    }

}
