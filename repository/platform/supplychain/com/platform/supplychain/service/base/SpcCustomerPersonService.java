/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.CrudService;
import com.platform.supplychain.entity.base.SpcCustomerPerson;
import com.platform.supplychain.dao.base.SpcCustomerPersonDao;

/**
 * 物料信息Service
 * @author 张江浩
 * @version 2017-03-28
 */
@Service
@Transactional(readOnly = true)
public class SpcCustomerPersonService extends CrudService<SpcCustomerPersonDao, SpcCustomerPerson> {

	 
	public List<SpcCustomerPerson> findList(SpcCustomerPerson spcCustomerPerson) {
		return super.findList(spcCustomerPerson);
	}
	 
	
	 
	
}