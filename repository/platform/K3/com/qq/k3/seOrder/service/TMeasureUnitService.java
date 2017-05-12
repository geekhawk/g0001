package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TMeasureUnitDao;
import com.qq.k3.seOrder.dao.TOrganizationDao;
import com.qq.k3.seOrder.entity.TMeasureUnit;
import com.qq.k3.seOrder.entity.TOrganization;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tMeasureUnitService")
@Transactional(readOnly = true)
public class TMeasureUnitService extends BaseServiceHBT<TMeasureUnit, TMeasureUnitDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}