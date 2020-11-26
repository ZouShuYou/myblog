package com.zsy.auth.service;

import com.zsy.blog.entity.sys.SysUser;
import com.zsy.blog.entity.sys.SysUserToken;

import java.util.Set;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 16:42
 */
public interface ShiroService {
    Set<String> getUserPermissons(Integer userId);

    SysUserToken queryByToken(String token);

    SysUser queryUser(Integer userId);

    void refreshToken(Integer userId, String accessToken);
}
