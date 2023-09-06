package org.example.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.entity.Headline;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.vo.PortalVO;
import org.example.utils.Result;

import java.util.Map;

/**
 * @author 86193
 * @description 针对表【news_headline】的数据库操作Mapper
 * @createDate 2023-09-04 10:41:34
 * @Entity org.example.entity.Headline
 */
public interface HeadlineMapper extends BaseMapper<Headline> {
    //自定义分页查询方法
    IPage<Map> selectPageMap(IPage<Headline> page,
                             @Param("portalVO") PortalVO portalVO);

    /**
     * 分页查询头条详情
     * @param hid
     * @return
     */
    Map selectDetailMap(Integer hid);
}




