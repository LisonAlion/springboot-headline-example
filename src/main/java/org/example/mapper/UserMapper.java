package org.example.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.utils.Result;

/**
* @author 86193
* @description 针对表【news_user】的数据库操作Mapper
* @createDate 2023-09-04 10:41:35
* @Entity org.example.entity.User
*/
public interface UserMapper extends BaseMapper<User> {


}




