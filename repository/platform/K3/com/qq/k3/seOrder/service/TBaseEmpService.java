package com.qq.k3.seOrder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

import com.qq.k3.seOrder.dao.TBaseEmpDao;
import com.qq.k3.seOrder.entity.EmployeeCusReleationEntry;
import com.qq.k3.seOrder.entity.TBaseEmp;
import com.qq.k3.seOrder.entity.TOrganization;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseServiceHBT;

@Service("tBaseEmpService")
@Transactional(readOnly = true)
public class TBaseEmpService extends BaseServiceHBT<TBaseEmp, TBaseEmpDao>
{
	private static final long serialVersionUID = 1L;
 
	 public List<TOrganization>   getReleationCus(TBaseEmp tBaseEmp)
		{
			List<TOrganization> organizationList = new ArrayList<TOrganization>();
			List<EmployeeCusReleationEntry> employeeCusReleationEntrys = tBaseEmp.getEmployeeCusReleations().get(0).getEmployeeCusReleationEntries();
			for (EmployeeCusReleationEntry employeeCusReleationEntry : employeeCusReleationEntrys)
			{
				organizationList.add(employeeCusReleationEntry.getTOrganization());

			}

			return organizationList;
		}

}