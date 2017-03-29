/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.dao.base;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.platform.supplychain.entity.base.SpcCustomerBase;

/**
 * 物料信息DAO接口
 * @author 张江浩
 * @version 2017-03-28
 */
@MyBatisDao
public interface SpcCustomerBaseDao extends CrudDao<SpcCustomerBase> {
	
}