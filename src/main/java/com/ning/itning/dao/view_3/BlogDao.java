package com.ning.itning.dao.view_3;

import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Blog数据Dao层
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.dao.view_3
 * @date :   2017/9/23
 **/
public interface BlogDao extends JpaRepository<Blog, String> {
    List<Blog> findByTypeOrderByDateDesc(Type type);
}
