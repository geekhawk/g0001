/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.web;

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
import com.thinkgem.jeesite.modules.sys.entity.Billcoder;
import com.thinkgem.jeesite.modules.sys.service.BillcoderService;

/**
 * 编码规则表Controller
 * @author zjh
 * @version 2017-03-23
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/billcoder")
public class BillcoderController extends BaseController {

	@Autowired
	private BillcoderService billcoderService;
	
	@ModelAttribute
	public Billcoder get(@RequestParam(required=false) String id) {
		Billcoder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = billcoderService.get(id);
		}
		if (entity == null){
			entity = new Billcoder();
		}
		return entity;
	}
	
	@RequiresPermissions("sys:billcoder:view")
	@RequestMapping(value = {"list", ""})
	public String list(Billcoder billcoder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Billcoder> page = billcoderService.findPage(new Page<Billcoder>(request, response), billcoder); 
		model.addAttribute("page", page);
		return "modules/sys/billcoderList";
	}

	@RequiresPermissions("sys:billcoder:view")
	@RequestMapping(value = "form")
	public String form(Billcoder billcoder, Model model) {
		if(billcoder.getNo()==null)
		{  
			Billcoder	bc =  new Billcoder(); 
			bc.setNo("BMGZ0001"); 
		  billcoder.setNo(billcoderService.createCode(billcoderService.findList(bc).get(0)));
		}
		model.addAttribute("billcoder", billcoder);
		return "modules/sys/billcoderForm";
	}

	@RequiresPermissions("sys:billcoder:edit")
	@RequestMapping(value = "save")
	public String save(Billcoder billcoder, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, billcoder)){
			return form(billcoder, model);
		}
		billcoderService.save(billcoder);
		addMessage(redirectAttributes, "保存编码规则表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/billcoder/?repage";
	}
	
	@RequiresPermissions("sys:billcoder:edit")
	@RequestMapping(value = "delete")
	public String delete(Billcoder billcoder, RedirectAttributes redirectAttributes) {
		billcoderService.delete(billcoder);
		addMessage(redirectAttributes, "删除编码规则表成功");
		return "redirect:"+Global.getAdminPath()+"/sys/billcoder/?repage";
	}

}