package com.ning.itning.dao.indexFrameWork;

import com.ning.itning.entity.indexFrameWork.NavBar;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 导航条Dao层接口
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.dao.indexFrameWork
 * @date :   2017/9/23
 **/
public interface NavBarDao extends JpaRepository<NavBar, String> {

}
