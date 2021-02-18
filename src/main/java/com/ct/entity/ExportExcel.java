package com.ct.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 此类是为了导出所需的字段到Excel，重新封装各对象字段
 */
@Data
public class ExportExcel {

    private terminals terminals;

    public ExportExcel(terminals t){
        this.org_department = t.getOrganization().getOrg_department();
        this.area_name = t.getArea().getArea_name();
        this.org_address = t.getOrganization().getOrg_address();
        this.e_name = t.getEmployee().getE_name();
        this.c_main_name = t.getMainCategory().getC_main_name();
        this.c_name = t.getCategory().getC_name();
        this.brand = t.getBrand();
        this.model = t.getModel();
        this.mainBoard = t.getMainBoard();
        this.memory = t.getMemory();
        this.hardDisk = t.getHardDisk();
        this.cpu = t.getCpu();
        this.graphicCard = t.getGraphicCard();
        this.networkCard = t.getNetworkCard();
        this.display = t.getDisplay();
        this.ip = t.getIp();
        this.os = t.getOs();
        this.software = t.getSoftware();
        this.state = t.getState();
        this.enabledDate = t.getEnabledDate();
    }

    @ExcelProperty(value = "所在部门", index = 0)
    private String org_department;

    @ExcelProperty(value = "所在区域", index = 1)
    private String area_name;

    @ExcelProperty(value = "所在地址", index = 2)
    private String org_address;

    @ExcelProperty(value = "使用人", index = 3)
    private String e_name;

    @ExcelProperty(value = "设备大类", index = 4)
    private String c_main_name;

    @ExcelProperty(value = "设备分类", index = 5)
    private String c_name;

    @ExcelProperty(value = "品牌", index = 6)
    private String brand;

    @ExcelProperty(value = "型号", index = 7)
    private String model;

    @ExcelProperty(value = "主板", index = 8)
    private String mainBoard;

    @ExcelProperty(value = "内存", index = 9)
    private String memory;

    @ExcelProperty(value = "硬盘", index = 10)
    private String hardDisk;

    @ExcelProperty(value = "中央处理器", index = 11)
    private String cpu;

    @ExcelProperty(value = "显卡", index = 12)
    private String graphicCard;

    @ExcelProperty(value = "网卡", index = 13)
    private String networkCard;

    @ExcelProperty(value = "显示器", index = 14)
    private String display;

    @ExcelProperty(value = "IP地址", index = 15)
    private String ip;

    @ExcelProperty(value = "操作系统", index = 16)
    private String os;

    @ExcelProperty(value = "安装软件", index = 17)
    private String software;

    @ExcelProperty(value = "状态", index = 18)
    private String state;

    @ExcelProperty(value = "启用日期", index = 19)
    private String enabledDate;

}
