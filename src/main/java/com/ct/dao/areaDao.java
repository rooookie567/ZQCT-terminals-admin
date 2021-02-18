package com.ct.dao;


import com.ct.entity.area;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface areaDao {

    List<area> queryAllArea();
}
