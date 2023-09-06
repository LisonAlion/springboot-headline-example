package org.example.service;

import org.example.entity.Headline;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.vo.PortalVO;
import org.example.utils.Result;

/**
* @author 86193
* @description 针对表【news_headline】的数据库操作Service
* @createDate 2023-09-04 10:41:35
*/
public interface HeadlineService extends IService<Headline> {
    /**
     * 首页数据查询
     * @param portalVO
     * @return
     */
    Result findNewsPage(PortalVO portalVO);
}
