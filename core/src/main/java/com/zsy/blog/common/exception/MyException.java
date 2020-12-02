package com.zsy.blog.common.exception;

import com.zsy.blog.common.exception.enums.ErrorEnum;
import lombok.Data;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 17:17
 */
@Data
public class MyException extends RuntimeException{
    private int code = 500;
    private String message;

    public MyException(ErrorEnum errorEnum, Throwable throwable) {
        super(errorEnum.getMessage(),throwable);
        this.code=errorEnum.getCode();
        this.message=errorEnum.getMessage();
    }

    public MyException(){
        super(ErrorEnum.UNKNOWN.getMessage());
        this.message=ErrorEnum.UNKNOWN.getMessage();
    }

    public MyException(ErrorEnum errorEnum){
        this.code=errorEnum.getCode();
        this.message=errorEnum.getMessage();
    }

    public MyException(String exception){
        this.message=exception;
    }
}
