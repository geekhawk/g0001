/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import org.hibernate.validator.constraints.Length; 
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 编码规则表Entity
 * @author zjh
 * @version 2017-03-23
 */
public class Billcoder extends DataEntity<Billcoder> {
	
	private static final long serialVersionUID = 1L;
	private String no;		// 编码
	private String name;		// 名称
	private String expression;		// 编码规则
	private String isunique;		// 是否唯一(1:是;0:否)
	private Date lastFlowDate;		// 上次取出流水号时间
	private Integer increassment;		// 递增量
	private Long currentFlowNo;		// 当前流水号
	private Date beginLastFlowDate;		// 开始 上次取出流水号时间
	private Date endLastFlowDate;		// 结束 上次取出流水号时间
	private Date beginCreateDate;		// 开始 创建时间
	private Date endCreateDate;		// 结束 创建时间
	private Date beginUpdateDate;		// 开始 更新时间
	private Date endUpdateDate;		// 结束 更新时间
	
	public Billcoder() {
		super();
	}

	public Billcoder(String id){
		super(id);
	}

	@Length(min=1, max=100, message="编码长度必须介于 1 和 100 之间")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=200, message="编码规则长度必须介于 1 和 200 之间")
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
	
	@Length(min=1, max=4, message="是否唯一(1:是;0:否)长度必须介于 1 和 4 之间")
	public String getIsunique() {
		return isunique;
	}

	public void setIsunique(String isunique) {
		this.isunique = isunique;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="上次取出流水号时间不能为空")
	public Date getLastFlowDate() {
		return lastFlowDate;
	}

	public void setLastFlowDate(Date lastFlowDate) {
		this.lastFlowDate = lastFlowDate;
	}
	
	@NotNull(message="递增量不能为空")
	public Integer getIncreassment() {
		return increassment;
	}

	public void setIncreassment(Integer increassment) {
		this.increassment = increassment;
	}
	
	@NotNull(message="当前流水号不能为空")
	public Long getCurrentFlowNo() {
		return currentFlowNo;
	}

	public void setCurrentFlowNo(Long currentFlowNo) {
		this.currentFlowNo = currentFlowNo;
	}
	
	public Date getBeginLastFlowDate() {
		return beginLastFlowDate;
	}

	public void setBeginLastFlowDate(Date beginLastFlowDate) {
		this.beginLastFlowDate = beginLastFlowDate;
	}
	
	public Date getEndLastFlowDate() {
		return endLastFlowDate;
	}

	public void setEndLastFlowDate(Date endLastFlowDate) {
		this.endLastFlowDate = endLastFlowDate;
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