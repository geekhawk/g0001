package com.qq.k3.seOrder.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table; 
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT; 

/**
 * SeorderEntry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SEOrderEntry", schema = "dbo", catalog = "AIS20170527080305")
@DynamicUpdate(true)
@SelectBeforeUpdate(value=true)
public class SeOrderEntry  extends BaseEntityHBT<SeOrderEntry>
{

	// Fields  
	private static final long serialVersionUID = 1L;
	private Integer fdetailId;
	private SeOrder seorder;
	private TIcitemCore ticitemCore;
	private Integer fentryId;
	private Double fqty;
	private Double fcommitQty;
	private Double fprice;
	private Double famount;
	private Double ftaxRate;
	private Double ftaxAmount;
	private Double ftax;
	private Float fdiscount;
	private String fnote;
	private Date fdate;
	private Double fdiscountAmount;
	private Double finvoiceQty;
	private Double fbcommitQty;
	private Integer ftranLeadTime;
	private Integer fatpdeduct;
	private Integer fcostObjectId;
	private TMeasureUnit  tmeasureUnit;
	private Double fauxBcommitQty;
	private Double fauxCommitQty;
	private Double fauxInvoiceQty;
	private Double fauxPrice;
	private Double fauxQty;
	private Double funiDiscount;
	private Double ffinalAmount;
	private Integer fsourceEntryId;
	private Integer fhaveMrp;
	private Double fstockQty;
	private Double fauxStockQty;
	private String fbatchNo;
	private Double fcess;
	private Date fadviceConsignDate;
	private Integer fbomInterId;
	private String fmapNumber;
	private String fmapName;
	private Integer flockFlag;
	private Integer finForeCast;
	private Double fallAmount;
	private Double fallStdAmount;
	private Integer fauxPropId;
	private Double fauxPriceDiscount;
	private Double fpriceDiscount;
	private Double fqtyInvoice;
	private Double fqtyInvoiceBase;
	private Double ftaxAmt;
	private Double fauxTaxPrice;
	private Double ftaxPrice;
	private Double freceiveAmountForCommit;
	private Double freceiveAmountCommit;
	private Double fsecCoefficient;
	private Double fsecQty;
	private Double fsecCommitQty;
	private Integer fsourceTranType;
	private Integer fsourceInterId;
	private String fsourceBillNo;
	private Integer fcontractInterId;
	private Integer fcontractEntryId;
	private String fcontractBillNo;
	private Integer fmrplockFlag;
	private Integer fmrptrackFlag;
	private Double forderCommitQty;
	private Double forderSecCommitQty;
	private Double fauxQtyInvoice;
	private Double fcommitInstall;
	private Double fauxCommitInstall;
	private Integer fmrpClosed;
	private Double fauxInCommitQty;
	private Double finCommitQty;
	private Double fsecInCommitQty;
	private Double fapplyCommitQty;
	private Double fauxApplyCommitQty;
	private Double fsecApplyCommitQty;
	private Integer fevaluated;
	private Integer fpackUnitId;
	private Integer fpackCount;
	private Double fpackType;
	private Integer fmapId;
	private String fgoodsDesc;
	private Double famountAfterDiscount;
	private Double finformCommitQty;
	private Double fauxInformCommitQty;
	private Double fsecInformCommitQty;
	private Double fpurCommitQty;
	private Double fauxPurCommitQty;
	private Double fsecPurCommitQty;
	private Integer fmrpAutoClosed;
	private Double fsecStockQty;
	private Double fsecInvoiceQty;
	private Double fsecCommitInstall;
	private Integer fplanMode;
	private String fmtono;
	private Double fentrySelfS0161;
	private Double fentrySelfS0162;
	private Double fentrySelfS0163;
	private Integer fentrySelfS0164;
	private Double fentrySelfS0166;
	private  String delFlag;

	// Constructors////赠品

	/** default constructor */
	public SeOrderEntry()
	{
	}

	/** minimal constructor 
	 * @param TMeasureUnit */
	public SeOrderEntry(SeOrder seorder, Integer fentryId, Double fqty, Double fcommitQty, Double fprice, Double famount, Double ftaxAmount, Double ftax, Double finvoiceQty,
			Double fbcommitQty, Integer ftranLeadTime, Integer fatpdeduct, Integer fcostObjectId,   Double fauxBcommitQty, Double fauxCommitQty,
			Double fauxInvoiceQty, Double fauxPrice, Double fauxQty, Double funiDiscount, Double ffinalAmount, Integer fsourceEntryId, Double fstockQty, Double fauxStockQty,
			String fbatchNo, Double fcess, Integer fbomInterId, String fmapNumber, Integer flockFlag, Double fallAmount, Double fallStdAmount, Integer fauxPropId,
			Double fauxPriceDiscount, Double fpriceDiscount, Double fqtyInvoice, Double fqtyInvoiceBase, Double ftaxAmt, Double fauxTaxPrice, Double ftaxPrice,
			Double freceiveAmountForCommit, Double freceiveAmountCommit, Double fsecCoefficient, Double fsecQty, Double fsecCommitQty, Integer fsourceTranType,
			Integer fsourceInterId, String fsourceBillNo, Integer fcontractInterId, Integer fcontractEntryId, String fcontractBillNo, Integer fmrplockFlag, Integer fmrptrackFlag,
			Double forderCommitQty, Double forderSecCommitQty, Double fauxQtyInvoice, Double fcommitInstall, Double fauxCommitInstall, Integer fmrpClosed, Double fauxInCommitQty,
			Double finCommitQty, Double fsecInCommitQty, Double fapplyCommitQty, Double fauxApplyCommitQty, Double fsecApplyCommitQty, Integer fevaluated, Integer fpackUnitId,
			Integer fpackCount, Double fpackType, Integer fmapId, String fgoodsDesc, Double famountAfterDiscount, Double finformCommitQty, Double fauxInformCommitQty,
			Double fsecInformCommitQty, Double fpurCommitQty, Double fauxPurCommitQty, Double fsecPurCommitQty, Double fsecStockQty, Double fsecInvoiceQty,
			Double fsecCommitInstall, Integer fplanMode, String fmtono, com.qq.k3.seOrder.entity.TMeasureUnit TMeasureUnit)
	{
		this.seorder = seorder;
		this.fentryId = fentryId;
		this.fqty = fqty;
		this.fcommitQty = fcommitQty;
		this.fprice = fprice;
		this.famount = famount;
		this.ftaxAmount = ftaxAmount;
		this.ftax = ftax;
		this.finvoiceQty = finvoiceQty;
		this.fbcommitQty = fbcommitQty;
		this.ftranLeadTime = ftranLeadTime;
		this.fatpdeduct = fatpdeduct;
		this.fcostObjectId = fcostObjectId;
		this.tmeasureUnit = TMeasureUnit;
		this.fauxBcommitQty = fauxBcommitQty;
		this.fauxCommitQty = fauxCommitQty;
		this.fauxInvoiceQty = fauxInvoiceQty;
		this.fauxPrice = fauxPrice;
		this.fauxQty = fauxQty;
		this.funiDiscount = funiDiscount;
		this.ffinalAmount = ffinalAmount;
		this.fsourceEntryId = fsourceEntryId;
		this.fstockQty = fstockQty;
		this.fauxStockQty = fauxStockQty;
		this.fbatchNo = fbatchNo;
		this.fcess = fcess;
		this.fbomInterId = fbomInterId;
		this.fmapNumber = fmapNumber;
		this.flockFlag = flockFlag;
		this.fallAmount = fallAmount;
		this.fallStdAmount = fallStdAmount;
		this.fauxPropId = fauxPropId;
		this.fauxPriceDiscount = fauxPriceDiscount;
		this.fpriceDiscount = fpriceDiscount;
		this.fqtyInvoice = fqtyInvoice;
		this.fqtyInvoiceBase = fqtyInvoiceBase;
		this.ftaxAmt = ftaxAmt;
		this.fauxTaxPrice = fauxTaxPrice;
		this.ftaxPrice = ftaxPrice;
		this.freceiveAmountForCommit = freceiveAmountForCommit;
		this.freceiveAmountCommit = freceiveAmountCommit;
		this.fsecCoefficient = fsecCoefficient;
		this.fsecQty = fsecQty;
		this.fsecCommitQty = fsecCommitQty;
		this.fsourceTranType = fsourceTranType;
		this.fsourceInterId = fsourceInterId;
		this.fsourceBillNo = fsourceBillNo;
		this.fcontractInterId = fcontractInterId;
		this.fcontractEntryId = fcontractEntryId;
		this.fcontractBillNo = fcontractBillNo;
		this.fmrplockFlag = fmrplockFlag;
		this.fmrptrackFlag = fmrptrackFlag;
		this.forderCommitQty = forderCommitQty;
		this.forderSecCommitQty = forderSecCommitQty;
		this.fauxQtyInvoice = fauxQtyInvoice;
		this.fcommitInstall = fcommitInstall;
		this.fauxCommitInstall = fauxCommitInstall;
		this.fmrpClosed = fmrpClosed;
		this.fauxInCommitQty = fauxInCommitQty;
		this.finCommitQty = finCommitQty;
		this.fsecInCommitQty = fsecInCommitQty;
		this.fapplyCommitQty = fapplyCommitQty;
		this.fauxApplyCommitQty = fauxApplyCommitQty;
		this.fsecApplyCommitQty = fsecApplyCommitQty;
		this.fevaluated = fevaluated;
		this.fpackUnitId = fpackUnitId;
		this.fpackCount = fpackCount;
		this.fpackType = fpackType;
		this.fmapId = fmapId;
		this.fgoodsDesc = fgoodsDesc;
		this.famountAfterDiscount = famountAfterDiscount;
		this.finformCommitQty = finformCommitQty;
		this.fauxInformCommitQty = fauxInformCommitQty;
		this.fsecInformCommitQty = fsecInformCommitQty;
		this.fpurCommitQty = fpurCommitQty;
		this.fauxPurCommitQty = fauxPurCommitQty;
		this.fsecPurCommitQty = fsecPurCommitQty;
		this.fsecStockQty = fsecStockQty;
		this.fsecInvoiceQty = fsecInvoiceQty;
		this.fsecCommitInstall = fsecCommitInstall;
		this.fplanMode = fplanMode;
		this.fmtono = fmtono;
	}

	/** full constructor 
	 * @param TMeasureUnit */
	public SeOrderEntry(SeOrder seorder, TIcitemCore ticitemCore, Integer fentryId, Double fqty, Double fcommitQty, Double fprice, Double famount, Double ftaxRate,
			Double ftaxAmount, Double ftax, Float fdiscount, String fnote, Date fdate, Double fdiscountAmount, Double finvoiceQty, Double fbcommitQty, Integer ftranLeadTime,
			Integer fatpdeduct, Integer fcostObjectId,   Double fauxBcommitQty, Double fauxCommitQty, Double fauxInvoiceQty, Double fauxPrice, Double fauxQty,
			Double funiDiscount, Double ffinalAmount, Integer fsourceEntryId, Integer fhaveMrp, Double fstockQty, Double fauxStockQty, String fbatchNo, Double fcess,
			Date fadviceConsignDate, Integer fbomInterId, String fmapNumber, String fmapName, Integer flockFlag, Integer finForeCast, Double fallAmount, Double fallStdAmount,
			Integer fauxPropId, Double fauxPriceDiscount, Double fpriceDiscount, Double fqtyInvoice, Double fqtyInvoiceBase, Double ftaxAmt, Double fauxTaxPrice, Double ftaxPrice,
			Double freceiveAmountForCommit, Double freceiveAmountCommit, Double fsecCoefficient, Double fsecQty, Double fsecCommitQty, Integer fsourceTranType,
			Integer fsourceInterId, String fsourceBillNo, Integer fcontractInterId, Integer fcontractEntryId, String fcontractBillNo, Integer fmrplockFlag, Integer fmrptrackFlag,
			Double forderCommitQty, Double forderSecCommitQty, Double fauxQtyInvoice, Double fcommitInstall, Double fauxCommitInstall, Integer fmrpClosed, Double fauxInCommitQty,
			Double finCommitQty, Double fsecInCommitQty, Double fapplyCommitQty, Double fauxApplyCommitQty, Double fsecApplyCommitQty, Integer fevaluated, Integer fpackUnitId,
			Integer fpackCount, Double fpackType, Integer fmapId, String fgoodsDesc, Double famountAfterDiscount, Double finformCommitQty, Double fauxInformCommitQty,
			Double fsecInformCommitQty, Double fpurCommitQty, Double fauxPurCommitQty, Double fsecPurCommitQty, Integer fmrpAutoClosed, Double fsecStockQty, Double fsecInvoiceQty,
			Double fsecCommitInstall, Integer fplanMode, String fmtono, Double fentrySelfS0161, Double fentrySelfS0162, Double fentrySelfS0163, Integer fentrySelfS0164, com.qq.k3.seOrder.entity.TMeasureUnit TMeasureUnit)
	{
		this.seorder = seorder;
		this.ticitemCore = ticitemCore;
		this.fentryId = fentryId;
		this.fqty = fqty;
		this.fcommitQty = fcommitQty;
		this.fprice = fprice;
		this.famount = famount;
		this.ftaxRate = ftaxRate;
		this.ftaxAmount = ftaxAmount;
		this.ftax = ftax;
		this.fdiscount = fdiscount;
		this.fnote = fnote;
		this.fdate = fdate;
		this.fdiscountAmount = fdiscountAmount;
		this.finvoiceQty = finvoiceQty;
		this.fbcommitQty = fbcommitQty;
		this.ftranLeadTime = ftranLeadTime;
		this.fatpdeduct = fatpdeduct;
		this.fcostObjectId = fcostObjectId;
		this.tmeasureUnit = TMeasureUnit;
		this.fauxBcommitQty = fauxBcommitQty;
		this.fauxCommitQty = fauxCommitQty;
		this.fauxInvoiceQty = fauxInvoiceQty;
		this.fauxPrice = fauxPrice;
		this.fauxQty = fauxQty;
		this.funiDiscount = funiDiscount;
		this.ffinalAmount = ffinalAmount;
		this.fsourceEntryId = fsourceEntryId;
		this.fhaveMrp = fhaveMrp;
		this.fstockQty = fstockQty;
		this.fauxStockQty = fauxStockQty;
		this.fbatchNo = fbatchNo;
		this.fcess = fcess;
		this.fadviceConsignDate = fadviceConsignDate;
		this.fbomInterId = fbomInterId;
		this.fmapNumber = fmapNumber;
		this.fmapName = fmapName;
		this.flockFlag = flockFlag;
		this.finForeCast = finForeCast;
		this.fallAmount = fallAmount;
		this.fallStdAmount = fallStdAmount;
		this.fauxPropId = fauxPropId;
		this.fauxPriceDiscount = fauxPriceDiscount;
		this.fpriceDiscount = fpriceDiscount;
		this.fqtyInvoice = fqtyInvoice;
		this.fqtyInvoiceBase = fqtyInvoiceBase;
		this.ftaxAmt = ftaxAmt;
		this.fauxTaxPrice = fauxTaxPrice;
		this.ftaxPrice = ftaxPrice;
		this.freceiveAmountForCommit = freceiveAmountForCommit;
		this.freceiveAmountCommit = freceiveAmountCommit;
		this.fsecCoefficient = fsecCoefficient;
		this.fsecQty = fsecQty;
		this.fsecCommitQty = fsecCommitQty;
		this.fsourceTranType = fsourceTranType;
		this.fsourceInterId = fsourceInterId;
		this.fsourceBillNo = fsourceBillNo;
		this.fcontractInterId = fcontractInterId;
		this.fcontractEntryId = fcontractEntryId;
		this.fcontractBillNo = fcontractBillNo;
		this.fmrplockFlag = fmrplockFlag;
		this.fmrptrackFlag = fmrptrackFlag;
		this.forderCommitQty = forderCommitQty;
		this.forderSecCommitQty = forderSecCommitQty;
		this.fauxQtyInvoice = fauxQtyInvoice;
		this.fcommitInstall = fcommitInstall;
		this.fauxCommitInstall = fauxCommitInstall;
		this.fmrpClosed = fmrpClosed;
		this.fauxInCommitQty = fauxInCommitQty;
		this.finCommitQty = finCommitQty;
		this.fsecInCommitQty = fsecInCommitQty;
		this.fapplyCommitQty = fapplyCommitQty;
		this.fauxApplyCommitQty = fauxApplyCommitQty;
		this.fsecApplyCommitQty = fsecApplyCommitQty;
		this.fevaluated = fevaluated;
		this.fpackUnitId = fpackUnitId;
		this.fpackCount = fpackCount;
		this.fpackType = fpackType;
		this.fmapId = fmapId;
		this.fgoodsDesc = fgoodsDesc;
		this.famountAfterDiscount = famountAfterDiscount;
		this.finformCommitQty = finformCommitQty;
		this.fauxInformCommitQty = fauxInformCommitQty;
		this.fsecInformCommitQty = fsecInformCommitQty;
		this.fpurCommitQty = fpurCommitQty;
		this.fauxPurCommitQty = fauxPurCommitQty;
		this.fsecPurCommitQty = fsecPurCommitQty;
		this.fmrpAutoClosed = fmrpAutoClosed;
		this.fsecStockQty = fsecStockQty;
		this.fsecInvoiceQty = fsecInvoiceQty;
		this.fsecCommitInstall = fsecCommitInstall;
		this.fplanMode = fplanMode;
		this.fmtono = fmtono;
		this.fentrySelfS0161 = fentrySelfS0161;
		this.fentrySelfS0162 = fentrySelfS0162;
		this.fentrySelfS0163 = fentrySelfS0163;
		this.fentrySelfS0164 = fentrySelfS0164;
	}

	// Property accessors 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id 
	@Column(name = "FDetailID", unique = true, nullable = false)
	public Integer getFdetailId()
		{
			return this.fdetailId;
		}

	public void setFdetailId(Integer fdetailId)
		{
			this.fdetailId = fdetailId;
		}
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns(
	{ @JoinColumn(name = "FBrNO", referencedColumnName = "FBrNo", nullable = false, updatable = false), @JoinColumn(name = "FInterID", referencedColumnName = "FInterID", nullable = false, updatable = false) })
	public SeOrder getSeorder()
		{
			return this.seorder;
		}

	public void setSeorder(SeOrder seorder)
		{
			this.seorder = seorder;
		}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FItemID")
	public TIcitemCore getTicitemCore()
		{
			return this.ticitemCore;
		}

	public void setTicitemCore(TIcitemCore TIcitemCore)
		{
			this.ticitemCore = TIcitemCore;
		}

	@Column(name = "FEntryID", nullable = false)
	public Integer getFentryId()
		{
			return this.fentryId;
		}

	public void setFentryId(Integer fentryId)
		{
			this.fentryId = fentryId;
		}

	@Column(name = "FQty", nullable = false, precision = 28, scale = 10)
	public Double getFqty()
		{
			return this.fqty;
		}

	public void setFqty(Double fqty)
		{
			this.fqty = fqty;
		}

	@Column(name = "FCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFcommitQty()
		{
			return this.fcommitQty;
		}

	public void setFcommitQty(Double fcommitQty)
		{
			this.fcommitQty = fcommitQty;
		}

	@Column(name = "FPrice", nullable = false, precision = 28, scale = 10)
	public Double getFprice()
		{
			return this.fprice;
		}

	public void setFprice(Double fprice)
		{
			this.fprice = fprice;
		}

	@Column(name = "FAmount", nullable = false, precision = 20)
	public Double getFamount()
		{
			return this.famount;
		}

	public void setFamount(Double famount)
		{
			this.famount = famount;
		}

	@Column(name = "FTaxRate", precision = 28, scale = 10)
	public Double getFtaxRate()
		{
			return this.ftaxRate;
		}

	public void setFtaxRate(Double ftaxRate)
		{
			this.ftaxRate = ftaxRate;
		}

	@Column(name = "FTaxAmount", nullable = false, precision = 20)
	public Double getFtaxAmount()
		{
			return this.ftaxAmount;
		}

	public void setFtaxAmount(Double ftaxAmount)
		{
			this.ftaxAmount = ftaxAmount;
		}

	@Column(name = "FTax", nullable = false, precision = 20)
	public Double getFtax()
		{
			return this.ftax;
		}

	public void setFtax(Double ftax)
		{
			this.ftax = ftax;
		}

	@Column(name = "FDiscount", precision = 24, scale = 0)
	public Float getFdiscount()
		{
			return this.fdiscount;
		}

	public void setFdiscount(Float fdiscount)
		{
			this.fdiscount = fdiscount;
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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "FDate", length = 23)
	public Date getFdate()
		{
			return this.fdate;
		}

	public void setFdate(Date fdate)
		{
			this.fdate = fdate;
		}

	@Column(name = "FDiscountAmount", precision = 20)
	public Double getFdiscountAmount()
		{
			return this.fdiscountAmount;
		}

	public void setFdiscountAmount(Double fdiscountAmount)
		{
			this.fdiscountAmount = fdiscountAmount;
		}

	@Column(name = "FInvoiceQty", nullable = false, precision = 28, scale = 10)
	public Double getFinvoiceQty()
		{
			return this.finvoiceQty;
		}

	public void setFinvoiceQty(Double finvoiceQty)
		{
			this.finvoiceQty = finvoiceQty;
		}

	@Column(name = "FBCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFbcommitQty()
		{
			return this.fbcommitQty;
		}

	public void setFbcommitQty(Double fbcommitQty)
		{
			this.fbcommitQty = fbcommitQty;
		}

	@Column(name = "FTranLeadTime", nullable = false)
	public Integer getFtranLeadTime()
		{
			return this.ftranLeadTime;
		}

	public void setFtranLeadTime(Integer ftranLeadTime)
		{
			this.ftranLeadTime = ftranLeadTime;
		}

	@Column(name = "FATPDeduct", nullable = false)
	public Integer getFatpdeduct()
		{
			return this.fatpdeduct;
		}

	public void setFatpdeduct(Integer fatpdeduct)
		{
			this.fatpdeduct = fatpdeduct;
		}

	@Column(name = "FCostObjectID", nullable = false)
	public Integer getFcostObjectId()
		{
			return this.fcostObjectId;
		}

	public void setFcostObjectId(Integer fcostObjectId)
		{
			this.fcostObjectId = fcostObjectId;
		}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FUnitID", nullable = false)
	public TMeasureUnit getTmeasureUnit()
		{
			return this.tmeasureUnit;
		}

	public void setTmeasureUnit(TMeasureUnit TMeasureUnit)
		{
			this.tmeasureUnit = TMeasureUnit;
		}

	@Column(name = "FAuxBCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxBcommitQty()
		{
			return this.fauxBcommitQty;
		}

	public void setFauxBcommitQty(Double fauxBcommitQty)
		{
			this.fauxBcommitQty = fauxBcommitQty;
		}

	@Column(name = "FAuxCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxCommitQty()
		{
			return this.fauxCommitQty;
		}

	public void setFauxCommitQty(Double fauxCommitQty)
		{
			this.fauxCommitQty = fauxCommitQty;
		}

	@Column(name = "FAuxInvoiceQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxInvoiceQty()
		{
			return this.fauxInvoiceQty;
		}

	public void setFauxInvoiceQty(Double fauxInvoiceQty)
		{
			this.fauxInvoiceQty = fauxInvoiceQty;
		}

	@Column(name = "FAuxPrice", nullable = false, precision = 28, scale = 10)
	public Double getFauxPrice()
		{
			return this.fauxPrice;
		}

	public void setFauxPrice(Double fauxPrice)
		{
			this.fauxPrice = fauxPrice;
		}

	@Column(name = "FAuxQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxQty()
		{
			return this.fauxQty;
		}

	public void setFauxQty(Double fauxQty)
		{
			this.fauxQty = fauxQty;
		}

	@Column(name = "FUniDiscount", nullable = false, precision = 28, scale = 10)
	public Double getFuniDiscount()
		{
			return this.funiDiscount;
		}

	public void setFuniDiscount(Double funiDiscount)
		{
			this.funiDiscount = funiDiscount;
		}

	@Column(name = "FFinalAmount", nullable = false, precision = 20)
	public Double getFfinalAmount()
		{
			return this.ffinalAmount;
		}

	public void setFfinalAmount(Double ffinalAmount)
		{
			this.ffinalAmount = ffinalAmount;
		}

	@Column(name = "FSourceEntryID", nullable = false)
	public Integer getFsourceEntryId()
		{
			return this.fsourceEntryId;
		}

	public void setFsourceEntryId(Integer fsourceEntryId)
		{
			this.fsourceEntryId = fsourceEntryId;
		}

	@Column(name = "FHaveMrp")
	public Integer getFhaveMrp()
		{
			return this.fhaveMrp;
		}

	public void setFhaveMrp(Integer fhaveMrp)
		{
			this.fhaveMrp = fhaveMrp;
		}

	@Column(name = "FStockQty", nullable = false, precision = 28, scale = 10)
	public Double getFstockQty()
		{
			return this.fstockQty;
		}

	public void setFstockQty(Double fstockQty)
		{
			this.fstockQty = fstockQty;
		}

	@Column(name = "FAuxStockQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxStockQty()
		{
			return this.fauxStockQty;
		}

	public void setFauxStockQty(Double fauxStockQty)
		{
			this.fauxStockQty = fauxStockQty;
		}

	@Column(name = "FBatchNo", nullable = false, length = 200)
	public String getFbatchNo()
		{
			return this.fbatchNo;
		}

	public void setFbatchNo(String fbatchNo)
		{
			this.fbatchNo = fbatchNo;
		}

	@Column(name = "FCESS", nullable = false, precision = 20)
	public Double getFcess()
		{
			return this.fcess;
		}

	public void setFcess(Double fcess)
		{
			this.fcess = fcess;
		}
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "FAdviceConsignDate", length = 23)
	public Date getFadviceConsignDate()
		{
			return this.fadviceConsignDate;
		}

	public void setFadviceConsignDate(Date fadviceConsignDate)
		{
			this.fadviceConsignDate = fadviceConsignDate;
		}

	@Column(name = "FBomInterID", nullable = false)
	public Integer getFbomInterId()
		{
			return this.fbomInterId;
		}

	public void setFbomInterId(Integer fbomInterId)
		{
			this.fbomInterId = fbomInterId;
		}

	@Column(name = "FMapNumber", nullable = false, length = 80)
	public String getFmapNumber()
		{
			return this.fmapNumber;
		}

	public void setFmapNumber(String fmapNumber)
		{
			this.fmapNumber = fmapNumber;
		}

	@Column(name = "FMapName", length = 256)
	public String getFmapName()
		{
			return this.fmapName;
		}

	public void setFmapName(String fmapName)
		{
			this.fmapName = fmapName;
		}

	@Column(name = "FLockFlag", nullable = false)
	public Integer getFlockFlag()
		{
			return this.flockFlag;
		}

	public void setFlockFlag(Integer flockFlag)
		{
			this.flockFlag = flockFlag;
		}

	@Column(name = "FInForeCast")
	public Integer getFinForeCast()
		{
			return this.finForeCast;
		}

	public void setFinForeCast(Integer finForeCast)
		{
			this.finForeCast = finForeCast;
		}

	@Column(name = "FAllAmount", nullable = false, precision = 28, scale = 4)
	public Double getFallAmount()
		{
			return this.fallAmount;
		}

	public void setFallAmount(Double fallAmount)
		{
			this.fallAmount = fallAmount;
		}

	@Column(name = "FAllStdAmount", nullable = false, precision = 28, scale = 4)
	public Double getFallStdAmount()
		{
			return this.fallStdAmount;
		}

	public void setFallStdAmount(Double fallStdAmount)
		{
			this.fallStdAmount = fallStdAmount;
		}

	@Column(name = "FAuxPropID", nullable = false)
	public Integer getFauxPropId()
		{
			return this.fauxPropId;
		}

	public void setFauxPropId(Integer fauxPropId)
		{
			this.fauxPropId = fauxPropId;
		}

	@Column(name = "FAuxPriceDiscount", nullable = false, precision = 28, scale = 10)
	public Double getFauxPriceDiscount()
		{
			return this.fauxPriceDiscount;
		}

	public void setFauxPriceDiscount(Double fauxPriceDiscount)
		{
			this.fauxPriceDiscount = fauxPriceDiscount;
		}

	@Column(name = "FPriceDiscount", nullable = false, precision = 28, scale = 10)
	public Double getFpriceDiscount()
		{
			return this.fpriceDiscount;
		}

	public void setFpriceDiscount(Double fpriceDiscount)
		{
			this.fpriceDiscount = fpriceDiscount;
		}

	@Column(name = "FQtyInvoice", nullable = false, precision = 28, scale = 10)
	public Double getFqtyInvoice()
		{
			return this.fqtyInvoice;
		}

	public void setFqtyInvoice(Double fqtyInvoice)
		{
			this.fqtyInvoice = fqtyInvoice;
		}

	@Column(name = "FQtyInvoiceBase", nullable = false, precision = 28, scale = 10)
	public Double getFqtyInvoiceBase()
		{
			return this.fqtyInvoiceBase;
		}

	public void setFqtyInvoiceBase(Double fqtyInvoiceBase)
		{
			this.fqtyInvoiceBase = fqtyInvoiceBase;
		}

	@Column(name = "FTaxAmt", nullable = false, precision = 28, scale = 4)
	public Double getFtaxAmt()
		{
			return this.ftaxAmt;
		}

	public void setFtaxAmt(Double ftaxAmt)
		{
			this.ftaxAmt = ftaxAmt;
		}

	@Column(name = "FAuxTaxPrice", nullable = false, precision = 28, scale = 10)
	public Double getFauxTaxPrice()
		{
			return this.fauxTaxPrice;
		}

	public void setFauxTaxPrice(Double fauxTaxPrice)
		{
			this.fauxTaxPrice = fauxTaxPrice;
		}

	@Column(name = "FTaxPrice", nullable = false, precision = 28, scale = 10)
	public Double getFtaxPrice()
		{
			return this.ftaxPrice;
		}

	public void setFtaxPrice(Double ftaxPrice)
		{
			this.ftaxPrice = ftaxPrice;
		}

	@Column(name = "FReceiveAmountFor_Commit", nullable = false, precision = 28, scale = 4)
	public Double getFreceiveAmountForCommit()
		{
			return this.freceiveAmountForCommit;
		}

	public void setFreceiveAmountForCommit(Double freceiveAmountForCommit)
		{
			this.freceiveAmountForCommit = freceiveAmountForCommit;
		}

	@Column(name = "FReceiveAmount_Commit", nullable = false, precision = 28, scale = 4)
	public Double getFreceiveAmountCommit()
		{
			return this.freceiveAmountCommit;
		}

	public void setFreceiveAmountCommit(Double freceiveAmountCommit)
		{
			this.freceiveAmountCommit = freceiveAmountCommit;
		}

	@Column(name = "FSecCoefficient", nullable = false, precision = 28, scale = 10)
	public Double getFsecCoefficient()
		{
			return this.fsecCoefficient;
		}

	public void setFsecCoefficient(Double fsecCoefficient)
		{
			this.fsecCoefficient = fsecCoefficient;
		}

	@Column(name = "FSecQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecQty()
		{
			return this.fsecQty;
		}

	public void setFsecQty(Double fsecQty)
		{
			this.fsecQty = fsecQty;
		}

	@Column(name = "FSecCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecCommitQty()
		{
			return this.fsecCommitQty;
		}

	public void setFsecCommitQty(Double fsecCommitQty)
		{
			this.fsecCommitQty = fsecCommitQty;
		}

	@Column(name = "FSourceTranType", nullable = false)
	public Integer getFsourceTranType()
		{
			return this.fsourceTranType;
		}

	public void setFsourceTranType(Integer fsourceTranType)
		{
			this.fsourceTranType = fsourceTranType;
		}

	@Column(name = "FSourceInterId", nullable = false)
	public Integer getFsourceInterId()
		{
			return this.fsourceInterId;
		}

	public void setFsourceInterId(Integer fsourceInterId)
		{
			this.fsourceInterId = fsourceInterId;
		}

	@Column(name = "FSourceBillNo", nullable = false)
	public String getFsourceBillNo()
		{
			return this.fsourceBillNo;
		}

	public void setFsourceBillNo(String fsourceBillNo)
		{
			this.fsourceBillNo = fsourceBillNo;
		}

	@Column(name = "FContractInterID", nullable = false)
	public Integer getFcontractInterId()
		{
			return this.fcontractInterId;
		}

	public void setFcontractInterId(Integer fcontractInterId)
		{
			this.fcontractInterId = fcontractInterId;
		}

	@Column(name = "FContractEntryID", nullable = false)
	public Integer getFcontractEntryId()
		{
			return this.fcontractEntryId;
		}

	public void setFcontractEntryId(Integer fcontractEntryId)
		{
			this.fcontractEntryId = fcontractEntryId;
		}

	@Column(name = "FContractBillNo", nullable = false)
	public String getFcontractBillNo()
		{
			return this.fcontractBillNo;
		}

	public void setFcontractBillNo(String fcontractBillNo)
		{
			this.fcontractBillNo = fcontractBillNo;
		}

	@Column(name = "FMRPLockFlag", nullable = false)
	public Integer getFmrplockFlag()
		{
			return this.fmrplockFlag;
		}

	public void setFmrplockFlag(Integer fmrplockFlag)
		{
			this.fmrplockFlag = fmrplockFlag;
		}

	@Column(name = "FMRPTrackFlag", nullable = false)
	public Integer getFmrptrackFlag()
		{
			return this.fmrptrackFlag;
		}

	public void setFmrptrackFlag(Integer fmrptrackFlag)
		{
			this.fmrptrackFlag = fmrptrackFlag;
		}

	@Column(name = "FOrderCommitQty", nullable = false, precision = 28, scale = 13)
	public Double getForderCommitQty()
		{
			return this.forderCommitQty;
		}

	public void setForderCommitQty(Double forderCommitQty)
		{
			this.forderCommitQty = forderCommitQty;
		}

	@Column(name = "FOrderSecCommitQty", nullable = false, precision = 28, scale = 13)
	public Double getForderSecCommitQty()
		{
			return this.forderSecCommitQty;
		}

	public void setForderSecCommitQty(Double forderSecCommitQty)
		{
			this.forderSecCommitQty = forderSecCommitQty;
		}

	@Column(name = "FAuxQtyInvoice", nullable = false, precision = 28, scale = 10)
	public Double getFauxQtyInvoice()
		{
			return this.fauxQtyInvoice;
		}

	public void setFauxQtyInvoice(Double fauxQtyInvoice)
		{
			this.fauxQtyInvoice = fauxQtyInvoice;
		}

	@Column(name = "FCommitInstall", nullable = false, precision = 28, scale = 10)
	public Double getFcommitInstall()
		{
			return this.fcommitInstall;
		}

	public void setFcommitInstall(Double fcommitInstall)
		{
			this.fcommitInstall = fcommitInstall;
		}

	@Column(name = "FAuxCommitInstall", nullable = false, precision = 28, scale = 10)
	public Double getFauxCommitInstall()
		{
			return this.fauxCommitInstall;
		}

	public void setFauxCommitInstall(Double fauxCommitInstall)
		{
			this.fauxCommitInstall = fauxCommitInstall;
		}

	@Column(name = "FMrpClosed", nullable = false)
	public Integer getFmrpClosed()
		{
			return this.fmrpClosed;
		}

	public void setFmrpClosed(Integer fmrpClosed)
		{
			this.fmrpClosed = fmrpClosed;
		}

	@Column(name = "FAuxInCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxInCommitQty()
		{
			return this.fauxInCommitQty;
		}

	public void setFauxInCommitQty(Double fauxInCommitQty)
		{
			this.fauxInCommitQty = fauxInCommitQty;
		}

	@Column(name = "FInCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFinCommitQty()
		{
			return this.finCommitQty;
		}

	public void setFinCommitQty(Double finCommitQty)
		{
			this.finCommitQty = finCommitQty;
		}

	@Column(name = "FSecInCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecInCommitQty()
		{
			return this.fsecInCommitQty;
		}

	public void setFsecInCommitQty(Double fsecInCommitQty)
		{
			this.fsecInCommitQty = fsecInCommitQty;
		}

	@Column(name = "FApplyCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFapplyCommitQty()
		{
			return this.fapplyCommitQty;
		}

	public void setFapplyCommitQty(Double fapplyCommitQty)
		{
			this.fapplyCommitQty = fapplyCommitQty;
		}

	@Column(name = "FAuxApplyCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxApplyCommitQty()
		{
			return this.fauxApplyCommitQty;
		}

	public void setFauxApplyCommitQty(Double fauxApplyCommitQty)
		{
			this.fauxApplyCommitQty = fauxApplyCommitQty;
		}

	@Column(name = "FSecApplyCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecApplyCommitQty()
		{
			return this.fsecApplyCommitQty;
		}

	public void setFsecApplyCommitQty(Double fsecApplyCommitQty)
		{
			this.fsecApplyCommitQty = fsecApplyCommitQty;
		}

	@Column(name = "FEvaluated", nullable = false)
	public Integer getFevaluated()
		{
			return this.fevaluated;
		}

	public void setFevaluated(Integer fevaluated)
		{
			this.fevaluated = fevaluated;
		}

	@Column(name = "FPackUnitID", nullable = false)
	public Integer getFpackUnitId()
		{
			return this.fpackUnitId;
		}

	public void setFpackUnitId(Integer fpackUnitId)
		{
			this.fpackUnitId = fpackUnitId;
		}

	@Column(name = "FPackCount", nullable = false)
	public Integer getFpackCount()
		{
			return this.fpackCount;
		}

	public void setFpackCount(Integer fpackCount)
		{
			this.fpackCount = fpackCount;
		}

	@Column(name = "FPackType", nullable = false, precision = 28, scale = 10)
	public Double getFpackType()
		{
			return this.fpackType;
		}

	public void setFpackType(Double fpackType)
		{
			this.fpackType = fpackType;
		}

	@Column(name = "FMapID", nullable = false)
	public Integer getFmapId()
		{
			return this.fmapId;
		}

	public void setFmapId(Integer fmapId)
		{
			this.fmapId = fmapId;
		}

	@Column(name = "FGoodsDesc", nullable = false)
	public String getFgoodsDesc()
		{
			return this.fgoodsDesc;
		}

	public void setFgoodsDesc(String fgoodsDesc)
		{
			this.fgoodsDesc = fgoodsDesc;
		}

	@Column(name = "FAmountAfterDiscount", nullable = false, precision = 28, scale = 4)
	public Double getFamountAfterDiscount()
		{
			return this.famountAfterDiscount;
		}

	public void setFamountAfterDiscount(Double famountAfterDiscount)
		{
			this.famountAfterDiscount = famountAfterDiscount;
		}

	@Column(name = "FInformCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFinformCommitQty()
		{
			return this.finformCommitQty;
		}

	public void setFinformCommitQty(Double finformCommitQty)
		{
			this.finformCommitQty = finformCommitQty;
		}

	@Column(name = "FAuxInformCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxInformCommitQty()
		{
			return this.fauxInformCommitQty;
		}

	public void setFauxInformCommitQty(Double fauxInformCommitQty)
		{
			this.fauxInformCommitQty = fauxInformCommitQty;
		}

	@Column(name = "FSecInformCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecInformCommitQty()
		{
			return this.fsecInformCommitQty;
		}

	public void setFsecInformCommitQty(Double fsecInformCommitQty)
		{
			this.fsecInformCommitQty = fsecInformCommitQty;
		}

	@Column(name = "FPurCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFpurCommitQty()
		{
			return this.fpurCommitQty;
		}

	public void setFpurCommitQty(Double fpurCommitQty)
		{
			this.fpurCommitQty = fpurCommitQty;
		}

	@Column(name = "FAuxPurCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFauxPurCommitQty()
		{
			return this.fauxPurCommitQty;
		}

	public void setFauxPurCommitQty(Double fauxPurCommitQty)
		{
			this.fauxPurCommitQty = fauxPurCommitQty;
		}

	@Column(name = "FSecPurCommitQty", nullable = false, precision = 28, scale = 10)
	public Double getFsecPurCommitQty()
		{
			return this.fsecPurCommitQty;
		}

	public void setFsecPurCommitQty(Double fsecPurCommitQty)
		{
			this.fsecPurCommitQty = fsecPurCommitQty;
		}

	@Column(name = "FMrpAutoClosed")
	public Integer getFmrpAutoClosed()
		{
			return this.fmrpAutoClosed;
		}

	public void setFmrpAutoClosed(Integer fmrpAutoClosed)
		{
			this.fmrpAutoClosed = fmrpAutoClosed;
		}

	@Column(name = "FSecStockQty", nullable = false, precision = 23, scale = 10)
	public Double getFsecStockQty()
		{
			return this.fsecStockQty;
		}

	public void setFsecStockQty(Double fsecStockQty)
		{
			this.fsecStockQty = fsecStockQty;
		}

	@Column(name = "FSecInvoiceQty", nullable = false, precision = 23, scale = 10)
	public Double getFsecInvoiceQty()
		{
			return this.fsecInvoiceQty;
		}

	public void setFsecInvoiceQty(Double fsecInvoiceQty)
		{
			this.fsecInvoiceQty = fsecInvoiceQty;
		}

	@Column(name = "FSecCommitInstall", nullable = false, precision = 23, scale = 10)
	public Double getFsecCommitInstall()
		{
			return this.fsecCommitInstall;
		}

	public void setFsecCommitInstall(Double fsecCommitInstall)
		{
			this.fsecCommitInstall = fsecCommitInstall;
		}

	@Column(name = "FPlanMode", nullable = false)
	public Integer getFplanMode()
		{
			return this.fplanMode;
		}

	public void setFplanMode(Integer fplanMode)
		{
			this.fplanMode = fplanMode;
		}

	@Column(name = "FMTONo", nullable = false, length = 50)
	public String getFmtono()
		{
			return this.fmtono;
		}

	public void setFmtono(String fmtono)
		{
			this.fmtono = fmtono;
		}

	@Column(name = "FEntrySelfS0161", precision = 28, scale = 10)
	public Double getFentrySelfS0161()
		{
			return this.fentrySelfS0161;
		}

	public void setFentrySelfS0161(Double fentrySelfS0161)
		{
			this.fentrySelfS0161 = fentrySelfS0161;
		}

	@Column(name = "FEntrySelfS0162", precision = 28, scale = 10)
	public Double getFentrySelfS0162()
		{
			return this.fentrySelfS0162;
		}

	public void setFentrySelfS0162(Double fentrySelfS0162)
		{
			this.fentrySelfS0162 = fentrySelfS0162;
		}

	@Column(name = "FEntrySelfS0163", precision = 28, scale = 10)
	public Double getFentrySelfS0163()
		{
			return this.fentrySelfS0163;
		}

	public void setFentrySelfS0163(Double fentrySelfS0163)
		{
			this.fentrySelfS0163 = fentrySelfS0163;
		}

	@Column(name = "FEntrySelfS0164")
	public Integer getFentrySelfS0164()
		{
			return this.fentrySelfS0164;
		}

	public void setFentrySelfS0164(Integer fentrySelfS0164)
		{
			this.fentrySelfS0164 = fentrySelfS0164;
		}
	
	
	
	@Column(name = "fentrySelfS0166")
	public Double getfentrySelfS0166()
		{
			return fentrySelfS0166;
		}

	public void setfentrySelfS0166(Double fentrySelfS0166)
		{
			this.fentrySelfS0166 = fentrySelfS0166;
		}

	@Transient
    public String getDelFlag()
		{
			if(this.delFlag==null)
				this.delFlag = "0";
			 return delFlag;
		}

	public void setDelFlag(String delFlag)
		{
			this.delFlag = delFlag;
		}

@Override
public Object  clone() throws CloneNotSupportedException
		{
		return (SeOrderEntry)super.clone();  
	}
	
}