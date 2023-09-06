package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.entity.Headline;
import org.example.entity.vo.PortalVO;
import org.example.service.HeadlineService;
import org.example.mapper.HeadlineMapper;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
* @author 86193
* @description 针对表【news_headline】的数据库操作Service实现
* @createDate 2023-09-04 10:41:35
*/
@Service
public class HeadlineServiceImpl extends ServiceImpl<HeadlineMapper, Headline>
    implements HeadlineService{
    @Autowired
    private HeadlineMapper headlineMapper;

    /**
     * 首页数据查询
     * @param portalVO
     * @return
     */
    public Result findNewsPage(PortalVO portalVO) {
        //1.条件拼接 需要非空判断
        LambdaQueryWrapper<Headline> headlineWrapper = new LambdaQueryWrapper<>();
        headlineWrapper.like(!StringUtils.isEmpty(portalVO.getKeyWords()),
                Headline::getTitle,portalVO.getKeyWords())
                .eq(portalVO.getType()!=0,Headline::getType,portalVO.getType());

        //2.分页参数
        IPage<Headline> page = new Page<>(portalVO.getPageNum(),portalVO.getPageSize());

        //3.分页查询
        //查询的结果 "pastHours":"3"   // 发布时间已过小时数 我们查询返回一个map
        //自定义方法
        headlineMapper.selectPageMap(page, portalVO);

        //4.结果封装
        //分页数据封装
        Map<String,Object> pageInfo =new HashMap<>();
        pageInfo.put("pageData",page.getRecords());
        pageInfo.put("pageNum",page.getCurrent());
        pageInfo.put("pageSize",page.getSize());
        pageInfo.put("totalPage",page.getPages());
        pageInfo.put("totalSize",page.getTotal());

        Map<String,Object> pageInfoMap=new HashMap<>();
        pageInfoMap.put("pageInfo",pageInfo);
        // 响应JSON
        return Result.ok(pageInfoMap);
    }
}




