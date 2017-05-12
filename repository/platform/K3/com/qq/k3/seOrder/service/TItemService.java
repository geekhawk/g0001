package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TItemDao;
import com.qq.k3.seOrder.entity.TItem;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tItemService")
@Transactional(readOnly = true)
public class TItemService extends BaseServiceHBT<TItem, TItemDao>
{ 
	private static final long serialVersionUID = 1L;
 
	 

}