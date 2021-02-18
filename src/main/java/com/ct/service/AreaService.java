package com.ct.service;

import com.ct.entity.area;

import java.util.List;

/**
 * (area)表服务接口
 *
 * @author
 * @since
 */
public interface AreaService {

    /**
     * 查询区域数据，供前端添加页面选择
     * @return 所有区域
     */
    List<area> queryAllArea();

}
