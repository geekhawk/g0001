package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.VIcitemDao;
import com.qq.k3.seOrder.entity.VIcitem;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("vIcitemService")
@Transactional(readOnly = true)
public class VIcitemService extends BaseServiceHBT<VIcitem, VIcitemDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}