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

import java.util.Date;
import java.util.UUID;

/**
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

    @RequestMapping("/article/{id}")
    public String getArticleByID(@PathVariable("id") String id, Model model) {
        Blog blogByID = view_3_service.getBlogByID(id);
        model.addAttribute("blog",blogByID);
        return "article";
    }

    @RequestMapping("saveBlog")
    @ResponseBody public String saveBlog(String title,String author,String typeID,String md){
        String uuid= UUID.randomUUID().toString();
        String imgUrl="views/view_3/img/4.jpg";
        String imgAlt="alt";
        Blog blog=new Blog();
        Type type =new Type();
        type.setId(typeID);
        type.setName("前端");
        type.setHref("#");
        blog.setId(uuid);
        blog.setaHref("#");
        blog.setaTitle(title);
        blog.setAuthor(author);
        blog.setImgAlt(imgAlt);
        blog.setImgSrc(imgUrl);
        blog.setType(type);
        blog.setMd(md);
        blog.setDate(new Date());
        view_3_service.saveBlog(blog);
        System.out.println(title);
        System.out.println(author);
        System.out.println(typeID);
        System.out.println(uuid);
        System.out.println(md);
        return "success";
    }
}
