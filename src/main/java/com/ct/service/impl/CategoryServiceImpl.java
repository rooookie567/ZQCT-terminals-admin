package com.ct.service.impl;

import com.ct.dao.categoryDao;
import com.ct.entity.category;
import com.ct.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private categoryDao categoryDao;

    @Override
    public List<category> queryAllCategory() {
        return categoryDao.queryAllCategory();
    }
}
