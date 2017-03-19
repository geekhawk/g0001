/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.dao.base;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.platform.supplychain.entity.base.SpcMaterialInventory;

/**
 * 物料信息DAO接口
 * @author 张江浩
 * @version 2017-03-08
 */
@MyBatisDao
public interface SpcMaterialInventoryDao extends CrudDao<SpcMaterialInventory> {
	
}