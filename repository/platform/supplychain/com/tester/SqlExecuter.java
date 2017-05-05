package com.tester;

import java.util.ArrayList;

public interface SqlExecuter
{
	 
	/**
	 * 返回查询受影响的行数 
	 * 
	 * @param  
	 * @return
	 * @throws Exception 
	 */
	public long returnRowCount() throws Exception;

	
	
	/**
	 * 执行Update,Insert,Delete返回受影响行数，包含参数，异常则返回 -1
	 * 
	 * @param  
	 * @return
	 */
	 public long executeUpdate();

	 
	 
	/**
	 *  返回table ArrayList组成的二维数组
	 * 
	 * @param  
	 * @return
	 */
	 public ArrayList<ArrayList<?>> returnTable(  );

	 
	 
	 
	 

	 
	 

}
