package com.qq.k3.seOrder.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qq.k3.seOrder.dao.SeorderDao;
import com.qq.k3.seOrder.pojo.Seorder;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT; 



@Service("seorderService")
public class SeorderService extends BaseServiceHBT< Seorder, SeorderDao>
{
 private static final long serialVersionUID = 1L; 
	
}