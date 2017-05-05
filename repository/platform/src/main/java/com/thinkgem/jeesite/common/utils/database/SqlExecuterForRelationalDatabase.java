package com.thinkgem.jeesite.common.utils.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

 

public class SqlExecuterForRelationalDatabase implements SqlExecuter
{
	private String dataSourceSpringBeanId;
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private String sql;
	private Map<Integer, ?> parameters;
	private ResultSet resultSet;

	/**
	 * 初始化根据Spring配置的dataSource获取一个dataSource
	 * 
	 * @param dataSourceBeanId
	 * @throws SQLException
	 */
	public SqlExecuterForRelationalDatabase(String dataSourceSpringBeanId) throws Exception
	{
		this.dataSourceSpringBeanId = dataSourceSpringBeanId;

		WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
		this.dataSource = (com.alibaba.druid.pool.DruidDataSource) wac.getBean(this.dataSourceSpringBeanId);
		this.connection = this.dataSource.getConnection();

	}

 
	public void setSqlAndParameters(String sql, Map<Integer, ?> parameters) throws Exception
	{
		this.sql = sql;
		this.parameters = parameters;
		this.preparedStatement = connection.prepareStatement(this.sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		if (this.parameters!=null&&this.parameters.size() > 0)
		{ // 遍历参数
			for (Entry<Integer, ?> entry : this.parameters.entrySet())
			{
				// 根据类型把参数加入preparedStatement
				if (entry.getValue() != null)
				{

					String className = entry.getValue().getClass().toString();

					if (("class java.lang.String").equals(className))
					{
						this.preparedStatement.setString(entry.getKey(), (java.lang.String) entry.getValue());
					}

					if (("class java.lang.Integer").equals(className))
					{
						this.preparedStatement.setInt(entry.getKey(), (java.lang.Integer) entry.getValue());
					}

					if (("class java.lang.Long").equals(className))
					{
						this.preparedStatement.setLong(entry.getKey(), (java.lang.Long) entry.getValue());
					}

					if (("class java.lang.Double").equals(className))
					{
						this.preparedStatement.setDouble(entry.getKey(), (java.lang.Double) entry.getValue());
					}

					if (("class java.lang.Float").equals(className))
					{
						this.preparedStatement.setFloat(entry.getKey(), (java.lang.Float) entry.getValue());
					}

					if (("class java.sql.Date").equals(className))
					{
						this.preparedStatement.setDate(entry.getKey(), (java.sql.Date) entry.getValue());
					}
					if (("class java.sql.Clob").equals(className))
					{
						this.preparedStatement.setClob(entry.getKey(), (java.sql.Clob) entry.getValue());
					}

				}

			}
		}
		 
	}

	@Override
	public long returnRowCount() throws Exception
	{
		this.resultSet = this.preparedStatement.executeQuery();
		resultSet.last();
		return resultSet.getRow();
	}

	@Override
	public long executeUpdate()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ArrayList<?>> returnTable( )
	{
		// TODO Auto-generated method stub
		return null;
	}

}
