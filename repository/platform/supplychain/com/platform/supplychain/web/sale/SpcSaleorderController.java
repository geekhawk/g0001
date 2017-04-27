/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.platform.supplychain.web.sale;

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
import com.thinkgem.jeesite.modules.sys.utils.BillorderUtils;
import com.platform.supplychain.entity.base.SpcCustomerBase;
import com.platform.supplychain.entity.base.SpcMeasureunit;
import com.platform.supplychain.entity.sale.SpcSaleorder;
import com.platform.supplychain.service.base.SpcCustomerBaseService;
import com.platform.supplychain.service.base.SpcMeasureunitService;
import com.platform.supplychain.service.sale.SpcSaleorderService;

/**
 * 销售订单Controller
 * @author 张江浩
 * @version 2017-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/supplychain/sale/spcSaleorder")
public class SpcSaleorderController extends BaseController {

	@Autowired
	private SpcSaleorderService spcSaleorderService;
	@Autowired
	private SpcCustomerBaseService spcCustomerBaseService;
	@Autowired
	private SpcMeasureunitService spcMeasureunitService;
	
	@ModelAttribute
	public SpcSaleorder get(@RequestParam(required=false) String id) {
		SpcSaleorder entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = spcSaleorderService.get(id);
		}
		if (entity == null){
			entity = new SpcSaleorder();
		}
		return entity;
	}
	
	@RequiresPermissions("supplychain:sale:spcSaleorder:view")
	@RequestMapping(value = {"list", ""})
	public String list(SpcSaleorder spcSaleorder, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SpcSaleorder> page = spcSaleorderService.findPage(new Page<SpcSaleorder>(request, response), spcSaleorder); 
		model.addAttribute("page", page);
		return "platform/supplychain/sale/spcSaleorderList";
	}

	@RequiresPermissions("supplychain:sale:spcSaleorder:view")
	@RequestMapping(value = "form")
	public String form(SpcSaleorder spcSaleorder, Model model) {
		List<?> spcCustomerBaseList = spcCustomerBaseService.findList(new SpcCustomerBase());
		List<?> spcMeasureunitList = spcMeasureunitService.findList(new SpcMeasureunit());
		//新建页面，按编码规则取出编码
		if(spcSaleorder.getNo()==null)
		{  
			spcSaleorder.setNo(BillorderUtils.createCode( "BMGZ00000006")) ;
		}
		model.addAttribute("spcMeasureunitList",spcMeasureunitList );
		model.addAttribute("spcCustomerBaseList", spcCustomerBaseList);
		model.addAttribute("spcSaleorder", spcSaleorder);
		return "platform/supplychain/sale/spcSaleorderForm";
	}

	@RequiresPermissions("supplychain:sale:spcSaleorder:edit")
	@RequestMapping(value = "save")
	public String save(SpcSaleorder spcSaleorder, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, spcSaleorder)){
			return form(spcSaleorder, model);
		}
		spcSaleorderService.save(spcSaleorder);
		addMessage(redirectAttributes, "保存销售订单成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/sale/spcSaleorder/?repage";
	}
	
	@RequiresPermissions("supplychain:sale:spcSaleorder:edit")
	@RequestMapping(value = "delete")
	public String delete(SpcSaleorder spcSaleorder, RedirectAttributes redirectAttributes) {
		spcSaleorderService.delete(spcSaleorder);
		addMessage(redirectAttributes, "删除销售订单成功");
		return "redirect:"+Global.getAdminPath()+"/supplychain/sale/spcSaleorder/?repage";
	}

}