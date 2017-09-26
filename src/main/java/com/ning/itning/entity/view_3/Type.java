package com.ning.itning.entity.view_3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 博客类别模块实体类
 * @package_name : com.ning.itning.entity.view_3
 * @author : ning
 * @version : 1.0.0
 * @date :   2017/9/22
**/
@Entity
@Table(name = "type")
public class Type implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}