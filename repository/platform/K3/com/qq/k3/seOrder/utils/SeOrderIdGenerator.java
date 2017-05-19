package com.qq.k3.seOrder.utils;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.AbstractUUIDGenerator;
import org.hibernate.id.Configurable;
import org.hibernate.type.Type;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.qq.k3.seOrder.entity.SeOrderId;

public class SeOrderIdGenerator extends AbstractUUIDGenerator implements Configurable
{

	public SeOrderIdGenerator()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public SeOrderId generate(SessionImplementor sessionimplementor, Object obj) throws HibernateException
		{
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			JdbcTemplate JdbcTemplateK3 = (JdbcTemplate) wac.getBean("jdbcTemplateK3");
			String sql = "declare @P1 int " + "set @P1=1145 " + "exec GetICMaxNum 'SEOrder', @P1 output, 1, 16394 " + "select @P1 as qq"; 
			List list = JdbcTemplateK3.queryForList(sql);
	        Iterator iterator = list.iterator();
	        Integer newId = 0  ;
	        while (iterator.hasNext()) {
	            Map map4dept = (Map) iterator.next();
	            newId = (Integer)map4dept.get("qq");
	        }  
	        return new  SeOrderId("0",newId); 
		}
	
	
	public Serializable generate( ) throws HibernateException
		{
			WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
			JdbcTemplate JdbcTemplateK3 = (JdbcTemplate) wac.getBean("jdbcTemplateK3");
			String sql = "declare @P1 int " + "set @P1=1145 " + "exec GetICMaxNum 'SEOrder', @P1 output, 1, 16394 " + "select @P1 as qq";
			 List list = JdbcTemplateK3.queryForList(sql);
	        Iterator iterator = list.iterator();
	        Integer newId = 0  ;
	        while (iterator.hasNext()) {
	            Map map4dept = (Map) iterator.next();
	            newId = (Integer)map4dept.get("qq");
	        }
	        return newId; 
		}

	@Override
	public void configure(Type type, Properties properties, Dialect dialect) throws MappingException
		{
			// TODO Auto-generated method stub

		}

}
