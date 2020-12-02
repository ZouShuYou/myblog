package com.zsy.blog.entity.operation;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-12-02 15:32
 */
@Data
@ApiModel(value="Tag对象", description="标签")
@TableName("tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = -9208292038273982523L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "标签名字")
    private String name;

    @ApiModelProperty(value = "所属类型：0文章，1阅读")
    private Integer type;
}
