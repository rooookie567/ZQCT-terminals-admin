package com.ct.service;

import com.ct.entity.terminals;

import java.util.List;

public interface terminalsService {

    /**
     * 查询数据
     *
     * @param
     * @return 所有终端实例对象列表
     */
    List<terminals> queryList();

    /**
     * 查询数据
     *
     * @param  id
     * @return 对应id的终端实例对象
     */
    terminals queryById(String id);

    /**
     * 新增数据
     *
     * @param terminals 实例对象
     * @return 实例对象
     */
    void insert(terminals terminals);

    /**
     * 更新数据
     *
     * @param terminals 实例对象
     * @return
     */
    void update(terminals terminals);

    /**
     * 根据id删除数据
     *
     * @param  id
     * @return
     */
    void deleteById(Integer id);

    /**
     * 查询数据
     *
     * @param  area_id
     * @return 对应area_id的终端数量
     */
    int countByAreaId(Integer area_id);

}
