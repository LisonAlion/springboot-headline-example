package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.vo.PortalVO;
import org.example.mapper.HeadlineMapper;
import org.example.service.HeadlineService;
import org.example.service.TypeService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 86193
 * @version 1.0
 * @description: TODO
 * @date 2023/9/5 17:18
 */
@RestController
@RequestMapping("portal")
@CrossOrigin
@Slf4j
public class PortalController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private HeadlineService headlineService;
    /**
     * 查询全部类别信息
     * @return
     */
    @GetMapping("/findAllTypes")
    public Result findAllTypes(){
        Result result = typeService.findAllTypes();
        return result;
    }
    @PostMapping("/findNewsPage")
    public Result findNewsPage(@RequestBody PortalVO portalVO){
        Result result = headlineService.findNewsPage(portalVO);
        return result;
    }
    @PostMapping("/showHeadlineDetail")
    public Result showHeadlineDetail( Integer hid){
        Result result = headlineService.showHeadlineDetail(hid);
        return result;
    }

}
