package com.zsy.auth.controller;

import com.zsy.auth.service.SysCaptchaService;
import com.zsy.blog.common.Result;
import com.zsy.blog.entity.sys.form.SysLoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 17:30
 */
@RestController
public class SysLoginController {
    @Autowired
    SysCaptchaService sysCaptchaService;

    @PostMapping("/admin/sys/login")
    public Result login(@RequestBody SysLoginForm sysLoginForm){
        boolean captcha = sysCaptchaService.validate(sysLoginForm.getUuid(),sysLoginForm.getCaptcha());
        return null;
    }


}
