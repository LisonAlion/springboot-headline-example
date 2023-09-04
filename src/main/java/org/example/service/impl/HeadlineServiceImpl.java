package org.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Headline;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.springframework.stereotype.Service;

/**
* @author 86193
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-09-04 10:41:35
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{

}




