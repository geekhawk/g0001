/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.dao.sale;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.platform.supplychain.entity.sale.SpcSaleorder;

/**
 * 销售订单DAO接口
 * @author 张江浩
 * @version 2017-04-26
 */
@MyBatisDao
public interface SpcSaleorderDao extends CrudDao<SpcSaleorder> {
	
}