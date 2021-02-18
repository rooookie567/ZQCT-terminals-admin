package com.ct.service.impl;

import com.ct.dao.terminalsDao;
import com.ct.entity.organization;
import com.ct.entity.terminals;
import com.ct.service.terminalsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("terminalsService")
public class terminalsServiceImpl implements terminalsService {

    @Resource
    private terminalsDao terminalsDao;


    /**
     * 查询数据
     *
     * @param
     * @return 所有终端实例对象列表
     */
    @Override
    public List<terminals> queryList() {
        return terminalsDao.queryList();

    }

    /**
     * 查询数据
     *
     * @param  id
     * @return 对应id的终端实例对象
     */
    @Override
    public terminals queryById(String id) {
        return terminalsDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param terminals 实例对象
     * @return
     */
    @Override
    public void insert(terminals terminals){
        terminalsDao.insert(terminals);
    }

    /**
     * 更新数据
     *
     * @param terminals 实例对象
     * @return
     */
    public void update(terminals terminals){
        terminalsDao.update(terminals);
    }


    /**
     * 根据id删除数据
     *
     * @param  id
     * @return
     */
    public void deleteById(Integer id){
        terminalsDao.deleteById(id);
    }

    /**
     * 查询数据
     *
     * @param  area_id
     * @return 对应area_id的终端数量
     */
    public int countByAreaId(Integer area_id){
        return terminalsDao.countByAreaId(area_id);
    }


}
