package com.ning.itning.entity.indexFrameWork;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * JAVA BEAN 页面导航栏实体 用于封装页面框架数据
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.entity.indexFrameWork
 * @date :   2017/9/22
 **/
@Entity
@Table(name = "index_title")
public class Title implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "text")
    private String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
