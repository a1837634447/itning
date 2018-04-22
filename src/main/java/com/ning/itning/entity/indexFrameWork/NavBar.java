package com.ning.itning.entity.indexFrameWork;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * JAVA BEAN 导航条实体 用于封装页面框架数据
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.entity
 * @date :   2017/9/22
 **/
@Entity
@Table(name = "index_narbar")
public class NavBar implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "title")
    private String title;
    @Column(name = "href")
    private String href;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
