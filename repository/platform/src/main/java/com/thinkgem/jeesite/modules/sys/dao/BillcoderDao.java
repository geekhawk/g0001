/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Billcoder;

/**
 * 编码规则表DAO接口
 * @author zjh
 * @version 2017-03-23
 */
@MyBatisDao
public interface BillcoderDao extends CrudDao<Billcoder> {
	
}