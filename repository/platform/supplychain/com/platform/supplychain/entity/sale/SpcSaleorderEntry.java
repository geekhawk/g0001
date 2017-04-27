/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.sale;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import com.platform.supplychain.entity.base.SpcMaterialBase;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 销售订单Entity
 * @author 张江浩
 * @version 2017-04-26
 */
public class SpcSaleorderEntry extends DataEntity<SpcSaleorderEntry> {
	
	private static final long serialVersionUID = 1L;
	private SpcSaleorder spcSaleorder;		// 业务主表ID 父类
	private SpcMaterialBase material;		// 产品
	private SpcMeasureunit measureunit;		// 计量单位
	private String isgift;		// 是否赠品（0，1）
	private Double qty;		// 数量
	private Double price;		// 单价
	private Double amount;		// 金额
	private Double unitvolume;		// 单位体积
	private Double volume;		// 体积
	private Double unitweight;		// 单位重量
	private Double weight;		// 重量
	
	public SpcSaleorderEntry() {
		super();
	}

	public SpcSaleorderEntry(String id){
		super(id);
	}

	public SpcSaleorderEntry(SpcSaleorder spcSaleorder){
		this.spcSaleorder = spcSaleorder;
	}

	@Length(min=0, max=64, message="业务主表ID长度必须介于 0 和 64 之间")
	public SpcSaleorder getSpcSaleorder() {
		return spcSaleorder;
	}

	public void setSpcSaleorder(SpcSaleorder spcSaleorder) {
		this.spcSaleorder = spcSaleorder;
	}
	
	@Length(min=1, max=64, message="产品长度必须介于 1 和 64 之间")
	public SpcMaterialBase getMaterial() {
		return material;
	}

	public void setMaterial(SpcMaterialBase material) {
		this.material = material;
	}
	
	@Length(min=1, max=64, message="计量单位长度必须介于 1 和 64 之间")
	public SpcMeasureunit getMeasureunit() {
		return measureunit;
	}

	public void setMeasureunit(SpcMeasureunit measureunit) {
		this.measureunit = measureunit;
	}
	
	@Length(min=1, max=1, message="是否赠品（0，1）长度必须介于 1 和 1 之间")
	public String getIsgift() {
		return isgift;
	}

	public void setIsgift(String isgift) {
		this.isgift = isgift;
	}
	
	@NotNull(message="数量不能为空")
	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}
	
	@NotNull(message="单价不能为空")
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	@NotNull(message="金额不能为空")
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Double getUnitvolume() {
		return unitvolume;
	}

	public void setUnitvolume(Double unitvolume) {
		this.unitvolume = unitvolume;
	}
	
	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}
	
	public Double getUnitweight() {
		return unitweight;
	}

	public void setUnitweight(Double unitweight) {
		this.unitweight = unitweight;
	}
	
	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
}