package com.ning.itning.dao.indexFrameWork;

import com.ning.itning.entity.indexFrameWork.Title;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 标题导航Dao层接口
 * @package_name : com.ning.itning.dao.indexFrameWork
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/23
**/
public interface TitleDao extends JpaRepository<Title,String> {

}
