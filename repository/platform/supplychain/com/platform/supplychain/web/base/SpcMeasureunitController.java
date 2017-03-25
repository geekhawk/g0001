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
import com.thinkgem.jeesite.modules.sys.utils.BillorderUtils;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.platform.supplychain.service.base.SpcMeasureunitService;

/**
 * 计量单位Controller
 * @author 张江浩
 * @version 2017-03-07
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/base/spcMeasureunit")
public class SpcMeasureunitController extends BaseController {

	@Autowired
	private SpcMeasureunitService spcMeasureunitService;
	
	@ModelAttribute
	public SpcMeasureunit get(@RequestParam(required=false) String id) {
		SpcMeasureunit entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = spcMeasureunitService.get(id);
		}
		if (entity == null){
			entity = new SpcMeasureunit();
		}
		return entity;
	}
	
	@RequiresPermissions("supplychain:base:spcMeasureunit:view")
	@RequestMapping(value = {"list", ""})
	public String list(SpcMeasureunit spcMeasureunit, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SpcMeasureunit> page = spcMeasureunitService.findPage(new Page<SpcMeasureunit>(request, response), spcMeasureunit); 
		model.addAttribute("page", page);
		return "platform/supplychain/base/spcMeasureunitList";
	}

	@RequiresPermissions("supplychain:base:spcMeasureunit:view")
	@RequestMapping(value = "form")
	public String form(SpcMeasureunit spcMeasureunit, Model model) {
		//新建页面，按编码规则取出编码
				if(spcMeasureunit.getNo()==null)
				{  
					spcMeasureunit.setNo(BillorderUtils.createCode( "BMGZ00000002")) ;
				}
		model.addAttribute("spcMeasureunit", spcMeasureunit);
		return "platform/supplychain/base/spcMeasureunitForm";
	}

	@RequiresPermissions("supplychain:base:spcMeasureunit:edit")
	@RequestMapping(value = "save")
	public String save(SpcMeasureunit spcMeasureunit, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, spcMeasureunit)){
			return form(spcMeasureunit, model);
		}
		spcMeasureunitService.save(spcMeasureunit);
		addMessage(redirectAttributes, "保存计量单位成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMeasureunit/?repage";
	}
	
	@RequiresPermissions("supplychain:base:spcMeasureunit:edit")
	@RequestMapping(value = "delete")
	public String delete(SpcMeasureunit spcMeasureunit, RedirectAttributes redirectAttributes) {
		spcMeasureunitService.delete(spcMeasureunit);
		addMessage(redirectAttributes, "删除计量单位成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/base/spcMeasureunit/?repage";
	}

}