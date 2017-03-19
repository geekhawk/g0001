/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.google.common.collect.Lists;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 物料信息Entity
 * @author 张江浩
 * @version 2017-03-08
 */
public class SpcMaterialBase extends DataEntity<SpcMaterialBase> {
	
	private static final long serialVersionUID = 1L;
	private String no;		// 编码
	private String name;		// 名称
	private String model;		// 规格
	private SpcMeasureunit  mearureunitId;		// 计量单位
	private Double price;		// 单价
	private Double length;		// 长度
	private Double width;		// 宽度
	private Double height;		// 高度
	private Double netweight;		// 净重
	private Double grossweight;		// 毛重
	private Date inDate;		// 加入日期
	private List<SpcMaterialInventory> spcMaterialInventoryList = Lists.newArrayList();		// 子表列表
	
	public SpcMaterialBase() {
		super();
	}

	public SpcMaterialBase(String id){
		super(id);
	}

	@Length(min=1, max=240, message="编码长度必须介于 1 和 240 之间")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@Length(min=0, max=100, message="名称长度必须介于 0 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=50, message="规格长度必须介于 0 和 50 之间")
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@NotNull(message="计量单位不能为空")
	public SpcMeasureunit getMearureunitId() {
		return mearureunitId;
	}

	public void setMearureunitId(SpcMeasureunit mearureunitId) {
		this.mearureunitId = mearureunitId;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}
	
	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}
	
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}
	
	public Double getNetweight() {
		return netweight;
	}

	public void setNetweight(Double netweight) {
		this.netweight = netweight;
	}
	
	public Double getGrossweight() {
		return grossweight;
	}

	public void setGrossweight(Double grossweight) {
		this.grossweight = grossweight;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	public List<SpcMaterialInventory> getSpcMaterialInventoryList() {
		return spcMaterialInventoryList;
	}

	public void setSpcMaterialInventoryList(List<SpcMaterialInventory> spcMaterialInventoryList) {
		this.spcMaterialInventoryList = spcMaterialInventoryList;
	}
}