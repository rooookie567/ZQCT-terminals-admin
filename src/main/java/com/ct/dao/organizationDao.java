package com.ct.dao;


import com.ct.entity.organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface organizationDao {

    /**
     * 查询部门数据，供前端添加页面选择
     * @return 所有部门
     */
    List<organization> queryAllOrg();
}
