
/* Drop Indexes */

DROP INDEX test_data_main_del_flag;
DROP INDEX test_data_child_del_flag;



/* Drop Tables */

DROP TABLE spc_customer_person CASCADE CONSTRAINTS;
DROP TABLE spc_customer_base CASCADE CONSTRAINTS;




/* Create Tables */

-- 业务数据表
CREATE TABLE spc_customer_base
(
	-- 编号
	id varchar2(64) NOT NULL,
	-- 人员
	person_id varchar2(64) NOT NULL,
	-- 营业执照编号
	no varchar2(64) NOT NULL UNIQUE,
	-- 业务代表
	saleperson_id varchar2(64),
	-- 部门
	office_id varchar2(64),
	-- 所在地
	area_id varchar2(64) NOT NULL,
	-- 地址
	address varchar2(100 char),
	-- 联系人
	con_Person varchar2(64),
	-- 联系人职务
	con_Person_Position varchar2(64),
	-- 办公电话
	office_phone varchar2(64),
	mobile_Phone varchar2(64),
	-- 传真
	fax varchar2(64),
	Email varchar2(64),
	-- 开票类型
	invoice_Type varchar2(3),
	-- 税务登记号
	tax_No varchar2(32),
	-- 开户银行
	tax_Bank varchar2(80 char),
	-- 银行账号
	tax_Bank_No varchar2(32),
	-- 开票地址
	tax_Address varchar2(80 char),
	-- 开票电话
	tax_Phone varchar2(32),
	-- 加入日期
	in_date date,
	-- 创建者
	create_by varchar2(64) NOT NULL,
	-- 创建时间
	create_date timestamp NOT NULL,
	-- 更新者
	update_by varchar2(64) NOT NULL,
	-- 更新时间
	update_date timestamp NOT NULL,
	-- 备注信息
	remarks nvarchar2(255),
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL,
	PRIMARY KEY (id)
);


-- 业务数据子表
CREATE TABLE spc_customer_person
(
	-- 编号
	id varchar2(64) NOT NULL,
	-- 客户主表ID
	spc_customer_base_id varchar2(64),
	-- 人员
	person_id varchar2(64),
	-- 创建者
	create_by varchar2(64) NOT NULL,
	-- 创建时间
	create_date timestamp NOT NULL,
	-- 更新者
	update_by varchar2(64) NOT NULL,
	-- 更新时间
	update_date timestamp NOT NULL,
	-- 备注信息
	remarks nvarchar2(255),
	-- 删除标记（0：正常；1：删除）
	del_flag char(1) DEFAULT '0' NOT NULL,
	PRIMARY KEY (id)
);



/* Create Foreign Keys */

ALTER TABLE spc_customer_person
	ADD FOREIGN KEY (spc_customer_base_id)
	REFERENCES spc_customer_base (id)
;



/* Create Indexes */

CREATE INDEX test_data_main_del_flag ON spc_customer_base ();
CREATE INDEX test_data_child_del_flag ON spc_customer_person ();



/* Comments */

COMMENT ON TABLE spc_customer_base IS '业务数据表';
COMMENT ON COLUMN spc_customer_base.id IS '编号';
COMMENT ON COLUMN spc_customer_base.person_id IS '人员';
COMMENT ON COLUMN spc_customer_base.no IS '营业执照编号';
COMMENT ON COLUMN spc_customer_base.saleperson_id IS '业务代表';
COMMENT ON COLUMN spc_customer_base.office_id IS '部门';
COMMENT ON COLUMN spc_customer_base.area_id IS '所在地';
COMMENT ON COLUMN spc_customer_base.address IS '地址';
COMMENT ON COLUMN spc_customer_base.con_Person IS '联系人';
COMMENT ON COLUMN spc_customer_base.con_Person_Position IS '联系人职务';
COMMENT ON COLUMN spc_customer_base.office_phone IS '办公电话';
COMMENT ON COLUMN spc_customer_base.fax IS '传真';
COMMENT ON COLUMN spc_customer_base.invoice_Type IS '开票类型';
COMMENT ON COLUMN spc_customer_base.tax_No IS '税务登记号';
COMMENT ON COLUMN spc_customer_base.tax_Bank IS '开户银行';
COMMENT ON COLUMN spc_customer_base.tax_Bank_No IS '银行账号';
COMMENT ON COLUMN spc_customer_base.tax_Address IS '开票地址';
COMMENT ON COLUMN spc_customer_base.tax_Phone IS '开票电话';
COMMENT ON COLUMN spc_customer_base.in_date IS '加入日期';
COMMENT ON COLUMN spc_customer_base.create_by IS '创建者';
COMMENT ON COLUMN spc_customer_base.create_date IS '创建时间';
COMMENT ON COLUMN spc_customer_base.update_by IS '更新者';
COMMENT ON COLUMN spc_customer_base.update_date IS '更新时间';
COMMENT ON COLUMN spc_customer_base.remarks IS '备注信息';
COMMENT ON COLUMN spc_customer_base.del_flag IS '删除标记（0：正常；1：删除）';
COMMENT ON TABLE spc_customer_person IS '业务数据子表';
COMMENT ON COLUMN spc_customer_person.id IS '编号';
COMMENT ON COLUMN spc_customer_person.spc_customer_base_id IS '客户主表ID';
COMMENT ON COLUMN spc_customer_person.person_id IS '人员';
COMMENT ON COLUMN spc_customer_person.create_by IS '创建者';
COMMENT ON COLUMN spc_customer_person.create_date IS '创建时间';
COMMENT ON COLUMN spc_customer_person.update_by IS '更新者';
COMMENT ON COLUMN spc_customer_person.update_date IS '更新时间';
COMMENT ON COLUMN spc_customer_person.remarks IS '备注信息';
COMMENT ON COLUMN spc_customer_person.del_flag IS '删除标记（0：正常；1：删除）';



