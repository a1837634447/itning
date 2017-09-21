package com.ning.itning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页框架类
 * @package_name : com.ning.itning.controller
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/21
**/
@Controller
public class IndexFrameWork {
    /**
     * 进入首页方法
     * @author : ning
     * @param model Model
     * @return  首页HTML名--java.lang.String
     * @date :   2017/9/21
     **/
    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("index");
        return "index";
    }
}
