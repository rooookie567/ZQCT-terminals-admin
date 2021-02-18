package com.ct.entity;

import java.io.Serializable;

public class mainCategory implements Serializable {

    //大类编号
    private Integer c_main_id;

    //大类名称
    private String c_main_name;

    public Integer getC_main_id() {
        return c_main_id;
    }

    public void setC_main_id(Integer c_main_id) {
        this.c_main_id = c_main_id;
    }

    public String getC_main_name() {
        return c_main_name;
    }

    public void setC_main_name(String c_main_name) {
        this.c_main_name = c_main_name;
    }
}
