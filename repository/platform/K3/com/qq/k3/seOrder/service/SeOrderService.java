package com.qq.k3.seOrder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.SeOrderDao;
import com.qq.k3.seOrder.dao.SeOrderEntryDao;
import com.qq.k3.seOrder.entity.SeOrder;
import com.qq.k3.seOrder.entity.SeOrderEntry;
import com.qq.k3.seOrder.entity.SeOrderId;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("seorderService")
@Transactional(readOnly = true)
public class SeOrderService extends BaseServiceHBT<SeOrder, SeOrderDao>
{
	private static final long serialVersionUID = 1L;

	@Autowired
	SeOrderEntryDao seorderEntryDao;

	@Transactional(readOnly = true)
	public SeOrder findById(SeOrderId seorderId)
		{

			SeOrder instance = super.dao.findById(seorderId);

			for (SeOrderEntry seorderEntry : instance.getSeorderEntries())
			{
				seorderEntry.setSeorder(instance);

			}
			return instance;

		}

	@Transactional(readOnly = true)
	public void add(SeOrder seorder)
		{
			super.add(seorder);
			System.out.println(1);
			for (SeOrderEntry seorderEntry : seorder.getSeorderEntries())
			{

				try
				{
					System.out.println(2);
					SeOrderEntry s = (SeOrderEntry) seorderEntry.clone();
					// seorderEntry.setSeorder(null);
					System.out.println(3);
					s.setSeorder(seorder);
					System.out.println(4);

					seorderEntryDao.add(s);
					System.out.println(5);
					seorderEntryDao.getSession().evict(seorderEntry);

				} catch (CloneNotSupportedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			seorderEntryDao.getSession().evict(seorder);

		}

	 

}