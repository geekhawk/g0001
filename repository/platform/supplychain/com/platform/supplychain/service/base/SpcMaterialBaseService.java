/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.platform.supplychain.entity.base.SpcMaterialBase;
import com.platform.supplychain.dao.base.SpcMaterialBaseDao;
import com.platform.supplychain.entity.base.SpcMaterialInventory;
import com.platform.supplychain.dao.base.SpcMaterialInventoryDao;

/**
 * 物料信息Service
 * @author 张江浩
 * @version 2017-03-22
 */
@Service
@Transactional(readOnly = true)
public class SpcMaterialBaseService extends CrudService<SpcMaterialBaseDao, SpcMaterialBase> {

	@Autowired
	private SpcMaterialInventoryDao spcMaterialInventoryDao;
	
	public SpcMaterialBase get(String id) {
		SpcMaterialBase spcMaterialBase = super.get(id);
		spcMaterialBase.setSpcMaterialInventoryList(spcMaterialInventoryDao.findList(new SpcMaterialInventory(spcMaterialBase)));
		return spcMaterialBase;
	}
	
	public List<SpcMaterialBase> findList(SpcMaterialBase spcMaterialBase) {
		return super.findList(spcMaterialBase);
	}
	
	public Page<SpcMaterialBase> findPage(Page<SpcMaterialBase> page, SpcMaterialBase spcMaterialBase) {
		return super.findPage(page, spcMaterialBase);
	}
	
	@Transactional(readOnly = false)
	public void save(SpcMaterialBase spcMaterialBase) {
		super.save(spcMaterialBase);
		for (SpcMaterialInventory spcMaterialInventory : spcMaterialBase.getSpcMaterialInventoryList()){
			if (spcMaterialInventory.getId() == null){
				continue;
			}
			if (SpcMaterialInventory.DEL_FLAG_NORMAL.equals(spcMaterialInventory.getDelFlag())){
				if (StringUtils.isBlank(spcMaterialInventory.getId())){
					spcMaterialInventory.setSpcMaterialBaseId(spcMaterialBase);
					spcMaterialInventory.preInsert();
					spcMaterialInventoryDao.insert(spcMaterialInventory);
				}else{
					spcMaterialInventory.preUpdate();
					spcMaterialInventoryDao.update(spcMaterialInventory);
				}
			}else{
				spcMaterialInventoryDao.delete(spcMaterialInventory);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(SpcMaterialBase spcMaterialBase) {
		super.delete(spcMaterialBase);
		spcMaterialInventoryDao.delete(new SpcMaterialInventory(spcMaterialBase));
	}
	
}