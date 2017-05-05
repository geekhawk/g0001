package com.thinkgem.jeesite.common.hibernate.persistence;
 
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.thinkgem.jeesite.common.persistence.BaseDao;

/**
 * DAO支持类实现
 * 
 * @author EntityhinkGem
 * @version 2014-05-16
 * @param <Entity>
 */

@SuppressWarnings("rawtypes")
public class BaseDaoHBT<Entity> implements IDaoHBT<Entity>
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
	public void add(Entity t)
		{
			Session session = getSession();
			session.save(t);
		}

	@Override
	public void delete(Entity t)
		{

			Session session = getSession();
			session.delete(t);
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
	public Entity findById(String id)
		{

			Session session = getSession();
			Entity t = (Entity) session.get(entityClass, id);
			return t;

		}

	@Override
	@SuppressWarnings("unchecked")
	public List<Entity> findByExample(Entity entity)
		{

			Session session = getSession();
			List<Entity> results = session.createCriteria(entityClass).add(Example.create(entity)).list();
			return results;

		}

	@Override
	public List<Entity> findByPropertys(Map<String,Object>  map )
		{
			return null;
			/*
			
			Session session = getSession();
			String queryString = "from "+entityClass+" as model where 1=1 " ;
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				queryString = queryString +" and " + propertyName + "= ?"  
			    System.out.println("key= " + entry.getKey() + " and value= "
				                      + entry.getValue());
				         }
			
				model." + propertyName + "= ?"
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
*/
		}

}