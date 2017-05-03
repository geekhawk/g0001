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
import com.platform.supplychain.entity.base.SpcCustomerBase;
import com.platform.supplychain.dao.base.SpcCustomerBaseDao;
import com.platform.supplychain.entity.base.SpcCustomerPerson;
import com.platform.supplychain.dao.base.SpcCustomerPersonDao;

/**
 * 物料信息Service
 * @author 张江浩
 * @version 2017-03-28
 */
@Service
@Transactional(readOnly = true)
public class SpcCustomerBaseService extends CrudService<SpcCustomerBaseDao, SpcCustomerBase> {

	@Autowired
	private SpcCustomerPersonDao spcCustomerPersonDao;
	@Autowired
	private SpcCustomerBaseDao spcCustomerBaseDao;
	
	
	public SpcCustomerBase get(String id) {
		SpcCustomerBase spcCustomerBase = super.get(id);
		spcCustomerBase.setSpcCustomerPersonList(spcCustomerPersonDao.findList(new SpcCustomerPerson(spcCustomerBase)));
		return spcCustomerBase;
	}
	
	public List<SpcCustomerBase> findList(SpcCustomerBase spcCustomerBase) {
		return super.findList(spcCustomerBase);
	}
	
	public Page<SpcCustomerBase> findPage(Page<SpcCustomerBase> page, SpcCustomerBase spcCustomerBase) {
		return super.findPage(page, spcCustomerBase);
	}
	
	@Transactional(readOnly = false)
	public void save(SpcCustomerBase spcCustomerBase) {
		super.save(spcCustomerBase);
		for (SpcCustomerPerson spcCustomerPerson : spcCustomerBase.getSpcCustomerPersonList()){
			if (spcCustomerPerson.getId() == null){
				continue;
			}
			if (SpcCustomerPerson.DEL_FLAG_NORMAL.equals(spcCustomerPerson.getDelFlag())){
				if (StringUtils.isBlank(spcCustomerPerson.getId())){
					spcCustomerPerson.setSpcCustomerBaseId(spcCustomerBase);
					spcCustomerPerson.preInsert();
					spcCustomerPersonDao.insert(spcCustomerPerson);
				}else{
					spcCustomerPerson.preUpdate();
					spcCustomerPersonDao.update(spcCustomerPerson);
				}
			}else{
				spcCustomerPersonDao.delete(spcCustomerPerson);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(SpcCustomerBase spcCustomerBase) {
		super.delete(spcCustomerBase);
		spcCustomerPersonDao.delete(new SpcCustomerPerson(spcCustomerBase));
	}
	
	public List<SpcCustomerBase> findListByIds(List<String > ids ) {
		return spcCustomerBaseDao.findListByIds(   ids );
	}
	
}