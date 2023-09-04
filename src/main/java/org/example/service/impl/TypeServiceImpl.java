package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Type;
import org.example.service.TypeService;
import org.example.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author 86193
* @description 针对表【news_type】的数据库操作Service实现
* @createDate 2023-09-04 10:41:35
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




