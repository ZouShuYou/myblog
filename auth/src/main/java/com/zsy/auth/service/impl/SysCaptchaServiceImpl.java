package com.zsy.auth.service.impl;

import com.zsy.auth.service.SysCaptchaService;

import java.awt.image.BufferedImage;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 11:28
 */
public class SysCaptchaServiceImpl implements SysCaptchaService {
    @Override
    public BufferedImage getCaptcha(String uuid) {
        return null;
    }

    @Override
    public Boolean validate(String uuid, String code) {
        return null;
    }
}
