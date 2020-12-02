package com.zsy.blog.common.base;

import com.zsy.blog.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-29 14:33
 */
public class AbstractController {

    protected SysUser getUser(){
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId(){
        return getUser().getUserId();
    }
}
