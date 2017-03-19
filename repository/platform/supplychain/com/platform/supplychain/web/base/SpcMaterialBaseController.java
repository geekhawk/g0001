/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.web.base;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.platform.supplychain.entity.base.SpcMaterialBase;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.platform.supplychain.service.base.SpcMaterialBaseService;
import com.platform.supplychain.service.base.SpcMeasureunitService;

/**
 * 物料信息Controller
 * @author 张江浩
 * @version 2017-03-08
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/base/spcMaterialBase")
public class SpcMaterialBaseController extends BaseController {

	@Autowired
	private SpcMaterialBaseService spcMaterialBaseService;
	@Autowired
	private SpcMeasureunitService   spcMeasureunitService;
	
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
		model.addAttribute("page", page);
		 
		return "platform/supplychain/base/spcMaterialBaseList";
	}

	@RequiresPermissions("supplychain:base:spcMaterialBase:view")
	@RequestMapping(value = "form")
	public String form(SpcMaterialBase spcMaterialBase, Model model) {
		model.addAttribute("spcMaterialBase", spcMaterialBase);
		List<SpcMeasureunit> muList1 = spcMeasureunitService.findList(new SpcMeasureunit() );
		 System.out.println(muList1.size());
		model.addAttribute("muList",muList1);
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

}