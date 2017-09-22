package com.ning.itning.dao.view_3;

import com.ning.itning.entity.view_3.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog,String> {
}
