package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Api(tags = "登录接口")
@RestController
public class LoginController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @ApiOperation(value="用户密码登录", notes="传递user对象：username, password",httpMethod = "GET")
    @ApiResponses({@ApiResponse(code = 1, message = "成功"), @ApiResponse(code = 0, message = "失败")})
    @GetMapping("login")
    public User login(User user){
        log.info(user.getUserName() + ": 请求登录！");
        user.setPassword(MD5.md516(user.getPassword()));
        User userInfo = userService.query(user.getUserName());
        log.info(userInfo == null? "找不到用户" : userInfo.toString() + "密码为：" + user.getPassword());
        return userInfo;
    }


}
