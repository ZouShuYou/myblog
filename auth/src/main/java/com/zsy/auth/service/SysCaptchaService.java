package com.zsy.auth.service;

import java.awt.image.BufferedImage;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 11:26
 */
public interface SysCaptchaService {

    BufferedImage getCaptcha(String uuid);

    Boolean validate(String uuid,String code);
}
