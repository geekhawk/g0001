/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.sale;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

import com.google.common.collect.Lists;
import com.platform.supplychain.entity.base.SpcCustomerBase;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 销售订单Entity
 * @author 张江浩
 * @version 2017-04-26
 */
public class SpcSaleorder extends DataEntity<SpcSaleorder> {
	
	private static final long serialVersionUID = 1L;
	private String no;		// 编码
	private SpcCustomerBase customer;		// 客户
	private Date orderdate;		// 下单日期
	private Double totalamount;		// 合计金额
	private Double totalvolume;		// 合计体积
	private Double totalweight;		// 合计重量
	private Date beginOrderdate;		// 开始 下单日期
	private Date endOrderdate;		// 结束 下单日期
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private List<SpcSaleorderEntry> spcSaleorderEntryList = Lists.newArrayList();		// 子表列表
	
	public SpcSaleorder() {
		super();
	}

	public SpcSaleorder(String id){
		super(id);
	}

	@Length(min=1, max=60, message="编码长度必须介于 1 和 60 之间")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@NotNull(message="客户不能为空")
	public SpcCustomerBase getCustomer() {
		return customer;
	}

	public void setCustomer(SpcCustomerBase customer) {
		this.customer = customer;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="下单日期不能为空")
	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	@NotNull(message="合计金额不能为空")
	public Double getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}
	
	@NotNull(message="合计体积不能为空")
	public Double getTotalvolume() {
		return totalvolume;
	}

	public void setTotalvolume(Double totalvolume) {
		this.totalvolume = totalvolume;
	}
	
	@NotNull(message="合计重量不能为空")
	public Double getTotalweight() {
		return totalweight;
	}

	public void setTotalweight(Double totalweight) {
		this.totalweight = totalweight;
	}
	
	public Date getBeginOrderdate() {
		return beginOrderdate;
	}

	public void setBeginOrderdate(Date beginOrderdate) {
		this.beginOrderdate = beginOrderdate;
	}
	
	public Date getEndOrderdate() {
		return endOrderdate;
	}

	public void setEndOrderdate(Date endOrderdate) {
		this.endOrderdate = endOrderdate;
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
		
	public List<SpcSaleorderEntry> getSpcSaleorderEntryList() {
		return spcSaleorderEntryList;
	}

	public void setSpcSaleorderEntryList(List<SpcSaleorderEntry> spcSaleorderEntryList) {
		this.spcSaleorderEntryList = spcSaleorderEntryList;
	}
}