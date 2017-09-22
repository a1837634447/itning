package com.ning.itning.service.impl;

import com.ning.itning.dao.view_3.ArchivingDao;
import com.ning.itning.dao.view_3.BlogDao;
import com.ning.itning.dao.view_3.TypeDao;
import com.ning.itning.entity.view_3.Archiving;
import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Type;
import com.ning.itning.service.View_3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视图三服务层实现类
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.service.impl
 * @date :   2017/9/22
 **/
@Service
public class View_3_ServiceImpl implements View_3_Service {

    private final TypeDao typeDao;

    private final ArchivingDao archivingDao;

    private final BlogDao blogDao;

    @Autowired
    public View_3_ServiceImpl(TypeDao typeDao, ArchivingDao archivingDao, BlogDao blogDao) {
        this.typeDao = typeDao;
        this.archivingDao = archivingDao;
        this.blogDao = blogDao;
    }

    /**
     * 获取博客类别实体方法
     *
     * @return --java.util.List<com.ning.itning.entity.view_3.Type>
     * @author : ning
     * @date :   2017/9/22
     **/
    @Override
    public List<Type> getTypeEntity() {
        return typeDao.findAll();
    }

    /**
     * 获取博客归档实体方法
     * @author : ning
     * @return  --java.util.List<com.ning.itning.entity.view_3.Archiving>
     * @date :   2017/9/22
    **/
    @Override
    public List<Archiving> getArchivingEntity() {
        return archivingDao.findAll();
    }

    @Override
    public Page<Blog> getBlogEntity() {
        return blogDao.findAll(new PageRequest(0, 10));
    }
}
