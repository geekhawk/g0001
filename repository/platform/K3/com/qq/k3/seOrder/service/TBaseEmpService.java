package com.qq.k3.seOrder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
 
	 public List<TOrganization>   getReleationCus(Integer  tBaseEmpId)
		{   TBaseEmp  tBaseEmp = this.findById(tBaseEmpId); 
			List<TOrganization> organizationList = new ArrayList<TOrganization>();
			if(tBaseEmp.getEmployeeCusReleations().size()>0)
			{
			List<EmployeeCusReleationEntry> employeeCusReleationEntrys = tBaseEmp.getEmployeeCusReleations().get(0).getEmployeeCusReleationEntries();
			for (EmployeeCusReleationEntry employeeCusReleationEntry : employeeCusReleationEntrys)
			{ employeeCusReleationEntry.getTOrganization().getFname();
				organizationList.add(employeeCusReleationEntry.getTOrganization()); 
			}
			}

			return organizationList;
		}

}