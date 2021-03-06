package com.poi.answer.dao;

import com.poi.answer.bo.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Mapper
public interface UserDao {
    public List<SysUser> searchAll();
    public SysUser findByUserName(String userName);
}
