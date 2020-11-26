package com.zsy.blog.entity.sys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.zsy.blog.common.validator.group.AddGroup;
import com.zsy.blog.common.validator.group.UpdateGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 16:56
 */

@Data
@ApiModel(value="SysUser对象", description="用户管理")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 1852171509186964945L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;


    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空" , groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    @ApiModelProperty(value = "用户密码")
    @NotBlank(message = "密码不能为空" , groups = {AddGroup.class})
    private String password;

    @ApiModelProperty(value = "用户邮箱")
    @NotBlank(message="邮箱不能为空", groups = {AddGroup.class, UpdateGroup.class})
    @Email(message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    @ApiModelProperty(value = "密码盐")
    private String salt;

    @ApiModelProperty(value = "创建者Id")
    @TableField(value = "create_user_id")
    private Integer createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    @ApiModelProperty(value = "0禁用，1正常")
    private Integer status;

    @TableField(exist=false)
    private List<Integer> roleIdList;
}
