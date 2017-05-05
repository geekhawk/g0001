package com.tester.hibernate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT; 



@Service("userServiceHBT")
public class UserServiceHBT extends BaseServiceHBT<UserInfoBean,UserDaoHBT>
{
 private static final long serialVersionUID = 1L; 
	
}