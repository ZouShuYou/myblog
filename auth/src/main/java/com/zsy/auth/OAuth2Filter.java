package com.zsy.auth;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 18:54
 */
public class OAuth2Filter extends AuthenticatingFilter {


    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);

        if(org.springframework.util.StringUtils.isEmpty(token)){
            return null;
        }

        return new OAuth2Token(token);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }

    private String getRequestToken(HttpServletRequest servletRequest) {
        String token = servletRequest.getHeader("token");
        if (StringUtils.isEmpty(token)){
            token = servletRequest.getParameter("token");
        }
        return token;
    }
}
