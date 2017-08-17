package com.poi.answer.web;

import com.poi.answer.bo.User;
import com.poi.answer.dao.UserDao;
import com.poi.answer.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/16.
 */
@RestController
public class UserController {
    @Resource(name="userService")
    private IUserService userService;

    @RequestMapping("/user")
    public List<User> searchAll(){
        return this.userService.searchAll();
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
}
