package com.ning.itning.service;

import com.ning.itning.entity.view_3.Archiving;
import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Blogs;
import com.ning.itning.entity.view_3.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 视图三服务接口类
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.service
 * @date :   2017/9/22
 **/
public interface View_3_Service {
    List<Type> getTypeEntity();

    void saveType(String name);

    void deleteTypeByID(String id);

    void updataTypeByID(String id, String name);

    List<Archiving> getArchivingEntity();

    Page<Blog> getBlogEntity(Integer page, Integer size);

    Blogs getBlogEntityByType(String typeId, Integer page, Integer size);

    Blog getBlogByID(String id);

    void saveBlog(String title, String author, String typeID, String md);

    void deleteBlogByID(String id);

    void updataBlogByID(String id, String title, String author, String typeID, String md);
}
