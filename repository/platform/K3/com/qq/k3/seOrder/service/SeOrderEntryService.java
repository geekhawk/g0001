package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.SeOrderEntryDao;
import com.qq.k3.seOrder.entity.SeOrderEntry;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("seorderEntryService")
@Transactional(readOnly = true)
public class SeOrderEntryService extends BaseServiceHBT<SeOrderEntry, SeOrderEntryDao>
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 
	
}