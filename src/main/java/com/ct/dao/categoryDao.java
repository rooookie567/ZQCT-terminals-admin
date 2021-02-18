package com.ct.dao;

import com.ct.entity.category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface categoryDao {

    List<category> queryAllCategory();
}
