package com.thinkgem.jeesite.common.hibernate.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;

/**
 * DAO支持类实现
 * 
 * @author zjh
 * @version 2014-05-16
 * @param <T>
 */
@Transactional(readOnly = true)
public class BaseServiceHBT<Entity extends BaseEntityHBT<Entity>, Dao extends DaoInterFaceHBT<Entity>> implements ServiceInterfaceHBT<Entity>
{

	private static final long serialVersionUID = 1L;

	@Autowired
	protected Dao dao;

	@Transactional(readOnly = false)
	@Override
	public void add(Entity entity)
		{
			dao.add(entity);
		}

	@Transactional(readOnly = false)
	@Override
	public void delete(Entity entity)
		{
			dao.delete(entity);
		}

	@Transactional(readOnly = false)
	@Override
	public Entity merge(Entity entity)
		{
			return dao.merge(entity);
		}

	@Transactional(readOnly = false)
	@Override
	public void saveOrUpdate(Entity entity)
		{
			dao.saveOrUpdate(entity);
		}

	@Transactional(readOnly = false)
	@Override
	public void attachClean(Entity entity)
		{
			dao.attachClean(entity);
		}

	@Override
	public Entity findById(Serializable  id)
		{
			return dao.findById(id);
		}

	@Override
	public List<Entity> findListByExample(Entity entity)
		{
			return dao.findListByExample(entity);
		}

	@Override
	public List<Entity> findList(Entity entity, List<Order> orderList, List<Criterion> criterionList)
		{
			// TODO Auto-generated method stub
			return dao.findList(entity, orderList, criterionList);
		}

	@Override
	public Page<Entity> findPage(Page<Entity> page,Entity entity, List<Order> orderList, List<Criterion> criterionList)
		{
			// TODO Auto-generated method stub
			return dao.findPage(  page,entity, orderList, criterionList);
		}

}