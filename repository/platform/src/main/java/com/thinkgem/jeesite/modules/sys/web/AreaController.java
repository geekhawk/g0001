/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

import java.util.List;
import java.util.Map;

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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.service.AreaService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;

/**
 * 区域Controller
 * @author ThinkGem
 * @version 2013-5-15
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/area")
public class AreaController extends BaseController {

	@Autowired
	private AreaService areaService;
	
	@ModelAttribute("area")
	public Area get(@RequestParam(required=false) String id) {
		if (StringUtils.isNotBlank(id)){
			return areaService.get(id);
		}else{
			return new Area();
		}
	}

	@RequiresPermissions("sys:area:view")
	@RequestMapping(value = {"list", ""})
	public String list(Area area, Model model) {
		model.addAttribute("list", areaService.findAll());
		return "modules/sys/areaList";
	}

	@RequiresPermissions("sys:area:view")
	@RequestMapping(value = "form")
	public String form(Area area, Model model) {
		if (area.getParent()==null||area.getParent().getId()==null){
			area.setParent(UserUtils.getUser().getOffice().getArea());
		}
		area.setParent(areaService.get(area.getParent().getId()));
//		// 自动获取排序号
//		if (StringUtils.isBlank(area.getId())){
//			int size = 0;
//			List<Area> list = areaService.findAll();
//			for (int i=0; i<list.size(); i++){
//				Area e = list.get(i);
//				if (e.getParent()!=null && e.getParent().getId()!=null
//						&& e.getParent().getId().equals(area.getParent().getId())){
//					size++;
//				}
//			}
//			area.setCode(area.getParent().getCode() + StringUtils.leftPad(String.valueOf(size > 0 ? size : 1), 4, "0"));
//		}
		model.addAttribute("area", area);
		return "modules/sys/areaForm";
	}
	
	@RequiresPermissions("sys:area:edit")
	@RequestMapping(value = "save")
	public String save(Area area, Model model, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/area";
		}
		if (!beanValidator(model, area)){
			return form(area, model);
		}
		areaService.save(area);
		addMessage(redirectAttributes, "保存区域'" + area.getName() + "'成功");
		return "redirect:" + adminPath + "/sys/area/";
	}
	
	@RequiresPermissions("sys:area:edit")
	@RequestMapping(value = "delete")
	public String delete(Area area, RedirectAttributes redirectAttributes) {
		if(Global.isDemoMode()){
			addMessage(redirectAttributes, "演示模式，不允许操作！");
			return "redirect:" + adminPath + "/sys/area";
		}
//		if (Area.isRoot(id)){
//			addMessage(redirectAttributes, "删除区域失败, 不允许删除顶级区域或编号为空");
//		}else{
			areaService.delete(area);
			addMessage(redirectAttributes, "删除区域成功");
//		}
		return "redirect:" + adminPath + "/sys/area/";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		Area area = new Area();
		area.setId("1");
		List<Area> list = areaService.findList(area) ;
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				if(!"5".equals(e.getType()))
				{
				 map.put("isParent", true);
				}
				else
				{
				  map.put("isParent", false);	
					
				}
				mapList.add(map);
			}
		}
 /*  临时作用，获取longname
		List<Area> list1 = areaService.findAll();
		for(int i=0;i<list1.size();i++)
		{
			Area area1 = list1.get(i);
			  String names[] =  area1.getName().split("-");
		       area1.setName(names[names.length-1]);
		   area1.setRemarks(getLongName(area1, areaService ));
		   names  =  area1.getName().split("-");
	       area1.setName(names[names.length-1]);
		   System.out.println( area1.getRemarks() ); 
		   areaService.save(area1);
		}
		 
		  */
		 
		return mapList;
	}
	

/**
* 临时作用，获取longname
*/
	
	public static String getLongName(Area area,AreaService areaService )
	{
		Area areaP = area.getParent();
		while(areaP!=null&& areaP.getName()!=null)
		{  String names[] =  areaP.getName().split("-");
		     areaP.setName(names[names.length-1]);
		    area.setName(areaP.getName()+"-"+area.getName());
		    areaP = areaService.get(areaP.getId());
		    if(areaP!=null)
		    areaP = areaP.getParent();
		     
		}
		
		return area.getName();
		
		
		
	}
	
	
	
	
	
	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeDataSyn")
	public List<Map<String, Object>> treeDataSyn(@RequestParam(required=false) String pId,@RequestParam(required=false) String nameLike, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
	 
		
		Area area = new Area();
		
		if(!"".equals(pId)&&pId!=null )
		{
		  Area pArea = new Area();
		  pArea.setId(pId);
		  area.setParent(pArea); 
		}
		else if(!"".equals(nameLike)&&nameLike!=null )
		{
		  
		  area.setName(nameLike);  
		}
		else{return mapList;}
		
		
		List<Area> list = areaService.findList(area) ;
		for (int i=0; i<list.size(); i++){
			Area e = list.get(i);
			 
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName()); 
				if(!"5".equals(e.getType()))
				{
				 map.put("isParent", true);
				}
				else
				{
				  map.put("isParent", false);	
				
					
				}  
				map.put("title",  e.getRemarks());	
				mapList.add(map); 
			 
		}
		  
		return mapList;
	}
}
