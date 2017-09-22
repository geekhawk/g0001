package com.thinkgem.jeesite.common.hibernate.persistence;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.persistence.Page;

/**
 * DAO支持类实现
 * 
 * @author zjh
 * @version 2014-05-16
 * @param <Entity>
 */

public class BaseDaoHBT<Entity extends BaseEntityHBT<Entity>> implements DaoInterFaceHBT<Entity>
{

	private static final long serialVersionUID = 1L;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 自动装配sessionFactoryK3
	 */
	@Autowired
	protected SessionFactory sessionFactoryK3;

	protected Class<Entity> entityClass;

	public Session getSession()
		{
			return sessionFactoryK3.getCurrentSession();
		}

	/*
	 * public Session getNewSession() { return sessionFactoryK3.openSession(); }
	 * 
	 * public void flush() { getSession().flush(); }
	 * 
	 * public void clear() { getSession().clear(); }
	 */

	@SuppressWarnings("unchecked")
	public BaseDaoHBT()
	{
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		// 获取到泛型的Class
		this.entityClass = (Class<Entity>) type.getActualTypeArguments()[0];
	}

	@Override
	public void add(Entity entity)
		{
			Session session = getSession();
			session.save(entity);
		}

	@Override
	public void delete(Entity entity)
		{

			Session session = getSession();
			session.delete(entity);
		}

	@Override
	@SuppressWarnings("unchecked")
	public Entity merge(Entity entity)
		{

			Session session = getSession();
			return (Entity) session.merge(entity);
		}

	@Override
	public void saveOrUpdate(Entity entity)
		{

			Session session = getSession();
			session.saveOrUpdate(entity);
		}

	@Override
	public void attachClean(Entity entity)
		{
			Session session = getSession();
			session.buildLockRequest(LockOptions.NONE).lock(entity);
		}

	@Override
	@SuppressWarnings("unchecked")
	public Entity findById(Serializable id)
		{
			Session session = getSession();
			Entity t = (Entity) session.get(entityClass, id);
			return t;
		}

	@Override
	@SuppressWarnings("unchecked")
	public List<Entity> findListByExample(Entity entity)
		{
			Session session = getSession();
			List<Entity> results = session.createCriteria(entityClass).add(Example.create(entity)).list();
			return results;
		}

	/**
	 * 根据任意条件获取集合
	 * 
	 * @param entity
	 * 
	 * @param orderlist
	 * @example exapple criteria.add(Restrictions.like("chanpin", "冰箱", MatchMode.ANYWHERE)); criteria.addOrder(Order.asc(""));
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<Entity> findList(Entity entity, List<Order> orderList, List<Criterion> criterionList)
		{
			Session session = getSession();
			Criteria criteria = session.createCriteria(entityClass);

			// 添加过滤条件
			if(criterionList!=null)
			for (Criterion criterion : criterionList)
			{
				criteria.add(criterion);
			}

			// 添加排序
			if(orderList!=null)
			for (Order order : orderList)
			{
				criteria.addOrder(order);
			}
			List<Entity> results = criteria.list();
			return results;
		}

	@Override
	@SuppressWarnings("unchecked")
	public Page<Entity> findPage(Page<Entity> page, Entity entity, List<Order> orderList, List<Criterion> criterionList)
		{
			Session session = getSession();
			Criteria criteria = session.createCriteria(entityClass);
            // 添加过滤条件
			if (criterionList != null)
				for (Criterion criterion : criterionList)
				{
					criteria.add(criterion);
				}
              // 设置总纲数
			entity.setPage(page);
			entity.getPage().setCount((Long) criteria.setProjection(Projections.rowCount()).uniqueResult());
			criteria.setProjection(null);
			 // 添加排序
						if (orderList != null)
							for (Order order : orderList)
							{
								criteria.addOrder(order);
							}
            //初始化分页
			entity.getPage().initialize();
			// 添加分页
			criteria.setMaxResults((entity.getPage().getPageNo()) * entity.getPage().getPageSize());
			criteria.setFirstResult((entity.getPage().getPageNo() - 1) * entity.getPage().getPageSize());

			List<Entity> results = criteria.list();
			entity.getPage().setList(results);
			return entity.getPage();
		}

}