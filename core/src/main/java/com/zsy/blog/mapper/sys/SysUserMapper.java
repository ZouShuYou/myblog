package com.zsy.blog.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsy.blog.entity.sys.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 17:19
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<String> queryAllPerms(Integer userId);

    List<Integer> queryAllMenuId(Integer userId);

}
