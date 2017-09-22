package com.qq.k3.seOrder.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT;

/**
 * TIcitem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_ICItem", schema = "dbo", catalog = "AIS20170527080305")
public class VIcitem extends BaseEntityHBT<VIcitem>
{

	// Fields

	private Integer fitemId;
	private String fmodel;
	private String fname;
	private String fhelpCode;
	private Short fdeleted;
	private String fshortNumber;
	private String fnumber;
	private String fmodifyTime;
	private Integer fparentId;
	private String fbrNo;
	private Integer ftopId;
	private Short frp;
	private Short fomortize;
	private Short fomortizeScale;
	private Boolean fforSale;
	private Double fstaCost;
	private Double forderPrice;
	private Integer forderMethod;
	private Integer fpriceFixingType;
	private Integer fsalePriceFixingType;
	private Double fperWastage;
	private Integer faracctId;
	private Short fplanPriceMethod;
	private Short fplanClass;
	private Integer ferpClsId;
	private Integer funitId;
	private Integer funitGroupId;
	private Integer fdefaultLoc;
	private Integer fspid;
	private Integer fsource;
	private Short fqtyDecimal;
	private Double flowLimit;
	private Double fhighLimit;
	private Double fsecInv;
	private Integer fuseState;
	private Boolean fisEquipment;
	private String fequipmentNum;
	private Boolean fisSparePart;
	private String ffullName;
	private Integer fsecUnitId;
	private Double fsecCoefficient;
	private Integer fsecUnitDecimal;
	private String falias;
	private Integer forderUnitId;
	private Integer fsaleUnitId;
	private Integer fstoreUnitId;
	private Integer fproductUnitId;
	private String fapproveNo;
	private Integer fauxClassId;
	private Integer ftypeId;
	private Integer fpreDeadLine;
	private Integer fserialClassId;
	private Integer forderRector;
	private Integer fpohghPrcMnyType;
	private Double fpohighPrice;
	private Double fwwhghPrc;
	private Integer fwwhghPrcMnyType;
	private Double fsolowPrc;
	private Integer fsolowPrcMnyType;
	private Boolean fisSale;
	private Double fprofitRate;
	private Double fsalePrice;
	private Boolean fbatchManager;
	private Boolean fiskfperiod;
	private Double fkfperiod;
	private Integer ftrack;
	private Double fplanPrice;
	private Short fpriceDecimal;
	private Integer facctId;
	private Integer fsaleAcctId;
	private Integer fcostAcctId;
	private Integer fapacctId;
	private Integer fgoodSpec;
	private Integer fcostProject;
	private Boolean fisSnManage;
	private Boolean fstockTime;
	private Boolean fbookPlan;
	private Integer fbeforeExpire;
	private Integer ftaxRate;
	private Integer fadminAcctId;
	private String fnote;
	private Boolean fisSpecialTax;
	private Double fsohighLimit;
	private Double fsolowLimit;
	private Double foihighLimit;
	private Double foilowLimit;
	private Integer fdaysPer;
	private Timestamp flastCheckDate;
	private Integer fcheckCycle;
	private Integer fcheckCycUnit;
	private Double fstockPrice;
	private String fabccls;
	private Double fbatchQty;
	private Boolean fclass;
	private Double fcostDiffRate;
	private Integer fdepartment;
	private Integer fsaleTaxAcctId;
	private Integer fcbbmStandardId;
	private Integer fplanTrategy;
	private Integer forderTrategy;
	private Float fleadTime;
	private Float ffixLeadTime;
	private Integer ftotalTqq;
	private Double fqtyMin;
	private Double fqtyMax;
	private Integer fcuunitId;
	private Integer forderInterVal;
	private Double fbatchAppendQty;
	private Double forderPoint;
	private Double fbatFixEconomy;
	private Double fbatChangeEconomy;
	private Integer frequirePoint;
	private Integer fplanPoint;
	private Integer fdefaultRoutingId;
	private Integer fdefaultWorkTypeId;
	private Integer fproductPrincipal;
	private Double fdailyConsume;
	private Boolean fmrpcon;
	private Integer fplanner;
	private Boolean fputInteger;
	private Double finHighLimit;
	private Double finLowLimit;
	private Integer flowestBomCode;
	private Boolean fmrporder;
	private Integer fisCharSourceItem;
	private Integer fcharSourceItemId;
	private Integer fplanMode;
	private Integer fctrlType;
	private Integer fctrlStraregy;
	private String fcontainerName;
	private Integer fkanBanCapability;
	private Double f102;
	private String fchartNumber;
	private Boolean fisKeyItem;
	private Integer fmaund;
	private Double fgrossWeight;
	private Double fnetWeight;
	private Integer fcubicMeasure;
	private Double flength;
	private Double fwidth;
	private Double fheight;
	private Double fsize;
	private String fversion;
	private Double fstandardCost;
	private Double fstandardManHour;
	private Double fstdPayRate;
	private Double fchgFeeRate;
	private Double fstdFixFeeRate;
	private Double foutMachFee;
	private Double fpieceRate;
	private Integer finspectionLevel;
	private Integer finspectionProject;
	private Integer fisListControl;
	private Integer fproChkMde;
	private Integer fwwchkMde;
	private Integer fsochkMde;
	private Integer fwthDrwChkMde;
	private Integer fstkChkMde;
	private Integer fotherChkMde;
	private Integer fstkChkPrd;
	private Integer fstkChkAlrm;
	private Integer fidentifier;
	private String fnameEn;
	private String fmodelEn;
	private Integer fhsnumber;
	private String ffirstUnit;
	private String fsecondUnit;
	private Double ffirstUnitRate;
	private Double fsecondUnitRate;
	private Boolean fisManage;
	private Integer fpackType;
	private Integer flenDecimal;
	private Integer fcubageDecimal;
	private Integer fweightDecimal;
	private Double fimpostTaxRate;
	private Double fconsumeTaxRate;
	private Integer fmanageType;

	// Constructors

	/** default constructor */
	public VIcitem()
	{
	}

	/** minimal constructor */
	public VIcitem(String fname)
	{
		this.fname = fname;
	}

	/** full constructor */
	public VIcitem(String fmodel, String fname, String fhelpCode, Short fdeleted, String fshortNumber, String fnumber, String fmodifyTime, Integer fparentId, String fbrNo,
			Integer ftopId, Short frp, Short fomortize, Short fomortizeScale, Boolean fforSale, Double fstaCost, Double forderPrice, Integer forderMethod,
			Integer fpriceFixingType, Integer fsalePriceFixingType, Double fperWastage, Integer faracctId, Short fplanPriceMethod, Short fplanClass, Integer ferpClsId,
			Integer funitId, Integer funitGroupId, Integer fdefaultLoc, Integer fspid, Integer fsource, Short fqtyDecimal, Double flowLimit, Double fhighLimit, Double fsecInv,
			Integer fuseState, Boolean fisEquipment, String fequipmentNum, Boolean fisSparePart, String ffullName, Integer fsecUnitId, Double fsecCoefficient,
			Integer fsecUnitDecimal, String falias, Integer forderUnitId, Integer fsaleUnitId, Integer fstoreUnitId, Integer fproductUnitId, String fapproveNo,
			Integer fauxClassId, Integer ftypeId, Integer fpreDeadLine, Integer fserialClassId, Integer forderRector, Integer fpohghPrcMnyType, Double fpohighPrice,
			Double fwwhghPrc, Integer fwwhghPrcMnyType, Double fsolowPrc, Integer fsolowPrcMnyType, Boolean fisSale, Double fprofitRate, Double fsalePrice, Boolean fbatchManager,
			Boolean fiskfperiod, Double fkfperiod, Integer ftrack, Double fplanPrice, Short fpriceDecimal, Integer facctId, Integer fsaleAcctId, Integer fcostAcctId,
			Integer fapacctId, Integer fgoodSpec, Integer fcostProject, Boolean fisSnManage, Boolean fstockTime, Boolean fbookPlan, Integer fbeforeExpire, Integer ftaxRate,
			Integer fadminAcctId, String fnote, Boolean fisSpecialTax, Double fsohighLimit, Double fsolowLimit, Double foihighLimit, Double foilowLimit, Integer fdaysPer,
			Timestamp flastCheckDate, Integer fcheckCycle, Integer fcheckCycUnit, Double fstockPrice, String fabccls, Double fbatchQty, Boolean fclass, Double fcostDiffRate,
			Integer fdepartment, Integer fsaleTaxAcctId, Integer fcbbmStandardId, Integer fplanTrategy, Integer forderTrategy, Float fleadTime, Float ffixLeadTime,
			Integer ftotalTqq, Double fqtyMin, Double fqtyMax, Integer fcuunitId, Integer forderInterVal, Double fbatchAppendQty, Double forderPoint, Double fbatFixEconomy,
			Double fbatChangeEconomy, Integer frequirePoint, Integer fplanPoint, Integer fdefaultRoutingId, Integer fdefaultWorkTypeId, Integer fproductPrincipal,
			Double fdailyConsume, Boolean fmrpcon, Integer fplanner, Boolean fputInteger, Double finHighLimit, Double finLowLimit, Integer flowestBomCode, Boolean fmrporder,
			Integer fisCharSourceItem, Integer fcharSourceItemId, Integer fplanMode, Integer fctrlType, Integer fctrlStraregy, String fcontainerName, Integer fkanBanCapability,
			Double f102, String fchartNumber, Boolean fisKeyItem, Integer fmaund, Double fgrossWeight, Double fnetWeight, Integer fcubicMeasure, Double flength, Double fwidth,
			Double fheight, Double fsize, String fversion, Double fstandardCost, Double fstandardManHour, Double fstdPayRate, Double fchgFeeRate, Double fstdFixFeeRate,
			Double foutMachFee, Double fpieceRate, Integer finspectionLevel, Integer finspectionProject, Integer fisListControl, Integer fproChkMde, Integer fwwchkMde,
			Integer fsochkMde, Integer fwthDrwChkMde, Integer fstkChkMde, Integer fotherChkMde, Integer fstkChkPrd, Integer fstkChkAlrm, Integer fidentifier, String fnameEn,
			String fmodelEn, Integer fhsnumber, String ffirstUnit, String fsecondUnit, Double ffirstUnitRate, Double fsecondUnitRate, Boolean fisManage, Integer fpackType,
			Integer flenDecimal, Integer fcubageDecimal, Integer fweightDecimal, Double fimpostTaxRate, Double fconsumeTaxRate, Integer fmanageType)
	{
		this.fmodel = fmodel;
		this.fname = fname;
		this.fhelpCode = fhelpCode;
		this.fdeleted = fdeleted;
		this.fshortNumber = fshortNumber;
		this.fnumber = fnumber;
		this.fmodifyTime = fmodifyTime;
		this.fparentId = fparentId;
		this.fbrNo = fbrNo;
		this.ftopId = ftopId;
		this.frp = frp;
		this.fomortize = fomortize;
		this.fomortizeScale = fomortizeScale;
		this.fforSale = fforSale;
		this.fstaCost = fstaCost;
		this.forderPrice = forderPrice;
		this.forderMethod = forderMethod;
		this.fpriceFixingType = fpriceFixingType;
		this.fsalePriceFixingType = fsalePriceFixingType;
		this.fperWastage = fperWastage;
		this.faracctId = faracctId;
		this.fplanPriceMethod = fplanPriceMethod;
		this.fplanClass = fplanClass;
		this.ferpClsId = ferpClsId;
		this.funitId = funitId;
		this.funitGroupId = funitGroupId;
		this.fdefaultLoc = fdefaultLoc;
		this.fspid = fspid;
		this.fsource = fsource;
		this.fqtyDecimal = fqtyDecimal;
		this.flowLimit = flowLimit;
		this.fhighLimit = fhighLimit;
		this.fsecInv = fsecInv;
		this.fuseState = fuseState;
		this.fisEquipment = fisEquipment;
		this.fequipmentNum = fequipmentNum;
		this.fisSparePart = fisSparePart;
		this.ffullName = ffullName;
		this.fsecUnitId = fsecUnitId;
		this.fsecCoefficient = fsecCoefficient;
		this.fsecUnitDecimal = fsecUnitDecimal;
		this.falias = falias;
		this.forderUnitId = forderUnitId;
		this.fsaleUnitId = fsaleUnitId;
		this.fstoreUnitId = fstoreUnitId;
		this.fproductUnitId = fproductUnitId;
		this.fapproveNo = fapproveNo;
		this.fauxClassId = fauxClassId;
		this.ftypeId = ftypeId;
		this.fpreDeadLine = fpreDeadLine;
		this.fserialClassId = fserialClassId;
		this.forderRector = forderRector;
		this.fpohghPrcMnyType = fpohghPrcMnyType;
		this.fpohighPrice = fpohighPrice;
		this.fwwhghPrc = fwwhghPrc;
		this.fwwhghPrcMnyType = fwwhghPrcMnyType;
		this.fsolowPrc = fsolowPrc;
		this.fsolowPrcMnyType = fsolowPrcMnyType;
		this.fisSale = fisSale;
		this.fprofitRate = fprofitRate;
		this.fsalePrice = fsalePrice;
		this.fbatchManager = fbatchManager;
		this.fiskfperiod = fiskfperiod;
		this.fkfperiod = fkfperiod;
		this.ftrack = ftrack;
		this.fplanPrice = fplanPrice;
		this.fpriceDecimal = fpriceDecimal;
		this.facctId = facctId;
		this.fsaleAcctId = fsaleAcctId;
		this.fcostAcctId = fcostAcctId;
		this.fapacctId = fapacctId;
		this.fgoodSpec = fgoodSpec;
		this.fcostProject = fcostProject;
		this.fisSnManage = fisSnManage;
		this.fstockTime = fstockTime;
		this.fbookPlan = fbookPlan;
		this.fbeforeExpire = fbeforeExpire;
		this.ftaxRate = ftaxRate;
		this.fadminAcctId = fadminAcctId;
		this.fnote = fnote;
		this.fisSpecialTax = fisSpecialTax;
		this.fsohighLimit = fsohighLimit;
		this.fsolowLimit = fsolowLimit;
		this.foihighLimit = foihighLimit;
		this.foilowLimit = foilowLimit;
		this.fdaysPer = fdaysPer;
		this.flastCheckDate = flastCheckDate;
		this.fcheckCycle = fcheckCycle;
		this.fcheckCycUnit = fcheckCycUnit;
		this.fstockPrice = fstockPrice;
		this.fabccls = fabccls;
		this.fbatchQty = fbatchQty;
		this.fclass = fclass;
		this.fcostDiffRate = fcostDiffRate;
		this.fdepartment = fdepartment;
		this.fsaleTaxAcctId = fsaleTaxAcctId;
		this.fcbbmStandardId = fcbbmStandardId;
		this.fplanTrategy = fplanTrategy;
		this.forderTrategy = forderTrategy;
		this.fleadTime = fleadTime;
		this.ffixLeadTime = ffixLeadTime;
		this.ftotalTqq = ftotalTqq;
		this.fqtyMin = fqtyMin;
		this.fqtyMax = fqtyMax;
		this.fcuunitId = fcuunitId;
		this.forderInterVal = forderInterVal;
		this.fbatchAppendQty = fbatchAppendQty;
		this.forderPoint = forderPoint;
		this.fbatFixEconomy = fbatFixEconomy;
		this.fbatChangeEconomy = fbatChangeEconomy;
		this.frequirePoint = frequirePoint;
		this.fplanPoint = fplanPoint;
		this.fdefaultRoutingId = fdefaultRoutingId;
		this.fdefaultWorkTypeId = fdefaultWorkTypeId;
		this.fproductPrincipal = fproductPrincipal;
		this.fdailyConsume = fdailyConsume;
		this.fmrpcon = fmrpcon;
		this.fplanner = fplanner;
		this.fputInteger = fputInteger;
		this.finHighLimit = finHighLimit;
		this.finLowLimit = finLowLimit;
		this.flowestBomCode = flowestBomCode;
		this.fmrporder = fmrporder;
		this.fisCharSourceItem = fisCharSourceItem;
		this.fcharSourceItemId = fcharSourceItemId;
		this.fplanMode = fplanMode;
		this.fctrlType = fctrlType;
		this.fctrlStraregy = fctrlStraregy;
		this.fcontainerName = fcontainerName;
		this.fkanBanCapability = fkanBanCapability;
		this.f102 = f102;
		this.fchartNumber = fchartNumber;
		this.fisKeyItem = fisKeyItem;
		this.fmaund = fmaund;
		this.fgrossWeight = fgrossWeight;
		this.fnetWeight = fnetWeight;
		this.fcubicMeasure = fcubicMeasure;
		this.flength = flength;
		this.fwidth = fwidth;
		this.fheight = fheight;
		this.fsize = fsize;
		this.fversion = fversion;
		this.fstandardCost = fstandardCost;
		this.fstandardManHour = fstandardManHour;
		this.fstdPayRate = fstdPayRate;
		this.fchgFeeRate = fchgFeeRate;
		this.fstdFixFeeRate = fstdFixFeeRate;
		this.foutMachFee = foutMachFee;
		this.fpieceRate = fpieceRate;
		this.finspectionLevel = finspectionLevel;
		this.finspectionProject = finspectionProject;
		this.fisListControl = fisListControl;
		this.fproChkMde = fproChkMde;
		this.fwwchkMde = fwwchkMde;
		this.fsochkMde = fsochkMde;
		this.fwthDrwChkMde = fwthDrwChkMde;
		this.fstkChkMde = fstkChkMde;
		this.fotherChkMde = fotherChkMde;
		this.fstkChkPrd = fstkChkPrd;
		this.fstkChkAlrm = fstkChkAlrm;
		this.fidentifier = fidentifier;
		this.fnameEn = fnameEn;
		this.fmodelEn = fmodelEn;
		this.fhsnumber = fhsnumber;
		this.ffirstUnit = ffirstUnit;
		this.fsecondUnit = fsecondUnit;
		this.ffirstUnitRate = ffirstUnitRate;
		this.fsecondUnitRate = fsecondUnitRate;
		this.fisManage = fisManage;
		this.fpackType = fpackType;
		this.flenDecimal = flenDecimal;
		this.fcubageDecimal = fcubageDecimal;
		this.fweightDecimal = fweightDecimal;
		this.fimpostTaxRate = fimpostTaxRate;
		this.fconsumeTaxRate = fconsumeTaxRate;
		this.fmanageType = fmanageType;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FItemID", nullable = false)
	public Integer getFitemId()
		{
			return this.fitemId;
		}

	public void setFitemId(Integer fitemId)
		{
			this.fitemId = fitemId;
		}

	@Column(name = "FModel")
	public String getFmodel()
		{
			return this.fmodel;
		}

	public void setFmodel(String fmodel)
		{
			this.fmodel = fmodel;
		}

	@Column(name = "FName", nullable = false, length = 80)
	public String getFname()
		{
			return this.fname;
		}

	public void setFname(String fname)
		{
			this.fname = fname;
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

	@Column(name = "FDeleted")
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

	@Column(name = "FNumber", length = 80)
	public String getFnumber()
		{
			return this.fnumber;
		}

	public void setFnumber(String fnumber)
		{
			this.fnumber = fnumber;
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

	@Column(name = "FParentID")
	public Integer getFparentId()
		{
			return this.fparentId;
		}

	public void setFparentId(Integer fparentId)
		{
			this.fparentId = fparentId;
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

	@Column(name = "FTopID")
	public Integer getFtopId()
		{
			return this.ftopId;
		}

	public void setFtopId(Integer ftopId)
		{
			this.ftopId = ftopId;
		}

	@Column(name = "FRP")
	public Short getFrp()
		{
			return this.frp;
		}

	public void setFrp(Short frp)
		{
			this.frp = frp;
		}

	@Column(name = "FOmortize")
	public Short getFomortize()
		{
			return this.fomortize;
		}

	public void setFomortize(Short fomortize)
		{
			this.fomortize = fomortize;
		}

	@Column(name = "FOmortizeScale")
	public Short getFomortizeScale()
		{
			return this.fomortizeScale;
		}

	public void setFomortizeScale(Short fomortizeScale)
		{
			this.fomortizeScale = fomortizeScale;
		}

	@Column(name = "FForSale")
	public Boolean getFforSale()
		{
			return this.fforSale;
		}

	public void setFforSale(Boolean fforSale)
		{
			this.fforSale = fforSale;
		}

	@Column(name = "FStaCost", precision = 53, scale = 0)
	public Double getFstaCost()
		{
			return this.fstaCost;
		}

	public void setFstaCost(Double fstaCost)
		{
			this.fstaCost = fstaCost;
		}

	@Column(name = "FOrderPrice", precision = 53, scale = 0)
	public Double getForderPrice()
		{
			return this.forderPrice;
		}

	public void setForderPrice(Double forderPrice)
		{
			this.forderPrice = forderPrice;
		}

	@Column(name = "FOrderMethod")
	public Integer getForderMethod()
		{
			return this.forderMethod;
		}

	public void setForderMethod(Integer forderMethod)
		{
			this.forderMethod = forderMethod;
		}

	@Column(name = "FPriceFixingType")
	public Integer getFpriceFixingType()
		{
			return this.fpriceFixingType;
		}

	public void setFpriceFixingType(Integer fpriceFixingType)
		{
			this.fpriceFixingType = fpriceFixingType;
		}

	@Column(name = "FSalePriceFixingType")
	public Integer getFsalePriceFixingType()
		{
			return this.fsalePriceFixingType;
		}

	public void setFsalePriceFixingType(Integer fsalePriceFixingType)
		{
			this.fsalePriceFixingType = fsalePriceFixingType;
		}

	@Column(name = "FPerWastage", precision = 53, scale = 0)
	public Double getFperWastage()
		{
			return this.fperWastage;
		}

	public void setFperWastage(Double fperWastage)
		{
			this.fperWastage = fperWastage;
		}

	@Column(name = "FARAcctID")
	public Integer getFaracctId()
		{
			return this.faracctId;
		}

	public void setFaracctId(Integer faracctId)
		{
			this.faracctId = faracctId;
		}

	@Column(name = "FPlanPriceMethod")
	public Short getFplanPriceMethod()
		{
			return this.fplanPriceMethod;
		}

	public void setFplanPriceMethod(Short fplanPriceMethod)
		{
			this.fplanPriceMethod = fplanPriceMethod;
		}

	@Column(name = "FPlanClass")
	public Short getFplanClass()
		{
			return this.fplanClass;
		}

	public void setFplanClass(Short fplanClass)
		{
			this.fplanClass = fplanClass;
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

	@Column(name = "FUnitID")
	public Integer getFunitId()
		{
			return this.funitId;
		}

	public void setFunitId(Integer funitId)
		{
			this.funitId = funitId;
		}

	@Column(name = "FUnitGroupID")
	public Integer getFunitGroupId()
		{
			return this.funitGroupId;
		}

	public void setFunitGroupId(Integer funitGroupId)
		{
			this.funitGroupId = funitGroupId;
		}

	@Column(name = "FDefaultLoc")
	public Integer getFdefaultLoc()
		{
			return this.fdefaultLoc;
		}

	public void setFdefaultLoc(Integer fdefaultLoc)
		{
			this.fdefaultLoc = fdefaultLoc;
		}

	@Column(name = "FSPID")
	public Integer getFspid()
		{
			return this.fspid;
		}

	public void setFspid(Integer fspid)
		{
			this.fspid = fspid;
		}

	@Column(name = "FSource")
	public Integer getFsource()
		{
			return this.fsource;
		}

	public void setFsource(Integer fsource)
		{
			this.fsource = fsource;
		}

	@Column(name = "FQtyDecimal")
	public Short getFqtyDecimal()
		{
			return this.fqtyDecimal;
		}

	public void setFqtyDecimal(Short fqtyDecimal)
		{
			this.fqtyDecimal = fqtyDecimal;
		}

	@Column(name = "FLowLimit", precision = 28, scale = 10)
	public Double getFlowLimit()
		{
			return this.flowLimit;
		}

	public void setFlowLimit(Double flowLimit)
		{
			this.flowLimit = flowLimit;
		}

	@Column(name = "FHighLimit", precision = 28, scale = 10)
	public Double getFhighLimit()
		{
			return this.fhighLimit;
		}

	public void setFhighLimit(Double fhighLimit)
		{
			this.fhighLimit = fhighLimit;
		}

	@Column(name = "FSecInv", precision = 28, scale = 10)
	public Double getFsecInv()
		{
			return this.fsecInv;
		}

	public void setFsecInv(Double fsecInv)
		{
			this.fsecInv = fsecInv;
		}

	@Column(name = "FUseState")
	public Integer getFuseState()
		{
			return this.fuseState;
		}

	public void setFuseState(Integer fuseState)
		{
			this.fuseState = fuseState;
		}

	@Column(name = "FIsEquipment")
	public Boolean getFisEquipment()
		{
			return this.fisEquipment;
		}

	public void setFisEquipment(Boolean fisEquipment)
		{
			this.fisEquipment = fisEquipment;
		}

	@Column(name = "FEquipmentNum", length = 80)
	public String getFequipmentNum()
		{
			return this.fequipmentNum;
		}

	public void setFequipmentNum(String fequipmentNum)
		{
			this.fequipmentNum = fequipmentNum;
		}

	@Column(name = "FIsSparePart")
	public Boolean getFisSparePart()
		{
			return this.fisSparePart;
		}

	public void setFisSparePart(Boolean fisSparePart)
		{
			this.fisSparePart = fisSparePart;
		}

	@Column(name = "FFullName", length = 250)
	public String getFfullName()
		{
			return this.ffullName;
		}

	public void setFfullName(String ffullName)
		{
			this.ffullName = ffullName;
		}

	@Column(name = "FSecUnitID")
	public Integer getFsecUnitId()
		{
			return this.fsecUnitId;
		}

	public void setFsecUnitId(Integer fsecUnitId)
		{
			this.fsecUnitId = fsecUnitId;
		}

	@Column(name = "FSecCoefficient", precision = 28, scale = 10)
	public Double getFsecCoefficient()
		{
			return this.fsecCoefficient;
		}

	public void setFsecCoefficient(Double fsecCoefficient)
		{
			this.fsecCoefficient = fsecCoefficient;
		}

	@Column(name = "FSecUnitDecimal")
	public Integer getFsecUnitDecimal()
		{
			return this.fsecUnitDecimal;
		}

	public void setFsecUnitDecimal(Integer fsecUnitDecimal)
		{
			this.fsecUnitDecimal = fsecUnitDecimal;
		}

	@Column(name = "FAlias", length = 80)
	public String getFalias()
		{
			return this.falias;
		}

	public void setFalias(String falias)
		{
			this.falias = falias;
		}

	@Column(name = "FOrderUnitID")
	public Integer getForderUnitId()
		{
			return this.forderUnitId;
		}

	public void setForderUnitId(Integer forderUnitId)
		{
			this.forderUnitId = forderUnitId;
		}

	@Column(name = "FSaleUnitID")
	public Integer getFsaleUnitId()
		{
			return this.fsaleUnitId;
		}

	public void setFsaleUnitId(Integer fsaleUnitId)
		{
			this.fsaleUnitId = fsaleUnitId;
		}

	@Column(name = "FStoreUnitID")
	public Integer getFstoreUnitId()
		{
			return this.fstoreUnitId;
		}

	public void setFstoreUnitId(Integer fstoreUnitId)
		{
			this.fstoreUnitId = fstoreUnitId;
		}

	@Column(name = "FProductUnitID")
	public Integer getFproductUnitId()
		{
			return this.fproductUnitId;
		}

	public void setFproductUnitId(Integer fproductUnitId)
		{
			this.fproductUnitId = fproductUnitId;
		}

	@Column(name = "FApproveNo", length = 80)
	public String getFapproveNo()
		{
			return this.fapproveNo;
		}

	public void setFapproveNo(String fapproveNo)
		{
			this.fapproveNo = fapproveNo;
		}

	@Column(name = "FAuxClassID")
	public Integer getFauxClassId()
		{
			return this.fauxClassId;
		}

	public void setFauxClassId(Integer fauxClassId)
		{
			this.fauxClassId = fauxClassId;
		}

	@Column(name = "FTypeID")
	public Integer getFtypeId()
		{
			return this.ftypeId;
		}

	public void setFtypeId(Integer ftypeId)
		{
			this.ftypeId = ftypeId;
		}

	@Column(name = "FPreDeadLine")
	public Integer getFpreDeadLine()
		{
			return this.fpreDeadLine;
		}

	public void setFpreDeadLine(Integer fpreDeadLine)
		{
			this.fpreDeadLine = fpreDeadLine;
		}

	@Column(name = "FSerialClassID")
	public Integer getFserialClassId()
		{
			return this.fserialClassId;
		}

	public void setFserialClassId(Integer fserialClassId)
		{
			this.fserialClassId = fserialClassId;
		}

	@Column(name = "FOrderRector")
	public Integer getForderRector()
		{
			return this.forderRector;
		}

	public void setForderRector(Integer forderRector)
		{
			this.forderRector = forderRector;
		}

	@Column(name = "FPOHghPrcMnyType")
	public Integer getFpohghPrcMnyType()
		{
			return this.fpohghPrcMnyType;
		}

	public void setFpohghPrcMnyType(Integer fpohghPrcMnyType)
		{
			this.fpohghPrcMnyType = fpohghPrcMnyType;
		}

	@Column(name = "FPOHighPrice", precision = 28, scale = 10)
	public Double getFpohighPrice()
		{
			return this.fpohighPrice;
		}

	public void setFpohighPrice(Double fpohighPrice)
		{
			this.fpohighPrice = fpohighPrice;
		}

	@Column(name = "FWWHghPrc", precision = 28, scale = 10)
	public Double getFwwhghPrc()
		{
			return this.fwwhghPrc;
		}

	public void setFwwhghPrc(Double fwwhghPrc)
		{
			this.fwwhghPrc = fwwhghPrc;
		}

	@Column(name = "FWWHghPrcMnyType")
	public Integer getFwwhghPrcMnyType()
		{
			return this.fwwhghPrcMnyType;
		}

	public void setFwwhghPrcMnyType(Integer fwwhghPrcMnyType)
		{
			this.fwwhghPrcMnyType = fwwhghPrcMnyType;
		}

	@Column(name = "FSOLowPrc", precision = 28, scale = 10)
	public Double getFsolowPrc()
		{
			return this.fsolowPrc;
		}

	public void setFsolowPrc(Double fsolowPrc)
		{
			this.fsolowPrc = fsolowPrc;
		}

	@Column(name = "FSOLowPrcMnyType")
	public Integer getFsolowPrcMnyType()
		{
			return this.fsolowPrcMnyType;
		}

	public void setFsolowPrcMnyType(Integer fsolowPrcMnyType)
		{
			this.fsolowPrcMnyType = fsolowPrcMnyType;
		}

	@Column(name = "FIsSale")
	public Boolean getFisSale()
		{
			return this.fisSale;
		}

	public void setFisSale(Boolean fisSale)
		{
			this.fisSale = fisSale;
		}

	@Column(name = "FProfitRate", precision = 28, scale = 10)
	public Double getFprofitRate()
		{
			return this.fprofitRate;
		}

	public void setFprofitRate(Double fprofitRate)
		{
			this.fprofitRate = fprofitRate;
		}

	@Column(name = "FSalePrice", precision = 28, scale = 10)
	public Double getFsalePrice()
		{
			return this.fsalePrice;
		}

	public void setFsalePrice(Double fsalePrice)
		{
			this.fsalePrice = fsalePrice;
		}

	@Column(name = "FBatchManager")
	public Boolean getFbatchManager()
		{
			return this.fbatchManager;
		}

	public void setFbatchManager(Boolean fbatchManager)
		{
			this.fbatchManager = fbatchManager;
		}

	@Column(name = "FISKFPeriod")
	public Boolean getFiskfperiod()
		{
			return this.fiskfperiod;
		}

	public void setFiskfperiod(Boolean fiskfperiod)
		{
			this.fiskfperiod = fiskfperiod;
		}

	@Column(name = "FKFPeriod", precision = 28, scale = 10)
	public Double getFkfperiod()
		{
			return this.fkfperiod;
		}

	public void setFkfperiod(Double fkfperiod)
		{
			this.fkfperiod = fkfperiod;
		}

	@Column(name = "FTrack")
	public Integer getFtrack()
		{
			return this.ftrack;
		}

	public void setFtrack(Integer ftrack)
		{
			this.ftrack = ftrack;
		}

	@Column(name = "FPlanPrice", precision = 28, scale = 10)
	public Double getFplanPrice()
		{
			return this.fplanPrice;
		}

	public void setFplanPrice(Double fplanPrice)
		{
			this.fplanPrice = fplanPrice;
		}

	@Column(name = "FPriceDecimal")
	public Short getFpriceDecimal()
		{
			return this.fpriceDecimal;
		}

	public void setFpriceDecimal(Short fpriceDecimal)
		{
			this.fpriceDecimal = fpriceDecimal;
		}

	@Column(name = "FAcctID")
	public Integer getFacctId()
		{
			return this.facctId;
		}

	public void setFacctId(Integer facctId)
		{
			this.facctId = facctId;
		}

	@Column(name = "FSaleAcctID")
	public Integer getFsaleAcctId()
		{
			return this.fsaleAcctId;
		}

	public void setFsaleAcctId(Integer fsaleAcctId)
		{
			this.fsaleAcctId = fsaleAcctId;
		}

	@Column(name = "FCostAcctID")
	public Integer getFcostAcctId()
		{
			return this.fcostAcctId;
		}

	public void setFcostAcctId(Integer fcostAcctId)
		{
			this.fcostAcctId = fcostAcctId;
		}

	@Column(name = "FAPAcctID")
	public Integer getFapacctId()
		{
			return this.fapacctId;
		}

	public void setFapacctId(Integer fapacctId)
		{
			this.fapacctId = fapacctId;
		}

	@Column(name = "FGoodSpec")
	public Integer getFgoodSpec()
		{
			return this.fgoodSpec;
		}

	public void setFgoodSpec(Integer fgoodSpec)
		{
			this.fgoodSpec = fgoodSpec;
		}

	@Column(name = "FCostProject")
	public Integer getFcostProject()
		{
			return this.fcostProject;
		}

	public void setFcostProject(Integer fcostProject)
		{
			this.fcostProject = fcostProject;
		}

	@Column(name = "FIsSnManage")
	public Boolean getFisSnManage()
		{
			return this.fisSnManage;
		}

	public void setFisSnManage(Boolean fisSnManage)
		{
			this.fisSnManage = fisSnManage;
		}

	@Column(name = "FStockTime")
	public Boolean getFstockTime()
		{
			return this.fstockTime;
		}

	public void setFstockTime(Boolean fstockTime)
		{
			this.fstockTime = fstockTime;
		}

	@Column(name = "FBookPlan")
	public Boolean getFbookPlan()
		{
			return this.fbookPlan;
		}

	public void setFbookPlan(Boolean fbookPlan)
		{
			this.fbookPlan = fbookPlan;
		}

	@Column(name = "FBeforeExpire")
	public Integer getFbeforeExpire()
		{
			return this.fbeforeExpire;
		}

	public void setFbeforeExpire(Integer fbeforeExpire)
		{
			this.fbeforeExpire = fbeforeExpire;
		}

	@Column(name = "FTaxRate")
	public Integer getFtaxRate()
		{
			return this.ftaxRate;
		}

	public void setFtaxRate(Integer ftaxRate)
		{
			this.ftaxRate = ftaxRate;
		}

	@Column(name = "FAdminAcctID")
	public Integer getFadminAcctId()
		{
			return this.fadminAcctId;
		}

	public void setFadminAcctId(Integer fadminAcctId)
		{
			this.fadminAcctId = fadminAcctId;
		}

	@Column(name = "FNote", length = 80)
	public String getFnote()
		{
			return this.fnote;
		}

	public void setFnote(String fnote)
		{
			this.fnote = fnote;
		}

	@Column(name = "FIsSpecialTax")
	public Boolean getFisSpecialTax()
		{
			return this.fisSpecialTax;
		}

	public void setFisSpecialTax(Boolean fisSpecialTax)
		{
			this.fisSpecialTax = fisSpecialTax;
		}

	@Column(name = "FSOHighLimit", precision = 28, scale = 10)
	public Double getFsohighLimit()
		{
			return this.fsohighLimit;
		}

	public void setFsohighLimit(Double fsohighLimit)
		{
			this.fsohighLimit = fsohighLimit;
		}

	@Column(name = "FSOLowLimit", precision = 28, scale = 10)
	public Double getFsolowLimit()
		{
			return this.fsolowLimit;
		}

	public void setFsolowLimit(Double fsolowLimit)
		{
			this.fsolowLimit = fsolowLimit;
		}

	@Column(name = "FOIHighLimit", precision = 28, scale = 10)
	public Double getFoihighLimit()
		{
			return this.foihighLimit;
		}

	public void setFoihighLimit(Double foihighLimit)
		{
			this.foihighLimit = foihighLimit;
		}

	@Column(name = "FOILowLimit", precision = 28, scale = 10)
	public Double getFoilowLimit()
		{
			return this.foilowLimit;
		}

	public void setFoilowLimit(Double foilowLimit)
		{
			this.foilowLimit = foilowLimit;
		}

	@Column(name = "FDaysPer")
	public Integer getFdaysPer()
		{
			return this.fdaysPer;
		}

	public void setFdaysPer(Integer fdaysPer)
		{
			this.fdaysPer = fdaysPer;
		}

	@Column(name = "FLastCheckDate", length = 23)
	public Timestamp getFlastCheckDate()
		{
			return this.flastCheckDate;
		}

	public void setFlastCheckDate(Timestamp flastCheckDate)
		{
			this.flastCheckDate = flastCheckDate;
		}

	@Column(name = "FCheckCycle")
	public Integer getFcheckCycle()
		{
			return this.fcheckCycle;
		}

	public void setFcheckCycle(Integer fcheckCycle)
		{
			this.fcheckCycle = fcheckCycle;
		}

	@Column(name = "FCheckCycUnit")
	public Integer getFcheckCycUnit()
		{
			return this.fcheckCycUnit;
		}

	public void setFcheckCycUnit(Integer fcheckCycUnit)
		{
			this.fcheckCycUnit = fcheckCycUnit;
		}

	@Column(name = "FStockPrice", precision = 28, scale = 10)
	public Double getFstockPrice()
		{
			return this.fstockPrice;
		}

	public void setFstockPrice(Double fstockPrice)
		{
			this.fstockPrice = fstockPrice;
		}

	@Column(name = "FABCCls", length = 1)
	public String getFabccls()
		{
			return this.fabccls;
		}

	public void setFabccls(String fabccls)
		{
			this.fabccls = fabccls;
		}

	@Column(name = "FBatchQty", precision = 53, scale = 0)
	public Double getFbatchQty()
		{
			return this.fbatchQty;
		}

	public void setFbatchQty(Double fbatchQty)
		{
			this.fbatchQty = fbatchQty;
		}

	@Column(name = "FClass")
	public Boolean getFclass()
		{
			return this.fclass;
		}

	public void setFclass(Boolean fclass)
		{
			this.fclass = fclass;
		}

	@Column(name = "FCostDiffRate", precision = 53, scale = 0)
	public Double getFcostDiffRate()
		{
			return this.fcostDiffRate;
		}

	public void setFcostDiffRate(Double fcostDiffRate)
		{
			this.fcostDiffRate = fcostDiffRate;
		}

	@Column(name = "FDepartment")
	public Integer getFdepartment()
		{
			return this.fdepartment;
		}

	public void setFdepartment(Integer fdepartment)
		{
			this.fdepartment = fdepartment;
		}

	@Column(name = "FSaleTaxAcctID")
	public Integer getFsaleTaxAcctId()
		{
			return this.fsaleTaxAcctId;
		}

	public void setFsaleTaxAcctId(Integer fsaleTaxAcctId)
		{
			this.fsaleTaxAcctId = fsaleTaxAcctId;
		}

	@Column(name = "FCBBmStandardID")
	public Integer getFcbbmStandardId()
		{
			return this.fcbbmStandardId;
		}

	public void setFcbbmStandardId(Integer fcbbmStandardId)
		{
			this.fcbbmStandardId = fcbbmStandardId;
		}

	@Column(name = "FPlanTrategy")
	public Integer getFplanTrategy()
		{
			return this.fplanTrategy;
		}

	public void setFplanTrategy(Integer fplanTrategy)
		{
			this.fplanTrategy = fplanTrategy;
		}

	@Column(name = "FOrderTrategy")
	public Integer getForderTrategy()
		{
			return this.forderTrategy;
		}

	public void setForderTrategy(Integer forderTrategy)
		{
			this.forderTrategy = forderTrategy;
		}

	@Column(name = "FLeadTime", precision = 24, scale = 0)
	public Float getFleadTime()
		{
			return this.fleadTime;
		}

	public void setFleadTime(Float fleadTime)
		{
			this.fleadTime = fleadTime;
		}

	@Column(name = "FFixLeadTime", precision = 24, scale = 0)
	public Float getFfixLeadTime()
		{
			return this.ffixLeadTime;
		}

	public void setFfixLeadTime(Float ffixLeadTime)
		{
			this.ffixLeadTime = ffixLeadTime;
		}

	@Column(name = "FTotalTQQ")
	public Integer getFtotalTqq()
		{
			return this.ftotalTqq;
		}

	public void setFtotalTqq(Integer ftotalTqq)
		{
			this.ftotalTqq = ftotalTqq;
		}

	@Column(name = "FQtyMin", precision = 18, scale = 6)
	public Double getFqtyMin()
		{
			return this.fqtyMin;
		}

	public void setFqtyMin(Double fqtyMin)
		{
			this.fqtyMin = fqtyMin;
		}

	@Column(name = "FQtyMax", precision = 18, scale = 6)
	public Double getFqtyMax()
		{
			return this.fqtyMax;
		}

	public void setFqtyMax(Double fqtyMax)
		{
			this.fqtyMax = fqtyMax;
		}

	@Column(name = "FCUUnitID")
	public Integer getFcuunitId()
		{
			return this.fcuunitId;
		}

	public void setFcuunitId(Integer fcuunitId)
		{
			this.fcuunitId = fcuunitId;
		}

	@Column(name = "FOrderInterVal")
	public Integer getForderInterVal()
		{
			return this.forderInterVal;
		}

	public void setForderInterVal(Integer forderInterVal)
		{
			this.forderInterVal = forderInterVal;
		}

	@Column(name = "FBatchAppendQty", precision = 28, scale = 10)
	public Double getFbatchAppendQty()
		{
			return this.fbatchAppendQty;
		}

	public void setFbatchAppendQty(Double fbatchAppendQty)
		{
			this.fbatchAppendQty = fbatchAppendQty;
		}

	@Column(name = "FOrderPoint", precision = 28, scale = 10)
	public Double getForderPoint()
		{
			return this.forderPoint;
		}

	public void setForderPoint(Double forderPoint)
		{
			this.forderPoint = forderPoint;
		}

	@Column(name = "FBatFixEconomy", precision = 28, scale = 10)
	public Double getFbatFixEconomy()
		{
			return this.fbatFixEconomy;
		}

	public void setFbatFixEconomy(Double fbatFixEconomy)
		{
			this.fbatFixEconomy = fbatFixEconomy;
		}

	@Column(name = "FBatChangeEconomy", precision = 28, scale = 10)
	public Double getFbatChangeEconomy()
		{
			return this.fbatChangeEconomy;
		}

	public void setFbatChangeEconomy(Double fbatChangeEconomy)
		{
			this.fbatChangeEconomy = fbatChangeEconomy;
		}

	@Column(name = "FRequirePoint")
	public Integer getFrequirePoint()
		{
			return this.frequirePoint;
		}

	public void setFrequirePoint(Integer frequirePoint)
		{
			this.frequirePoint = frequirePoint;
		}

	@Column(name = "FPlanPoint")
	public Integer getFplanPoint()
		{
			return this.fplanPoint;
		}

	public void setFplanPoint(Integer fplanPoint)
		{
			this.fplanPoint = fplanPoint;
		}

	@Column(name = "FDefaultRoutingID")
	public Integer getFdefaultRoutingId()
		{
			return this.fdefaultRoutingId;
		}

	public void setFdefaultRoutingId(Integer fdefaultRoutingId)
		{
			this.fdefaultRoutingId = fdefaultRoutingId;
		}

	@Column(name = "FDefaultWorkTypeID")
	public Integer getFdefaultWorkTypeId()
		{
			return this.fdefaultWorkTypeId;
		}

	public void setFdefaultWorkTypeId(Integer fdefaultWorkTypeId)
		{
			this.fdefaultWorkTypeId = fdefaultWorkTypeId;
		}

	@Column(name = "FProductPrincipal")
	public Integer getFproductPrincipal()
		{
			return this.fproductPrincipal;
		}

	public void setFproductPrincipal(Integer fproductPrincipal)
		{
			this.fproductPrincipal = fproductPrincipal;
		}

	@Column(name = "FDailyConsume", precision = 28, scale = 10)
	public Double getFdailyConsume()
		{
			return this.fdailyConsume;
		}

	public void setFdailyConsume(Double fdailyConsume)
		{
			this.fdailyConsume = fdailyConsume;
		}

	@Column(name = "FMRPCon")
	public Boolean getFmrpcon()
		{
			return this.fmrpcon;
		}

	public void setFmrpcon(Boolean fmrpcon)
		{
			this.fmrpcon = fmrpcon;
		}

	@Column(name = "FPlanner")
	public Integer getFplanner()
		{
			return this.fplanner;
		}

	public void setFplanner(Integer fplanner)
		{
			this.fplanner = fplanner;
		}

	@Column(name = "FPutInteger")
	public Boolean getFputInteger()
		{
			return this.fputInteger;
		}

	public void setFputInteger(Boolean fputInteger)
		{
			this.fputInteger = fputInteger;
		}

	@Column(name = "FInHighLimit", precision = 28, scale = 10)
	public Double getFinHighLimit()
		{
			return this.finHighLimit;
		}

	public void setFinHighLimit(Double finHighLimit)
		{
			this.finHighLimit = finHighLimit;
		}

	@Column(name = "FInLowLimit", precision = 28, scale = 10)
	public Double getFinLowLimit()
		{
			return this.finLowLimit;
		}

	public void setFinLowLimit(Double finLowLimit)
		{
			this.finLowLimit = finLowLimit;
		}

	@Column(name = "FLowestBomCode")
	public Integer getFlowestBomCode()
		{
			return this.flowestBomCode;
		}

	public void setFlowestBomCode(Integer flowestBomCode)
		{
			this.flowestBomCode = flowestBomCode;
		}

	@Column(name = "FMRPOrder")
	public Boolean getFmrporder()
		{
			return this.fmrporder;
		}

	public void setFmrporder(Boolean fmrporder)
		{
			this.fmrporder = fmrporder;
		}

	@Column(name = "FIsCharSourceItem")
	public Integer getFisCharSourceItem()
		{
			return this.fisCharSourceItem;
		}

	public void setFisCharSourceItem(Integer fisCharSourceItem)
		{
			this.fisCharSourceItem = fisCharSourceItem;
		}

	@Column(name = "FCharSourceItemID")
	public Integer getFcharSourceItemId()
		{
			return this.fcharSourceItemId;
		}

	public void setFcharSourceItemId(Integer fcharSourceItemId)
		{
			this.fcharSourceItemId = fcharSourceItemId;
		}

	@Column(name = "FPlanMode")
	public Integer getFplanMode()
		{
			return this.fplanMode;
		}

	public void setFplanMode(Integer fplanMode)
		{
			this.fplanMode = fplanMode;
		}

	@Column(name = "FCtrlType")
	public Integer getFctrlType()
		{
			return this.fctrlType;
		}

	public void setFctrlType(Integer fctrlType)
		{
			this.fctrlType = fctrlType;
		}

	@Column(name = "FCtrlStraregy")
	public Integer getFctrlStraregy()
		{
			return this.fctrlStraregy;
		}

	public void setFctrlStraregy(Integer fctrlStraregy)
		{
			this.fctrlStraregy = fctrlStraregy;
		}

	@Column(name = "FContainerName", length = 50)
	public String getFcontainerName()
		{
			return this.fcontainerName;
		}

	public void setFcontainerName(String fcontainerName)
		{
			this.fcontainerName = fcontainerName;
		}

	@Column(name = "FKanBanCapability")
	public Integer getFkanBanCapability()
		{
			return this.fkanBanCapability;
		}

	public void setFkanBanCapability(Integer fkanBanCapability)
		{
			this.fkanBanCapability = fkanBanCapability;
		}

	@Column(name = "F_102", precision = 53, scale = 0)
	public Double getF102()
		{
			return this.f102;
		}

	public void setF102(Double f102)
		{
			this.f102 = f102;
		}

	@Column(name = "FChartNumber")
	public String getFchartNumber()
		{
			return this.fchartNumber;
		}

	public void setFchartNumber(String fchartNumber)
		{
			this.fchartNumber = fchartNumber;
		}

	@Column(name = "FIsKeyItem")
	public Boolean getFisKeyItem()
		{
			return this.fisKeyItem;
		}

	public void setFisKeyItem(Boolean fisKeyItem)
		{
			this.fisKeyItem = fisKeyItem;
		}

	@Column(name = "FMaund")
	public Integer getFmaund()
		{
			return this.fmaund;
		}

	public void setFmaund(Integer fmaund)
		{
			this.fmaund = fmaund;
		}

	@Column(name = "FGrossWeight", precision = 28, scale = 10)
	public Double getFgrossWeight()
		{
			return this.fgrossWeight;
		}

	public void setFgrossWeight(Double fgrossWeight)
		{
			this.fgrossWeight = fgrossWeight;
		}

	@Column(name = "FNetWeight", precision = 28, scale = 10)
	public Double getFnetWeight()
		{
			return this.fnetWeight;
		}

	public void setFnetWeight(Double fnetWeight)
		{
			this.fnetWeight = fnetWeight;
		}

	@Column(name = "FCubicMeasure")
	public Integer getFcubicMeasure()
		{
			return this.fcubicMeasure;
		}

	public void setFcubicMeasure(Integer fcubicMeasure)
		{
			this.fcubicMeasure = fcubicMeasure;
		}

	@Column(name = "FLength", precision = 28, scale = 10)
	public Double getFlength()
		{
			return this.flength;
		}

	public void setFlength(Double flength)
		{
			this.flength = flength;
		}

	@Column(name = "FWidth", precision = 28, scale = 10)
	public Double getFwidth()
		{
			return this.fwidth;
		}

	public void setFwidth(Double fwidth)
		{
			this.fwidth = fwidth;
		}

	@Column(name = "FHeight", precision = 28, scale = 10)
	public Double getFheight()
		{
			return this.fheight;
		}

	public void setFheight(Double fheight)
		{
			this.fheight = fheight;
		}

	@Column(name = "FSize", precision = 28, scale = 10)
	public Double getFsize()
		{
			return this.fsize;
		}

	public void setFsize(Double fsize)
		{
			this.fsize = fsize;
		}

	@Column(name = "FVersion", length = 10)
	public String getFversion()
		{
			return this.fversion;
		}

	public void setFversion(String fversion)
		{
			this.fversion = fversion;
		}

	@Column(name = "FStandardCost", precision = 28, scale = 10)
	public Double getFstandardCost()
		{
			return this.fstandardCost;
		}

	public void setFstandardCost(Double fstandardCost)
		{
			this.fstandardCost = fstandardCost;
		}

	@Column(name = "FStandardManHour", precision = 28, scale = 10)
	public Double getFstandardManHour()
		{
			return this.fstandardManHour;
		}

	public void setFstandardManHour(Double fstandardManHour)
		{
			this.fstandardManHour = fstandardManHour;
		}

	@Column(name = "FStdPayRate", precision = 28, scale = 10)
	public Double getFstdPayRate()
		{
			return this.fstdPayRate;
		}

	public void setFstdPayRate(Double fstdPayRate)
		{
			this.fstdPayRate = fstdPayRate;
		}

	@Column(name = "FChgFeeRate", precision = 28, scale = 10)
	public Double getFchgFeeRate()
		{
			return this.fchgFeeRate;
		}

	public void setFchgFeeRate(Double fchgFeeRate)
		{
			this.fchgFeeRate = fchgFeeRate;
		}

	@Column(name = "FStdFixFeeRate", precision = 28, scale = 10)
	public Double getFstdFixFeeRate()
		{
			return this.fstdFixFeeRate;
		}

	public void setFstdFixFeeRate(Double fstdFixFeeRate)
		{
			this.fstdFixFeeRate = fstdFixFeeRate;
		}

	@Column(name = "FOutMachFee", precision = 28, scale = 10)
	public Double getFoutMachFee()
		{
			return this.foutMachFee;
		}

	public void setFoutMachFee(Double foutMachFee)
		{
			this.foutMachFee = foutMachFee;
		}

	@Column(name = "FPieceRate", precision = 28, scale = 10)
	public Double getFpieceRate()
		{
			return this.fpieceRate;
		}

	public void setFpieceRate(Double fpieceRate)
		{
			this.fpieceRate = fpieceRate;
		}

	@Column(name = "FInspectionLevel")
	public Integer getFinspectionLevel()
		{
			return this.finspectionLevel;
		}

	public void setFinspectionLevel(Integer finspectionLevel)
		{
			this.finspectionLevel = finspectionLevel;
		}

	@Column(name = "FInspectionProject")
	public Integer getFinspectionProject()
		{
			return this.finspectionProject;
		}

	public void setFinspectionProject(Integer finspectionProject)
		{
			this.finspectionProject = finspectionProject;
		}

	@Column(name = "FIsListControl")
	public Integer getFisListControl()
		{
			return this.fisListControl;
		}

	public void setFisListControl(Integer fisListControl)
		{
			this.fisListControl = fisListControl;
		}

	@Column(name = "FProChkMde")
	public Integer getFproChkMde()
		{
			return this.fproChkMde;
		}

	public void setFproChkMde(Integer fproChkMde)
		{
			this.fproChkMde = fproChkMde;
		}

	@Column(name = "FWWChkMde")
	public Integer getFwwchkMde()
		{
			return this.fwwchkMde;
		}

	public void setFwwchkMde(Integer fwwchkMde)
		{
			this.fwwchkMde = fwwchkMde;
		}

	@Column(name = "FSOChkMde")
	public Integer getFsochkMde()
		{
			return this.fsochkMde;
		}

	public void setFsochkMde(Integer fsochkMde)
		{
			this.fsochkMde = fsochkMde;
		}

	@Column(name = "FWthDrwChkMde")
	public Integer getFwthDrwChkMde()
		{
			return this.fwthDrwChkMde;
		}

	public void setFwthDrwChkMde(Integer fwthDrwChkMde)
		{
			this.fwthDrwChkMde = fwthDrwChkMde;
		}

	@Column(name = "FStkChkMde")
	public Integer getFstkChkMde()
		{
			return this.fstkChkMde;
		}

	public void setFstkChkMde(Integer fstkChkMde)
		{
			this.fstkChkMde = fstkChkMde;
		}

	@Column(name = "FOtherChkMde")
	public Integer getFotherChkMde()
		{
			return this.fotherChkMde;
		}

	public void setFotherChkMde(Integer fotherChkMde)
		{
			this.fotherChkMde = fotherChkMde;
		}

	@Column(name = "FStkChkPrd")
	public Integer getFstkChkPrd()
		{
			return this.fstkChkPrd;
		}

	public void setFstkChkPrd(Integer fstkChkPrd)
		{
			this.fstkChkPrd = fstkChkPrd;
		}

	@Column(name = "FStkChkAlrm")
	public Integer getFstkChkAlrm()
		{
			return this.fstkChkAlrm;
		}

	public void setFstkChkAlrm(Integer fstkChkAlrm)
		{
			this.fstkChkAlrm = fstkChkAlrm;
		}

	@Column(name = "FIdentifier")
	public Integer getFidentifier()
		{
			return this.fidentifier;
		}

	public void setFidentifier(Integer fidentifier)
		{
			this.fidentifier = fidentifier;
		}

	@Column(name = "FNameEn")
	public String getFnameEn()
		{
			return this.fnameEn;
		}

	public void setFnameEn(String fnameEn)
		{
			this.fnameEn = fnameEn;
		}

	@Column(name = "FModelEn")
	public String getFmodelEn()
		{
			return this.fmodelEn;
		}

	public void setFmodelEn(String fmodelEn)
		{
			this.fmodelEn = fmodelEn;
		}

	@Column(name = "FHSNumber")
	public Integer getFhsnumber()
		{
			return this.fhsnumber;
		}

	public void setFhsnumber(Integer fhsnumber)
		{
			this.fhsnumber = fhsnumber;
		}

	@Column(name = "FFirstUnit")
	public String getFfirstUnit()
		{
			return this.ffirstUnit;
		}

	public void setFfirstUnit(String ffirstUnit)
		{
			this.ffirstUnit = ffirstUnit;
		}

	@Column(name = "FSecondUnit")
	public String getFsecondUnit()
		{
			return this.fsecondUnit;
		}

	public void setFsecondUnit(String fsecondUnit)
		{
			this.fsecondUnit = fsecondUnit;
		}

	@Column(name = "FFirstUnitRate", precision = 28, scale = 10)
	public Double getFfirstUnitRate()
		{
			return this.ffirstUnitRate;
		}

	public void setFfirstUnitRate(Double ffirstUnitRate)
		{
			this.ffirstUnitRate = ffirstUnitRate;
		}

	@Column(name = "FSecondUnitRate", precision = 28, scale = 10)
	public Double getFsecondUnitRate()
		{
			return this.fsecondUnitRate;
		}

	public void setFsecondUnitRate(Double fsecondUnitRate)
		{
			this.fsecondUnitRate = fsecondUnitRate;
		}

	@Column(name = "FIsManage")
	public Boolean getFisManage()
		{
			return this.fisManage;
		}

	public void setFisManage(Boolean fisManage)
		{
			this.fisManage = fisManage;
		}

	@Column(name = "FPackType")
	public Integer getFpackType()
		{
			return this.fpackType;
		}

	public void setFpackType(Integer fpackType)
		{
			this.fpackType = fpackType;
		}

	@Column(name = "FLenDecimal")
	public Integer getFlenDecimal()
		{
			return this.flenDecimal;
		}

	public void setFlenDecimal(Integer flenDecimal)
		{
			this.flenDecimal = flenDecimal;
		}

	@Column(name = "FCubageDecimal")
	public Integer getFcubageDecimal()
		{
			return this.fcubageDecimal;
		}

	public void setFcubageDecimal(Integer fcubageDecimal)
		{
			this.fcubageDecimal = fcubageDecimal;
		}

	@Column(name = "FWeightDecimal")
	public Integer getFweightDecimal()
		{
			return this.fweightDecimal;
		}

	public void setFweightDecimal(Integer fweightDecimal)
		{
			this.fweightDecimal = fweightDecimal;
		}

	@Column(name = "FImpostTaxRate", precision = 28, scale = 10)
	public Double getFimpostTaxRate()
		{
			return this.fimpostTaxRate;
		}

	public void setFimpostTaxRate(Double fimpostTaxRate)
		{
			this.fimpostTaxRate = fimpostTaxRate;
		}

	@Column(name = "FConsumeTaxRate", precision = 28, scale = 10)
	public Double getFconsumeTaxRate()
		{
			return this.fconsumeTaxRate;
		}

	public void setFconsumeTaxRate(Double fconsumeTaxRate)
		{
			this.fconsumeTaxRate = fconsumeTaxRate;
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

}