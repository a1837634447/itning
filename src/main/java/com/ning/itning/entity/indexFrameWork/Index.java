package com.ning.itning.entity.indexFrameWork;

import java.io.Serializable;
import java.util.List;

/**
 * JAVA BEAN 用于封装主页框架数据
 * @package_name : com.ning.itning.entity
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/22
**/
public class Index implements Serializable {
    private List<NavBar> navbarList;
    private List<String> viewTitle;

    public List<NavBar> getNavbarList() {
        return navbarList;
    }

    public void setNavbarList(List<NavBar> navbarList) {
        this.navbarList = navbarList;
    }

    public List<String> getViewTitle() {
        return viewTitle;
    }

    public void setViewTitle(List<String> viewTitle) {
        this.viewTitle = viewTitle;
    }
}
