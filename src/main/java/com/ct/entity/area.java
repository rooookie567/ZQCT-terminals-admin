package com.ct.entity;

import java.io.Serializable;

public class area implements Serializable {

    //区域编号
    private Integer area_id;

    //区域名称
    private String area_name;

    public Integer getArea_id() {
        return area_id;
    }

    public void setArea_id(Integer area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }
}
