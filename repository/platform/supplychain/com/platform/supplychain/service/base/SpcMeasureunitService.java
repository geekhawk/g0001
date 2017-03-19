/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.service.base;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.platform.supplychain.dao.base.SpcMeasureunitDao;

/**
 * 计量单位Service
 * @author 张江浩
 * @version 2017-03-07
 */
@Service
@Transactional(readOnly = true)
public class SpcMeasureunitService extends CrudService<SpcMeasureunitDao, SpcMeasureunit> {

	public SpcMeasureunit get(String id) {
		return super.get(id);
	}
	
	public List<SpcMeasureunit> findList(SpcMeasureunit spcMeasureunit) {
		return super.findList(spcMeasureunit);
	}
	
	public Page<SpcMeasureunit> findPage(Page<SpcMeasureunit> page, SpcMeasureunit spcMeasureunit) {
		return super.findPage(page, spcMeasureunit);
	}
	
	@Transactional(readOnly = false)
	public void save(SpcMeasureunit spcMeasureunit) {
		super.save(spcMeasureunit);
	}
	
	@Transactional(readOnly = false)
	public void delete(SpcMeasureunit spcMeasureunit) {
		super.delete(spcMeasureunit);
	}
	
}