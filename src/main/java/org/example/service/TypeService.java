package org.example.service;

import org.example.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.utils.Result;

/**
* @author 86193
* @description 针对表【news_type】的数据库操作Service
* @createDate 2023-09-04 10:41:35
*/
public interface TypeService extends IService<Type> {
    /**
     * 查询全部类别信息
     * @return
     */
    Result findAllTypes();
}
