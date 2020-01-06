package com.baomidou.test.user.controller;


import com.baomidou.test.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-26
 */
@Controller
@RequestMapping("/user/user")
public class UserController{

    @Autowired
    UserService userService;


}
