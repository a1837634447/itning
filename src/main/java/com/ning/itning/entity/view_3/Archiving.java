package com.ning.itning.entity.view_3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 博客归档模块实体类
 * @package_name : com.ning.itning.entity.view_3
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/22
**/
@Entity
@Table(name = "archiving")
public class Archiving implements Serializable{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "data")
    private Date date;
    @Column(name = "href")
    private String href;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
