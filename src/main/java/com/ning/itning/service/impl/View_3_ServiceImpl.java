package com.ning.itning.service.impl;

import com.ning.itning.dao.view_3.ArchivingDao;
import com.ning.itning.dao.view_3.BlogDao;
import com.ning.itning.dao.view_3.TypeDao;
import com.ning.itning.entity.view_3.Archiving;
import com.ning.itning.entity.view_3.Blog;
import com.ning.itning.entity.view_3.Blogs;
import com.ning.itning.entity.view_3.Type;
import com.ning.itning.service.View_3_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     *
     * @return --java.util.List<com.ning.itning.entity.view_3.Archiving>
     * @author : ning
     * @date :   2017/9/22
     **/
    @Override
    public List<Archiving> getArchivingEntity() {
        return archivingDao.findAll();
    }

    /**
     * 分页获取Blog实体
     *
     * @param page 页码
     * @param size 单页条目数
     * @return --org.springframework.data.domain.Page<com.ning.itning.entity.view_3.Blog>
     * @author : ning
     * @date :   2017/9/23
     **/
    @Override
    public Page<Blog> getBlogEntity(Integer page, Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "date");
        if (page < 0) {
            page = 0;
        }
        Pageable pageable = new PageRequest(page, size, sort);
        return blogDao.findAll(pageable);
    }

    /**
     * 根据类别分页获取Blog实体
     *
     * @param typeId 分类ID
     * @param page   当前页码
     * @param size   每页条目数
     * @return --com.ning.itning.entity.view_3.Blogs
     * @author : ning
     * @date :   2017/9/23
     **/
    @Override
    public Blogs getBlogEntityByType(String typeId, Integer page, Integer size) {
        Type type = new Type();
        type.setId(typeId);
        List<Blog> blogByTypeList = blogDao.findByTypeOrderByDateDesc(type);
        int totalPages = 0;//初始化总页数为0
        List<Blog> blogByTypeLimitList = new ArrayList<>();
        if (!blogByTypeList.isEmpty()) {
            int listSize = blogByTypeList.size();//总条数
            int start = (page - 1) * size;//该页开始条数
            totalPages = listSize % size == 0 ? (listSize / size) : (listSize / size) + 1;//总共页数
            for (int i = start; i < start + size; i++) {
                if (i >= listSize) {
                    break;
                }
                Blog blog = blogByTypeList.get(i);
                blogByTypeLimitList.add(blog);
            }
        }
        Blogs blogs = new Blogs();
        blogs.setContent(blogByTypeLimitList);
        blogs.setFirst(page == 1);
        blogs.setLast(page == totalPages);
        blogs.setTotalPages(totalPages);
        return blogs;
    }
}
