package com.ct.service.impl;

import com.ct.dao.mainCategoryDao;
import com.ct.entity.mainCategory;
import com.ct.service.MainCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("MainCategoryService")
public class MainCategoryServiceImpl implements MainCategoryService {

    @Resource
    private mainCategoryDao mainCategoryDao;

    @Override
    public List<mainCategory> queryAllMainCategory() {
        return mainCategoryDao.queryAllMainCategory();
    }
}
