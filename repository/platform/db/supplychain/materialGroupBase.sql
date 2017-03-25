
/* Drop Indexes */

DROP INDEX test_tree_del_flag;
DROP INDEX test_data_parent_id;
DROP INDEX test_data_parent_ids;



/* Drop Tables */

DROP TABLE material_group_base CASCADE CONSTRAINTS;




/* Create Tables */

-- ���ṹ��
CREATE TABLE material_group_base
(
	-- ���
	id varchar2(64) NOT NULL,
	-- ����
	no varchar2(100) UNIQUE,
	-- �������
	parent_id varchar2(64) NOT NULL,
	-- ���и������
	parent_ids varchar2(2000) NOT NULL,
	-- ����
	name nvarchar2(100) NOT NULL,
	-- ����
	sorts number(10,0) NOT NULL,
	-- ������
	create_by varchar2(64) NOT NULL,
	-- ����ʱ��
	create_date timestamp NOT NULL,
	-- ������
	update_by varchar2(64) NOT NULL,
	-- ����ʱ��
	update_date timestamp NOT NULL,
	-- ��ע��Ϣ
	remarks nvarchar2(255),
	-- ɾ����ǣ�0��������1��ɾ����
	del_flag char(1) DEFAULT '0' NOT NULL,
	PRIMARY KEY (id)
);



/* Create Indexes */

CREATE INDEX test_tree_del_flag ON material_group_base ();
CREATE INDEX test_data_parent_id ON material_group_base ();
CREATE INDEX test_data_parent_ids ON material_group_base ();



/* Comments */

COMMENT ON TABLE material_group_base IS '���ṹ��';
COMMENT ON COLUMN material_group_base.id IS '���';
COMMENT ON COLUMN material_group_base.no IS '����';
COMMENT ON COLUMN material_group_base.parent_id IS '�������';
COMMENT ON COLUMN material_group_base.parent_ids IS '���и������';
COMMENT ON COLUMN material_group_base.name IS '����';
COMMENT ON COLUMN material_group_base.sorts IS '����';
COMMENT ON COLUMN material_group_base.create_by IS '������';
COMMENT ON COLUMN material_group_base.create_date IS '����ʱ��';
COMMENT ON COLUMN material_group_base.update_by IS '������';
COMMENT ON COLUMN material_group_base.update_date IS '����ʱ��';
COMMENT ON COLUMN material_group_base.remarks IS '��ע��Ϣ';
COMMENT ON COLUMN material_group_base.del_flag IS 'ɾ����ǣ�0��������1��ɾ����';



