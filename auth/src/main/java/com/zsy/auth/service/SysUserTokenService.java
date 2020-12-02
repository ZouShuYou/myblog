package com.zsy.auth.service;

import com.zsy.blog.common.Result;
import com.zsy.blog.entity.sys.SysUserToken;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 19:18
 */
public interface SysUserTokenService {
    /**
     * 生成Token
     * @param userId
     * @return
     */
    Result createToken(Integer userId);

    /**
     * 查询token
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
