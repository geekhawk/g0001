package com.qq.k3.seOrder.utils;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.qq.k3.seOrder.entity.TOrganization;
import com.thinkgem.jeesite.common.utils.DateUtils;

public class IcitemUtil
{

	public IcitemUtil()
	{
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
		{
			// TODO Auto-generated method stub

		}

	/**
	 * 获取价格政策
	 */
	
	public static double  getPrice(TOrganization tOrganization,Integer icItemId)
		{
			
			String dateStr =DateUtils.getDate();
			String timeStr = DateFormatUtils.formatUTC(new Date(), "HH:mm:ss");
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			JdbcTemplate JdbcTemplateK3 = (JdbcTemplate) wac.getBean("jdbcTemplateK3");
			String sql = "EXECUTE sp_executesql N'Select top 1 t2.FInterID, t2.FEntryID,t2.FItemID, \n"
					+ "  Round((Case When t2.FCuryID=1 Then t2.FPrice Else t2.FPrice/CAST(1 AS FLOAT) End)/CAST(tm.FCoefficient AS FLOAT)*CAST(@dblCoefficient AS FLOAT),ti.FPriceDecimal) As FPrice, \n"
					+ "  Case When tc.FOperator=''*'' Then Round(CAST(t4.FLowPrice AS FLOAT)* CASE WHEN tc.FCurrencyID = 1 THEN 1 ELSE (CAST(tc.FExchangeRate AS FLOAT)/CAST(1 AS FLOAT)) END * CAST(@dblCoefficient AS FLOAT),ti.FPriceDecimal) Else Round(CAST(t4.FLowPrice AS FLOAT)/CASE WHEN tc.FCurrencyID = 1 THEN 1 ELSE (CAST(tc.FExchangeRate AS FLOAT)/CAST(1 AS FLOAT)) END * CAST(@dblCoefficient AS FLOAT),ti.FPriceDecimal) End As FLowPrice, \n"
					+ "  t4.FCanSell,t4.FLPriceCtrl, \n"
					+ "  Case When t2.FCuryID=1  Then 0 Else 1 End As FOrder1, \n"
					+ "  Case When t2.FUnitID=121 Then 0 Else 1 End As FOrder2, \n"
					+ "  Case When t2.FBegQty=0 And t2.FEndQty=0 Then 1 Else 0 End As FOrder3, \n"
					+ "  (1-sign(t2.FAuxPropID)) As FOrder4 \n"
					+ "   From IcPrcPly t1 \n"
					+ "   Inner Join IcPrcPlyEntry t2 On t1.FInterID=t2.FInterID And FPlyType<>''PrcAsm0'' \n"
					+ "   Inner Join t_ICItem ti On t2.FItemID=ti.FItemID \n"
					+ "   Inner Join t_MeasureUnit tm On t2.FUnitID=tm.FMeasureUnitID \n"
					+ "   Inner Join IcPrcOpt t3 On t1.FPlyType=t3.FKey And t3.FValue=''1'' Inner Join IcPrcPlyEntrySpec t4 On t2.FInterID=t4.FInterID And t2.FItemID=t4.FItemID And t2.FRelatedID=t4.FRelatedID \n"
					+ "   Inner Join t_Currency tc On t4.FLPriceCuryID=tc.FCurrencyID \n"
					+ "   Where t2.FRelatedID In (0,"+tOrganization.getFitemId()+","+tOrganization.getFtypeId()+",0,0,0) \n"
					+ "   And t2.FBegDate<=''"+dateStr+"'' And t2.FEndDate>=''"+dateStr+"'' and t2.FItemID=@lItemID  And t2.FAuxPropID in (0,@lAuxPropID) \n"
					+ "   And ((t2.FUnitID=@lUnitID And ((t2.FBegQty<=@dblQty And t2.FEndQty>=@dblQty ) Or (t2.FBegQty=0 And t2.FEndQty=0))) \n"
					+ "   Or  (t2.FUnitID=ti.FUnitID And ((t2.FBegQty<=@dblBaseQty And t2.FEndQty>=@dblBaseQty ) Or (t2.FBegQty=0 And t2.FEndQty=0))))  \n"
					+ "    And (t2.FCuryID=1 Or t2.FCuryID=1) And t2.FChecked=1 \n"
					+ "  And (FPeriodType = 0 Or (FPeriodType=1 And FCycBegTime<=''"+timeStr+"'' And FCycEndTime>=''"+timeStr+"'') Or (FPeriodType=2 And FCycBegTime<=''"+timeStr+"'' And FCycEndTime>=''"+timeStr+"'' And CharIndex(''5'',FWeek)>0) or (FPeriodType=3 And FCycBegTime<=''"+timeStr+"'' And FCycEndTime>=''"+timeStr+"'' And CharIndex(''@Month'' ,FMonth)>0 And (FDayPerMonth=''2'' Or (FSerialWeekPerMonth=''1'' And FWeekDayPerMonth=''5'')))) \n"
					+ "  Order by t1.FPri,t3.FSort,FOrder1,FOrder2,FOrder3,FOrder4,t2.FBegDate Desc' \n"
					+ "  ,N'@lItemID INT,@lAuxPropID INT,@lUnitID INT ,@dblQty DECIMAL(28,10),@dblBaseQty DECIMAL(28,10),@dblCoefficient FLOAT' \n"
					+ "  ,@lItemID="+icItemId+",@lAuxPropID=0,@lUnitID=121,@dblQty=0,@dblBaseQty=0,@dblCoefficient=1";
			System.out.println(sql);
			List list = JdbcTemplateK3.queryForList(sql);
			Iterator iterator = list.iterator();
			Double fprice = (double) 0;
			while (iterator.hasNext())
			{
				Map map4dept = (Map) iterator.next();
				fprice = (Double) map4dept.get("fprice");
			}
			return fprice;

		}
}
