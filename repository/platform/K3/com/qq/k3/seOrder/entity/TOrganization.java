package com.qq.k3.seOrder.entity;

import java.sql.Timestamp;
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
 * TOrganization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_Organization", schema = "dbo", catalog = "AIS20170502093932")
public class TOrganization extends BaseEntityHBT<TOrganization>
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer fitemId;
	private String faddress;
	private String fcity;
	private String fprovince;
	private String fcountry;
	private String fpostalCode;
	private String fphone;
	private String ffax;
	private String femail;
	private String fhomePage;
	private String fcreditLimit;
	private String ftaxId;
	private String fbank;
	private String faccount;
	private String fbankNumber;
	private String fbrNo;
	private Integer fboundAttr;
	private Integer ferpClsId;
	private String fshortName;
	private Integer fpriorityId;
	private Integer fpogroupId;
	private Integer fstatus;
	private Integer flanguageId;
	private Integer fregionId;
	private Integer ftrade;
	private Double fminPovalue;
	private Double fmaxDebitDate;
	private String flegalPerson;
	private String fcontact;
	private String fcontactAcct;
	private String fphoneAcct;
	private String ffaxAcct;
	private String fzipAcct;
	private String femailAcct;
	private String faddrAcct;
	private Float ftax;
	private Integer fcyId;
	private Integer fsetId;
	private Integer fsetDlineId;
	private String ftaxNum;
	private Integer fpriceClsId;
	private Integer foperId;
	private String fciqnumber;
	private Short fdeleted;
	private Integer fsaleMode;
	private String fname;
	private String fnumber;
	private Integer fparentId;
	private String fshortNumber;
	private Integer faraccountId;
	private Integer fapaccountId;
	private Integer fpreAcctId;
	private Double flastTradeAmount;
	private Double flastRpamount;
	private String ffavorPolicy;
	private Integer fdepartment;
	private Integer femployee;
	private String fcorperate;
	private Timestamp fbeginTradeDate;
	private Timestamp fendTradeDate;
	private Timestamp flastTradeDate;
	private Timestamp flastReceiveDate;
	private String fcashDiscount;
	private Integer fcurrencyId;
	private Double fmaxDealAmount;
	private Double fminForeReceiveRate;
	private Double fminReserverate;
	private Integer fdebtLevel;
	private Integer fcarryingAos;
	private Boolean fisCreditMgr;
	private Integer fcreditPeriod;
	private Integer fcreditLevel;
	private Integer fpayTaxAcctId;
	private Double fvalueAddRate;
	private Integer ftypeId;
	private Integer fcreditDays;
	private Double fcreditAmount;
	private Integer fstockIdassign;
	private Integer fstockIdinst;
	private Integer fstockIdkeep;
	private Timestamp fpaperPeriod;
	private Integer falarmPeriod;
	private Boolean flicAndPermit;
	private Integer fotherAracctId;
	private Integer fotherApacctId;
	private Integer fpreApacctId;
	private Integer fsaleId;
	private String fhelpCode;
	private String fmodifyTime;
	private String fnameEn;
	private String faddrEn;
	private String fciqcode;
	private Integer fregion;
	private String fmobilePhone;
	private Integer fpayCondition;
	private Integer fmanageType;
	private Integer fclass;
	private String fvalue;
	private Integer fregUserId;
	private Timestamp flastModifyDate;
	private Timestamp frecentContactDate;
	private Timestamp fregDate;
	private Integer fflat;
	private Integer fclassTypeId;
	private Integer f102;
	private Set<SeOrder> seorders = new HashSet<SeOrder>(0);

	// Constructors

	/** default constructor */
	public TOrganization()
	{
	}

	/** minimal constructor */
	public TOrganization(Short fdeleted, Integer fsaleMode, Integer fparentId, Integer faraccountId, Integer fapaccountId, Integer fpreAcctId, Double flastTradeAmount,
			Double flastRpamount, Integer fdepartment, Integer femployee, String fcashDiscount, Integer fcurrencyId, Double fmaxDealAmount, Double fminForeReceiveRate,
			Double fminReserverate, Integer fdebtLevel, Integer fcarryingAos, Boolean fisCreditMgr, Integer fcreditPeriod, Integer fcreditLevel, Integer fpayTaxAcctId,
			Integer ftypeId, Integer fstockIdassign, Integer fstockIdinst, Boolean flicAndPermit, Integer fotherAracctId, Integer fotherApacctId, Integer fpreApacctId,
			String fmodifyTime, Integer fclass, String fvalue, Integer fregUserId, Integer fflat, Integer fclassTypeId)
	{
		this.fdeleted = fdeleted;
		this.fsaleMode = fsaleMode;
		this.fparentId = fparentId;
		this.faraccountId = faraccountId;
		this.fapaccountId = fapaccountId;
		this.fpreAcctId = fpreAcctId;
		this.flastTradeAmount = flastTradeAmount;
		this.flastRpamount = flastRpamount;
		this.fdepartment = fdepartment;
		this.femployee = femployee;
		this.fcashDiscount = fcashDiscount;
		this.fcurrencyId = fcurrencyId;
		this.fmaxDealAmount = fmaxDealAmount;
		this.fminForeReceiveRate = fminForeReceiveRate;
		this.fminReserverate = fminReserverate;
		this.fdebtLevel = fdebtLevel;
		this.fcarryingAos = fcarryingAos;
		this.fisCreditMgr = fisCreditMgr;
		this.fcreditPeriod = fcreditPeriod;
		this.fcreditLevel = fcreditLevel;
		this.fpayTaxAcctId = fpayTaxAcctId;
		this.ftypeId = ftypeId;
		this.fstockIdassign = fstockIdassign;
		this.fstockIdinst = fstockIdinst;
		this.flicAndPermit = flicAndPermit;
		this.fotherAracctId = fotherAracctId;
		this.fotherApacctId = fotherApacctId;
		this.fpreApacctId = fpreApacctId;
		this.fmodifyTime = fmodifyTime;
		this.fclass = fclass;
		this.fvalue = fvalue;
		this.fregUserId = fregUserId;
		this.fflat = fflat;
		this.fclassTypeId = fclassTypeId;
	}

	/** full constructor */
	public TOrganization(String faddress, String fcity, String fprovince, String fcountry, String fpostalCode, String fphone, String ffax, String femail, String fhomePage,
			String fcreditLimit, String ftaxId, String fbank, String faccount, String fbankNumber, String fbrNo, Integer fboundAttr, Integer ferpClsId, String fshortName,
			Integer fpriorityId, Integer fpogroupId, Integer fstatus, Integer flanguageId, Integer fregionId, Integer ftrade, Double fminPovalue, Double fmaxDebitDate,
			String flegalPerson, String fcontact, String fcontactAcct, String fphoneAcct, String ffaxAcct, String fzipAcct, String femailAcct, String faddrAcct, Float ftax,
			Integer fcyId, Integer fsetId, Integer fsetDlineId, String ftaxNum, Integer fpriceClsId, Integer foperId, String fciqnumber, Short fdeleted, Integer fsaleMode,
			String fname, String fnumber, Integer fparentId, String fshortNumber, Integer faraccountId, Integer fapaccountId, Integer fpreAcctId, Double flastTradeAmount,
			Double flastRpamount, String ffavorPolicy, Integer fdepartment, Integer femployee, String fcorperate, Timestamp fbeginTradeDate, Timestamp fendTradeDate,
			Timestamp flastTradeDate, Timestamp flastReceiveDate, String fcashDiscount, Integer fcurrencyId, Double fmaxDealAmount, Double fminForeReceiveRate,
			Double fminReserverate, Integer fdebtLevel, Integer fcarryingAos, Boolean fisCreditMgr, Integer fcreditPeriod, Integer fcreditLevel, Integer fpayTaxAcctId,
			Double fvalueAddRate, Integer ftypeId, Integer fcreditDays, Double fcreditAmount, Integer fstockIdassign, Integer fstockIdinst, Integer fstockIdkeep,
			Timestamp fpaperPeriod, Integer falarmPeriod, Boolean flicAndPermit, Integer fotherAracctId, Integer fotherApacctId, Integer fpreApacctId, Integer fsaleId,
			String fhelpCode, String fmodifyTime, String fnameEn, String faddrEn, String fciqcode, Integer fregion, String fmobilePhone, Integer fpayCondition,
			Integer fmanageType, Integer fclass, String fvalue, Integer fregUserId, Timestamp flastModifyDate, Timestamp frecentContactDate, Timestamp fregDate, Integer fflat,
			Integer fclassTypeId, Integer f102, Set<SeOrder> seorders)
	{
		this.faddress = faddress;
		this.fcity = fcity;
		this.fprovince = fprovince;
		this.fcountry = fcountry;
		this.fpostalCode = fpostalCode;
		this.fphone = fphone;
		this.ffax = ffax;
		this.femail = femail;
		this.fhomePage = fhomePage;
		this.fcreditLimit = fcreditLimit;
		this.ftaxId = ftaxId;
		this.fbank = fbank;
		this.faccount = faccount;
		this.fbankNumber = fbankNumber;
		this.fbrNo = fbrNo;
		this.fboundAttr = fboundAttr;
		this.ferpClsId = ferpClsId;
		this.fshortName = fshortName;
		this.fpriorityId = fpriorityId;
		this.fpogroupId = fpogroupId;
		this.fstatus = fstatus;
		this.flanguageId = flanguageId;
		this.fregionId = fregionId;
		this.ftrade = ftrade;
		this.fminPovalue = fminPovalue;
		this.fmaxDebitDate = fmaxDebitDate;
		this.flegalPerson = flegalPerson;
		this.fcontact = fcontact;
		this.fcontactAcct = fcontactAcct;
		this.fphoneAcct = fphoneAcct;
		this.ffaxAcct = ffaxAcct;
		this.fzipAcct = fzipAcct;
		this.femailAcct = femailAcct;
		this.faddrAcct = faddrAcct;
		this.ftax = ftax;
		this.fcyId = fcyId;
		this.fsetId = fsetId;
		this.fsetDlineId = fsetDlineId;
		this.ftaxNum = ftaxNum;
		this.fpriceClsId = fpriceClsId;
		this.foperId = foperId;
		this.fciqnumber = fciqnumber;
		this.fdeleted = fdeleted;
		this.fsaleMode = fsaleMode;
		this.fname = fname;
		this.fnumber = fnumber;
		this.fparentId = fparentId;
		this.fshortNumber = fshortNumber;
		this.faraccountId = faraccountId;
		this.fapaccountId = fapaccountId;
		this.fpreAcctId = fpreAcctId;
		this.flastTradeAmount = flastTradeAmount;
		this.flastRpamount = flastRpamount;
		this.ffavorPolicy = ffavorPolicy;
		this.fdepartment = fdepartment;
		this.femployee = femployee;
		this.fcorperate = fcorperate;
		this.fbeginTradeDate = fbeginTradeDate;
		this.fendTradeDate = fendTradeDate;
		this.flastTradeDate = flastTradeDate;
		this.flastReceiveDate = flastReceiveDate;
		this.fcashDiscount = fcashDiscount;
		this.fcurrencyId = fcurrencyId;
		this.fmaxDealAmount = fmaxDealAmount;
		this.fminForeReceiveRate = fminForeReceiveRate;
		this.fminReserverate = fminReserverate;
		this.fdebtLevel = fdebtLevel;
		this.fcarryingAos = fcarryingAos;
		this.fisCreditMgr = fisCreditMgr;
		this.fcreditPeriod = fcreditPeriod;
		this.fcreditLevel = fcreditLevel;
		this.fpayTaxAcctId = fpayTaxAcctId;
		this.fvalueAddRate = fvalueAddRate;
		this.ftypeId = ftypeId;
		this.fcreditDays = fcreditDays;
		this.fcreditAmount = fcreditAmount;
		this.fstockIdassign = fstockIdassign;
		this.fstockIdinst = fstockIdinst;
		this.fstockIdkeep = fstockIdkeep;
		this.fpaperPeriod = fpaperPeriod;
		this.falarmPeriod = falarmPeriod;
		this.flicAndPermit = flicAndPermit;
		this.fotherAracctId = fotherAracctId;
		this.fotherApacctId = fotherApacctId;
		this.fpreApacctId = fpreApacctId;
		this.fsaleId = fsaleId;
		this.fhelpCode = fhelpCode;
		this.fmodifyTime = fmodifyTime;
		this.fnameEn = fnameEn;
		this.faddrEn = faddrEn;
		this.fciqcode = fciqcode;
		this.fregion = fregion;
		this.fmobilePhone = fmobilePhone;
		this.fpayCondition = fpayCondition;
		this.fmanageType = fmanageType;
		this.fclass = fclass;
		this.fvalue = fvalue;
		this.fregUserId = fregUserId;
		this.flastModifyDate = flastModifyDate;
		this.frecentContactDate = frecentContactDate;
		this.fregDate = fregDate;
		this.fflat = fflat;
		this.fclassTypeId = fclassTypeId;
		this.f102 = f102;
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

	@Column(name = "FAddress")
	public String getFaddress()
		{
			return this.faddress;
		}

	public void setFaddress(String faddress)
		{
			this.faddress = faddress;
		}

	@Column(name = "FCity", length = 80)
	public String getFcity()
		{
			return this.fcity;
		}

	public void setFcity(String fcity)
		{
			this.fcity = fcity;
		}

	@Column(name = "FProvince", length = 80)
	public String getFprovince()
		{
			return this.fprovince;
		}

	public void setFprovince(String fprovince)
		{
			this.fprovince = fprovince;
		}

	@Column(name = "FCountry", length = 80)
	public String getFcountry()
		{
			return this.fcountry;
		}

	public void setFcountry(String fcountry)
		{
			this.fcountry = fcountry;
		}

	@Column(name = "FPostalCode", length = 20)
	public String getFpostalCode()
		{
			return this.fpostalCode;
		}

	public void setFpostalCode(String fpostalCode)
		{
			this.fpostalCode = fpostalCode;
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

	@Column(name = "FFax", length = 40)
	public String getFfax()
		{
			return this.ffax;
		}

	public void setFfax(String ffax)
		{
			this.ffax = ffax;
		}

	@Column(name = "FEmail", length = 40)
	public String getFemail()
		{
			return this.femail;
		}

	public void setFemail(String femail)
		{
			this.femail = femail;
		}

	@Column(name = "FHomePage", length = 80)
	public String getFhomePage()
		{
			return this.fhomePage;
		}

	public void setFhomePage(String fhomePage)
		{
			this.fhomePage = fhomePage;
		}

	@Column(name = "FCreditLimit", length = 20)
	public String getFcreditLimit()
		{
			return this.fcreditLimit;
		}

	public void setFcreditLimit(String fcreditLimit)
		{
			this.fcreditLimit = fcreditLimit;
		}

	@Column(name = "FTaxID", length = 40)
	public String getFtaxId()
		{
			return this.ftaxId;
		}

	public void setFtaxId(String ftaxId)
		{
			this.ftaxId = ftaxId;
		}

	@Column(name = "FBank")
	public String getFbank()
		{
			return this.fbank;
		}

	public void setFbank(String fbank)
		{
			this.fbank = fbank;
		}

	@Column(name = "FAccount", length = 80)
	public String getFaccount()
		{
			return this.faccount;
		}

	public void setFaccount(String faccount)
		{
			this.faccount = faccount;
		}

	@Column(name = "FBankNumber")
	public String getFbankNumber()
		{
			return this.fbankNumber;
		}

	public void setFbankNumber(String fbankNumber)
		{
			this.fbankNumber = fbankNumber;
		}

	@Column(name = "FBrNo", length = 10)
	public String getFbrNo()
		{
			return this.fbrNo;
		}

	public void setFbrNo(String fbrNo)
		{
			this.fbrNo = fbrNo;
		}

	@Column(name = "FBoundAttr")
	public Integer getFboundAttr()
		{
			return this.fboundAttr;
		}

	public void setFboundAttr(Integer fboundAttr)
		{
			this.fboundAttr = fboundAttr;
		}

	@Column(name = "FErpClsID")
	public Integer getFerpClsId()
		{
			return this.ferpClsId;
		}

	public void setFerpClsId(Integer ferpClsId)
		{
			this.ferpClsId = ferpClsId;
		}

	@Column(name = "FShortName", length = 50)
	public String getFshortName()
		{
			return this.fshortName;
		}

	public void setFshortName(String fshortName)
		{
			this.fshortName = fshortName;
		}

	@Column(name = "FPriorityID")
	public Integer getFpriorityId()
		{
			return this.fpriorityId;
		}

	public void setFpriorityId(Integer fpriorityId)
		{
			this.fpriorityId = fpriorityId;
		}

	@Column(name = "FPOGroupID")
	public Integer getFpogroupId()
		{
			return this.fpogroupId;
		}

	public void setFpogroupId(Integer fpogroupId)
		{
			this.fpogroupId = fpogroupId;
		}

	@Column(name = "FStatus")
	public Integer getFstatus()
		{
			return this.fstatus;
		}

	public void setFstatus(Integer fstatus)
		{
			this.fstatus = fstatus;
		}

	@Column(name = "FLanguageID")
	public Integer getFlanguageId()
		{
			return this.flanguageId;
		}

	public void setFlanguageId(Integer flanguageId)
		{
			this.flanguageId = flanguageId;
		}

	@Column(name = "FRegionID")
	public Integer getFregionId()
		{
			return this.fregionId;
		}

	public void setFregionId(Integer fregionId)
		{
			this.fregionId = fregionId;
		}

	@Column(name = "FTrade")
	public Integer getFtrade()
		{
			return this.ftrade;
		}

	public void setFtrade(Integer ftrade)
		{
			this.ftrade = ftrade;
		}

	@Column(name = "FMinPOValue", precision = 53, scale = 0)
	public Double getFminPovalue()
		{
			return this.fminPovalue;
		}

	public void setFminPovalue(Double fminPovalue)
		{
			this.fminPovalue = fminPovalue;
		}

	@Column(name = "FMaxDebitDate", precision = 53, scale = 0)
	public Double getFmaxDebitDate()
		{
			return this.fmaxDebitDate;
		}

	public void setFmaxDebitDate(Double fmaxDebitDate)
		{
			this.fmaxDebitDate = fmaxDebitDate;
		}

	@Column(name = "FLegalPerson", length = 50)
	public String getFlegalPerson()
		{
			return this.flegalPerson;
		}

	public void setFlegalPerson(String flegalPerson)
		{
			this.flegalPerson = flegalPerson;
		}

	@Column(name = "FContact", length = 50)
	public String getFcontact()
		{
			return this.fcontact;
		}

	public void setFcontact(String fcontact)
		{
			this.fcontact = fcontact;
		}

	@Column(name = "FContactAcct", length = 50)
	public String getFcontactAcct()
		{
			return this.fcontactAcct;
		}

	public void setFcontactAcct(String fcontactAcct)
		{
			this.fcontactAcct = fcontactAcct;
		}

	@Column(name = "FPhoneAcct", length = 50)
	public String getFphoneAcct()
		{
			return this.fphoneAcct;
		}

	public void setFphoneAcct(String fphoneAcct)
		{
			this.fphoneAcct = fphoneAcct;
		}

	@Column(name = "FFaxAcct", length = 50)
	public String getFfaxAcct()
		{
			return this.ffaxAcct;
		}

	public void setFfaxAcct(String ffaxAcct)
		{
			this.ffaxAcct = ffaxAcct;
		}

	@Column(name = "FZipAcct", length = 50)
	public String getFzipAcct()
		{
			return this.fzipAcct;
		}

	public void setFzipAcct(String fzipAcct)
		{
			this.fzipAcct = fzipAcct;
		}

	@Column(name = "FEmailAcct", length = 50)
	public String getFemailAcct()
		{
			return this.femailAcct;
		}

	public void setFemailAcct(String femailAcct)
		{
			this.femailAcct = femailAcct;
		}

	@Column(name = "FAddrAcct", length = 50)
	public String getFaddrAcct()
		{
			return this.faddrAcct;
		}

	public void setFaddrAcct(String faddrAcct)
		{
			this.faddrAcct = faddrAcct;
		}

	@Column(name = "FTax", precision = 24, scale = 0)
	public Float getFtax()
		{
			return this.ftax;
		}

	public void setFtax(Float ftax)
		{
			this.ftax = ftax;
		}

	@Column(name = "FCyID")
	public Integer getFcyId()
		{
			return this.fcyId;
		}

	public void setFcyId(Integer fcyId)
		{
			this.fcyId = fcyId;
		}

	@Column(name = "FSetID")
	public Integer getFsetId()
		{
			return this.fsetId;
		}

	public void setFsetId(Integer fsetId)
		{
			this.fsetId = fsetId;
		}

	@Column(name = "FSetDLineID")
	public Integer getFsetDlineId()
		{
			return this.fsetDlineId;
		}

	public void setFsetDlineId(Integer fsetDlineId)
		{
			this.fsetDlineId = fsetDlineId;
		}

	@Column(name = "FTaxNum", length = 50)
	public String getFtaxNum()
		{
			return this.ftaxNum;
		}

	public void setFtaxNum(String ftaxNum)
		{
			this.ftaxNum = ftaxNum;
		}

	@Column(name = "FPriceClsID")
	public Integer getFpriceClsId()
		{
			return this.fpriceClsId;
		}

	public void setFpriceClsId(Integer fpriceClsId)
		{
			this.fpriceClsId = fpriceClsId;
		}

	@Column(name = "FOperID")
	public Integer getFoperId()
		{
			return this.foperId;
		}

	public void setFoperId(Integer foperId)
		{
			this.foperId = foperId;
		}

	@Column(name = "FCIQNumber", length = 20)
	public String getFciqnumber()
		{
			return this.fciqnumber;
		}

	public void setFciqnumber(String fciqnumber)
		{
			this.fciqnumber = fciqnumber;
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

	@Column(name = "FSaleMode", nullable = false)
	public Integer getFsaleMode()
		{
			return this.fsaleMode;
		}

	public void setFsaleMode(Integer fsaleMode)
		{
			this.fsaleMode = fsaleMode;
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

	@Column(name = "FNumber")
	public String getFnumber()
		{
			return this.fnumber;
		}

	public void setFnumber(String fnumber)
		{
			this.fnumber = fnumber;
		}

	@Column(name = "FParentID", nullable = false)
	public Integer getFparentId()
		{
			return this.fparentId;
		}

	public void setFparentId(Integer fparentId)
		{
			this.fparentId = fparentId;
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

	@Column(name = "FARAccountID", nullable = false)
	public Integer getFaraccountId()
		{
			return this.faraccountId;
		}

	public void setFaraccountId(Integer faraccountId)
		{
			this.faraccountId = faraccountId;
		}

	@Column(name = "FAPAccountID", nullable = false)
	public Integer getFapaccountId()
		{
			return this.fapaccountId;
		}

	public void setFapaccountId(Integer fapaccountId)
		{
			this.fapaccountId = fapaccountId;
		}

	@Column(name = "FpreAcctID", nullable = false)
	public Integer getFpreAcctId()
		{
			return this.fpreAcctId;
		}

	public void setFpreAcctId(Integer fpreAcctId)
		{
			this.fpreAcctId = fpreAcctId;
		}

	@Column(name = "FlastTradeAmount", nullable = false, scale = 4)
	public Double getFlastTradeAmount()
		{
			return this.flastTradeAmount;
		}

	public void setFlastTradeAmount(Double flastTradeAmount)
		{
			this.flastTradeAmount = flastTradeAmount;
		}

	@Column(name = "FlastRPAmount", nullable = false, scale = 4)
	public Double getFlastRpamount()
		{
			return this.flastRpamount;
		}

	public void setFlastRpamount(Double flastRpamount)
		{
			this.flastRpamount = flastRpamount;
		}

	@Column(name = "FfavorPolicy")
	public String getFfavorPolicy()
		{
			return this.ffavorPolicy;
		}

	public void setFfavorPolicy(String ffavorPolicy)
		{
			this.ffavorPolicy = ffavorPolicy;
		}

	@Column(name = "Fdepartment", nullable = false)
	public Integer getFdepartment()
		{
			return this.fdepartment;
		}

	public void setFdepartment(Integer fdepartment)
		{
			this.fdepartment = fdepartment;
		}

	@Column(name = "Femployee", nullable = false)
	public Integer getFemployee()
		{
			return this.femployee;
		}

	public void setFemployee(Integer femployee)
		{
			this.femployee = femployee;
		}

	@Column(name = "Fcorperate", length = 80)
	public String getFcorperate()
		{
			return this.fcorperate;
		}

	public void setFcorperate(String fcorperate)
		{
			this.fcorperate = fcorperate;
		}

	@Column(name = "FbeginTradeDate", length = 23)
	public Timestamp getFbeginTradeDate()
		{
			return this.fbeginTradeDate;
		}

	public void setFbeginTradeDate(Timestamp fbeginTradeDate)
		{
			this.fbeginTradeDate = fbeginTradeDate;
		}

	@Column(name = "FendTradeDate", length = 23)
	public Timestamp getFendTradeDate()
		{
			return this.fendTradeDate;
		}

	public void setFendTradeDate(Timestamp fendTradeDate)
		{
			this.fendTradeDate = fendTradeDate;
		}

	@Column(name = "FlastTradeDate", length = 23)
	public Timestamp getFlastTradeDate()
		{
			return this.flastTradeDate;
		}

	public void setFlastTradeDate(Timestamp flastTradeDate)
		{
			this.flastTradeDate = flastTradeDate;
		}

	@Column(name = "FlastReceiveDate", length = 23)
	public Timestamp getFlastReceiveDate()
		{
			return this.flastReceiveDate;
		}

	public void setFlastReceiveDate(Timestamp flastReceiveDate)
		{
			this.flastReceiveDate = flastReceiveDate;
		}

	@Column(name = "FcashDiscount", nullable = false)
	public String getFcashDiscount()
		{
			return this.fcashDiscount;
		}

	public void setFcashDiscount(String fcashDiscount)
		{
			this.fcashDiscount = fcashDiscount;
		}

	@Column(name = "FcurrencyID", nullable = false)
	public Integer getFcurrencyId()
		{
			return this.fcurrencyId;
		}

	public void setFcurrencyId(Integer fcurrencyId)
		{
			this.fcurrencyId = fcurrencyId;
		}

	@Column(name = "FmaxDealAmount", nullable = false, precision = 53, scale = 0)
	public Double getFmaxDealAmount()
		{
			return this.fmaxDealAmount;
		}

	public void setFmaxDealAmount(Double fmaxDealAmount)
		{
			this.fmaxDealAmount = fmaxDealAmount;
		}

	@Column(name = "FminForeReceiveRate", nullable = false, precision = 53, scale = 0)
	public Double getFminForeReceiveRate()
		{
			return this.fminForeReceiveRate;
		}

	public void setFminForeReceiveRate(Double fminForeReceiveRate)
		{
			this.fminForeReceiveRate = fminForeReceiveRate;
		}

	@Column(name = "FminReserverate", nullable = false, precision = 53, scale = 0)
	public Double getFminReserverate()
		{
			return this.fminReserverate;
		}

	public void setFminReserverate(Double fminReserverate)
		{
			this.fminReserverate = fminReserverate;
		}

	@Column(name = "FdebtLevel", nullable = false)
	public Integer getFdebtLevel()
		{
			return this.fdebtLevel;
		}

	public void setFdebtLevel(Integer fdebtLevel)
		{
			this.fdebtLevel = fdebtLevel;
		}

	@Column(name = "FCarryingAOS", nullable = false)
	public Integer getFcarryingAos()
		{
			return this.fcarryingAos;
		}

	public void setFcarryingAos(Integer fcarryingAos)
		{
			this.fcarryingAos = fcarryingAos;
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

	@Column(name = "FCreditPeriod", nullable = false)
	public Integer getFcreditPeriod()
		{
			return this.fcreditPeriod;
		}

	public void setFcreditPeriod(Integer fcreditPeriod)
		{
			this.fcreditPeriod = fcreditPeriod;
		}

	@Column(name = "FCreditLevel", nullable = false)
	public Integer getFcreditLevel()
		{
			return this.fcreditLevel;
		}

	public void setFcreditLevel(Integer fcreditLevel)
		{
			this.fcreditLevel = fcreditLevel;
		}

	@Column(name = "FPayTaxAcctID", nullable = false)
	public Integer getFpayTaxAcctId()
		{
			return this.fpayTaxAcctId;
		}

	public void setFpayTaxAcctId(Integer fpayTaxAcctId)
		{
			this.fpayTaxAcctId = fpayTaxAcctId;
		}

	@Column(name = "FValueAddRate", precision = 28)
	public Double getFvalueAddRate()
		{
			return this.fvalueAddRate;
		}

	public void setFvalueAddRate(Double fvalueAddRate)
		{
			this.fvalueAddRate = fvalueAddRate;
		}

	@Column(name = "FTypeID", nullable = false)
	public Integer getFtypeId()
		{
			return this.ftypeId;
		}

	public void setFtypeId(Integer ftypeId)
		{
			this.ftypeId = ftypeId;
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

	@Column(name = "FStockIDAssign", nullable = false)
	public Integer getFstockIdassign()
		{
			return this.fstockIdassign;
		}

	public void setFstockIdassign(Integer fstockIdassign)
		{
			this.fstockIdassign = fstockIdassign;
		}

	@Column(name = "FStockIDInst", nullable = false)
	public Integer getFstockIdinst()
		{
			return this.fstockIdinst;
		}

	public void setFstockIdinst(Integer fstockIdinst)
		{
			this.fstockIdinst = fstockIdinst;
		}

	@Column(name = "FStockIDKeep")
	public Integer getFstockIdkeep()
		{
			return this.fstockIdkeep;
		}

	public void setFstockIdkeep(Integer fstockIdkeep)
		{
			this.fstockIdkeep = fstockIdkeep;
		}

	@Column(name = "FPaperPeriod", length = 23)
	public Timestamp getFpaperPeriod()
		{
			return this.fpaperPeriod;
		}

	public void setFpaperPeriod(Timestamp fpaperPeriod)
		{
			this.fpaperPeriod = fpaperPeriod;
		}

	@Column(name = "FAlarmPeriod")
	public Integer getFalarmPeriod()
		{
			return this.falarmPeriod;
		}

	public void setFalarmPeriod(Integer falarmPeriod)
		{
			this.falarmPeriod = falarmPeriod;
		}

	@Column(name = "FLicAndPermit", nullable = false)
	public Boolean getFlicAndPermit()
		{
			return this.flicAndPermit;
		}

	public void setFlicAndPermit(Boolean flicAndPermit)
		{
			this.flicAndPermit = flicAndPermit;
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

	@Column(name = "FPreAPAcctID", nullable = false)
	public Integer getFpreApacctId()
		{
			return this.fpreApacctId;
		}

	public void setFpreApacctId(Integer fpreApacctId)
		{
			this.fpreApacctId = fpreApacctId;
		}

	@Column(name = "FSaleID")
	public Integer getFsaleId()
		{
			return this.fsaleId;
		}

	public void setFsaleId(Integer fsaleId)
		{
			this.fsaleId = fsaleId;
		}

	@Column(name = "FHelpCode", length = 50)
	public String getFhelpCode()
		{
			return this.fhelpCode;
		}

	public void setFhelpCode(String fhelpCode)
		{
			this.fhelpCode = fhelpCode;
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

	@Column(name = "FNameEN")
	public String getFnameEn()
		{
			return this.fnameEn;
		}

	public void setFnameEn(String fnameEn)
		{
			this.fnameEn = fnameEn;
		}

	@Column(name = "FAddrEn")
	public String getFaddrEn()
		{
			return this.faddrEn;
		}

	public void setFaddrEn(String faddrEn)
		{
			this.faddrEn = faddrEn;
		}

	@Column(name = "FCIQCode")
	public String getFciqcode()
		{
			return this.fciqcode;
		}

	public void setFciqcode(String fciqcode)
		{
			this.fciqcode = fciqcode;
		}

	@Column(name = "FRegion")
	public Integer getFregion()
		{
			return this.fregion;
		}

	public void setFregion(Integer fregion)
		{
			this.fregion = fregion;
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

	@Column(name = "FPayCondition")
	public Integer getFpayCondition()
		{
			return this.fpayCondition;
		}

	public void setFpayCondition(Integer fpayCondition)
		{
			this.fpayCondition = fpayCondition;
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

	@Column(name = "FClass", nullable = false)
	public Integer getFclass()
		{
			return this.fclass;
		}

	public void setFclass(Integer fclass)
		{
			this.fclass = fclass;
		}

	@Column(name = "FValue", nullable = false)
	public String getFvalue()
		{
			return this.fvalue;
		}

	public void setFvalue(String fvalue)
		{
			this.fvalue = fvalue;
		}

	@Column(name = "FRegUserID", nullable = false)
	public Integer getFregUserId()
		{
			return this.fregUserId;
		}

	public void setFregUserId(Integer fregUserId)
		{
			this.fregUserId = fregUserId;
		}

	@Column(name = "FLastModifyDate", length = 23)
	public Timestamp getFlastModifyDate()
		{
			return this.flastModifyDate;
		}

	public void setFlastModifyDate(Timestamp flastModifyDate)
		{
			this.flastModifyDate = flastModifyDate;
		}

	@Column(name = "FRecentContactDate", length = 23)
	public Timestamp getFrecentContactDate()
		{
			return this.frecentContactDate;
		}

	public void setFrecentContactDate(Timestamp frecentContactDate)
		{
			this.frecentContactDate = frecentContactDate;
		}

	@Column(name = "FRegDate", length = 23)
	public Timestamp getFregDate()
		{
			return this.fregDate;
		}

	public void setFregDate(Timestamp fregDate)
		{
			this.fregDate = fregDate;
		}

	@Column(name = "FFlat", nullable = false)
	public Integer getFflat()
		{
			return this.fflat;
		}

	public void setFflat(Integer fflat)
		{
			this.fflat = fflat;
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

	@Column(name = "F_102")
	public Integer getF102()
		{
			return this.f102;
		}

	public void setF102(Integer f102)
		{
			this.f102 = f102;
		}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganization")
	public Set<SeOrder> getSeorders()
		{
			return this.seorders;
		}

	public void setSeorders(Set<SeOrder> seorders)
		{
			this.seorders = seorders;
		}

}