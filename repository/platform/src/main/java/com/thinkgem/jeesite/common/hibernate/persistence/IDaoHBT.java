package com.thinkgem.jeesite.common.hibernate.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
 
/**
 * DAO支持类实现
 * 
 * @author EntityhinkGem
 * @version 2014-05-16
 * @param <Entity>
 */

public interface IDaoHBT<Entity>  extends Serializable
{

	public void add( Entity t);

	public void delete(Entity t);

	public Entity merge(Entity entity);

	public void saveOrUpdate(Entity entity);

	public void attachClean(Entity entity);

	public Entity findById(String id);

	public List<Entity> findByExample(Entity t);

	public List<Entity> findByPropertys(Map<String,Object>  map);
 

}