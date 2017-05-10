package com.thinkgem.jeesite.common.hibernate.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.thinkgem.jeesite.common.persistence.Page;
 
/**
 * DAO支持类实现
 * 
 * @author zjh
 * @version 2014-05-16
 * @param <Entity>
 */
 
public interface ServiceInterfaceHBT<Entity> extends Serializable
{

	public void add(Entity t);

	public void delete(Entity t);

	public Entity merge(Entity entity);

	public void saveOrUpdate(Entity entity);

	public void attachClean(Entity entity);

	public Entity findById(Serializable id);

	public List<Entity> findListByExample(Entity t);

	public List<Entity> findList(Entity entity, List<Order> orderList, List<Criterion> criterionList);

	public Page<Entity> findPage(Page<Entity> page,Entity entity, List<Order> orderList, List<Criterion> criterionList);

}