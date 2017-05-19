package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TBaseEmpDao;
import com.qq.k3.seOrder.dao.TBaseUserDao;
import com.qq.k3.seOrder.entity.TBaseEmp;
import com.qq.k3.seOrder.entity.TBaseUser;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tBaseUserService")
@Transactional(readOnly = true)
public class TBaseUserService extends BaseServiceHBT<TBaseUser, TBaseUserDao>
{
	private static final long serialVersionUID = 1L;
 
	 

}