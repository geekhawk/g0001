/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.utils.TimeUtils;
import com.thinkgem.jeesite.modules.sys.entity.Billcoder;
import com.thinkgem.jeesite.modules.sys.dao.BillcoderDao;

/**
 * 编码规则表Service
 * 
 * @author zjh
 * @version 2017-03-23
 */
@Service
@Transactional(readOnly = true)
public class BillcoderService extends CrudService<BillcoderDao, Billcoder>
{

	public Billcoder get(String id)
	{
		return super.get(id);
	}

	public List<Billcoder> findList(Billcoder billcoder)
	{
		return super.findList(billcoder);
	}

	public Page<Billcoder> findPage(Page<Billcoder> page, Billcoder billcoder)
	{
		return super.findPage(page, billcoder);
	}

	@Transactional(readOnly = false)
	public void save(Billcoder billcoder)
	{
		super.save(billcoder);
	}

	@Transactional(readOnly = false)
	public void delete(Billcoder billcoder)
	{
		super.delete(billcoder);
	}

	public   String createCode(Billcoder billcoder)
	{
		
    //取出编码规则  
	String 	expression =   billcoder.getExpression();
	//替换特殊字符
	System.out.println(expression);
	//expression = StringUtils.escapeExprSpecialWord(expression);
	String[] expressions =expression.split(",");
	//用于收集转换完成后的编码
	String 	expressionTransed =  "";
    //取出一个时间点
	Date dateNow = new Date();
	//对每个大括号进行遍历，转换为最终字符
		for(int i=0 ; i<expressions.length;i++)
		{   System.out.println(expressions[i]);
			String expressionSub = expressions[i];
			 
			//过滤字符型
			 if(expressionSub.indexOf("{C:")==0)
			{
				expressionSub = expressionSub.replace("{C:", "");
				expressionSub = expressionSub.replace("}", "");
			}
			//过滤日期
			else if(expressionSub.indexOf("{T:")==0)
			{
				expressionSub = expressionSub.replace("{T:", "");
				expressionSub = expressionSub.replace("}", "");
				int index = "yyyy-MM-dd HH:mm:ss".indexOf(expressionSub);
				//如果是yy，取后两位
				 if(expressionSub.equals("yy"))
				 {
					 index+=2;
					 
				 }
				int length = expressionSub.length();
				
				
				String dateTimeNow = DateUtils.formatDate(dateNow, "yyyy-MM-dd HH:mm:ss");
				expressionSub = dateTimeNow.substring(index, index+length);
			 }
			 //过滤流水号
			else if(expressionSub.indexOf("{y:")==0||expressionSub.indexOf("{M:")==0||expressionSub.indexOf("{d:")==0||expressionSub.indexOf("{N:")==0)
			{   
				//取出距上次编码的年月日
			    Date  lastFlowDate =   	billcoder.getLastFlowDate();
			    int lasttFlowYear  =  lastFlowDate.getYear();
			    int lasttFlowMonth  =  lastFlowDate.getMonth();
			    int lasttFlowDateOfM =  lastFlowDate.getDate();
			    
			     //取出当前的年月日
			    int nowtFlowYear  =  dateNow.getYear();
			    int nowtFlowMonth  =  dateNow.getMonth();
			    int nowtFlowDateOfM =  dateNow.getDate();
			    //年份改变，流水号重新置0
			    if(nowtFlowYear-lasttFlowYear!=0 )
			    {
			    	billcoder.setCurrentFlowNo((long) 0);
			    	
			    }//月份改变，按月或者按日流水，流水号重新置0
			    else  if(nowtFlowMonth-lasttFlowMonth!=0&&(expressionSub.indexOf("{M:")==0||expressionSub.indexOf("{d:")==0) )
			    {
			    	billcoder.setCurrentFlowNo((long) 0);
			    	
			    }
			    //日期改变， 按日流水，流水号重新置0
			    else  if(nowtFlowDateOfM-lasttFlowDateOfM!=0&& expressionSub.indexOf("{d:")==0  )
			    {
			    	billcoder.setCurrentFlowNo((long) 0);
			     }
			     //无需置0，流水号按规则增长
			    
				{   //增长
					billcoder.setCurrentFlowNo(billcoder.getCurrentFlowNo() + billcoder.getIncreassment());
					 System.out.println("billcoder.getCurrentFlowNo():"+billcoder.getCurrentFlowNo());
					// 取出流水号位数
					String flowNoLenthStr = expressionSub.replace("{y:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{M:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{d:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{N:", "");
					flowNoLenthStr = flowNoLenthStr.replace("}", "");
                    int flowNoLenth = Integer.parseInt(flowNoLenthStr);
                    System.out.println("flowNoLenth:"+flowNoLenth);
                    //进行前补0操作
                    String currentFlowNoStr = billcoder.getCurrentFlowNo().toString();
                   
                    for(int j=currentFlowNoStr.length();j<flowNoLenth;j++ )
                    {
                    	
                    	currentFlowNoStr  ="0"+currentFlowNoStr ;
                    	
                    }
                    expressionSub = currentFlowNoStr.substring(0, flowNoLenth);

				}
				
			}
				 
			expressionTransed+=expressionSub;
		}
		 billcoder.setLastFlowDate(dateNow );
		 this.save(billcoder);
		return expressionTransed;
	}
	
	public static void main(String args[])
	{
		Billcoder billcoder = new Billcoder();
		billcoder.setIncreassment(1);
		billcoder.setLastFlowDate(new Date() );
		billcoder.setCurrentFlowNo((long) 1);
		billcoder.setExpression("{C:J},{C:L},{C:D},{C:W},{C:-},{T:yyyy},{T:yy},{T:MM},{T:dd},{T:HH},{T:mm},{T:ss},{y:6}");
		//System.out.println( createCode(billcoder));
		System.out.println(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		
	}
	

}