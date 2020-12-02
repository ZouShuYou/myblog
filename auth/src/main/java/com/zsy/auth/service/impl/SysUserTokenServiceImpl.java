package com.zsy.auth.service.impl;

import com.zsy.auth.TokenGenerator;
import com.zsy.auth.service.SysUserTokenService;
import com.zsy.blog.common.Result;
import com.zsy.blog.common.constants.RedisKeyConstants;
import com.zsy.blog.common.util.RedisUtils;
import com.zsy.blog.entity.sys.SysUserToken;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 11:28
 */
public class SysUserTokenServiceImpl implements SysUserTokenService {
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    RedisUtils redisUtils;


    @Override
    public Result createToken(Integer userId) {
        String token = TokenGenerator.generateValue();

        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;

        String tokenInRedis = redisUtils.get(userIdKey);
        if (!StringUtils.isEmpty(tokenInRedis)){
            redisUtils.delete(RedisKeyConstants.MANAGE_SYS_USER_TOKEN+tokenInRedis);
        }
        redisUtils.set(tokenKey,userId,EXPIRE);
        redisUtils.set(userIdKey,token,EXPIRE);
        return new Result().put("token",token).put("expire",EXPIRE);
    }

    @Override
    public SysUserToken queryByToken(String token) {
        String userId = redisUtils.get(token);
        if (StringUtils.isEmpty(userId)){
            return null;
        }
        SysUserToken sysUserToken = new SysUserToken();
        sysUserToken.setToken(token);
        sysUserToken.setUserId(Integer.parseInt(userId));
        return sysUserToken;
    }

    @Override
    public void logout(Integer userId) {
        String userIdKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;
        String token = redisUtils.get(userIdKey);
        String tokenKey = RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;

        redisUtils.delete(userIdKey);
        redisUtils.delete(tokenKey);
    }

    @Override
    public void refreshToken(Integer userId, String token) {
        String tokenKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+token;
        String userIdKey= RedisKeyConstants.MANAGE_SYS_USER_TOKEN+userId;
        redisUtils.updateExpire(tokenKey);
        redisUtils.updateExpire(userIdKey);
    }
}
