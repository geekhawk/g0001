/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import java.util.Date;

import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 物料基本分类_一体树Entity
 * @author 张江浩
 * @version 2017-03-24
 */
public class SpcMaterialGroupBase extends TreeEntity<SpcMaterialGroupBase> {
	
	private static final long serialVersionUID = 1L;
	private String no;		// 编码
	private SpcMaterialGroupBase parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
	private Integer sort;		// 排序
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public SpcMaterialGroupBase() {
		super();
	}

	public SpcMaterialGroupBase(String id){
		super(id);
	}

	@Length(min=1, max=100, message="编码长度必须介于 1 和 100 之间")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public SpcMaterialGroupBase getParent() {
		return parent;
	}

	public void setParent(SpcMaterialGroupBase parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@NotNull(message="排序不能为空")
	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
	public Date getBeginCreateDate() {
		return beginCreateDate;
	}

	public void setBeginCreateDate(Date beginCreateDate) {
		this.beginCreateDate = beginCreateDate;
	}
	
	public Date getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(Date endCreateDate) {
		this.endCreateDate = endCreateDate;
	}
		
	public Date getBeginUpdateDate() {
		return beginUpdateDate;
	}

	public void setBeginUpdateDate(Date beginUpdateDate) {
		this.beginUpdateDate = beginUpdateDate;
	}
	
	public Date getEndUpdateDate() {
		return endUpdateDate;
	}

	public void setEndUpdateDate(Date endUpdateDate) {
		this.endUpdateDate = endUpdateDate;
	}
		
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}