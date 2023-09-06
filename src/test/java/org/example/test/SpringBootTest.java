package org.example.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.boot.test.context.SpringBootTest
public class SpringBootTest {

    @Autowired
    private JwtHelper jwtHelper;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        //生成 传入用户标识
        String token = jwtHelper.createToken(1L);
        System.out.println("token = " + token);

        //解析用户标识
        int userId = jwtHelper.getUserId(token).intValue();
        System.out.println("userId = " + userId);

        //校验是否到期! false 未到期 true到期
        boolean expiration = jwtHelper.isExpiration(token);
        System.out.println("expiration = " + expiration);
    }
    @Test
    public void test_2(){
      /*  List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);*/
        /*QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> eq = userQueryWrapper.eq("uid", 1);
        userMapper.selectOne(eq);*/
        /*QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",1);*/

        User user = userMapper.selectById(2);
        System.out.println(user);
     /*   User user = new User();
        user.setUserPwd("123");
        user.setUsername("aaa");
        user.setNickName("AAA");
        userMapper.insert(user);*/

    }


}