package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.example.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 86193
 * @description 针对表【news_user】的数据库操作Service实现
 * @createDate 2023-09-04 10:41:35
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;

    /**
     * 登录业务
     *
     * @param user
     * @return
     */
    public Result login(User user) {
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, user.getUsername());
        User loginUser = userMapper.selectOne(userLambdaQueryWrapper);
        if (loginUser == null) {
            return Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }
        //对比密码 不为空且相同
        if (!StringUtils.isEmpty(user.getUserPwd()) &&
                MD5Util.encrypt(user.getUserPwd()).equals(loginUser.getUserPwd())) {
            //登录成功
            //根据用户id生成token
            String token = jwtHelper.createToken(Long.valueOf(loginUser.getUid()));
            //将token封装到result中
            HashMap<Object, Object> data = new HashMap<>();
            data.put("token", token);

            return Result.ok(data);
        }

        return Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
    }

    /**
     * 根据token获取用户数据
     *
     * @param token
     * @return
     */
    public Result getUserInfo(String token) {
        boolean expiration = jwtHelper.isExpiration(token);
        if (expiration) {
            //登录过期
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }
        //2.获取token对应的用户
        int userId = jwtHelper.getUserId(token).intValue();
        //3.查询数据
        User user = userMapper.selectById(userId);

        if(user!=null){
            user.setUserPwd("******");
            Map data = new HashMap();
            data.put("loginUser",user);
            return Result.ok(data);
        }

        return Result.build(null,ResultCodeEnum.NOTLOGIN);
    }

    /**
     * 检查账号是否可以注册
     *
     * @param username 账号信息
     * @return
     */
    public Result checkUserName(String username) {
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(userQueryWrapper);
        /**
         * 账号名存在
         */
        if(user!=null){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        return Result.ok(null);
    }

    /**
     * 注册用户
     * @return
     */
    public Result regist(User user) {
        //判断用户名是否存在
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        /**
         * 查询表中是否有同名的用户
         */
        Long count = userMapper.selectCount(userLambdaQueryWrapper);
        //存在同名的用户
        if(count>0){
            return Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        //可以将用户插入表内
        //密码加密
        user.setUserPwd(MD5Util.encrypt(user.getUserPwd()));
        int insert = userMapper.insert(user);
        log.info("success添加用户数：{}",insert);
        return Result.ok(null);
    }


}




