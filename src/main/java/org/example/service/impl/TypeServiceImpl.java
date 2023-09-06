package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Type;
import org.example.service.TypeService;
import org.example.mapper.TypeMapper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 86193
 * @description 针对表【news_type】的数据库操作Service实现
 * @createDate 2023-09-04 10:41:35
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    /**
     * 查询全部类别信息
     * @return
     */
    public Result findAllTypes() {
        //直接调用业务层,查询全部数据
        List<Type> types = typeMapper.selectList(null);

        return Result.ok(types);
    }
}




