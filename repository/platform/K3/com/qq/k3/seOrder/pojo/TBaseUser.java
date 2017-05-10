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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT;
import com.thinkgem.jeesite.common.hibernate.persistence.EntityInterfaceHBT;

/**
 * TBaseUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_Base_User", schema = "dbo", catalog = "AIS20170502093932", uniqueConstraints = @UniqueConstraint(columnNames = "FName"))
public class TBaseUser extends BaseEntityHBT<TBaseUser>
{

	// Fields

	private Integer fuserId;
	private String fname;
	private String fsid;
	private Short fprimaryGroup;
	private String fdescription;
	private Boolean fforbidden;
	private byte[] fright;
	private Integer fempId;
	private Integer fdataVokeType;
	private Boolean fisNeedOffline;
	private Boolean frightChanged;
	private Boolean fofflineRefeshEachTime;
	private Integer fsafeMode;
	private Integer fhruser;
	private String fssousername;
	private String fscpwd;
	private String uuid;
	private String fmodifyTime;
	private Integer faccessUuid;
	private Timestamp fuinValidDate;
	private Timestamp fpwCreateDate;
	private Integer fpwValidDay;
	private Integer fauthRight;
	private Integer fuserTypeId;
	private String fportUser;
	private Set<SeOrder> seorders = new HashSet<SeOrder>(0);

	// Constructors

	/** default constructor */
	public TBaseUser()
	{
	}

	/** minimal constructor */
	public TBaseUser(String fname, Short fprimaryGroup)
	{
		this.fname = fname;
		this.fprimaryGroup = fprimaryGroup;
	}

	/** full constructor */
	public TBaseUser(String fname, String fsid, Short fprimaryGroup, String fdescription, Boolean fforbidden, byte[] fright, Integer fempId, Integer fdataVokeType,
			Boolean fisNeedOffline, Boolean frightChanged, Boolean fofflineRefeshEachTime, Integer fsafeMode, Integer fhruser, String fssousername, String fscpwd, String uuid,
			String fmodifyTime, Integer faccessUuid, Timestamp fuinValidDate, Timestamp fpwCreateDate, Integer fpwValidDay, Integer fauthRight, Integer fuserTypeId,
			String fportUser, Set<SeOrder> seorders)
	{
		this.fname = fname;
		this.fsid = fsid;
		this.fprimaryGroup = fprimaryGroup;
		this.fdescription = fdescription;
		this.fforbidden = fforbidden;
		this.fright = fright;
		this.fempId = fempId;
		this.fdataVokeType = fdataVokeType;
		this.fisNeedOffline = fisNeedOffline;
		this.frightChanged = frightChanged;
		this.fofflineRefeshEachTime = fofflineRefeshEachTime;
		this.fsafeMode = fsafeMode;
		this.fhruser = fhruser;
		this.fssousername = fssousername;
		this.fscpwd = fscpwd;
		this.uuid = uuid;
		this.fmodifyTime = fmodifyTime;
		this.faccessUuid = faccessUuid;
		this.fuinValidDate = fuinValidDate;
		this.fpwCreateDate = fpwCreateDate;
		this.fpwValidDay = fpwValidDay;
		this.fauthRight = fauthRight;
		this.fuserTypeId = fuserTypeId;
		this.fportUser = fportUser;
		this.seorders = seorders;
	}

	// Property accessors 
	@Id 
	@Column(name = "FUserID", unique = true, nullable = false)
	public Integer getFuserId()
		{
			return this.fuserId;
		}

	public void setFuserId(Integer fuserId)
		{
			this.fuserId = fuserId;
		}

	@Column(name = "FName", unique = true, nullable = false, length = 50)
	public String getFname()
		{
			return this.fname;
		}

	public void setFname(String fname)
		{
			this.fname = fname;
		}

	@Column(name = "FSID")
	public String getFsid()
		{
			return this.fsid;
		}

	public void setFsid(String fsid)
		{
			this.fsid = fsid;
		}

	@Column(name = "FPrimaryGroup", nullable = false)
	public Short getFprimaryGroup()
		{
			return this.fprimaryGroup;
		}

	public void setFprimaryGroup(Short fprimaryGroup)
		{
			this.fprimaryGroup = fprimaryGroup;
		}

	@Column(name = "FDescription")
	public String getFdescription()
		{
			return this.fdescription;
		}

	public void setFdescription(String fdescription)
		{
			this.fdescription = fdescription;
		}

	@Column(name = "FForbidden")
	public Boolean getFforbidden()
		{
			return this.fforbidden;
		}

	public void setFforbidden(Boolean fforbidden)
		{
			this.fforbidden = fforbidden;
		}

	@Lob
	@Column(name = "FRight")
	public byte[] getFright()
		{
			return this.fright;
		}

	public void setFright(byte[] fright)
		{
			this.fright = fright;
		}

	@Column(name = "FEmpID")
	public Integer getFempId()
		{
			return this.fempId;
		}

	public void setFempId(Integer fempId)
		{
			this.fempId = fempId;
		}

	@Column(name = "FDataVokeType")
	public Integer getFdataVokeType()
		{
			return this.fdataVokeType;
		}

	public void setFdataVokeType(Integer fdataVokeType)
		{
			this.fdataVokeType = fdataVokeType;
		}

	@Column(name = "FIsNeedOffline")
	public Boolean getFisNeedOffline()
		{
			return this.fisNeedOffline;
		}

	public void setFisNeedOffline(Boolean fisNeedOffline)
		{
			this.fisNeedOffline = fisNeedOffline;
		}

	@Column(name = "FRightChanged")
	public Boolean getFrightChanged()
		{
			return this.frightChanged;
		}

	public void setFrightChanged(Boolean frightChanged)
		{
			this.frightChanged = frightChanged;
		}

	@Column(name = "FOfflineRefeshEachTime")
	public Boolean getFofflineRefeshEachTime()
		{
			return this.fofflineRefeshEachTime;
		}

	public void setFofflineRefeshEachTime(Boolean fofflineRefeshEachTime)
		{
			this.fofflineRefeshEachTime = fofflineRefeshEachTime;
		}

	@Column(name = "FSafeMode")
	public Integer getFsafeMode()
		{
			return this.fsafeMode;
		}

	public void setFsafeMode(Integer fsafeMode)
		{
			this.fsafeMode = fsafeMode;
		}

	@Column(name = "FHRUser")
	public Integer getFhruser()
		{
			return this.fhruser;
		}

	public void setFhruser(Integer fhruser)
		{
			this.fhruser = fhruser;
		}

	@Column(name = "FSSOUsername")
	public String getFssousername()
		{
			return this.fssousername;
		}

	public void setFssousername(String fssousername)
		{
			this.fssousername = fssousername;
		}

	@Column(name = "FSCPwd", length = 32)
	public String getFscpwd()
		{
			return this.fscpwd;
		}

	public void setFscpwd(String fscpwd)
		{
			this.fscpwd = fscpwd;
		}

	@Column(name = "UUID", length = 36)
	public String getUuid()
		{
			return this.uuid;
		}

	public void setUuid(String uuid)
		{
			this.uuid = uuid;
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

	@Column(name = "FAccessUUID")
	public Integer getFaccessUuid()
		{
			return this.faccessUuid;
		}

	public void setFaccessUuid(Integer faccessUuid)
		{
			this.faccessUuid = faccessUuid;
		}

	@Column(name = "FUInValidDate", length = 23)
	public Timestamp getFuinValidDate()
		{
			return this.fuinValidDate;
		}

	public void setFuinValidDate(Timestamp fuinValidDate)
		{
			this.fuinValidDate = fuinValidDate;
		}

	@Column(name = "FPwCreateDate", length = 23)
	public Timestamp getFpwCreateDate()
		{
			return this.fpwCreateDate;
		}

	public void setFpwCreateDate(Timestamp fpwCreateDate)
		{
			this.fpwCreateDate = fpwCreateDate;
		}

	@Column(name = "FPwValidDay")
	public Integer getFpwValidDay()
		{
			return this.fpwValidDay;
		}

	public void setFpwValidDay(Integer fpwValidDay)
		{
			this.fpwValidDay = fpwValidDay;
		}

	@Column(name = "FAuthRight")
	public Integer getFauthRight()
		{
			return this.fauthRight;
		}

	public void setFauthRight(Integer fauthRight)
		{
			this.fauthRight = fauthRight;
		}

	@Column(name = "FUserTypeID")
	public Integer getFuserTypeId()
		{
			return this.fuserTypeId;
		}

	public void setFuserTypeId(Integer fuserTypeId)
		{
			this.fuserTypeId = fuserTypeId;
		}

	@Column(name = "FPortUser", length = 200)
	public String getFportUser()
		{
			return this.fportUser;
		}

	public void setFportUser(String fportUser)
		{
			this.fportUser = fportUser;
		}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TBaseUser")
	public Set<SeOrder> getSeorders()
		{
			return this.seorders;
		}

	public void setSeorders(Set<SeOrder> seorders)
		{
			this.seorders = seorders;
		}

}