package com.ct.service;


import com.ct.entity.organization;

import java.util.List;

/**
 * (organization)表服务接口
 *
 * @author
 * @since
 */
public interface OrganizationService {


    /**
     * 查询部门数据，供前端添加页面选择
     * @return 所有部门
     */
    List<organization> queryAllOrg();
}
