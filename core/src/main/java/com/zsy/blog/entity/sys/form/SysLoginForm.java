package com.zsy.blog.entity.sys.form;

import lombok.Data;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-26 18:42
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
