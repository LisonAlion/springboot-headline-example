package org.example.service;

import org.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author 86193
* @description 针对表【news_user】的数据库操作Service
* @createDate 2023-09-04 10:41:35
*/
public interface UserService extends IService<User> {
    /**
     * 登录业务
     * @param user
     * @return
     */
    Result login(User user);

    /**
     * 根据token获取用户数据
     * @param token
     * @return
     */
    Result getUserInfo(String token);
    /**
     * 检查账号是否可以注册
     *
     * @param username 账号信息
     * @return
     */
    Result checkUserName(String username);

    Result regist(User user);
}
