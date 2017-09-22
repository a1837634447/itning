package com.ning.itning.controller;

import com.ning.itning.entity.indexFrameWork.Index;
import com.ning.itning.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 主页框架类
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.controller
 * @date :   2017/9/21
 **/
@Controller
public class IndexFrameWork {

    private final IndexService indexService;

    @Autowired
    public IndexFrameWork(IndexService indexService) {
        this.indexService = indexService;
    }

    /**
     * 进入首页方法
     * @return 首页HTML名--java.lang.String
     * @author : ning
     * @date :   2017/9/21
     **/
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    /**
     * 框架数据获取方法
     * @author : ning
     * @return  JSON数据--com.ning.itning.entity.indexFrameWork.Index
     * @date :   2017/9/22
    **/
    @RequestMapping("/getIndexFrameWorkData")
    @ResponseBody
    public Index getIndexFrameWorkData() {
        return indexService.getIndexEntity();
    }
}
