package com.thinkgem.jeesite.common.hibernate.persistence;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;

/**
 * DAO支持类实现
 * 
 * @author zjh
 * @version 2014-05-16
 * @param <T>
 */
@Transactional(readOnly = true)
public  abstract  class BaseEntityHBT<Entity> implements EntityInterfaceHBT
{
	private static final long serialVersionUID = 1L;
	/**
	 * 当前实体分页对象
	 */
	protected Page<Entity> page;

	@JsonIgnore
	public String getDbName()
		{
			return Global.getConfig("jdbc.type");
		}

	@JsonIgnore
	@XmlTransient
	public Page<Entity> getPage()
		{
			if (page == null)
			{
				page = new Page<Entity>();
			}
			return page;
		}

	public Page<Entity> setPage(Page<Entity> page)
		{
			this.page = page;
			return page;
		}

}