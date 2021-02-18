DROP DATABASE IF EXISTS ct_terminals;
CREATE DATABASE ct_terminals DEFAULT CHARACTER SET utf8;
USE ct_terminals;

/* Table structure for organization */
DROP TABLE IF EXISTS organization;
CREATE TABLE organization (
  org_id int(11) NOT NULL AUTO_INCREMENT COMMENT '��֯���',
  org_company varchar(255) DEFAULT NULL COMMENT '��˾��',
  org_department varchar(255) DEFAULT NULL COMMENT '������',
  org_address varchar(255) NOT NULL COMMENT '����/�ն����ڵ�ַ',
  PRIMARY KEY (org_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for employee */
DROP TABLE IF EXISTS employee;
CREATE TABLE employee (
  e_id int(11) NOT NULL AUTO_INCREMENT COMMENT 'Ա�����',
  e_name varchar(255) DEFAULT NULL COMMENT 'Ա������',
  e_title varchar(255)  DEFAULT NULL COMMENT '��λ����',
  org_id int(11) DEFAULT NULL COMMENT '��֯���',
  PRIMARY KEY (e_id),
  CONSTRAINT fk_emp_org FOREIGN KEY (org_id) REFERENCES organization (org_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for category */
DROP TABLE IF EXISTS category;
CREATE TABLE category (
  c_id int(11) NOT NULL AUTO_INCREMENT COMMENT '������',
  c_name varchar(255) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (c_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for mainCategory */
DROP TABLE IF EXISTS mainCategory;
CREATE TABLE mainCategory (
  c_main_id int(11) NOT NULL COMMENT '������',
  c_main_name varchar(255) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (c_main_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for terminals */
DROP TABLE IF EXISTS terminals;
CREATE TABLE terminals (
  ter_id int(11) NOT NULL AUTO_INCREMENT COMMENT '�ն˱��',
  org_id int(11) NOT NULL COMMENT '�ն�������֯���',
  e_id int(11) NOT NULL COMMENT 'ʹ��Ա�����',
  c_id int(11) NOT NULL COMMENT '������',
  c_main_id int(11) NOT NULL COMMENT '������',
  state varchar(10) NOT NULL 	COMMENT'ʹ��״̬',
  enabledDate datetime DEFAULT NULL COMMENT'����ʱ��',
  brand varchar(255) DEFAULT NULL COMMENT'Ʒ��',
  model varchar(255) DEFAULT NULL COMMENT'�ͺ�',
  mainboard varchar(255) DEFAULT NULL COMMENT'����',
  memory varchar(255) DEFAULT NULL COMMENT'�ڴ�',
  harddisk varchar(255) DEFAULT NULL COMMENT'Ӳ��',
  cpu varchar(255) DEFAULT NULL COMMENT'CPU',
  graphicCard varchar(255) DEFAULT NULL COMMENT'�Կ�',
  networkCard varchar(255) DEFAULT NULL COMMENT'����',
  display varchar(255) DEFAULT NULL COMMENT'��ʾ��',
  ip varchar(255) DEFAULT NULL COMMENT'ip��ַ',
  os varchar(255) DEFAULT NULL COMMENT'����ϵͳ',
  software varchar(255) DEFAULT NULL COMMENT'��װ���',
  PRIMARY KEY (ter_id),
  CONSTRAINT fk_ter_org FOREIGN KEY (org_id) REFERENCES organization(org_id),
  CONSTRAINT fk_ter_emp FOREIGN KEY (e_id) REFERENCES employee(e_id),
  CONSTRAINT fk_ter_cgy FOREIGN KEY (c_id) REFERENCES category(c_id),
  CONSTRAINT fk_ter_mcgy FOREIGN KEY (c_main_id) REFERENCES mainCategory(c_main_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Table structure for image */
DROP TABLE IF EXISTS image;
CREATE TABLE image (
  img_id int(11) NOT NULL AUTO_INCREMENT COMMENT 'ͼƬ���',
  ter_id int(11) NOT NULL COMMENT '�ն˱��',
  img_name varchar(255) COMMENT 'ͼƬ��',
  PRIMARY KEY (img_id),
  CONSTRAINT fk_img_ter FOREIGN KEY (ter_id) REFERENCES terminals (ter_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;