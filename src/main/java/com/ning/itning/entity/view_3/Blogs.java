package com.ning.itning.entity.view_3;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装选择类别后的Blog实体类和分页信息
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.entity.view_3
 * @date :   2017/9/23
 **/
public class Blogs implements Serializable {
    private Boolean first;
    private Boolean last;
    private Integer totalPages;
    private List<Blog> content;

    public Boolean getFirst() {
        return first;
    }

    public void setFirst(Boolean first) {
        this.first = first;
    }

    public Boolean getLast() {
        return last;
    }

    public void setLast(Boolean last) {
        this.last = last;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Blog> getContent() {
        return content;
    }

    public void setContent(List<Blog> content) {
        this.content = content;
    }
}
