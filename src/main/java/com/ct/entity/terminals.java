package com.ct.entity;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class terminals implements Serializable {

    //终端编号
    private String ter_id;

    //终端所在组织编号
    private Integer org_id;

    //使用员工编号
    private Integer e_id;

    //分类编号
    private Integer c_id;

    //大类编号
    private Integer c_main_id;

    //区域编号
    private Integer area_id;

    //使用状态
    private String state;

    //启用时间
    private String enabledDate;

    //品牌
    private String brand;

    //型号
    private String model;

    //主板
    private String mainBoard;

    //内存
    private String memory;

    //硬盘
    private String hardDisk;

    //CPU
    private String cpu;

    //显卡
    private String graphicCard;

    //网卡
    private String networkCard;

    //显示器
    private String display;

    //ip
    private String ip;

    //操作系统
    private String os;

    //安装软件
    private String software;

    //序列号
    private String serialNumber;

    //使用属性
    private String attribute;

    //非数据库字段
    private organization organization;

    //非数据库字段
    private employee employee;

    //非数据库字段
    private mainCategory mainCategory;

    //非数据库字段
    private category category;

    //非数据库字段
    private area area;


}
