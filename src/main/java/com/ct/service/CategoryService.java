package com.ct.service;


import com.ct.entity.category;

import java.util.List;

/**
 * (category)表服务接口
 *
 * @author
 * @since
 */
public interface CategoryService {

    /**
     * 查询分类数据，供前端添加页面选择
     * @return 所有分类
     */
    List<category> queryAllCategory();
}
