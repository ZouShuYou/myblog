package com.zsy.auth.service.impl;

import com.zsy.auth.service.ShiroService;
import com.zsy.auth.service.SysUserTokenService;
import com.zsy.blog.common.constants.SysConstants;
import com.zsy.blog.entity.sys.SysMenu;
import com.zsy.blog.entity.sys.SysUser;
import com.zsy.blog.entity.sys.SysUserToken;
import com.zsy.blog.mapper.sys.SysMenuMapper;
import com.zsy.blog.mapper.sys.SysUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 17:17
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @Override
    public Set<String> getUserPermissons(Integer userId) {
        List<String> permsList;

        if (SysConstants.SysEnum.SUPER_ADMIN.id.equals(userId)){
            List<SysMenu> menuList = sysMenuMapper.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            menuList.forEach(menu -> permsList.add(menu.getPerms()));
        }else {
            permsList = sysUserMapper.queryAllPerms(userId);
        }
        return permsList.stream().filter( perms -> !StringUtils.isEmpty(perms))
                .flatMap(perms -> Arrays.stream(perms.split(",")))
                .collect(Collectors.toSet());
    }

    @Override
    public SysUserToken queryByToken(String token) {

        return null;
    }

    @Override
    public SysUser queryUser(Integer userId) {
        return null;
    }

    @Override
    public void refreshToken(Integer userId, String accessToken) {

    }
}
