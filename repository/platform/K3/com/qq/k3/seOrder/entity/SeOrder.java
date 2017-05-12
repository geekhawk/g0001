package com.qq.k3.seOrder.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT; 

/**
 * Seorder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEOrder", schema = "dbo", catalog = "AIS20170502093932")
public class SeOrder extends BaseEntityHBT<SeOrder>
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SeOrderId id;
	private TDepartment TDepartment;
	private TOrganization TOrganization;
	private TBaseUser TBaseUser;
	private TBaseEmp TBaseEmp;
	private String fbillNo;
	private Integer fcurrencyId;
	private Date fdate;
	private Date fBegindate;
	private Date fEnddate;
	private String fpayStyle;
	private Date fpayDate;
	private String ffetchStyle;
	private Date ffetchDate;
	private String ffetchAdd;
	private Integer fsaleStyle;
	private Integer fcheckerId;
	private String fnote;
	private Short fclosed;
	private Integer ftranType;
	private Short finvoiceClosed;
	private Short fbclosed;
	private Integer fmangerId;
	private Integer fsettleId;
	private Double fexchangeRate;
	private Boolean fdiscountType;
	private Short fstatus;
	private Boolean fcancellation;
	private Integer fmultiCheckLevel1;
	private Integer fmultiCheckLevel2;
	private Integer fmultiCheckLevel3;
	private Integer fmultiCheckLevel4;
	private Integer fmultiCheckLevel5;
	private Integer fmultiCheckLevel6;
	private Date fmultiCheckDate1;
	private Date fmultiCheckDate2;
	private Date fmultiCheckDate3;
	private Date fmultiCheckDate4;
	private Date fmultiCheckDate5;
	private Date fmultiCheckDate6;
	private Integer fcurCheckLevel;
	private Float ftransitAheadTime;
	private String fpoordBillNo;
	private Integer frelateBrId;
	private Integer fimport;
	private Integer forderAffirm;
	private Integer ftranStatus;
	private String fuuid;
	private byte[] foperDate;
	private Integer fsystemType;
	private String fcashDiscount;
	private Date fcheckDate;
	private String fexplanation;
	private Date fsettleDate;
	private Integer fselTranType;
	private Integer fchildren;
	private Integer fbrId;
	private Integer fareaPs;
	private Integer fclassTypeId;
	private Integer fmanageType;
	private Short fsysStatus;
	private Set<SeOrderEntry> seorderEntries = new HashSet<SeOrderEntry>(0);

	// Constructors

	/** default constructor */
	public SeOrder()
	{
	}

	/** minimal constructor */
	public SeOrder(SeOrderId id, String fbillNo, Short fclosed, Integer ftranType, Short fbclosed, Boolean fdiscountType, Short fstatus, Boolean fcancellation, Integer fimport,
			String fuuid, byte[] foperDate, Integer fsystemType, String fcashDiscount, String fexplanation, Integer fselTranType, Integer fchildren, Integer fareaPs,
			Integer fclassTypeId, Short fsysStatus)
	{
		this.id = id;
		this.fbillNo = fbillNo;
		this.fclosed = fclosed;
		this.ftranType = ftranType;
		this.fbclosed = fbclosed;
		this.fdiscountType = fdiscountType;
		this.fstatus = fstatus;
		this.fcancellation = fcancellation;
		this.fimport = fimport;
		this.fuuid = fuuid;
		this.foperDate = foperDate;
		this.fsystemType = fsystemType;
		this.fcashDiscount = fcashDiscount;
		this.fexplanation = fexplanation;
		this.fselTranType = fselTranType;
		this.fchildren = fchildren;
		this.fareaPs = fareaPs;
		this.fclassTypeId = fclassTypeId;
		this.fsysStatus = fsysStatus;
	}

	/** full constructor */
	public SeOrder(SeOrderId id, TDepartment TDepartment, TOrganization TOrganization, TBaseUser TBaseUser, TBaseEmp TBaseEmp, String fbillNo, Integer fcurrencyId,
			Date fdate, String fpayStyle, Date fpayDate, String ffetchStyle, Date ffetchDate, String ffetchAdd, Integer fsaleStyle, Integer fcheckerId,
			String fnote, Short fclosed, Integer ftranType, Short finvoiceClosed, Short fbclosed, Integer fmangerId, Integer fsettleId, Double fexchangeRate,
			Boolean fdiscountType, Short fstatus, Boolean fcancellation, Integer fmultiCheckLevel1, Integer fmultiCheckLevel2, Integer fmultiCheckLevel3,
			Integer fmultiCheckLevel4, Integer fmultiCheckLevel5, Integer fmultiCheckLevel6, Date fmultiCheckDate1, Date fmultiCheckDate2, Date fmultiCheckDate3,
			Date fmultiCheckDate4, Date fmultiCheckDate5, Date fmultiCheckDate6, Integer fcurCheckLevel, Float ftransitAheadTime, String fpoordBillNo,
			Integer frelateBrId, Integer fimport, Integer forderAffirm, Integer ftranStatus, String fuuid, byte[] foperDate, Integer fsystemType, String fcashDiscount,
			Date fcheckDate, String fexplanation, Date fsettleDate, Integer fselTranType, Integer fchildren, Integer fbrId, Integer fareaPs, Integer fclassTypeId,
			Integer fmanageType, Short fsysStatus, Set<SeOrderEntry> seorderEntries)
	{
		this.id = id;
		this.TDepartment = TDepartment;
		this.TOrganization = TOrganization;
		this.TBaseUser = TBaseUser;
		this.TBaseEmp = TBaseEmp;
		this.fbillNo = fbillNo;
		this.fcurrencyId = fcurrencyId;
		this.fdate = fdate;
		this.fpayStyle = fpayStyle;
		this.fpayDate = fpayDate;
		this.ffetchStyle = ffetchStyle;
		this.ffetchDate = ffetchDate;
		this.ffetchAdd = ffetchAdd;
		this.fsaleStyle = fsaleStyle;
		this.fcheckerId = fcheckerId;
		this.fnote = fnote;
		this.fclosed = fclosed;
		this.ftranType = ftranType;
		this.finvoiceClosed = finvoiceClosed;
		this.fbclosed = fbclosed;
		this.fmangerId = fmangerId;
		this.fsettleId = fsettleId;
		this.fexchangeRate = fexchangeRate;
		this.fdiscountType = fdiscountType;
		this.fstatus = fstatus;
		this.fcancellation = fcancellation;
		this.fmultiCheckLevel1 = fmultiCheckLevel1;
		this.fmultiCheckLevel2 = fmultiCheckLevel2;
		this.fmultiCheckLevel3 = fmultiCheckLevel3;
		this.fmultiCheckLevel4 = fmultiCheckLevel4;
		this.fmultiCheckLevel5 = fmultiCheckLevel5;
		this.fmultiCheckLevel6 = fmultiCheckLevel6;
		this.fmultiCheckDate1 = fmultiCheckDate1;
		this.fmultiCheckDate2 = fmultiCheckDate2;
		this.fmultiCheckDate3 = fmultiCheckDate3;
		this.fmultiCheckDate4 = fmultiCheckDate4;
		this.fmultiCheckDate5 = fmultiCheckDate5;
		this.fmultiCheckDate6 = fmultiCheckDate6;
		this.fcurCheckLevel = fcurCheckLevel;
		this.ftransitAheadTime = ftransitAheadTime;
		this.fpoordBillNo = fpoordBillNo;
		this.frelateBrId = frelateBrId;
		this.fimport = fimport;
		this.forderAffirm = forderAffirm;
		this.ftranStatus = ftranStatus;
		this.fuuid = fuuid;
		this.foperDate = foperDate;
		this.fsystemType = fsystemType;
		this.fcashDiscount = fcashDiscount;
		this.fcheckDate = fcheckDate;
		this.fexplanation = fexplanation;
		this.fsettleDate = fsettleDate;
		this.fselTranType = fselTranType;
		this.fchildren = fchildren;
		this.fbrId = fbrId;
		this.fareaPs = fareaPs;
		this.fclassTypeId = fclassTypeId;
		this.fmanageType = fmanageType;
		this.fsysStatus = fsysStatus;
		this.seorderEntries = seorderEntries;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides(
	{ @AttributeOverride(name = "fbrNo", column = @Column(name = "FBrNo", nullable = false, length = 10)),
			@AttributeOverride(name = "finterId", column = @Column(name = "FInterID", nullable = false)) })
	public SeOrderId getId()
		{
			return this.id;
		}

	public void setId(SeOrderId id)
		{
			this.id = id;
		}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FDeptID")
	public TDepartment getTDepartment()
		{
			return this.TDepartment;
		}

	public void setTDepartment(TDepartment TDepartment)
		{
			this.TDepartment = TDepartment;
		}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FCustID")
	public TOrganization getTOrganization()
		{
			return this.TOrganization;
		}

	public void setTOrganization(TOrganization TOrganization)
		{
			this.TOrganization = TOrganization;
		}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FBillerID")
	public TBaseUser getTBaseUser()
		{
			return this.TBaseUser;
		}

	public void setTBaseUser(TBaseUser TBaseUser)
		{
			this.TBaseUser = TBaseUser;
		}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FEmpID")
	public TBaseEmp getTBaseEmp()
		{
			return this.TBaseEmp;
		}

	public void setTBaseEmp(TBaseEmp TBaseEmp)
		{
			this.TBaseEmp = TBaseEmp;
		}

	@Column(name = "FBillNo", nullable = false)
	public String getFbillNo()
		{
			return this.fbillNo;
		}

	public void setFbillNo(String fbillNo)
		{
			this.fbillNo = fbillNo;
		}

	@Column(name = "FCurrencyID")
	public Integer getFcurrencyId()
		{
			return this.fcurrencyId;
		}

	public void setFcurrencyId(Integer fcurrencyId)
		{
			this.fcurrencyId = fcurrencyId;
		}

	@Column(name = "FDate", length = 23)
	public Date getFdate()
		{
			return this.fdate;
		}

	public void setFdate(Date fdate)
		{
			this.fdate = fdate;
		}

	@Column(name = "FPayStyle", length = 30)
	public String getFpayStyle()
		{
			return this.fpayStyle;
		}

	public void setFpayStyle(String fpayStyle)
		{
			this.fpayStyle = fpayStyle;
		}

	@Column(name = "FPayDate", length = 23)
	public Date getFpayDate()
		{
			return this.fpayDate;
		}

	public void setFpayDate(Date fpayDate)
		{
			this.fpayDate = fpayDate;
		}

	@Column(name = "FFetchStyle", length = 30)
	public String getFfetchStyle()
		{
			return this.ffetchStyle;
		}

	public void setFfetchStyle(String ffetchStyle)
		{
			this.ffetchStyle = ffetchStyle;
		}

	@Column(name = "FFetchDate", length = 23)
	public Date getFfetchDate()
		{
			return this.ffetchDate;
		}

	public void setFfetchDate(Date ffetchDate)
		{
			this.ffetchDate = ffetchDate;
		}

	@Column(name = "FFetchAdd")
	public String getFfetchAdd()
		{
			return this.ffetchAdd;
		}

	public void setFfetchAdd(String ffetchAdd)
		{
			this.ffetchAdd = ffetchAdd;
		}

	@Column(name = "FSaleStyle")
	public Integer getFsaleStyle()
		{
			return this.fsaleStyle;
		}

	public void setFsaleStyle(Integer fsaleStyle)
		{
			this.fsaleStyle = fsaleStyle;
		}

	@Column(name = "FCheckerID")
	public Integer getFcheckerId()
		{
			return this.fcheckerId;
		}

	public void setFcheckerId(Integer fcheckerId)
		{
			this.fcheckerId = fcheckerId;
		}

	@Column(name = "FNote", length = 30)
	public String getFnote()
		{
			return this.fnote;
		}

	public void setFnote(String fnote)
		{
			this.fnote = fnote;
		}

	@Column(name = "FClosed", nullable = false)
	public Short getFclosed()
		{
			return this.fclosed;
		}

	public void setFclosed(Short fclosed)
		{
			this.fclosed = fclosed;
		}

	@Column(name = "FTranType", nullable = false)
	public Integer getFtranType()
		{
			return this.ftranType;
		}

	public void setFtranType(Integer ftranType)
		{
			this.ftranType = ftranType;
		}

	@Column(name = "FInvoiceClosed")
	public Short getFinvoiceClosed()
		{
			return this.finvoiceClosed;
		}

	public void setFinvoiceClosed(Short finvoiceClosed)
		{
			this.finvoiceClosed = finvoiceClosed;
		}

	@Column(name = "FBClosed", nullable = false)
	public Short getFbclosed()
		{
			return this.fbclosed;
		}

	public void setFbclosed(Short fbclosed)
		{
			this.fbclosed = fbclosed;
		}

	@Column(name = "FMangerID")
	public Integer getFmangerId()
		{
			return this.fmangerId;
		}

	public void setFmangerId(Integer fmangerId)
		{
			this.fmangerId = fmangerId;
		}

	@Column(name = "FSettleID")
	public Integer getFsettleId()
		{
			return this.fsettleId;
		}

	public void setFsettleId(Integer fsettleId)
		{
			this.fsettleId = fsettleId;
		}

	@Column(name = "FExchangeRate", precision = 53, scale = 0)
	public Double getFexchangeRate()
		{
			return this.fexchangeRate;
		}

	public void setFexchangeRate(Double fexchangeRate)
		{
			this.fexchangeRate = fexchangeRate;
		}

	@Column(name = "FDiscountType", nullable = false)
	public Boolean getFdiscountType()
		{
			return this.fdiscountType;
		}

	public void setFdiscountType(Boolean fdiscountType)
		{
			this.fdiscountType = fdiscountType;
		}

	@Column(name = "FStatus", nullable = false)
	public Short getFstatus()
		{
			return this.fstatus;
		}

	public void setFstatus(Short fstatus)
		{
			this.fstatus = fstatus;
		}

	@Column(name = "FCancellation", nullable = false)
	public Boolean getFcancellation()
		{
			return this.fcancellation;
		}

	public void setFcancellation(Boolean fcancellation)
		{
			this.fcancellation = fcancellation;
		}

	@Column(name = "FMultiCheckLevel1")
	public Integer getFmultiCheckLevel1()
		{
			return this.fmultiCheckLevel1;
		}

	public void setFmultiCheckLevel1(Integer fmultiCheckLevel1)
		{
			this.fmultiCheckLevel1 = fmultiCheckLevel1;
		}

	@Column(name = "FMultiCheckLevel2")
	public Integer getFmultiCheckLevel2()
		{
			return this.fmultiCheckLevel2;
		}

	public void setFmultiCheckLevel2(Integer fmultiCheckLevel2)
		{
			this.fmultiCheckLevel2 = fmultiCheckLevel2;
		}

	@Column(name = "FMultiCheckLevel3")
	public Integer getFmultiCheckLevel3()
		{
			return this.fmultiCheckLevel3;
		}

	public void setFmultiCheckLevel3(Integer fmultiCheckLevel3)
		{
			this.fmultiCheckLevel3 = fmultiCheckLevel3;
		}

	@Column(name = "FMultiCheckLevel4")
	public Integer getFmultiCheckLevel4()
		{
			return this.fmultiCheckLevel4;
		}

	public void setFmultiCheckLevel4(Integer fmultiCheckLevel4)
		{
			this.fmultiCheckLevel4 = fmultiCheckLevel4;
		}

	@Column(name = "FMultiCheckLevel5")
	public Integer getFmultiCheckLevel5()
		{
			return this.fmultiCheckLevel5;
		}

	public void setFmultiCheckLevel5(Integer fmultiCheckLevel5)
		{
			this.fmultiCheckLevel5 = fmultiCheckLevel5;
		}

	@Column(name = "FMultiCheckLevel6")
	public Integer getFmultiCheckLevel6()
		{
			return this.fmultiCheckLevel6;
		}

	public void setFmultiCheckLevel6(Integer fmultiCheckLevel6)
		{
			this.fmultiCheckLevel6 = fmultiCheckLevel6;
		}

	@Column(name = "FMultiCheckDate1", length = 23)
	public Date getFmultiCheckDate1()
		{
			return this.fmultiCheckDate1;
		}

	public void setFmultiCheckDate1(Date fmultiCheckDate1)
		{
			this.fmultiCheckDate1 = fmultiCheckDate1;
		}

	@Column(name = "FMultiCheckDate2", length = 23)
	public Date getFmultiCheckDate2()
		{
			return this.fmultiCheckDate2;
		}

	public void setFmultiCheckDate2(Date fmultiCheckDate2)
		{
			this.fmultiCheckDate2 = fmultiCheckDate2;
		}

	@Column(name = "FMultiCheckDate3", length = 23)
	public Date getFmultiCheckDate3()
		{
			return this.fmultiCheckDate3;
		}

	public void setFmultiCheckDate3(Date fmultiCheckDate3)
		{
			this.fmultiCheckDate3 = fmultiCheckDate3;
		}

	@Column(name = "FMultiCheckDate4", length = 23)
	public Date getFmultiCheckDate4()
		{
			return this.fmultiCheckDate4;
		}

	public void setFmultiCheckDate4(Date fmultiCheckDate4)
		{
			this.fmultiCheckDate4 = fmultiCheckDate4;
		}

	@Column(name = "FMultiCheckDate5", length = 23)
	public Date getFmultiCheckDate5()
		{
			return this.fmultiCheckDate5;
		}

	public void setFmultiCheckDate5(Date fmultiCheckDate5)
		{
			this.fmultiCheckDate5 = fmultiCheckDate5;
		}

	@Column(name = "FMultiCheckDate6", length = 23)
	public Date getFmultiCheckDate6()
		{
			return this.fmultiCheckDate6;
		}

	public void setFmultiCheckDate6(Date fmultiCheckDate6)
		{
			this.fmultiCheckDate6 = fmultiCheckDate6;
		}

	@Column(name = "FCurCheckLevel")
	public Integer getFcurCheckLevel()
		{
			return this.fcurCheckLevel;
		}

	public void setFcurCheckLevel(Integer fcurCheckLevel)
		{
			this.fcurCheckLevel = fcurCheckLevel;
		}

	@Column(name = "FTransitAheadTime", precision = 24, scale = 0)
	public Float getFtransitAheadTime()
		{
			return this.ftransitAheadTime;
		}

	public void setFtransitAheadTime(Float ftransitAheadTime)
		{
			this.ftransitAheadTime = ftransitAheadTime;
		}

	@Column(name = "FPOOrdBillNo", length = 510)
	public String getFpoordBillNo()
		{
			return this.fpoordBillNo;
		}

	public void setFpoordBillNo(String fpoordBillNo)
		{
			this.fpoordBillNo = fpoordBillNo;
		}

	@Column(name = "FRelateBrID")
	public Integer getFrelateBrId()
		{
			return this.frelateBrId;
		}

	public void setFrelateBrId(Integer frelateBrId)
		{
			this.frelateBrId = frelateBrId;
		}

	@Column(name = "FImport", nullable = false)
	public Integer getFimport()
		{
			return this.fimport;
		}

	public void setFimport(Integer fimport)
		{
			this.fimport = fimport;
		}

	@Column(name = "FOrderAffirm")
	public Integer getForderAffirm()
		{
			return this.forderAffirm;
		}

	public void setForderAffirm(Integer forderAffirm)
		{
			this.forderAffirm = forderAffirm;
		}

	@Column(name = "FTranStatus")
	public Integer getFtranStatus()
		{
			return this.ftranStatus;
		}

	public void setFtranStatus(Integer ftranStatus)
		{
			this.ftranStatus = ftranStatus;
		}

	@Column(name = "FUUID", nullable = false, length = 36)
	public String getFuuid()
		{
			return this.fuuid;
		}

	public void setFuuid(String fuuid)
		{
			this.fuuid = fuuid;
		}

	@Column(name = "FOperDate", nullable = false,insertable  = false,updatable  = false)
	public byte[] getFoperDate()
		{
			return this.foperDate;
		}

	public void setFoperDate(byte[] foperDate)
		{
			this.foperDate = foperDate;
		}

	@Column(name = "FSystemType", nullable = false)
	public Integer getFsystemType()
		{
			return this.fsystemType;
		}

	public void setFsystemType(Integer fsystemType)
		{
			this.fsystemType = fsystemType;
		}

	@Column(name = "FCashDiscount", nullable = false)
	public String getFcashDiscount()
		{
			return this.fcashDiscount;
		}

	public void setFcashDiscount(String fcashDiscount)
		{
			this.fcashDiscount = fcashDiscount;
		}

	@Column(name = "FCheckDate", length = 23)
	public Date getFcheckDate()
		{
			return this.fcheckDate;
		}

	public void setFcheckDate(Date fcheckDate)
		{
			this.fcheckDate = fcheckDate;
		}

	@Column(name = "FExplanation", nullable = false)
	public String getFexplanation()
		{
			return this.fexplanation;
		}

	public void setFexplanation(String fexplanation)
		{
			this.fexplanation = fexplanation;
		}

	@Column(name = "FSettleDate", length = 23)
	public Date getFsettleDate()
		{
			return this.fsettleDate;
		}

	public void setFsettleDate(Date fsettleDate)
		{
			this.fsettleDate = fsettleDate;
		}

	@Column(name = "FSelTranType", nullable = false)
	public Integer getFselTranType()
		{
			return this.fselTranType;
		}

	public void setFselTranType(Integer fselTranType)
		{
			this.fselTranType = fselTranType;
		}

	@Column(name = "FChildren", nullable = false)
	public Integer getFchildren()
		{
			return this.fchildren;
		}

	public void setFchildren(Integer fchildren)
		{
			this.fchildren = fchildren;
		}

	@Column(name = "FBrID")
	public Integer getFbrId()
		{
			return this.fbrId;
		}

	public void setFbrId(Integer fbrId)
		{
			this.fbrId = fbrId;
		}

	@Column(name = "FAreaPS", nullable = false)
	public Integer getFareaPs()
		{
			return this.fareaPs;
		}

	public void setFareaPs(Integer fareaPs)
		{
			this.fareaPs = fareaPs;
		}

	@Column(name = "FClassTypeID", nullable = false)
	public Integer getFclassTypeId()
		{
			return this.fclassTypeId;
		}

	public void setFclassTypeId(Integer fclassTypeId)
		{
			this.fclassTypeId = fclassTypeId;
		}

	@Column(name = "FManageType")
	public Integer getFmanageType()
		{
			return this.fmanageType;
		}

	public void setFmanageType(Integer fmanageType)
		{
			this.fmanageType = fmanageType;
		}

	@Column(name = "FSysStatus", nullable = false)
	public Short getFsysStatus()
		{
			return this.fsysStatus;
		}

	public void setFsysStatus(Short fsysStatus)
		{
			this.fsysStatus = fsysStatus;
		}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "seorder")
	public Set<SeOrderEntry> getSeorderEntries()
		{
			return this.seorderEntries;
		}

	public void setSeorderEntries(Set<SeOrderEntry> seorderEntries)
		{
			this.seorderEntries = seorderEntries;
		}

	
	@Transient
	public Date getfBegindate()
		{
			return fBegindate;
		}

	public void setfBegindate(Date fBegindate)
		{
			this.fBegindate = fBegindate;
		}
	@Transient
	public Date getfEnddate()
		{
			return fEnddate;
		}

	public void setfEnddate(Date fEnddate)
		{
			this.fEnddate = fEnddate;
		}

	
	
}