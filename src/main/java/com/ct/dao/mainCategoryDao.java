package com.ct.dao;


import com.ct.entity.mainCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface mainCategoryDao {

    /**
     * 查询大类数据，供前端添加页面选择
     * @return 所有大类
     */
    List<mainCategory> queryAllMainCategory();
}
