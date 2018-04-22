package com.ning.itning.service.impl;

import com.ning.itning.dao.view_1.CarouselDao;
import com.ning.itning.entity.view_1.Carousel;
import com.ning.itning.service.View_1_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视图一服务层实现类
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.service.impl
 * @date :   2017/9/22
 **/
@Service
public class View_1_ServiceImpl implements View_1_Service {

    private final CarouselDao carouselDao;

    @Autowired
    public View_1_ServiceImpl(CarouselDao carouselDao) {
        this.carouselDao = carouselDao;
    }


    /**
     * 获取轮播图数据方法
     *
     * @return --java.util.List<com.ning.itning.entity.view_1.Carousel>
     * @author : ning
     * @date :   2017/9/22
     **/
    @Override
    public List<Carousel> getCarouselData() {
        return carouselDao.findAll();
    }
}
