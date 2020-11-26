package com.zsy.auth;

import com.zsy.auth.service.ShiroService;
import com.zsy.blog.entity.sys.SysUser;
import com.zsy.blog.entity.sys.SysUserToken;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Set;

/**
 *
 * @Description
 * @author zousy
 * @version v1.0
 * @date  2020-11-24 16:41
 */
@Component(value = "oAuth2Realm")
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser sysUser = (SysUser) principalCollection.getPrimaryPrincipal();
        Integer userId = sysUser.getUserId();

        Set<String> permsSet = shiroService.getUserPermissons(userId);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permsSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();

        SysUserToken sysUserToken = shiroService.queryByToken(accessToken);

        if (sysUserToken == null){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        Integer userId = sysUserToken.getUserId();
        SysUser sysUser = shiroService.queryUser(userId);

        if (sysUser.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        shiroService.refreshToken(userId,accessToken);

        return new SimpleAuthenticationInfo(sysUser,accessToken,getName());
    }
}
