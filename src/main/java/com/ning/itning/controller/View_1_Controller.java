package com.ning.itning.controller;

import com.ning.itning.entity.view_1.Carousel;
import com.ning.itning.service.View_1_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 视图一控制层
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.controller
 * @date :   2017/9/21
 **/
@RestController
public class View_1_Controller {

    private final View_1_Service view_1_service;

    @Autowired
    public View_1_Controller(View_1_Service view_1_service) {
        this.view_1_service = view_1_service;
    }

    /**
     * 获取轮播图数据方法
     *
     * @return 轮播图数据JSON--java.util.List<com.ning.itning.entity.view_1.Carousel>
     * @author : ning
     * @date :   2017/9/22
     **/
    @RequestMapping("/getCarouselData")
    public List<Carousel> getCarouselData() {
        return view_1_service.getCarouselData();
    }
}
