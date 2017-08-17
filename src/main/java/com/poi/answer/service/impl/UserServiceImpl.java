package com.poi.answer.service.impl;

import com.poi.answer.bo.User;
import com.poi.answer.dao.UserDao;
import com.poi.answer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> searchAll() {
        return this.userDao.searchAll();
    }
}
