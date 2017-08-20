package com.poi.answer.service.impl;

import com.poi.answer.bo.Permission;
import com.poi.answer.bo.SysUser;
import com.poi.answer.dao.PermissionDao;
import com.poi.answer.dao.UserDao;
import com.poi.answer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/20.
 */
@Service
public class CustomUserService implements UserDetailsService,IUserService { //自定义UserDetailsService 接口

    @Autowired
    UserDao userDao;
    @Autowired
    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        if (user != null) {
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getPermissionName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUserName(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
    @Override
    public List<SysUser> searchAll() {
        return this.userDao.searchAll();
    }
}
