/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.web.base;

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
import com.platform.supplychain.entity.base.SpcCustomerBase;
import com.platform.supplychain.service.base.SpcCustomerBaseService;

/**
 * 物料信息Controller
 * @author 张江浩
 * @version 2017-03-28
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/base/spcCustomerBase")
public class SpcCustomerBaseController extends BaseController {

	@Autowired
	private SpcCustomerBaseService spcCustomerBaseService;
	
	@ModelAttribute
	public SpcCustomerBase get(@RequestParam(required=false) String id) {
		SpcCustomerBase entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = spcCustomerBaseService.get(id);
		}
		if (entity == null){
			entity = new SpcCustomerBase();
		}
		return entity;
	}
	
	@RequiresPermissions("supplychain:base:spcCustomerBase:view")
	@RequestMapping(value = {"list", ""})
	public String list(SpcCustomerBase spcCustomerBase, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SpcCustomerBase> page = spcCustomerBaseService.findPage(new Page<SpcCustomerBase>(request, response), spcCustomerBase); 
		model.addAttribute("page", page);
		return "platform/supplychain/base/spcCustomerBaseList";
	}

	@RequiresPermissions("supplychain:base:spcCustomerBase:view")
	@RequestMapping(value = "form")
	public String form(SpcCustomerBase spcCustomerBase, Model model) {
		model.addAttribute("spcCustomerBase", spcCustomerBase);
		return "platform/supplychain/base/spcCustomerBaseForm";
	}

	@RequiresPermissions("supplychain:base:spcCustomerBase:edit")
	@RequestMapping(value = "save")
	public String save(SpcCustomerBase spcCustomerBase, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, spcCustomerBase)){
			return form(spcCustomerBase, model);
		}
		spcCustomerBaseService.save(spcCustomerBase);
		addMessage(redirectAttributes, "保存物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcCustomerBase/?repage";
	}
	
	@RequiresPermissions("supplychain:base:spcCustomerBase:edit")
	@RequestMapping(value = "delete")
	public String delete(SpcCustomerBase spcCustomerBase, RedirectAttributes redirectAttributes) {
		spcCustomerBaseService.delete(spcCustomerBase);
		addMessage(redirectAttributes, "删除物料信息成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcCustomerBase/?repage";
	}

}