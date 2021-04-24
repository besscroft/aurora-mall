package com.besscroft.aurora.mall.auth.controller;

import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.domain.Oauth2Token;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 参考文档：https://docs.spring.io/spring-security/oauth/apidocs/org/springframework/security/oauth2/provider/endpoint/TokenEndpoint.html
 *
 * https://github.com/spring-projects/spring-security/wiki/OAuth-2.0-Migration-Guide
 *
 * 这里也算是对TokenEndpoint包装了一层Controller
 * @Author Besscroft
 * @Date 2021/1/23 13:55
 */
@Slf4j
@Api(tags = "商城认证中心接口")
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenEndpoint tokenEndpoint;

    private Set<HttpMethod> allowedRequestMethods = new HashSet<>(Arrays.asList(HttpMethod.POST));

    @GetMapping("/oauth/token")
    public AjaxResult getAccessToken(
            Principal principal, @RequestParam Map<String, String> parameters)
            throws HttpRequestMethodNotSupportedException {

        if (!allowedRequestMethods.contains(HttpMethod.GET)) {
            throw new HttpRequestMethodNotSupportedException("GET");
        }
        return postAccessToken(principal, parameters);
    }

    @ApiOperation("OAuth2认证生成token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "grant_type", value = "授权模式", required = true),
            @ApiImplicitParam(name = "client_id", value = "Oauth2客户端ID", required = true),
            @ApiImplicitParam(name = "client_secret", value = "Oauth2客户端秘钥", required = true),
            @ApiImplicitParam(name = "refresh_token", value = "刷新token"),
            @ApiImplicitParam(name = "username", value = "登录用户名"),
            @ApiImplicitParam(name = "password", value = "登录密码")
    })
    @PostMapping("/oauth/token")
    public AjaxResult postAccessToken(
            @ApiIgnore Principal principal,
            @ApiIgnore @RequestParam Map<String, String> parameters
    ) throws HttpRequestMethodNotSupportedException {
        log.info("请求到了，parameters:{}",parameters);
        if (!(principal instanceof Authentication)) {
            throw new InsufficientAuthenticationException(
                    "There is no client authentication. Try adding an appropriate authentication filter.");
        }
        OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal, parameters).getBody();
        Oauth2Token oauth2Token = Oauth2Token.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(AuthConstants.JWT_TOKEN_PREFIX).build();
        log.info("生成的token:{}",oauth2Token);
        return AjaxResult.success(oauth2Token);
    }
}







