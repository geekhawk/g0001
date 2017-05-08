package com.qq.k3.seOrder.pojo;

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
 * TIcitemCore entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_ICItemCore", schema = "dbo", catalog = "AIS20170502093932")
public class TIcitemCore implements EntityInterfaceHBT
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
	private Set<SeorderEntry> seorderEntries = new HashSet<SeorderEntry>(0);

	// Constructors

	/** default constructor */
	public TIcitemCore()
	{
	}

	/** minimal constructor */
	public TIcitemCore(String fname)
	{
		this.fname = fname;
	}

	/** full constructor */
	public TIcitemCore(String fmodel, String fname, String fhelpCode, Short fdeleted, String fshortNumber, String fnumber, String fmodifyTime, Integer fparentId, String fbrNo,
			Integer ftopId, Short frp, Short fomortize, Short fomortizeScale, Boolean fforSale, Double fstaCost, Double forderPrice, Integer forderMethod,
			Integer fpriceFixingType, Integer fsalePriceFixingType, Double fperWastage, Integer faracctId, Short fplanPriceMethod, Short fplanClass,
			Set<SeorderEntry> seorderEntries)
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
		this.seorderEntries = seorderEntries;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TIcitemCore")
	public Set<SeorderEntry> getSeorderEntries()
		{
			return this.seorderEntries;
		}

	public void setSeorderEntries(Set<SeorderEntry> seorderEntries)
		{
			this.seorderEntries = seorderEntries;
		}

}