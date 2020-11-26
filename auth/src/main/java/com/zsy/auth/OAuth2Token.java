package com.zsy.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 17:58
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
