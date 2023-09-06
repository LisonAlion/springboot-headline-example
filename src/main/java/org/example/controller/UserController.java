package org.example.controller;

import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.service.UserService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 86193
 * @version 1.0
 * @description: TODO
 * @date 2023/9/4 15:10
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        Result result = userService.login(user);
        return result;
    }

    /*
     * 大概流程:
     *    1.获取token,解析token对应的userId
     *    2.根据userId,查询用户数据
     *    3.将用户数据的密码置空,并且把用户数据封装到结果中key = loginUser
     *    4.失败返回504 (本次先写到当前业务,后期提取到拦截器和全局异常处理器)
     * */
    @GetMapping("/getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {
        Result result = userService.getUserInfo(token);
        return result;
    }

    /**
     * 实现步骤:
     * *   1. 获取账号数据
     * *   2. 根据账号进行数据库查询
     * *   3. 结果封装
     *
     * @param username
     * @return
     */
    @PostMapping("/checkUserName")
    public Result checkUserName(String username) {
        Result result = userService.checkUserName(username);
        return result;
    }
    @PostMapping("/regist")
    public Result regist(@RequestBody User user){
        Result result = userService.regist(user);
        return result;
    }
}
