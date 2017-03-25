/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.service.base;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.platform.supplychain.entity.base.SpcMaterialGroupBase;
import com.platform.supplychain.dao.base.SpcMaterialGroupBaseDao;

/**
 * 物料基本分类_一体树Service
 * @author 张江浩
 * @version 2017-03-24
 */
@Service
@Transactional(readOnly = true)
public class SpcMaterialGroupBaseService extends TreeService<SpcMaterialGroupBaseDao, SpcMaterialGroupBase> {

	public SpcMaterialGroupBase get(String id) {
		return super.get(id);
	}
	
	public List<SpcMaterialGroupBase> findList(SpcMaterialGroupBase spcMaterialGroupBase) {
		if (StringUtils.isNotBlank(spcMaterialGroupBase.getParentIds())){
			spcMaterialGroupBase.setParentIds(","+spcMaterialGroupBase.getParentIds()+",");
		}
		return super.findList(spcMaterialGroupBase);
	}
	
	@Transactional(readOnly = false)
	public void save(SpcMaterialGroupBase spcMaterialGroupBase) {
		super.save(spcMaterialGroupBase);
	}
	
	@Transactional(readOnly = false)
	public void delete(SpcMaterialGroupBase spcMaterialGroupBase) {
		super.delete(spcMaterialGroupBase);
	}
	
}