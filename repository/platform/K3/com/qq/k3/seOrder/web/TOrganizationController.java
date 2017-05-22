/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qq.k3.seOrder.web;

import java.util.List; 
import java.util.Map;   
import javax.servlet.http.HttpServletResponse;   
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;  
import com.thinkgem.jeesite.common.web.BaseController;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps; 
import com.qq.k3.seOrder.entity.TOrganization;
import com.qq.k3.seOrder.entity.VIcitem;
import com.qq.k3.seOrder.service.TOrganizationService;
import com.qq.k3.seOrder.service.VIcitemService;

/**
 * 销售订单Controller
 * 
 * @author 张江浩
 * @version 2017-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/qq/k3/tOrganization")
public class TOrganizationController extends BaseController
{

	@Autowired
	private TOrganizationService tOrganizationService; 
	@Autowired
	private VIcitemService vIcitemService;
	 
	
	@ModelAttribute
	public TOrganization get(@RequestParam(required = false) Integer fitemId)
		{
			TOrganization entity = null;
			if (fitemId != null)
			{
				 entity = tOrganizationService.findById(fitemId);
			}
			if (entity == null)
			{
				entity = new TOrganization();
			}
			return entity;
		}

	 
 
	
	@ResponseBody
	@RequestMapping(value = "getTOrganizationInfo")
	public Map<String, Object> getMaterialInfo(@RequestParam(required = true) Integer fitemid, HttpServletResponse response)
	{  
		List<Map<String, Object>> mapList = Lists.newArrayList();
		TOrganization  tOrganization = new TOrganization(); 
		tOrganization =tOrganizationService.findById(fitemid); 
		Map<String, Object> map = Maps.newHashMap(); 
		map.put("faddress", tOrganization.getFaddress());
		map.put("fdepartment", tOrganization.getFdepartment());  
		   
		mapList.add(map);

		return map;
	}
	

}