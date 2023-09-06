package org.example.entity.vo;

import lombok.Data;

/**
 * @author 86193
 * @version 1.0
 * @description: portal/findNewsPage请求参数
 * }
 * @date 2023/9/5 17:42
 */
@Data
public class PortalVO {
    private String keyWords;// 搜索标题关键字
    private int type =0;// 新闻类型
    private int pageNum =1;// 页码数
    private int pageSize =10;// 页大小

}
