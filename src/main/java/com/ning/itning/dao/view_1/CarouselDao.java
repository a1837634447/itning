package com.ning.itning.dao.view_1;

import com.ning.itning.entity.view_1.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 轮播图数据Dao层接口
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.dao.view_1
 * @date :   2017/9/23
 **/
public interface CarouselDao extends JpaRepository<Carousel, String> {
}
