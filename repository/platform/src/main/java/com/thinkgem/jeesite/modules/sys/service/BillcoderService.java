/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.TimeUtils;
import com.thinkgem.jeesite.modules.sys.entity.Billcoder;
import com.thinkgem.jeesite.modules.sys.dao.BillcoderDao;

/**
 * 编码规则表Service
 * 
 * @author zjh
 * @version 2017-03-23
 */
@Service
@Transactional(readOnly = true)
public class BillcoderService extends CrudService<BillcoderDao, Billcoder>
{

	public Billcoder get(String id)
	{
		return super.get(id);
	}

	public List<Billcoder> findList(Billcoder billcoder)
	{
		return super.findList(billcoder);
	}

	public Page<Billcoder> findPage(Page<Billcoder> page, Billcoder billcoder)
	{
		return super.findPage(page, billcoder);
	}

	@Transactional(readOnly = false)
	public void save(Billcoder billcoder)
	{
		super.save(billcoder);
	}

	@Transactional(readOnly = false)
	public void delete(Billcoder billcoder)
	{
		super.delete(billcoder);
	}

	
	public static void main(String args[])
	{
		Billcoder billcoder = new Billcoder();
		billcoder.setIncreassment(1);
		billcoder.setLastFlowDate(new Date() );
		billcoder.setCurrentFlowNo((long) 1);
		billcoder.setExpression("{C:J},{C:L},{C:D},{C:W},{C:-},{T:yyyy},{T:yy},{T:MM},{T:dd},{T:HH},{T:mm},{T:ss},{y:6}");
		//System.out.println( createCode(billcoder));
		System.out.println(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
	}
	

}