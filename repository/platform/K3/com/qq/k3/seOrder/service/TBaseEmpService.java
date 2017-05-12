package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TBaseEmpDao;
import com.qq.k3.seOrder.entity.TBaseEmp;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tBaseEmpService")
@Transactional(readOnly = true)
public class TBaseEmpService extends BaseServiceHBT<TBaseEmp, TBaseEmpDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}