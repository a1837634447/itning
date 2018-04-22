package com.ning.itning.dao.view_3;

import com.ning.itning.entity.view_3.Archiving;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 归档Dao层接口
 *
 * @author : ning
 * @version : 1.0.0
 * @package_name : com.ning.itning.dao.view_3
 * @date :   2017/9/23
 **/
public interface ArchivingDao extends JpaRepository<Archiving, String> {
}
