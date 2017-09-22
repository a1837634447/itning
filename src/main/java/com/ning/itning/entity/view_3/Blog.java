package com.ning.itning.entity.view_3;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Blog实体
 * @package_name : com.ning.itning.entity.view_3
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/22
**/
@Entity
@Table(name = "blog")
public class Blog implements Serializable{
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "imgsrc")
    private String imgSrc;
    @Column(name = "imgalt")
    private String imgAlt;
    @Column(name = "atitle")
    private String aTitle;
    @Column(name = "ahref")
    private String aHref;
    @Column(name = "date")
    private Date date;
    @Column(name = "author")
    private String author;
    @OneToOne(cascade=CascadeType.ALL)//Blog是关系的维护端
    @JoinColumn(name="type")//指定外键的名称
    @Fetch(FetchMode.JOIN)//会使用left join查询,只产生一条语句
    private Type type;
    @Column(name = "md")
    private String md;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getImgAlt() {
        return imgAlt;
    }

    public void setImgAlt(String imgAlt) {
        this.imgAlt = imgAlt;
    }

    public String getaTitle() {
        return aTitle;
    }

    public void setaTitle(String aTitle) {
        this.aTitle = aTitle;
    }

    public String getaHref() {
        return aHref;
    }

    public void setaHref(String aHref) {
        this.aHref = aHref;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }
}
