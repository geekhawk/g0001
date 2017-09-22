package com.qq.k3.seOrder.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
 


import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT;

/**
 * TDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_Department", schema = "dbo", catalog = "AIS20170527080305")
public class TDepartment extends BaseEntityHBT<TDepartment>
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fitemId;
	private String fbrNo;
	private Integer fmanager;
	private String fphone;
	private String ffax;
	private String fnote;
	private String fnumber;
	private String fname;
	private Integer fparentId;
	private Integer fdproperty;
	private Integer fdstock;
	private Short fdeleted;
	private String fshortNumber;
	private Integer facctId;
	private Integer fcostAccountType;
	private String fmodifyTime;
	private Integer fcalId;
	private Integer fplanArea;
	private Integer fotherAracctId;
	private Integer fotherApacctId;
	private Integer fpreAracctId;
	private Integer fpreApacctId;
	private Boolean fisCreditMgr;
	private Set<SeOrder> seorders = new HashSet<SeOrder>(0);

	// Constructors

	/** default constructor */
	public TDepartment()
	{
	}

	/** minimal constructor */
	public TDepartment(String fbrNo, Integer fdproperty, Short fdeleted, Integer facctId, Integer fcostAccountType, String fmodifyTime, Integer fcalId, Integer fotherAracctId,
			Integer fotherApacctId, Integer fpreAracctId, Integer fpreApacctId, Boolean fisCreditMgr)
	{
		this.fbrNo = fbrNo;
		this.fdproperty = fdproperty;
		this.fdeleted = fdeleted;
		this.facctId = facctId;
		this.fcostAccountType = fcostAccountType;
		this.fmodifyTime = fmodifyTime;
		this.fcalId = fcalId;
		this.fotherAracctId = fotherAracctId;
		this.fotherApacctId = fotherApacctId;
		this.fpreAracctId = fpreAracctId;
		this.fpreApacctId = fpreApacctId;
		this.fisCreditMgr = fisCreditMgr;
	}

	/** full constructor */
	public TDepartment(String fbrNo, Integer fmanager, String fphone, String ffax, String fnote, String fnumber, String fname, Integer fparentId, Integer fdproperty,
			Integer fdstock, Short fdeleted, String fshortNumber, Integer facctId, Integer fcostAccountType, String fmodifyTime, Integer fcalId, Integer fplanArea,
			Integer fotherAracctId, Integer fotherApacctId, Integer fpreAracctId, Integer fpreApacctId, Boolean fisCreditMgr, Set<SeOrder> seorders)
	{
		this.fbrNo = fbrNo;
		this.fmanager = fmanager;
		this.fphone = fphone;
		this.ffax = ffax;
		this.fnote = fnote;
		this.fnumber = fnumber;
		this.fname = fname;
		this.fparentId = fparentId;
		this.fdproperty = fdproperty;
		this.fdstock = fdstock;
		this.fdeleted = fdeleted;
		this.fshortNumber = fshortNumber;
		this.facctId = facctId;
		this.fcostAccountType = fcostAccountType;
		this.fmodifyTime = fmodifyTime;
		this.fcalId = fcalId;
		this.fplanArea = fplanArea;
		this.fotherAracctId = fotherAracctId;
		this.fotherApacctId = fotherApacctId;
		this.fpreAracctId = fpreAracctId;
		this.fpreApacctId = fpreApacctId;
		this.fisCreditMgr = fisCreditMgr;
		this.seorders = seorders;
	}

	// Property accessors 
	@Id 
	@Column(name = "FItemID", unique = true, nullable = false)
	public Integer getFitemId()
		{
			return this.fitemId;
		}

	public void setFitemId(Integer fitemId)
		{
			this.fitemId = fitemId;
		}

	@Column(name = "FBrNO", nullable = false, length = 10)
	public String getFbrNo()
		{
			return this.fbrNo;
		}

	public void setFbrNo(String fbrNo)
		{
			this.fbrNo = fbrNo;
		}

	@Column(name = "FManager")
	public Integer getFmanager()
		{
			return this.fmanager;
		}

	public void setFmanager(Integer fmanager)
		{
			this.fmanager = fmanager;
		}

	@Column(name = "FPhone", length = 30)
	public String getFphone()
		{
			return this.fphone;
		}

	public void setFphone(String fphone)
		{
			this.fphone = fphone;
		}

	@Column(name = "FFax", length = 30)
	public String getFfax()
		{
			return this.ffax;
		}

	public void setFfax(String ffax)
		{
			this.ffax = ffax;
		}

	@Column(name = "FNote")
	public String getFnote()
		{
			return this.fnote;
		}

	public void setFnote(String fnote)
		{
			this.fnote = fnote;
		}

	@Column(name = "FNumber")
	public String getFnumber()
		{
			return this.fnumber;
		}

	public void setFnumber(String fnumber)
		{
			this.fnumber = fnumber;
		}

	@Column(name = "FName", length = 80)
	public String getFname()
		{
			return this.fname;
		}

	public void setFname(String fname)
		{
			this.fname = fname;
		}

	@Column(name = "FParentID")
	public Integer getFparentId()
		{
			return this.fparentId;
		}

	public void setFparentId(Integer fparentId)
		{
			this.fparentId = fparentId;
		}

	@Column(name = "FDProperty", nullable = false)
	public Integer getFdproperty()
		{
			return this.fdproperty;
		}

	public void setFdproperty(Integer fdproperty)
		{
			this.fdproperty = fdproperty;
		}

	@Column(name = "FDStock")
	public Integer getFdstock()
		{
			return this.fdstock;
		}

	public void setFdstock(Integer fdstock)
		{
			this.fdstock = fdstock;
		}

	@Column(name = "FDeleted", nullable = false)
	public Short getFdeleted()
		{
			return this.fdeleted;
		}

	public void setFdeleted(Short fdeleted)
		{
			this.fdeleted = fdeleted;
		}

	@Column(name = "FShortNumber", length = 80)
	public String getFshortNumber()
		{
			return this.fshortNumber;
		}

	public void setFshortNumber(String fshortNumber)
		{
			this.fshortNumber = fshortNumber;
		}

	@Column(name = "FAcctID", nullable = false)
	public Integer getFacctId()
		{
			return this.facctId;
		}

	public void setFacctId(Integer facctId)
		{
			this.facctId = facctId;
		}

	@Column(name = "FCostAccountType", nullable = false)
	public Integer getFcostAccountType()
		{
			return this.fcostAccountType;
		}

	public void setFcostAccountType(Integer fcostAccountType)
		{
			this.fcostAccountType = fcostAccountType;
		}

	@Column(name = "FModifyTime", nullable = false)
	public String getFmodifyTime()
		{
			return this.fmodifyTime;
		}

	public void setFmodifyTime(String fmodifyTime)
		{
			this.fmodifyTime = fmodifyTime;
		}

	@Column(name = "FCalID", nullable = false)
	public Integer getFcalId()
		{
			return this.fcalId;
		}

	public void setFcalId(Integer fcalId)
		{
			this.fcalId = fcalId;
		}

	@Column(name = "FPlanArea")
	public Integer getFplanArea()
		{
			return this.fplanArea;
		}

	public void setFplanArea(Integer fplanArea)
		{
			this.fplanArea = fplanArea;
		}

	@Column(name = "FOtherARAcctID", nullable = false)
	public Integer getFotherAracctId()
		{
			return this.fotherAracctId;
		}

	public void setFotherAracctId(Integer fotherAracctId)
		{
			this.fotherAracctId = fotherAracctId;
		}

	@Column(name = "FOtherAPAcctID", nullable = false)
	public Integer getFotherApacctId()
		{
			return this.fotherApacctId;
		}

	public void setFotherApacctId(Integer fotherApacctId)
		{
			this.fotherApacctId = fotherApacctId;
		}

	@Column(name = "FPreARAcctID", nullable = false)
	public Integer getFpreAracctId()
		{
			return this.fpreAracctId;
		}

	public void setFpreAracctId(Integer fpreAracctId)
		{
			this.fpreAracctId = fpreAracctId;
		}

	@Column(name = "FPreAPAcctID", nullable = false)
	public Integer getFpreApacctId()
		{
			return this.fpreApacctId;
		}

	public void setFpreApacctId(Integer fpreApacctId)
		{
			this.fpreApacctId = fpreApacctId;
		}

	@Column(name = "FIsCreditMgr", nullable = false)
	public Boolean getFisCreditMgr()
		{
			return this.fisCreditMgr;
		}

	public void setFisCreditMgr(Boolean fisCreditMgr)
		{
			this.fisCreditMgr = fisCreditMgr;
		}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDepartment")
	public Set<SeOrder> getSeorders()
		{
			return this.seorders;
		}

	public void setSeorders(Set<SeOrder> seorders)
		{
			this.seorders = seorders;
		}

}