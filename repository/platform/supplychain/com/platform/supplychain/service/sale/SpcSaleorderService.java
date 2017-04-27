/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.service.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.platform.supplychain.entity.sale.SpcSaleorder;
import com.platform.supplychain.dao.sale.SpcSaleorderDao;
import com.platform.supplychain.entity.sale.SpcSaleorderEntry;
import com.platform.supplychain.dao.sale.SpcSaleorderEntryDao;

/**
 * 销售订单Service
 * @author 张江浩
 * @version 2017-04-26
 */
@Service
@Transactional(readOnly = true)
public class SpcSaleorderService extends CrudService<SpcSaleorderDao, SpcSaleorder> {

	@Autowired
	private SpcSaleorderEntryDao spcSaleorderEntryDao;
	
	public SpcSaleorder get(String id) {
		SpcSaleorder spcSaleorder = super.get(id);
		spcSaleorder.setSpcSaleorderEntryList(spcSaleorderEntryDao.findList(new SpcSaleorderEntry(spcSaleorder)));
		return spcSaleorder;
	}
	
	public List<SpcSaleorder> findList(SpcSaleorder spcSaleorder) {
		return super.findList(spcSaleorder);
	}
	
	public Page<SpcSaleorder> findPage(Page<SpcSaleorder> page, SpcSaleorder spcSaleorder) {
		return super.findPage(page, spcSaleorder);
	}
	
	@Transactional(readOnly = false)
	public void save(SpcSaleorder spcSaleorder) {
		super.save(spcSaleorder);
		for (SpcSaleorderEntry spcSaleorderEntry : spcSaleorder.getSpcSaleorderEntryList()){
			if (spcSaleorderEntry.getId() == null){
				continue;
			}
			if (SpcSaleorderEntry.DEL_FLAG_NORMAL.equals(spcSaleorderEntry.getDelFlag())){
				if (StringUtils.isBlank(spcSaleorderEntry.getId())){
					spcSaleorderEntry.setSpcSaleorder(spcSaleorder);
					spcSaleorderEntry.preInsert();
					spcSaleorderEntryDao.insert(spcSaleorderEntry);
				}else{
					spcSaleorderEntry.preUpdate();
					spcSaleorderEntryDao.update(spcSaleorderEntry);
				}
			}else{
				spcSaleorderEntryDao.delete(spcSaleorderEntry);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(SpcSaleorder spcSaleorder) {
		super.delete(spcSaleorder);
		spcSaleorderEntryDao.delete(new SpcSaleorderEntry(spcSaleorder));
	}
	
}