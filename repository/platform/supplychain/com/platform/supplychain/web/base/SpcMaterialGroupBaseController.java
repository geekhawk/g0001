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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.platform.supplychain.entity.base.SpcMaterialGroupBase;
import com.platform.supplychain.service.base.SpcMaterialGroupBaseService;

/**
 * 物料基本分类_一体树Controller
 * @author 张江浩
 * @version 2017-03-24
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/base/spcMaterialGroupBase")
public class SpcMaterialGroupBaseController extends BaseController {

	@Autowired
	private SpcMaterialGroupBaseService spcMaterialGroupBaseService;
	
	@ModelAttribute
	public SpcMaterialGroupBase get(@RequestParam(required=false) String id) {
		SpcMaterialGroupBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = spcMaterialGroupBaseService.get(id);
		}
		if (entity == null){
			entity = new SpcMaterialGroupBase();
		}
		return entity;
	}
	
	@RequiresPermissions("supplychain:base:spcMaterialGroupBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(SpcMaterialGroupBase spcMaterialGroupBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		List<SpcMaterialGroupBase> list = spcMaterialGroupBaseService.findList(spcMaterialGroupBase); 
		model.addAttribute("list", list);
		return "platform/supplychain/base/spcMaterialGroupBaseList";
	}

	@RequiresPermissions("supplychain:base:spcMaterialGroupBase:view")
	@RequestMapping(value = "form")
	public String form(SpcMaterialGroupBase spcMaterialGroupBase, Model model) {
		if (spcMaterialGroupBase.getParent()!=null && StringUtils.isNotBlank(spcMaterialGroupBase.getParent().getId())){
			spcMaterialGroupBase.setParent(spcMaterialGroupBaseService.get(spcMaterialGroupBase.getParent().getId()));
			// 获取排序号，最末节点排序号+30
			if (StringUtils.isBlank(spcMaterialGroupBase.getId())){
				SpcMaterialGroupBase spcMaterialGroupBaseChild = new SpcMaterialGroupBase();
				spcMaterialGroupBaseChild.setParent(new SpcMaterialGroupBase(spcMaterialGroupBase.getParent().getId()));
				List<SpcMaterialGroupBase> list = spcMaterialGroupBaseService.findList(spcMaterialGroupBase); 
				if (list.size() > 0){
					spcMaterialGroupBase.setSort(list.get(list.size()-1).getSort());
					if (spcMaterialGroupBase.getSort() != null){
						spcMaterialGroupBase.setSort(spcMaterialGroupBase.getSort() + 30);
					}
				}
			}
		}
		if (spcMaterialGroupBase.getSort() == null){
			spcMaterialGroupBase.setSort(30);
		}
		model.addAttribute("spcMaterialGroupBase", spcMaterialGroupBase);
		return "platform/supplychain/base/spcMaterialGroupBaseForm";
	}

	@RequiresPermissions("supplychain:base:spcMaterialGroupBase:edit")
	@RequestMapping(value = "save")
	public String save(SpcMaterialGroupBase spcMaterialGroupBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, spcMaterialGroupBase)){
			return form(spcMaterialGroupBase, model);
		}
		spcMaterialGroupBaseService.save(spcMaterialGroupBase);
		addMessage(redirectAttributes, "保存物料基本分类_一体树成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMaterialGroupBase/?repage";
	}
	
	@RequiresPermissions("supplychain:base:spcMaterialGroupBase:edit")
	@RequestMapping(value = "delete")
	public String delete(SpcMaterialGroupBase spcMaterialGroupBase, RedirectAttributes redirectAttributes) {
		spcMaterialGroupBaseService.delete(spcMaterialGroupBase);
		addMessage(redirectAttributes, "删除物料基本分类_一体树成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMaterialGroupBase/?repage";
	}

	@RequiresPermissions("user")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String extId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<SpcMaterialGroupBase> list = spcMaterialGroupBaseService.findList(new SpcMaterialGroupBase());
		for (int i=0; i<list.size(); i++){
			SpcMaterialGroupBase e = list.get(i);
			if (StringUtils.isBlank(extId) || (extId!=null && !extId.equals(e.getId()) && e.getParentIds().indexOf(","+extId+",")==-1)){
				Map<String, Object> map = Maps.newHashMap();
				map.put("id", e.getId());
				map.put("pId", e.getParentId());
				map.put("name", e.getName());
				mapList.add(map);
			}
		}
		return mapList;
	}
	
}