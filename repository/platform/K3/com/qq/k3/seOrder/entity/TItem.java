package com.qq.k3.seOrder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT;

/**
 * TItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_Item", schema = "dbo", catalog = "AIS20170502093932", uniqueConstraints = @UniqueConstraint(columnNames =
{ "FItemClassID", "FNumber" }))
public class TItem extends BaseEntityHBT<TItem>
{

	// Fields 
	private static final long serialVersionUID = 1L;
	private Integer fitemId; 
	private Integer fparentId;
	private Integer fItemClassID;
	private Integer fexternId;
	private String fnumber;
	private Short flevel;
	private Boolean fdetail;
	private String fname;
	private Boolean funUsed;
	private String fbrNo;
	private String ffullNumber;
	private Boolean fdiff;
	private Short fdeleted;
	private String fshortNumber;
	private String ffullName;
	private String uuid;
	private Integer fgrcommonId;
	private Integer fsystemType;
	private Integer fuseSign;
	private Short fchkUserId;
	private Short faccessory;
	private Integer fgrControl;
	private String fmodifyTime;  

	// Constructors

	/** default constructor */
	public TItem()
	{
	}

	/** minimal constructor */
	public TItem( Integer fparentId, Integer fItemClassID,Integer fexternId, String fnumber, Short flevel, Boolean fdetail, String fname, String fbrNo, String ffullNumber,
			Boolean fdiff, Short fdeleted, String uuid, Integer fgrcommonId, Integer fsystemType, Integer fuseSign, Short faccessory, Integer fgrControl, String fmodifyTime)
	{ 
		this.fparentId = fparentId;
		this.fItemClassID=fItemClassID;
		this.fexternId = fexternId;
		this.fnumber = fnumber;
		this.flevel = flevel;
		this.fdetail = fdetail;
		this.fname = fname;
		this.fbrNo = fbrNo;
		this.ffullNumber = ffullNumber;
		this.fdiff = fdiff;
		this.fdeleted = fdeleted;
		this.uuid = uuid;
		this.fgrcommonId = fgrcommonId;
		this.fsystemType = fsystemType;
		this.fuseSign = fuseSign;
		this.faccessory = faccessory;
		this.fgrControl = fgrControl;
		this.fmodifyTime = fmodifyTime;
	}

	/** full constructor */
	public TItem(  Integer fparentId, Integer fItemClassID, Integer fexternId, String fnumber, Short flevel, Boolean fdetail, String fname, Boolean funUsed, String fbrNo,
			String ffullNumber, Boolean fdiff, Short fdeleted, String fshortNumber, String ffullName, String uuid, Integer fgrcommonId, Integer fsystemType, Integer fuseSign,
			Short fchkUserId, Short faccessory, Integer fgrControl, String fmodifyTime   )
	{
		 
		this.fparentId = fparentId;
		this.fItemClassID=fItemClassID;
		this.fexternId = fexternId;
		this.fnumber = fnumber;
		this.flevel = flevel;
		this.fdetail = fdetail;
		this.fname = fname;
		this.funUsed = funUsed;
		this.fbrNo = fbrNo;
		this.ffullNumber = ffullNumber;
		this.fdiff = fdiff;
		this.fdeleted = fdeleted;
		this.fshortNumber = fshortNumber;
		this.ffullName = ffullName;
		this.uuid = uuid;
		this.fgrcommonId = fgrcommonId;
		this.fsystemType = fsystemType;
		this.fuseSign = fuseSign;
		this.fchkUserId = fchkUserId;
		this.faccessory = faccessory;
		this.fgrControl = fgrControl;
		this.fmodifyTime = fmodifyTime; 
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
 
 
	@JoinColumn(name = "FParentID", nullable = false)
	public Integer getFparentId()
		{
			return fparentId;
		}

	public void setFparentId(Integer fparentId)
		{
			this.fparentId = fparentId;
		}

	
	
	@Column(name = "FItemClassID", nullable = false)
	public Integer getfItemClassID()
		{
			return fItemClassID;
		}
    public void setfItemClassID(Integer fItemClassID)
		{
			this.fItemClassID = fItemClassID;
		}

	
	@Column(name = "FExternID", nullable = false)
	public Integer getFexternId()
		{
			return this.fexternId;
		}

	public void setFexternId(Integer fexternId)
		{
			this.fexternId = fexternId;
		}

	@Column(name = "FNumber", nullable = false, length = 80)
	public String getFnumber()
		{
			return this.fnumber;
		}

	public void setFnumber(String fnumber)
		{
			this.fnumber = fnumber;
		}

	@Column(name = "FLevel", nullable = false)
	public Short getFlevel()
		{
			return this.flevel;
		}

	public void setFlevel(Short flevel)
		{
			this.flevel = flevel;
		}

	@Column(name = "FDetail", nullable = false)
	public Boolean getFdetail()
		{
			return this.fdetail;
		}

	public void setFdetail(Boolean fdetail)
		{
			this.fdetail = fdetail;
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

	@Column(name = "FUnUsed")
	public Boolean getFunUsed()
		{
			return this.funUsed;
		}

	public void setFunUsed(Boolean funUsed)
		{
			this.funUsed = funUsed;
		}

	@Column(name = "FBrNo", nullable = false, length = 10)
	public String getFbrNo()
		{
			return this.fbrNo;
		}

	public void setFbrNo(String fbrNo)
		{
			this.fbrNo = fbrNo;
		}

	@Column(name = "FFullNumber", nullable = false, length = 80)
	public String getFfullNumber()
		{
			return this.ffullNumber;
		}

	public void setFfullNumber(String ffullNumber)
		{
			this.ffullNumber = ffullNumber;
		}

	@Column(name = "FDiff", nullable = false)
	public Boolean getFdiff()
		{
			return this.fdiff;
		}

	public void setFdiff(Boolean fdiff)
		{
			this.fdiff = fdiff;
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

	@Column(name = "FFullName", length = 250)
	public String getFfullName()
		{
			return this.ffullName;
		}

	public void setFfullName(String ffullName)
		{
			this.ffullName = ffullName;
		}

	@Column(name = "UUID", nullable = false, length = 36)
	public String getUuid()
		{
			return this.uuid;
		}

	public void setUuid(String uuid)
		{
			this.uuid = uuid;
		}

	@Column(name = "FGRCommonID", nullable = false)
	public Integer getFgrcommonId()
		{
			return this.fgrcommonId;
		}

	public void setFgrcommonId(Integer fgrcommonId)
		{
			this.fgrcommonId = fgrcommonId;
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

	@Column(name = "FUseSign", nullable = false)
	public Integer getFuseSign()
		{
			return this.fuseSign;
		}

	public void setFuseSign(Integer fuseSign)
		{
			this.fuseSign = fuseSign;
		}

	@Column(name = "FChkUserID")
	public Short getFchkUserId()
		{
			return this.fchkUserId;
		}

	public void setFchkUserId(Short fchkUserId)
		{
			this.fchkUserId = fchkUserId;
		}

	@Column(name = "FAccessory", nullable = false)
	public Short getFaccessory()
		{
			return this.faccessory;
		}

	public void setFaccessory(Short faccessory)
		{
			this.faccessory = faccessory;
		}

	@Column(name = "FGrControl", nullable = false)
	public Integer getFgrControl()
		{
			return this.fgrControl;
		}

	public void setFgrControl(Integer fgrControl)
		{
			this.fgrControl = fgrControl;
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
 

}