package com.qq.k3.seOrder.dao;

import org.springframework.stereotype.Repository;

import com.qq.k3.seOrder.entity.SeOrder;
import com.qq.k3.seOrder.entity.SeOrderEntry;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseDaoHBT; 
@Repository 
public class SeOrderEntryDao extends BaseDaoHBT<SeOrderEntry>
{
 
	private static final long serialVersionUID = 1L;

	public SeOrderEntryDao()
	{
		// TODO Auto-generated constructor stub
	}

}
