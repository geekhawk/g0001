package com.qq.k3.seOrder.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.thinkgem.jeesite.common.hibernate.persistence.EntityInterfaceHBT;

/**
 * TBaseEmp entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_Base_Emp", schema = "dbo", catalog = "AIS20170502093932")
public class TBaseEmp implements EntityInterfaceHBT
{

	// Fields

	private Integer fitemId;
	private Integer fgender;
	private Timestamp fbirthday;
	private String femail;
	private String faddress;
	private String fphone;
	private String fid;
	private Integer fduty;
	private Integer fdegree;
	private Timestamp fhireDate;
	private Timestamp fleaveDate;
	private Integer fempGroupId;
	private Integer fitemDepId;
	private Integer fbankId;
	private String fbankAccount;
	private String fnote;
	private String fbrNo;
	private String fname;
	private Integer fparentId;
	private Short fdeleted;
	private Integer fdepartmentId;
	private Integer fempGroup;
	private String fnumber;
	private String fshortNumber;
	private Boolean fisCreditMgr;
	private Integer fcreditPeriod;
	private Integer fcreditLevel;
	private Integer fprofessionalGroup;
	private Integer foperationGroup;
	private Integer fjobTypeId;
	private Double fallotPercent;
	private Integer fcreditDays;
	private Double fcreditAmount;
	private Integer fotherAracctId;
	private Integer fotherApacctId;
	private Integer fpreAracctId;
	private Integer fpreApacctId;
	private String fmobilePhone;
	private String fmodifyTime;
	private Set<Seorder> seorders = new HashSet<Seorder>(0);

	// Constructors

	/** default constructor */
	public TBaseEmp()
	{
	}

	/** minimal constructor */
	public TBaseEmp(String fname)
	{
		this.fname = fname;
	}

	/** full constructor */
	public TBaseEmp(Integer fgender, Timestamp fbirthday, String femail, String faddress, String fphone, String fid, Integer fduty, Integer fdegree, Timestamp fhireDate,
			Timestamp fleaveDate, Integer fempGroupId, Integer fitemDepId, Integer fbankId, String fbankAccount, String fnote, String fbrNo, String fname, Integer fparentId,
			Short fdeleted, Integer fdepartmentId, Integer fempGroup, String fnumber, String fshortNumber, Boolean fisCreditMgr, Integer fcreditPeriod, Integer fcreditLevel,
			Integer fprofessionalGroup, Integer foperationGroup, Integer fjobTypeId, Double fallotPercent, Integer fcreditDays, Double fcreditAmount, Integer fotherAracctId,
			Integer fotherApacctId, Integer fpreAracctId, Integer fpreApacctId, String fmobilePhone, String fmodifyTime, Set<Seorder> seorders)
	{
		this.fgender = fgender;
		this.fbirthday = fbirthday;
		this.femail = femail;
		this.faddress = faddress;
		this.fphone = fphone;
		this.fid = fid;
		this.fduty = fduty;
		this.fdegree = fdegree;
		this.fhireDate = fhireDate;
		this.fleaveDate = fleaveDate;
		this.fempGroupId = fempGroupId;
		this.fitemDepId = fitemDepId;
		this.fbankId = fbankId;
		this.fbankAccount = fbankAccount;
		this.fnote = fnote;
		this.fbrNo = fbrNo;
		this.fname = fname;
		this.fparentId = fparentId;
		this.fdeleted = fdeleted;
		this.fdepartmentId = fdepartmentId;
		this.fempGroup = fempGroup;
		this.fnumber = fnumber;
		this.fshortNumber = fshortNumber;
		this.fisCreditMgr = fisCreditMgr;
		this.fcreditPeriod = fcreditPeriod;
		this.fcreditLevel = fcreditLevel;
		this.fprofessionalGroup = fprofessionalGroup;
		this.foperationGroup = foperationGroup;
		this.fjobTypeId = fjobTypeId;
		this.fallotPercent = fallotPercent;
		this.fcreditDays = fcreditDays;
		this.fcreditAmount = fcreditAmount;
		this.fotherAracctId = fotherAracctId;
		this.fotherApacctId = fotherApacctId;
		this.fpreAracctId = fpreAracctId;
		this.fpreApacctId = fpreApacctId;
		this.fmobilePhone = fmobilePhone;
		this.fmodifyTime = fmodifyTime;
		this.seorders = seorders;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "uuid.string")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "FItemID", unique = true, nullable = false)
	public Integer getFitemId()
		{
			return this.fitemId;
		}

	public void setFitemId(Integer fitemId)
		{
			this.fitemId = fitemId;
		}

	@Column(name = "FGender")
	public Integer getFgender()
		{
			return this.fgender;
		}

	public void setFgender(Integer fgender)
		{
			this.fgender = fgender;
		}

	@Column(name = "FBirthday", length = 23)
	public Timestamp getFbirthday()
		{
			return this.fbirthday;
		}

	public void setFbirthday(Timestamp fbirthday)
		{
			this.fbirthday = fbirthday;
		}

	@Column(name = "FEmail", length = 50)
	public String getFemail()
		{
			return this.femail;
		}

	public void setFemail(String femail)
		{
			this.femail = femail;
		}

	@Column(name = "FAddress")
	public String getFaddress()
		{
			return this.faddress;
		}

	public void setFaddress(String faddress)
		{
			this.faddress = faddress;
		}

	@Column(name = "FPhone", length = 40)
	public String getFphone()
		{
			return this.fphone;
		}

	public void setFphone(String fphone)
		{
			this.fphone = fphone;
		}

	@Column(name = "FID", length = 50)
	public String getFid()
		{
			return this.fid;
		}

	public void setFid(String fid)
		{
			this.fid = fid;
		}

	@Column(name = "FDuty")
	public Integer getFduty()
		{
			return this.fduty;
		}

	public void setFduty(Integer fduty)
		{
			this.fduty = fduty;
		}

	@Column(name = "FDegree")
	public Integer getFdegree()
		{
			return this.fdegree;
		}

	public void setFdegree(Integer fdegree)
		{
			this.fdegree = fdegree;
		}

	@Column(name = "FHireDate", length = 23)
	public Timestamp getFhireDate()
		{
			return this.fhireDate;
		}

	public void setFhireDate(Timestamp fhireDate)
		{
			this.fhireDate = fhireDate;
		}

	@Column(name = "FLeaveDate", length = 23)
	public Timestamp getFleaveDate()
		{
			return this.fleaveDate;
		}

	public void setFleaveDate(Timestamp fleaveDate)
		{
			this.fleaveDate = fleaveDate;
		}

	@Column(name = "FEmpGroupID")
	public Integer getFempGroupId()
		{
			return this.fempGroupId;
		}

	public void setFempGroupId(Integer fempGroupId)
		{
			this.fempGroupId = fempGroupId;
		}

	@Column(name = "FItemDepID")
	public Integer getFitemDepId()
		{
			return this.fitemDepId;
		}

	public void setFitemDepId(Integer fitemDepId)
		{
			this.fitemDepId = fitemDepId;
		}

	@Column(name = "FBankID")
	public Integer getFbankId()
		{
			return this.fbankId;
		}

	public void setFbankId(Integer fbankId)
		{
			this.fbankId = fbankId;
		}

	@Column(name = "FBankAccount", length = 40)
	public String getFbankAccount()
		{
			return this.fbankAccount;
		}

	public void setFbankAccount(String fbankAccount)
		{
			this.fbankAccount = fbankAccount;
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

	@Column(name = "FBrNO", length = 10)
	public String getFbrNo()
		{
			return this.fbrNo;
		}

	public void setFbrNo(String fbrNo)
		{
			this.fbrNo = fbrNo;
		}

	@Column(name = "FName", nullable = false)
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

	@Column(name = "FDeleted")
	public Short getFdeleted()
		{
			return this.fdeleted;
		}

	public void setFdeleted(Short fdeleted)
		{
			this.fdeleted = fdeleted;
		}

	@Column(name = "FDepartmentID")
	public Integer getFdepartmentId()
		{
			return this.fdepartmentId;
		}

	public void setFdepartmentId(Integer fdepartmentId)
		{
			this.fdepartmentId = fdepartmentId;
		}

	@Column(name = "FEmpGroup")
	public Integer getFempGroup()
		{
			return this.fempGroup;
		}

	public void setFempGroup(Integer fempGroup)
		{
			this.fempGroup = fempGroup;
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

	@Column(name = "FShortNumber", length = 80)
	public String getFshortNumber()
		{
			return this.fshortNumber;
		}

	public void setFshortNumber(String fshortNumber)
		{
			this.fshortNumber = fshortNumber;
		}

	@Column(name = "FIsCreditMgr")
	public Boolean getFisCreditMgr()
		{
			return this.fisCreditMgr;
		}

	public void setFisCreditMgr(Boolean fisCreditMgr)
		{
			this.fisCreditMgr = fisCreditMgr;
		}

	@Column(name = "FCreditPeriod")
	public Integer getFcreditPeriod()
		{
			return this.fcreditPeriod;
		}

	public void setFcreditPeriod(Integer fcreditPeriod)
		{
			this.fcreditPeriod = fcreditPeriod;
		}

	@Column(name = "FCreditLevel")
	public Integer getFcreditLevel()
		{
			return this.fcreditLevel;
		}

	public void setFcreditLevel(Integer fcreditLevel)
		{
			this.fcreditLevel = fcreditLevel;
		}

	@Column(name = "FProfessionalGroup")
	public Integer getFprofessionalGroup()
		{
			return this.fprofessionalGroup;
		}

	public void setFprofessionalGroup(Integer fprofessionalGroup)
		{
			this.fprofessionalGroup = fprofessionalGroup;
		}

	@Column(name = "FOperationGroup")
	public Integer getFoperationGroup()
		{
			return this.foperationGroup;
		}

	public void setFoperationGroup(Integer foperationGroup)
		{
			this.foperationGroup = foperationGroup;
		}

	@Column(name = "FJobTypeID")
	public Integer getFjobTypeId()
		{
			return this.fjobTypeId;
		}

	public void setFjobTypeId(Integer fjobTypeId)
		{
			this.fjobTypeId = fjobTypeId;
		}

	@Column(name = "FAllotPercent", precision = 28, scale = 10)
	public Double getFallotPercent()
		{
			return this.fallotPercent;
		}

	public void setFallotPercent(Double fallotPercent)
		{
			this.fallotPercent = fallotPercent;
		}

	@Column(name = "FCreditDays")
	public Integer getFcreditDays()
		{
			return this.fcreditDays;
		}

	public void setFcreditDays(Integer fcreditDays)
		{
			this.fcreditDays = fcreditDays;
		}

	@Column(name = "FCreditAmount", precision = 18)
	public Double getFcreditAmount()
		{
			return this.fcreditAmount;
		}

	public void setFcreditAmount(Double fcreditAmount)
		{
			this.fcreditAmount = fcreditAmount;
		}

	@Column(name = "FOtherARAcctID")
	public Integer getFotherAracctId()
		{
			return this.fotherAracctId;
		}

	public void setFotherAracctId(Integer fotherAracctId)
		{
			this.fotherAracctId = fotherAracctId;
		}

	@Column(name = "FOtherAPAcctID")
	public Integer getFotherApacctId()
		{
			return this.fotherApacctId;
		}

	public void setFotherApacctId(Integer fotherApacctId)
		{
			this.fotherApacctId = fotherApacctId;
		}

	@Column(name = "FPreARAcctID")
	public Integer getFpreAracctId()
		{
			return this.fpreAracctId;
		}

	public void setFpreAracctId(Integer fpreAracctId)
		{
			this.fpreAracctId = fpreAracctId;
		}

	@Column(name = "FPreAPAcctID")
	public Integer getFpreApacctId()
		{
			return this.fpreApacctId;
		}

	public void setFpreApacctId(Integer fpreApacctId)
		{
			this.fpreApacctId = fpreApacctId;
		}

	@Column(name = "FMobilePhone", length = 50)
	public String getFmobilePhone()
		{
			return this.fmobilePhone;
		}

	public void setFmobilePhone(String fmobilePhone)
		{
			this.fmobilePhone = fmobilePhone;
		}

	@Column(name = "FModifyTime")
	public String getFmodifyTime()
		{
			return this.fmodifyTime;
		}

	public void setFmodifyTime(String fmodifyTime)
		{
			this.fmodifyTime = fmodifyTime;
		}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseEmp")
	public Set<Seorder> getSeorders()
		{
			return this.seorders;
		}

	public void setSeorders(Set<Seorder> seorders)
		{
			this.seorders = seorders;
		}

}