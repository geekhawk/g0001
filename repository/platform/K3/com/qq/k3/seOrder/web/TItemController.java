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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps; 
import com.qq.k3.seOrder.entity.TItem;
import com.qq.k3.seOrder.entity.VIcitem;
import com.qq.k3.seOrder.service.TItemService;
import com.qq.k3.seOrder.service.VIcitemService;

/**
 * 销售订单Controller
 * 
 * @author 张江浩
 * @version 2017-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/qq/k3/tItem")
public class TItemController extends BaseController
{

	@Autowired
	private TItemService tItemService; 
	@Autowired
	private VIcitemService vIcitemService;
	 
	
	@ModelAttribute
	public TItem get(@RequestParam(required = false) Integer fitemId)
		{
			TItem entity = null;
			if (fitemId != null)
			{
				 entity = tItemService.findById(fitemId);
			}
			if (entity == null)
			{
				entity = new TItem();
			}
			return entity;
		}

	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		TItem item =  new TItem();
		item.setfItemClassID(4) ;
		item.setFdetail(false);
		List<TItem> list = tItemService.findListByExample(item);
		for (int i=0; i<list.size(); i++){
			TItem e = list.get(i);
			if (StringUtils.isBlank(extId))
			{
				Map<String, Object> map = Maps.newHashMap();
				map.put("id",e.getFitemId());
				map.put("pId", e.getFparentId());
				map.put("name", e.getFname());
				map.put("isParent", true);	
				mapList.add(map);
			}
		}
		return mapList;
	}
	
 
	@ResponseBody
	@RequestMapping(value = "treeDataSyn")
	public List<Map<String, Object>> treeDataSyn(@RequestParam(required=false) Integer pId,@RequestParam(required=false) String nameLike, HttpServletResponse response) 
		{
			List<Map<String, Object>> mapList = Lists.newArrayList();
			TItem tItem = new TItem();

			if (!"".equals(pId) && pId != null)
			{

				tItem.setFparentId(pId);
			} else if (!"".equals(nameLike) && nameLike != null)
			{

				tItem.setFname(nameLike);
			} else
			{
				return mapList;
			}
			List<TItem> list = tItemService.findListByExample(tItem);
			for (int i = 0; i < list.size(); i++)
			{
				TItem e = list.get(i);
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getFitemId());
				map.put("pId", e.getFparentId());
				map.put("name", e.getFname());
				map.put("isParent", false);
				map.put("title", e.getFfullName());
				mapList.add(map);
			} 
			return mapList;
		}
 
	
	@ResponseBody
	@RequestMapping(value = "getIcitemInfo")
	public Map<String, Object> getMaterialInfo(@RequestParam(required = true) Integer fitemid, HttpServletResponse response)
	{  
		List<Map<String, Object>> mapList = Lists.newArrayList();
		VIcitem  vIcitem = new VIcitem(); 
		vIcitem =vIcitemService.findById(fitemid); 
		Map<String, Object> map = Maps.newHashMap(); 
		map.put("price", vIcitem.getForderPrice());
		map.put("volume", vIcitem.getF102());  
		mapList.add(map);

		return map;
	}
	

}