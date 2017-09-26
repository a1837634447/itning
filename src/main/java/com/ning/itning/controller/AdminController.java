package com.ning.itning.controller;

import com.ning.itning.service.View_3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.controller
 * @date :   2017/9/25
 **/
@Controller
@RequestMapping("adminApi")
public class AdminController {
    private final View_3_Service view_3_service;

    @Autowired
    public AdminController(View_3_Service view_3_service) {
        this.view_3_service = view_3_service;
    }

    /**
     * 保存文章方法
     *
     * @param title  文章标题
     * @param author 文章作者
     * @param typeID 文章类别
     * @param md     MD信息
     * @return --java.util.List<java.lang.String>
     * @author : ning
     * @date :  2017/9/25
     **/
    @RequestMapping("saveBlog")
    @ResponseBody
    public List<String> saveBlog(String title, String author, String typeID, String md) {
        view_3_service.saveBlog(title, author, typeID, md);
        List<String> list = new ArrayList<>();
        list.add("success");
        return list;
    }

    /**
     * 删除Blog 根据ID
     *
     * @param id Blog ID
     * @return --void
     * @author : ning
     * @date :   2017/9/25
     **/
    @RequestMapping("deleteBlogByID")
    @ResponseBody
    public List<String> deleteBlogByID(String id) {
        view_3_service.deleteBlogByID(id);
        List<String> list = new ArrayList<>();
        list.add("success");
        return list;
    }

    /**
     * 更新文章 根据ID
     *
     * @param id      Blog ID
     * @param title   Blog Title
     * @param author, Blog author
     * @param typeID  Blog Type ID
     * @param md      Blog MD
     * @return --java.util.List<java.lang.String>
     * @author : ning
     * @date :   2017/9/25
     **/
    @RequestMapping("updataBlogByID")
    @ResponseBody
    public List<String> updataBlogByID(String id, String title, String author, String typeID, String md) {
        List<String> list = new ArrayList<>();
        view_3_service.updataBlogByID(id, title, author, typeID, md);
        list.add("success");
        return list;
    }

    /**
     * @param name 名称
     * @return --java.util.List<java.lang.String>
     * @author : ning
     * @date :   2017/9/26
     **/
    @RequestMapping("addType")
    @ResponseBody
    public List<String> addType(String name) {
        view_3_service.saveType(name);
        List<String> list = new ArrayList<>();
        list.add("success");
        return list;
    }

    /**
     * 删除类别 根据ID
     * @author : ning
     * @param id 要删除的ID
     * @return  --java.util.List<java.lang.String>
     * @date :   2017/9/26
    **/
    @RequestMapping("deleteTypeByID")
    @ResponseBody
    public List<String> deleteTypeByID(String id) {
        System.out.println(id);
        view_3_service.deleteTypeByID(id);
        List<String> list = new ArrayList<>();
        list.add("success");
        return list;
    }

    /**
     * 修改类别 根据ID
     * @author : ning
     * @param id 类别ID
     * @param name 类别名
     * @return  --java.util.List<java.lang.String>
     * @date :   2017/9/26
    **/
    @RequestMapping("updataTypeByID")
    @ResponseBody
    public List<String> updataTypeByID(String id, String name) {
        System.out.println(id + name);
        view_3_service.updataTypeByID(id, name);
        List<String> list = new ArrayList<>();
        list.add("success");
        return list;
    }
}
