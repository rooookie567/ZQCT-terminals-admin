package com.ct.service.impl;

import com.ct.dao.areaDao;
import com.ct.entity.area;
import com.ct.service.AreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AreaService")
public class AreaServiceImpl implements AreaService {

    @Resource
    private areaDao areaDao;

    @Override
    public List<area> queryAllArea() {
        return areaDao.queryAllArea();
    }
}
