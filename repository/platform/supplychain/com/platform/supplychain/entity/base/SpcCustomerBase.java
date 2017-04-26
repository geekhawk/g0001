/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.modules.sys.entity.Area;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.List;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 物料信息Entity
 * @author 张江浩
 * @version 2017-03-28
 */
public class SpcCustomerBase extends DataEntity<SpcCustomerBase> {
	
	private static final long serialVersionUID = 1L;
	 
	private String no;		// 营业执照编号
	private String name;		//名称
	private User saleperson;		// 业务代表
	private Office office;		// 部门
	private Area area;		// 所在地
	private String address;		// 地址
	private String conPerson;		// 联系人
	private String conPersonPosition;		// 联系人职务
	private String officePhone;		// 办公电话
	private String mobilePhone;		// 手机
	private String fax;		// 传真
	private String email;		// email
	private String invoiceType;		// 开票类型
	private String taxNo;		// 税务登记号
	private String taxBank;		// 开户银行
	private String taxBankNo;		// 银行账号
	private String taxAddress;		// 开票地址
	private String taxPhone;		// 开票电话
	private Date inDate;		// 加入日期
	private List<SpcCustomerPerson> spcCustomerPersonList = Lists.newArrayList();		// 子表列表
	
	public SpcCustomerBase() {
		super();
	}

	public SpcCustomerBase(String id){
		super(id);
	}
 
	@Length(min=1, max=64, message="营业执照编号长度必须介于 1 和 64 之间")
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
	@Length(min=1, max=64, message="名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	public User getSaleperson() {
		return saleperson;
	}

	public void setSaleperson(User saleperson) {
		this.saleperson = saleperson;
	}
	
	@NotNull(message="部门不能为空")
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	@NotNull(message="所在地不能为空")
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=1, max=400, message="地址长度必须介于 1 和 400 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=64, message="联系人长度必须介于 0 和 64 之间")
	public String getConPerson() {
		return conPerson;
	}

	public void setConPerson(String conPerson) {
		this.conPerson = conPerson;
	}
	
	@Length(min=0, max=64, message="联系人职务长度必须介于 0 和 64 之间")
	public String getConPersonPosition() {
		return conPersonPosition;
	}

	public void setConPersonPosition(String conPersonPosition) {
		this.conPersonPosition = conPersonPosition;
	}
	
	@Length(min=0, max=64, message="办公电话长度必须介于 0 和 64 之间")
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	
	@Length(min=0, max=64, message="手机长度必须介于 0 和 64 之间")
	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	
	@Length(min=0, max=64, message="传真长度必须介于 0 和 64 之间")
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	
	@Length(min=0, max=64, message="email长度必须介于 0 和 64 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=3, message="开票类型长度必须介于 0 和 3 之间")
	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	
	@Length(min=0, max=32, message="税务登记号长度必须介于 0 和 32 之间")
	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}
	
	@Length(min=0, max=320, message="开户银行长度必须介于 0 和 320 之间")
	public String getTaxBank() {
		return taxBank;
	}

	public void setTaxBank(String taxBank) {
		this.taxBank = taxBank;
	}
	
	@Length(min=0, max=32, message="银行账号长度必须介于 0 和 32 之间")
	public String getTaxBankNo() {
		return taxBankNo;
	}

	public void setTaxBankNo(String taxBankNo) {
		this.taxBankNo = taxBankNo;
	}
	
	@Length(min=0, max=320, message="开票地址长度必须介于 0 和 320 之间")
	public String getTaxAddress() {
		return taxAddress;
	}

	public void setTaxAddress(String taxAddress) {
		this.taxAddress = taxAddress;
	}
	
	@Length(min=0, max=32, message="开票电话长度必须介于 0 和 32 之间")
	public String getTaxPhone() {
		return taxPhone;
	}

	public void setTaxPhone(String taxPhone) {
		this.taxPhone = taxPhone;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
	public List<SpcCustomerPerson> getSpcCustomerPersonList() {
		return spcCustomerPersonList;
	}

	public void setSpcCustomerPersonList(List<SpcCustomerPerson> spcCustomerPersonList) {
		this.spcCustomerPersonList = spcCustomerPersonList;
	}
}