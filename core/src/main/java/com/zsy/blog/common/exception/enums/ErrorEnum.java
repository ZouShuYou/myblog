package com.zsy.blog.common.exception.enums;

import lombok.Getter;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 17:19
 */
@Getter
public enum  ErrorEnum {

    NO_UUID(503,"uuid为空"),
    UNKNOWN(500,"系统内部错误，请联系管理员"),



    //登录模块错误
    LOGIN_FAIL(10001,"登录失败"),
    CAPTCHA_WRONG(10002,"验证码错误"),
    USERNAME_OR_PASSWORD_WRONG(10003,"用户名或密码错误"),



    TOKEN_GENERATOR_ERROR(502,"token生成失败");

    private ErrorEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;


}
