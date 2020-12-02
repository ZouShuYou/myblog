package com.zsy.auth.service.impl;

import com.google.code.kaptcha.Producer;
import com.zsy.auth.service.SysCaptchaService;
import com.zsy.blog.common.constants.RedisKeyConstants;
import com.zsy.blog.common.exception.MyException;
import com.zsy.blog.common.exception.enums.ErrorEnum;
import com.zsy.blog.common.util.RedisUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.image.BufferedImage;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 11:28
 */
public class SysCaptchaServiceImpl implements SysCaptchaService {

    @Autowired
    private Producer producer;

    @Autowired
    private RedisUtils redisUtils;

    /**  验证码过期时长5秒 */
    public final static long CAPTCHA_EXPIRE = 60 * 5;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isEmpty(uuid)){
            throw new MyException(ErrorEnum.NO_UUID);
        }
        String code = producer.createText();
        redisUtils.set(genRedisKey(uuid),code,CAPTCHA_EXPIRE);
        return producer.createImage(code);
    }

    private String genRedisKey(String uuid) {
        return RedisKeyConstants.MANAGE_SYS_CAPTCHA+uuid;
    }

    @Override
    public Boolean validate(String uuid, String code) {
        if (StringUtils.isEmpty(uuid) || StringUtils.isEmpty(code)){
            return false;
        }
        String redisKey = genRedisKey(uuid);
        String captchaCode = redisUtils.get(redisKey);

        redisUtils.delete(redisKey);
        if (code.equalsIgnoreCase(captchaCode)){
            return true;
        }
        return false;
    }
}
