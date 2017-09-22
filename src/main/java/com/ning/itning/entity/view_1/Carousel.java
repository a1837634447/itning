package com.ning.itning.entity.view_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.entity.view_1
 * @date :   2017/9/22
 **/
@Entity
@Table(name = "view1_carousel")
public class Carousel implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "href")
    private String href;
    @Column(name = "alt")
    private String alt;
    @Column(name = "src")
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
