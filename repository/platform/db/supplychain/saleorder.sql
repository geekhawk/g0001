
/* Drop Indexes */

DROP INDEX test_data_main_del_flag;
DROP INDEX test_data_child_del_flag;



/* Drop Tables */

DROP TABLE spc_saleorder_entry CASCADE CONSTRAINTS;
DROP TABLE spc_saleorder CASCADE CONSTRAINTS;




/* Create Tables */

-- 业务数据表
CREATE TABLE spc_saleorder
(
	-- 编号
	id varchar2(64) NOT NULL,
	-- 编码
	no varchar2(60) NOT NULL UNIQUE,
	-- 客户
	customerid varchar2(60) NOT NULL,
	-- 下单日期
	orderdate date DEFAULT SYSDATE NOT NULL,
	-- 合计金额
	totalAmount number(19,4) NOT NULL,
	-- 合计体积
	totalvolume number(10,4) NOT NULL,
	-- 合计重量
	totalweight number(10,4) NOT NULL,
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
CREATE TABLE spc_saleorder_entry
(
	-- 编号
	id varchar2(64) NOT NULL,
	-- 业务主表ID
	main_id varchar2(64),
	-- 产品
	material_id varchar2(64) NOT NULL,
	-- 计量单位
	measureunit_id varchar2(64) NOT NULL,
	-- 是否赠品（0，1）
	isgift varchar2(1) NOT NULL,
	-- 数量
	qty number(10,4) NOT NULL,
	-- 单价
	price number(10,4) NOT NULL,
	-- 金额
	amount number(19,4) NOT NULL,
	-- 单位体积
	unitvolume number(10,4),
	-- 体积
	volume number(10,4),
	-- 单位重量
	unitWeight number(10,4),
	-- 重量
	weight number(10,4),
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

ALTER TABLE spc_saleorder_entry
	ADD FOREIGN KEY (main_id)
	REFERENCES spc_saleorder (id)
;



/* Create Indexes */

CREATE INDEX test_data_main_del_flag ON spc_saleorder ();
CREATE INDEX test_data_child_del_flag ON spc_saleorder_entry ();



/* Comments */

COMMENT ON TABLE spc_saleorder IS '业务数据表';
COMMENT ON COLUMN spc_saleorder.id IS '编号';
COMMENT ON COLUMN spc_saleorder.no IS '编码';
COMMENT ON COLUMN spc_saleorder.customerid IS '客户';
COMMENT ON COLUMN spc_saleorder.orderdate IS '下单日期';
COMMENT ON COLUMN spc_saleorder.totalAmount IS '合计金额';
COMMENT ON COLUMN spc_saleorder.totalvolume IS '合计体积';
COMMENT ON COLUMN spc_saleorder.totalweight IS '合计重量';
COMMENT ON COLUMN spc_saleorder.create_by IS '创建者';
COMMENT ON COLUMN spc_saleorder.create_date IS '创建时间';
COMMENT ON COLUMN spc_saleorder.update_by IS '更新者';
COMMENT ON COLUMN spc_saleorder.update_date IS '更新时间';
COMMENT ON COLUMN spc_saleorder.remarks IS '备注信息';
COMMENT ON COLUMN spc_saleorder.del_flag IS '删除标记（0：正常；1：删除）';
COMMENT ON TABLE spc_saleorder_entry IS '业务数据子表';
COMMENT ON COLUMN spc_saleorder_entry.id IS '编号';
COMMENT ON COLUMN spc_saleorder_entry.main_id IS '业务主表ID';
COMMENT ON COLUMN spc_saleorder_entry.material_id IS '产品';
COMMENT ON COLUMN spc_saleorder_entry.measureunit_id IS '计量单位';
COMMENT ON COLUMN spc_saleorder_entry.isgift IS '是否赠品（0，1）';
COMMENT ON COLUMN spc_saleorder_entry.qty IS '数量';
COMMENT ON COLUMN spc_saleorder_entry.price IS '单价';
COMMENT ON COLUMN spc_saleorder_entry.amount IS '金额';
COMMENT ON COLUMN spc_saleorder_entry.unitvolume IS '单位体积';
COMMENT ON COLUMN spc_saleorder_entry.volume IS '体积';
COMMENT ON COLUMN spc_saleorder_entry.unitWeight IS '单位重量';
COMMENT ON COLUMN spc_saleorder_entry.weight IS '重量';
COMMENT ON COLUMN spc_saleorder_entry.create_by IS '创建者';
COMMENT ON COLUMN spc_saleorder_entry.create_date IS '创建时间';
COMMENT ON COLUMN spc_saleorder_entry.update_by IS '更新者';
COMMENT ON COLUMN spc_saleorder_entry.update_date IS '更新时间';
COMMENT ON COLUMN spc_saleorder_entry.remarks IS '备注信息';
COMMENT ON COLUMN spc_saleorder_entry.del_flag IS '删除标记（0：正常；1：删除）';



