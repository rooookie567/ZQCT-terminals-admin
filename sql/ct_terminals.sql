DROP DATABASE IF EXISTS ct_terminals;
CREATE DATABASE ct_terminals DEFAULT CHARACTER SET utf8;
USE ct_terminals;

/* Table structure for organization */
DROP TABLE IF EXISTS organization;
CREATE TABLE organization (
  org_id int(11) NOT NULL AUTO_INCREMENT COMMENT '组织编号',
  org_company varchar(255) DEFAULT NULL COMMENT '公司名',
  org_department varchar(255) DEFAULT NULL COMMENT '部门名',
  org_address varchar(255) NOT NULL COMMENT '部门/终端所在地址',
  PRIMARY KEY (org_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for employee */
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  e_id int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  e_name varchar(255) DEFAULT NULL COMMENT '员工名称',
  e_title varchar(255)  DEFAULT NULL COMMENT '岗位名称',
  org_id int(11) DEFAULT NULL COMMENT '组织编号',
  PRIMARY KEY (e_id),
  CONSTRAINT fk_emp_org FOREIGN KEY (org_id) REFERENCES organization (org_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for category */
DROP TABLE IF EXISTS category;
CREATE TABLE category (
  c_id int(11) NOT NULL AUTO_INCREMENT COMMENT '分类编号',
  c_name varchar(255) DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (c_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for mainCategory */
DROP TABLE IF EXISTS mainCategory;
CREATE TABLE mainCategory (
  c_main_id int(11) NOT NULL COMMENT '大类编号',
  c_main_name varchar(255) DEFAULT NULL COMMENT '大类名称',
  PRIMARY KEY (c_main_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for terminals */
DROP TABLE IF EXISTS terminals;
CREATE TABLE terminals (
  ter_id int(11) NOT NULL AUTO_INCREMENT COMMENT '终端编号',
  org_id int(11) NOT NULL COMMENT '终端所在组织编号',
  e_id int(11) NOT NULL COMMENT '使用员工编号',
  c_id int(11) NOT NULL COMMENT '分类编号',
  c_main_id int(11) NOT NULL COMMENT '大类编号',
  state varchar(10) NOT NULL 	COMMENT'使用状态',
  enabledDate datetime DEFAULT NULL COMMENT'启用时间',
  brand varchar(255) DEFAULT NULL COMMENT'品牌',
  model varchar(255) DEFAULT NULL COMMENT'型号',
  mainboard varchar(255) DEFAULT NULL COMMENT'主板',
  memory varchar(255) DEFAULT NULL COMMENT'内存',
  harddisk varchar(255) DEFAULT NULL COMMENT'硬盘',
  cpu varchar(255) DEFAULT NULL COMMENT'CPU',
  graphicCard varchar(255) DEFAULT NULL COMMENT'显卡',
  networkCard varchar(255) DEFAULT NULL COMMENT'网卡',
  display varchar(255) DEFAULT NULL COMMENT'显示器',
  ip varchar(255) DEFAULT NULL COMMENT'ip地址',
  os varchar(255) DEFAULT NULL COMMENT'操作系统',
  software varchar(255) DEFAULT NULL COMMENT'安装软件',
  PRIMARY KEY (ter_id),
  CONSTRAINT fk_ter_org FOREIGN KEY (org_id) REFERENCES organization(org_id),
  CONSTRAINT fk_ter_emp FOREIGN KEY (e_id) REFERENCES employee(e_id),
  CONSTRAINT fk_ter_cgy FOREIGN KEY (c_id) REFERENCES category(c_id),
  CONSTRAINT fk_ter_mcgy FOREIGN KEY (c_main_id) REFERENCES mainCategory(c_main_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for image */
DROP TABLE IF EXISTS image;
CREATE TABLE image (
  img_id int(11) NOT NULL AUTO_INCREMENT COMMENT '图片编号',
  ter_id int(11) NOT NULL COMMENT '终端编号',
  img_name varchar(255) COMMENT '图片名',
  PRIMARY KEY (img_id),
  CONSTRAINT fk_img_ter FOREIGN KEY (ter_id) REFERENCES terminals (ter_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;