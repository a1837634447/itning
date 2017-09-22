package com.ning.itning.controller;

import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Type;
import com.ning.itning.service.View_3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 视图三控制层
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.controller
 * @date :   2017/9/22
 **/
@RestController
public class View_3_Controller {
    private final View_3_Service view_3_service;

    @Autowired
    public View_3_Controller(View_3_Service view_3_service) {
        this.view_3_service = view_3_service;
    }

    /**
     * 获取博客分类数据方法
     * @author : ning
     * @return  博客类别JSON--java.util.List<com.ning.itning.entity.view_3.Type>
     * @date :   2017/9/22
    **/
    @RequestMapping("getBlogTypeData")
    public List<Type> getBlogTypeData(){
        return view_3_service.getTypeEntity();
    }
    /**
     *
     * @author : ning
     * @return  --java.util.List<com.ning.itning.entity.view_3.Blog>
     * @date :   2017/9/22
    **/
    @RequestMapping("getBlogData")
    public Page<Blog> getBlogData(){
        return view_3_service.getBlogEntity();
    }
}
