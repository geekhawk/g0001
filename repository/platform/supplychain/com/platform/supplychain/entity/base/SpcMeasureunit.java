/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.entity.base;

import com.thinkgem.jeesite.modules.sys.entity.User;
import javax.validation.constraints.NotNull;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 计量单位Entity
 * @author 张江浩
 * @version 2017-03-07
 */
public class SpcMeasureunit extends DataEntity<SpcMeasureunit> {
	
	private static final long serialVersionUID = 1L;
	private String no ; //编码 
	private String name;		// 名称
	private Date inDate;		// 加入日期
	
	public SpcMeasureunit() {
		super();
	}

	public SpcMeasureunit(String id){
		super(id);
	}

	 
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min =1,max =100,message="编号长度必须介于1到100之间")
	public String getNo()
	{
		return no;
	}

	public void setNo(String no)
	{
		this.no = no;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message="加入日期不能为空")
	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	
}