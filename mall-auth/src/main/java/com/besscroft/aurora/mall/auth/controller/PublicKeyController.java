package com.besscroft.aurora.mall.auth.controller;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @Author Besscroft
 * @Date 2021/2/17 22:37
 */
@Api(tags = "公钥获取接口")
@RestController
@RequestMapping("/publicKey")
public class PublicKeyController {

    @Autowired
    private KeyPair keyPair;

    /**
     * https://spring.io/guides/tutorials/spring-boot-oauth2/#_social_login_authserver
     * @return
     */
    @GetMapping("/get")
    public Map<String, Object> loadPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return new JWKSet(key).toJSONObject();
    }

}
