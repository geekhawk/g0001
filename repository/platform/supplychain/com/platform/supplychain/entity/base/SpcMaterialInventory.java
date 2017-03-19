/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import org.hibernate.validator.constraints.Length;
import com.thinkgem.jeesite.modules.sys.entity.Office;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 物料信息Entity
 * @author 张江浩
 * @version 2017-03-08
 */
public class SpcMaterialInventory extends DataEntity<SpcMaterialInventory> {
	
	private static final long serialVersionUID = 1L;
	private SpcMaterialBase spcMaterialBase;		// 业务主表ID 父类
	private Office office;		// 所属部门
	private Double qty;		// 库存数量
	
	public SpcMaterialInventory() {
		super();
	}

	public SpcMaterialInventory(String id){
		super(id);
	}

	public SpcMaterialInventory(SpcMaterialBase spcMaterialBase ){
		this.spcMaterialBase = spcMaterialBase ;
	}

	@Length(min=0, max=64, message="业务主表ID长度必须介于 0 和 64 之间")
	public SpcMaterialBase getSpcMaterialBase () {
		return spcMaterialBase;
	}

	public void setSpcMaterialBase (SpcMaterialBase spcMaterialBase ) {
		this.spcMaterialBase = spcMaterialBase ;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}
	
}