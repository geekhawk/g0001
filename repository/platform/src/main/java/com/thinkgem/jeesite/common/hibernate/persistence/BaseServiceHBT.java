package com.thinkgem.jeesite.common.hibernate.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * DAO支持类实现
 * 
 * @author zjh
 * @version 2014-05-16
 * @param <T>
 */
@Transactional(readOnly = true)
public class BaseServiceHBT<Entity extends EntityInterfaceHBT, Dao extends DaoInterFaceHBT<Entity>> implements ServiceInterfaceHBT<Entity>
{

	private static final long serialVersionUID = 1L;

	@Autowired
	Dao dao;

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
	public Entity findById(String id)
		{
			return dao.findById(id);
		}

	@Override
	public List<Entity> findByExample(Entity entity)
		{
			return dao.findByExample(entity);
		}

	@Override
	public List<Entity> findByPropertys(Map<String, Object> map)
		{

			return dao.findByPropertys(map);
		}

}