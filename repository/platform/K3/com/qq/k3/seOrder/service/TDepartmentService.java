package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TDepartmentDao;
import com.qq.k3.seOrder.entity.TDepartment;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tDepartmentService")
@Transactional(readOnly = true)
public class TDepartmentService extends BaseServiceHBT<TDepartment, TDepartmentDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}