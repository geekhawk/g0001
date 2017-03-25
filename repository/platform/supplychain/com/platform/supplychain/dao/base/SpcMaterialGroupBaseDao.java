/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.dao.base;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.platform.supplychain.entity.base.SpcMaterialGroupBase;

/**
 * 物料基本分类_一体树DAO接口
 * @author 张江浩
 * @version 2017-03-24
 */
@MyBatisDao
public interface SpcMaterialGroupBaseDao extends TreeDao<SpcMaterialGroupBase> {
	
}