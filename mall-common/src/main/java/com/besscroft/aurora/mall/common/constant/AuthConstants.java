package com.besscroft.aurora.mall.common.constant;

/**
 * 权限相关常量
 *
 * @Author Besscroft
 * @Date 2021/2/4 17:31
 */
public interface AuthConstants {

    /**
     * 认证信息Http请求头
     */
    String JWT_TOKEN_HEADER = "Authorization";

    /**
     * 用户信息Http请求头
     */
    String USER_TOKEN_HEADER = "user";

    /**
     * JWT令牌前缀
     */
    String JWT_TOKEN_PREFIX = "Bearer ";

    /**
     * JWT存储权限前缀
     */
    String AUTHORITY_PREFIX = "ROLE_";

    /**
     * JWT存储权限属性
     */
    String JWT_AUTHORITIES_KEY = "authorities";

    /**
     * 后台管理接口路径匹配
     */
    String ADMIN_URL_PATTERN ="/mall-admin/**" ;

    /**
     * Redis缓存权限规则key
     */
    String PERMISSION_RULES_KEY = "auth:permission:rules";

    /**
     * 后台管理client_id
     */
    String ADMIN_CLIENT_ID = "admin-app";

    /**
     * 前台商城client_id
     */
    String PORTAL_CLIENT_ID = "mall-app";

    /**
     * 密码加密方式
     */
    String BCRYPT = "{bcrypt}";

    String JWT_USER_ID_KEY = "id";

    String JWT_CLIENT_ID_KEY = "client_id";

}
