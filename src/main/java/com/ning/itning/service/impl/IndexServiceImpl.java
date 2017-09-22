package com.ning.itning.service.impl;

import com.ning.itning.dao.indexFrameWork.NavBarDao;
import com.ning.itning.dao.indexFrameWork.TitleDao;
import com.ning.itning.entity.indexFrameWork.Index;
import com.ning.itning.entity.indexFrameWork.NavBar;
import com.ning.itning.entity.indexFrameWork.Title;
import com.ning.itning.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 页面框架服务层实现
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.service.impl
 * @date :   2017/9/22
 **/
@Service
public class IndexServiceImpl implements IndexService {

    private final NavBarDao navBarDao;

    private final TitleDao titleDao;

    @Autowired
    public IndexServiceImpl(NavBarDao navBarDao, TitleDao titleDao) {
        this.navBarDao = navBarDao;
        this.titleDao = titleDao;
    }

    /**
     * 实现getIndexEntity()方法，调用Dao层封装数据返回
     * 获取框架实体数据
     *
     * @return 实体类-com.ning.itning.entity.indexFrameWork.Index
     * @author : ning
     * @date :   2017/9/22
     **/
    @Override
    public Index getIndexEntity() {
        List<NavBar> navBarList = navBarDao.findAll();
        List<Title> titleList = titleDao.findAll();
        List<String> viewTitle = new ArrayList<>();
        for (Title title : titleList) {
            viewTitle.add(title.getText());
        }
        Index index = new Index();
        index.setNavbarList(navBarList);
        index.setViewTitle(viewTitle);
        return index;
    }
}
