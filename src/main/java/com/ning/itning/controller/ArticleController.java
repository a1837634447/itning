package com.ning.itning.controller;

import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Type;
import com.ning.itning.service.View_3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Blog 文章控制层
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.controller
 * @date :   2017/9/24
 **/
@Controller
public class ArticleController {

    private final View_3_Service view_3_service;

    @Autowired
    public ArticleController(View_3_Service view_3_service) {
        this.view_3_service = view_3_service;
    }

    /**
     * 根据ID获取文章实体
     * @author : ning
     * @param id, 文章ID
     * @param model org.springframework.ui.Model
     * @return  --java.lang.String
     * @date :   2017/9/25
    **/
    @RequestMapping("/article/{id}")
    public String getArticleByID(@PathVariable("id") String id, Model model) {
        Blog blogByID = view_3_service.getBlogByID(id);
        model.addAttribute("blog",blogByID);
        return "article";
    }
}
