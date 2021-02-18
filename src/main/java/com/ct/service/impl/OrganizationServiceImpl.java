package com.ct.service.impl;

import com.ct.dao.organizationDao;
import com.ct.entity.organization;
import com.ct.service.OrganizationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OrganizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private organizationDao organizationDao;

    @Override
    public List<organization> queryAllOrg() {
        return organizationDao.queryAllOrg();
    }
}
