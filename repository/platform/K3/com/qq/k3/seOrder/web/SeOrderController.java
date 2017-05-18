/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.qq.k3.seOrder.web;

import java.util.ArrayList;
import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.qq.k3.seOrder.entity.SeOrder;
import com.qq.k3.seOrder.entity.SeOrderId;
import com.qq.k3.seOrder.entity.TBaseEmp;
import com.qq.k3.seOrder.entity.TBaseUser;
import com.qq.k3.seOrder.entity.TDepartment;
import com.qq.k3.seOrder.entity.TMeasureUnit;
import com.qq.k3.seOrder.entity.TOrganization;
import com.qq.k3.seOrder.service.SeOrderService;
import com.qq.k3.seOrder.service.TBaseEmpService;
import com.qq.k3.seOrder.service.TBaseUserService;
import com.qq.k3.seOrder.service.TDepartmentService;
import com.qq.k3.seOrder.service.TMeasureUnitService;
import com.qq.k3.seOrder.service.TOrganizationService;

/**
 * 销售订单Controller
 * 
 * @author 张江浩
 * @version 2017-04-26
 */
@Controller
@RequestMapping(value = "${adminPath}/qq/k3/seOrder")
public class SeOrderController extends BaseController
{

	@Autowired
	private SeOrderService seOrderService; 
	@Autowired
	private TOrganizationService tOrganizationService;
	@Autowired
	TDepartmentService tDepartmentService;
	@Autowired
	TBaseEmpService tBaseEmpService;
	@Autowired
	TMeasureUnitService tMeasureUnitService;
	@Autowired
	TBaseUserService tBaseUserService;
	
	@ModelAttribute
	public SeOrder get(@RequestParam(required = false) Integer finterId,Model model)
		{

			// 添加客户
			List<TOrganization> tOrganizationList = tOrganizationService.findList(new TOrganization(), null, null);
			model.addAttribute("tOrganizationList", tOrganizationList);
			// 添加部门
			List<TDepartment> tDepartmentList = tDepartmentService.findList(new TDepartment(), null, null);
			model.addAttribute("tDepartmentList", tDepartmentList);
			// 添加业务员
			List<TBaseEmp> tBaseEmpList = tBaseEmpService.findList(new TBaseEmp(), null, null);
			model.addAttribute("tBaseEmpList", tBaseEmpList);
			// 添加计量单位
			List<TMeasureUnit> tMeasureUnitList = tMeasureUnitService.findList(new TMeasureUnit(), null, null);
			model.addAttribute("tMeasureUnitList", tMeasureUnitList);
			
			
			SeOrder entity = null;
			if (finterId != null)
			{
				SeOrderId seOrderId = new SeOrderId("0", finterId);
				entity = seOrderService.findById(seOrderId);
			}
			if (entity == null)
			{
				entity = new SeOrder();
			}
			return entity;
		}

	@RequiresPermissions("qq:k3:seOrder:view")
	@RequestMapping(value = { "list", "" })
	public String list(SeOrder seOrder, HttpServletRequest request, HttpServletResponse response, Model model)
		{
			//添加前台过滤条件
			//添加客户
			 
			//添加后台过滤条件，添加排序
			List<Criterion> criterionList = new ArrayList<Criterion>();
			if(seOrder!=null)
			{
			
		     //添加单号
			if(!StringUtils.isBlank(seOrder.getFbillNo()) )
			criterionList.add(Restrictions.like("fbillNo", seOrder.getFbillNo(), MatchMode.ANYWHERE) );
			 //添加部门
			if( null!=seOrder.getTDepartment()&&null!=seOrder.getTDepartment().getFitemId() )
			criterionList.add(Restrictions.eq("TDepartment.fitemId", seOrder.getTDepartment().getFitemId()));
			//添加客户
			if( null!=seOrder.getTOrganization() &&null!=seOrder.getTOrganization().getFitemId())
				criterionList.add(Restrictions.eq("TOrganization.fitemId", seOrder.getTOrganization().getFitemId()));
			 //添加业务员
			if(null!= seOrder.getTBaseEmp() &&null!=seOrder.getTBaseEmp().getFitemId()) 
				criterionList.add(Restrictions.eq("TBaseEmp.fitemId", seOrder.getTBaseEmp().getFitemId()));
			//添加日期
			if( null!=seOrder.getfBegindate()&& null!=seOrder.getfEnddate())
				criterionList.add(Restrictions.between("fdate", seOrder.getfBegindate(), seOrder.getfEnddate())); 
			 }
			
			//添加后台排序条件 
			List<Order> orderList = new ArrayList<Order>();
			if(seOrder!=null)
			{
			   orderList.add(Order.desc("fdate")); 
			 }
			 
			Page<SeOrder> page = seOrderService.findPage(new Page<SeOrder>(request, response),seOrder, orderList, criterionList);
			model.addAttribute("page", page); 
			//添加显示页面过滤条件选择
			 return "qq/k3/seOrderList";
		}
	
	
	
	@RequiresPermissions("qq:k3:seOrder:edit")
	@RequestMapping(value = "form")
	public String form(SeOrder seOrder, Model model)
		{
			 if (null != seOrder.getId())
			 	seOrder = seOrderService.findById(seOrder.getId());
			 else
			 	seOrder = new SeOrder();
			    model.addAttribute("seOrder", seOrder);
			return "qq/k3/seOrderForm";
		}
 

 
 /*
 * 
 */
	@RequiresPermissions("qq:k3:seOrder:edit")
	@RequestMapping(value = "save")
	public String save(SeOrder seOrder, Model model, RedirectAttributes redirectAttributes)
		{   
			if (!beanValidator(model, seOrder))
			{
				return form(seOrder, model);
			}
			User currentUser = UserUtils.getUser();
			TBaseUser  tBaseUser =  new TBaseUser();
		 
			tBaseUser = tBaseUserService.findById(Integer.parseInt(currentUser.getNo()));
			seOrder.setTBaseUser(tBaseUser);
			seOrderService.add(seOrder);
			addMessage(redirectAttributes, "保存销售订单成功");
			return "redirect:" + Global.getAdminPath() + "/qq/k3/seOrder/list";
		}

	@RequiresPermissions("qq:k3:seOrder:edit")
	@RequestMapping(value = "delete")
	public String delete(SeOrder seOrder, RedirectAttributes redirectAttributes)
		{
			seOrderService.delete(seOrder);
			addMessage(redirectAttributes, "删除销售订单成功");
			return "redirect:" + Global.getAdminPath() + "/qq/k3/seOrder/list";
		}

}