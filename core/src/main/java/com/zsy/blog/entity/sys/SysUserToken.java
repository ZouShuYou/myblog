package com.zsy.blog.entity.sys;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 16:54
 */

@Data
@ApiModel(value = "SysUserToken对象",description = "系统用户Token")
public class SysUserToken implements Serializable {
    private static final long serialVersionUID = 9107033499132426965L;
    private Integer userId;

    private String token;
}
