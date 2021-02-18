package com.ct.service;

import com.ct.entity.mainCategory;

import java.util.List;

/**
 * (maincategory)表服务接口
 *
 * @author
 * @since
 */
public interface MainCategoryService {

    /**
     * 查询大类数据，供前端添加页面选择
     * @return 所有大类
     */
    List<mainCategory> queryAllMainCategory();
}
