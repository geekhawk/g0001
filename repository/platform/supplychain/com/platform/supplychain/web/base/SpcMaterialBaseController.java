/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.web.base;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.utils.BillorderUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.platform.supplychain.entity.base.SpcMaterialBase;
import com.platform.supplychain.entity.base.SpcMaterialGroupBase;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.platform.supplychain.service.base.SpcMaterialBaseService;
import com.platform.supplychain.service.base.SpcMeasureunitService;

/**
 * 物料信息Controller
 * @author 张江浩
 * @version 2017-03-22
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/base/spcMaterialBase")
public class SpcMaterialBaseController extends BaseController {

	@Autowired
	private SpcMaterialBaseService spcMaterialBaseService;
	@Autowired
	private SpcMeasureunitService spcMeasureunitService;
	
	@ModelAttribute
	public SpcMaterialBase get(@RequestParam(required=false) String id) {
		SpcMaterialBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = spcMaterialBaseService.get(id);
		}
		if (entity == null){
			entity = new SpcMaterialBase();
		}
		return entity;
	}
	
	@RequiresPermissions("supplychain:base:spcMaterialBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(SpcMaterialBase spcMaterialBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SpcMaterialBase> page = spcMaterialBaseService.findPage(new Page<SpcMaterialBase>(request, response), spcMaterialBase); 
		List<?> spcMeasureunitList = spcMeasureunitService.findList(new SpcMeasureunit());
		System.out.println(spcMeasureunitList.size());
		model.addAttribute("spcMeasureunitList",spcMeasureunitList );
		model.addAttribute("page", page);
		return "platform/supplychain/base/spcMaterialBaseList";
	}

	@RequiresPermissions("supplychain:base:spcMaterialBase:view")
	@RequestMapping(value = "form")
	public String form(SpcMaterialBase spcMaterialBase, Model model) {
		
		List<?> spcMeasureunitList = spcMeasureunitService.findList(new SpcMeasureunit());
		//新建页面，按编码规则取出编码
		if(spcMaterialBase.getNo()==null)
		{  
			spcMaterialBase.setNo(BillorderUtils.createCode( "BMGZ00000005")) ;
		}
		model.addAttribute("spcMeasureunitList",spcMeasureunitList );
		model.addAttribute("spcMaterialBase", spcMaterialBase);
		return "platform/supplychain/base/spcMaterialBaseForm";
	}

	@RequiresPermissions("supplychain:base:spcMaterialBase:edit")
	@RequestMapping(value = "save")
	public String save(SpcMaterialBase spcMaterialBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, spcMaterialBase)){
			return form(spcMaterialBase, model);
		}
		spcMaterialBaseService.save(spcMaterialBase);
		addMessage(redirectAttributes, "保存物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMaterialBase/?repage";
	}
	
	@RequiresPermissions("supplychain:base:spcMaterialBase:edit")
	@RequestMapping(value = "delete")
	public String delete(SpcMaterialBase spcMaterialBase, RedirectAttributes redirectAttributes) {
		spcMaterialBaseService.delete(spcMaterialBase);
		addMessage(redirectAttributes, "删除物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMaterialBase/?repage";
	}
	
	
 
	@ResponseBody
	@RequestMapping(value = "treeDataSyn")
	public List<Map<String, Object>> treeDataSyn(@RequestParam(required=false) String pId,@RequestParam(required=false) String nameLike, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
	      SpcMaterialBase spcMaterialBase = new SpcMaterialBase();
	     
		if(!"".equals(pId)&&pId!=null )
		{
			 SpcMaterialGroupBase spcMaterialGroupBase = new SpcMaterialGroupBase();
			 spcMaterialGroupBase.setId(pId);
			 spcMaterialBase.setGroupBase(spcMaterialGroupBase);
		}
		else if(!"".equals(nameLike)&&nameLike!=null )
		{
		  
			spcMaterialBase.setName(nameLike);  
		}
		else{return mapList;}
		
		
		List<SpcMaterialBase> list = spcMaterialBaseService.findList(spcMaterialBase) ;
		for (int i=0; i<list.size(); i++){
			SpcMaterialBase e = list.get(i);
			 
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getGroupBase().getId());
				map.put("name", e.getName()); 
				 
				{
				  map.put("isParent", false);	
				
					
				}  
				map.put("title",  e.getRemarks());	
				mapList.add(map); 
			 
		}
		  
		return mapList;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "getMaterialInfo")
	public Map<String, Object> getMaterialInfo(@RequestParam(required = true) String materialid, HttpServletResponse response)
	{  System.out.println("materialid:"+materialid);
		List<Map<String, Object>> mapList = Lists.newArrayList();
		SpcMaterialBase spcMaterialBase = new SpcMaterialBase();

		spcMaterialBase = spcMaterialBaseService.get(materialid);

		Map<String, Object> map = Maps.newHashMap();
		map.put("mearureunit", spcMaterialBase.getMearureunit());
		map.put("price", spcMaterialBase.getPrice());
		map.put("volume", spcMaterialBase.getVolume());
		map.put("weight", spcMaterialBase.getGrossweight());

		mapList.add(map);

		return map;
	}
	
	
	
}