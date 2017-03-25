/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.utils;

import java.util.Date;
import java.util.List;

import com.thinkgem.jeesite.common.utils.DateUtils;
import com.thinkgem.jeesite.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.modules.sys.entity.Billcoder;
import com.thinkgem.jeesite.modules.sys.service.BillcoderService;

/**
 * 字典工具类
 * @author ThinkGem
 * @version 2013-5-29
 */
public class BillorderUtils {
	 
	private  static BillcoderService  billcoderService = SpringContextHolder.getBean(BillcoderService.class);
	public static final String CACHE_DICT_MAP = "dictMap";
	
	public  static  String createCode(String billcoderNo)
	{

		// 取出编码规则 "BMGZ0001"
		Billcoder billcoder = new Billcoder();
		billcoder.setNo(billcoderNo);
		//如果编码规则不存在 ，按设置一个默认格式进行编码
		List<Billcoder> billcoders =  billcoderService.findList(billcoder) ;
		if(billcoders.size()>0)
		{
		  billcoder = billcoders.get(0);
		}
		else
		{
			billcoder.setName("系统默认编码规则"); 
			billcoder.setIsunique("1");
			billcoder.setIncreassment(1);
			billcoder.setLastFlowDate(new Date());
			billcoder.setCurrentFlowNo((long) 0);
			billcoder.setExpression("{C:CODE},{T:yyyy},{T:MM},{T:dd},{d:8}");
			
		}
		String expression = billcoder.getExpression();
		// 替换特殊字符
		// expression = StringUtils.escapeExprSpecialWord(expression);
		String[] expressions = expression.split(",");
		// 用于收集转换完成后的编码
		String expressionTransed = "";
		// 取出一个时间点
		Date dateNow = new Date();
		// 对每个大括号进行遍历，转换为最终字符
		for (int i = 0; i < expressions.length; i++)
		{
			String expressionSub = expressions[i];

			// 过滤字符型
			if (expressionSub.indexOf("{C:") == 0)
			{
				expressionSub = expressionSub.replace("{C:", "");
				expressionSub = expressionSub.replace("}", "");
			}
			// 过滤日期
			else if (expressionSub.indexOf("{T:") == 0)
			{
				expressionSub = expressionSub.replace("{T:", "");
				expressionSub = expressionSub.replace("}", "");
				int index = "yyyy-MM-dd HH:mm:ss".indexOf(expressionSub);
				// 如果是yy，取后两位
				if (expressionSub.equals("yy"))
				{
					index += 2;

				}
				int length = expressionSub.length();

				String dateTimeNow = DateUtils.formatDate(dateNow, "yyyy-MM-dd HH:mm:ss");
				expressionSub = dateTimeNow.substring(index, index + length);
			}
			// 过滤流水号
			else if (expressionSub.indexOf("{y:") == 0 || expressionSub.indexOf("{M:") == 0 || expressionSub.indexOf("{d:") == 0 || expressionSub.indexOf("{N:") == 0)
			{
				// 取出距上次编码的年月日
				Date lastFlowDate = billcoder.getLastFlowDate();
				@SuppressWarnings("deprecation")
				int lasttFlowYear = lastFlowDate.getYear();
				@SuppressWarnings("deprecation")
				int lasttFlowMonth = lastFlowDate.getMonth();
				@SuppressWarnings("deprecation")
				int lasttFlowDateOfM = lastFlowDate.getDate();

				// 取出当前的年月日
				@SuppressWarnings("deprecation")
				int nowtFlowYear = dateNow.getYear();
				@SuppressWarnings("deprecation")
				int nowtFlowMonth = dateNow.getMonth();
				@SuppressWarnings("deprecation")
				int nowtFlowDateOfM = dateNow.getDate();
				// 年份改变，流水号重新置0
				if (nowtFlowYear - lasttFlowYear != 0)
				{
					billcoder.setCurrentFlowNo((long) 0);

				}// 月份改变，按月或者按日流水，流水号重新置0
				else if (nowtFlowMonth - lasttFlowMonth != 0 && (expressionSub.indexOf("{M:") == 0 || expressionSub.indexOf("{d:") == 0))
				{
					billcoder.setCurrentFlowNo((long) 0);

				}
				// 日期改变， 按日流水，流水号重新置0
				else if (nowtFlowDateOfM - lasttFlowDateOfM != 0 && expressionSub.indexOf("{d:") == 0)
				{
					billcoder.setCurrentFlowNo((long) 0);
				}
				// 无需置0，流水号按规则增长

				{ // 增长
					billcoder.setCurrentFlowNo(billcoder.getCurrentFlowNo() + billcoder.getIncreassment());
					// 取出流水号位数
					String flowNoLenthStr = expressionSub.replace("{y:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{M:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{d:", "");
					flowNoLenthStr = flowNoLenthStr.replace("{N:", "");
					flowNoLenthStr = flowNoLenthStr.replace("}", "");
					int flowNoLenth = Integer.parseInt(flowNoLenthStr);
					// 进行前补0操作
					String currentFlowNoStr = billcoder.getCurrentFlowNo().toString();

					for (int j = currentFlowNoStr.length(); j < flowNoLenth; j++)
					{

						currentFlowNoStr = "0" + currentFlowNoStr;

					}
					expressionSub = currentFlowNoStr.substring(0, flowNoLenth);

				}

			}

			expressionTransed += expressionSub;
		}
		billcoder.setLastFlowDate(dateNow);
		billcoderService.save(billcoder);
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
