package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TOrganizationDao;
import com.qq.k3.seOrder.entity.TOrganization;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tOrganizationService")
@Transactional(readOnly = true)
public class TOrganizationService extends BaseServiceHBT<TOrganization, TOrganizationDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}