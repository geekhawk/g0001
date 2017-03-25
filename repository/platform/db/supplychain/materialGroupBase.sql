
/* Drop Indexes */

DROP INDEX test_tree_del_flag;
DROP INDEX test_data_parent_id;
DROP INDEX test_data_parent_ids;



/* Drop Tables */

DROP TABLE material_group_base CASCADE CONSTRAINTS;




/* Create Tables */

-- 树结构表
CREATE TABLE material_group_base
(
	-- 编号
	id varchar2(64) NOT NULL,
	-- 编码
	no varchar2(100) UNIQUE,
	-- 父级编号
	parent_id varchar2(64) NOT NULL,
	-- 所有父级编号
	parent_ids varchar2(2000) NOT NULL,
	-- 名称
	name nvarchar2(100) NOT NULL,
	-- 排序
	sorts number(10,0) NOT NULL,
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



/* Create Indexes */

CREATE INDEX test_tree_del_flag ON material_group_base ();
CREATE INDEX test_data_parent_id ON material_group_base ();
CREATE INDEX test_data_parent_ids ON material_group_base ();



/* Comments */

COMMENT ON TABLE material_group_base IS '树结构表';
COMMENT ON COLUMN material_group_base.id IS '编号';
COMMENT ON COLUMN material_group_base.no IS '编码';
COMMENT ON COLUMN material_group_base.parent_id IS '父级编号';
COMMENT ON COLUMN material_group_base.parent_ids IS '所有父级编号';
COMMENT ON COLUMN material_group_base.name IS '名称';
COMMENT ON COLUMN material_group_base.sorts IS '排序';
COMMENT ON COLUMN material_group_base.create_by IS '创建者';
COMMENT ON COLUMN material_group_base.create_date IS '创建时间';
COMMENT ON COLUMN material_group_base.update_by IS '更新者';
COMMENT ON COLUMN material_group_base.update_date IS '更新时间';
COMMENT ON COLUMN material_group_base.remarks IS '备注信息';
COMMENT ON COLUMN material_group_base.del_flag IS '删除标记（0：正常；1：删除）';



