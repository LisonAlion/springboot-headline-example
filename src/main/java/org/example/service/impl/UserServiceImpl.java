package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 86193
* @description 针对表【news_user】的数据库操作Service实现
* @createDate 2023-09-04 10:41:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




