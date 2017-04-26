/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 物料信息Entity
 * @author 张江浩
 * @version 2017-03-28
 */
public class SpcCustomerPerson extends DataEntity<SpcCustomerPerson> {
	
	private static final long serialVersionUID = 1L;
	private SpcCustomerBase spcCustomerBase;		// 客户主表ID 父类
	private User person;		// 人员
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public SpcCustomerPerson() {
		super();
	}

	public SpcCustomerPerson(String id){
		super(id);
	}

	public SpcCustomerPerson(SpcCustomerBase spcCustomerBase){
		this.spcCustomerBase = spcCustomerBase;
	}

	@Length(min=0, max=64, message="客户主表ID长度必须介于 0 和 64 之间")
	public SpcCustomerBase getSpcCustomerBaseId() {
		return spcCustomerBase;
	}

	public void setSpcCustomerBaseId(SpcCustomerBase spcCustomerBase) {
		this.spcCustomerBase = spcCustomerBase;
	}
	
	@Length(min=0, max=64, message="人员长度必须介于 0 和 64 之间")
	public User getPerson() {
		return person;
	}

	public void setPerson(User person) {
		this.person = person;
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
		
}