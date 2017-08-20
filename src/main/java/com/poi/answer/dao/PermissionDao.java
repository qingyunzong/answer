package com.poi.answer.dao;

import com.poi.answer.bo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/8/17.
 */
@Mapper
public interface PermissionDao {
    public List<Permission> findAll();
    public List<Permission> findByAdminUserId(long userId);
}
