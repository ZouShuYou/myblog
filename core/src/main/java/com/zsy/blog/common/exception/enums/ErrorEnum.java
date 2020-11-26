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


    UNKNOWN(500,"系统内部错误，请联系管理员"),
    TOKEN_GENERATOR_ERROR(502,"token生成失败");

    private ErrorEnum(int code,String message){
        this.code = code;
        this.message = message;
    }
    private int code;
    private String message;


}
