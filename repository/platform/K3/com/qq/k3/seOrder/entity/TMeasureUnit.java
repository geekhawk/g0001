package com.qq.k3.seOrder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.thinkgem.jeesite.common.hibernate.persistence.BaseEntityHBT;


/**
 * TMeasureUnit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_MeasureUnit"
    ,schema="dbo"
    ,catalog="AIS20170520090131"
, uniqueConstraints = {@UniqueConstraint(columnNames={"FUnitGroupID", "FName"}), @UniqueConstraint(columnNames={"FUnitGroupID", "FNumber"})}
)

public class TMeasureUnit  extends BaseEntityHBT<TMeasureUnit>  {


    // Fields    

     private Integer fmeasureUnitId;
     private Integer funitGroupId;
     private String fnumber;
     private String fauxClass;
     private String fname;
     private Integer fconversation;
     private Double fcoefficient;
     private Integer fprecision;
     private String fbrNo;
     private Integer fitemId;
     private Integer fparentId;
     private Short fdeleted;
     private String fshortNumber;
     private String foperDate;
     private Double fscale;
     private Short fstandard;
     private Short fcontrol;
     private String fmodifyTime;
     private Integer fsystemType;
     private String uuid;
     private String fnameEn;
     private String fnameEnPlu;


    // Constructors

    /** default constructor */
    public TMeasureUnit() {
    }

	/** minimal constructor */
    public TMeasureUnit(Integer funitGroupId, String fnumber, String fauxClass, String fname, Double fcoefficient, Integer fprecision, String fbrNo, Integer fitemId, Short fdeleted, Double fscale, Short fstandard, Short fcontrol, String fmodifyTime, Integer fsystemType, String uuid) {
        this.funitGroupId = funitGroupId;
        this.fnumber = fnumber;
        this.fauxClass = fauxClass;
        this.fname = fname;
        this.fcoefficient = fcoefficient;
        this.fprecision = fprecision;
        this.fbrNo = fbrNo;
        this.fitemId = fitemId;
        this.fdeleted = fdeleted;
        this.fscale = fscale;
        this.fstandard = fstandard;
        this.fcontrol = fcontrol;
        this.fmodifyTime = fmodifyTime;
        this.fsystemType = fsystemType;
        this.uuid = uuid;
    }
    
    /** full constructor */
    public TMeasureUnit(Integer funitGroupId, String fnumber, String fauxClass, String fname, Integer fconversation, Double fcoefficient, Integer fprecision, String fbrNo, Integer fitemId, Integer fparentId, Short fdeleted, String fshortNumber, String foperDate, Double fscale, Short fstandard, Short fcontrol, String fmodifyTime, Integer fsystemType, String uuid, String fnameEn, String fnameEnPlu) {
        this.funitGroupId = funitGroupId;
        this.fnumber = fnumber;
        this.fauxClass = fauxClass;
        this.fname = fname;
        this.fconversation = fconversation;
        this.fcoefficient = fcoefficient;
        this.fprecision = fprecision;
        this.fbrNo = fbrNo;
        this.fitemId = fitemId;
        this.fparentId = fparentId;
        this.fdeleted = fdeleted;
        this.fshortNumber = fshortNumber;
        this.foperDate = foperDate;
        this.fscale = fscale;
        this.fstandard = fstandard;
        this.fcontrol = fcontrol;
        this.fmodifyTime = fmodifyTime;
        this.fsystemType = fsystemType;
        this.uuid = uuid;
        this.fnameEn = fnameEn;
        this.fnameEnPlu = fnameEnPlu;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="FMeasureUnitID", unique=true, nullable=false)

    public Integer getFmeasureUnitId() {
        return this.fmeasureUnitId;
    }
    
    public void setFmeasureUnitId(Integer fmeasureUnitId) {
        this.fmeasureUnitId = fmeasureUnitId;
    }
    
    @Column(name="FUnitGroupID", nullable=false)

    public Integer getFunitGroupId() {
        return this.funitGroupId;
    }
    
    public void setFunitGroupId(Integer funitGroupId) {
        this.funitGroupId = funitGroupId;
    }
    
    @Column(name="FNumber", nullable=false, length=30)

    public String getFnumber() {
        return this.fnumber;
    }
    
    public void setFnumber(String fnumber) {
        this.fnumber = fnumber;
    }
    
    @Column(name="FAuxClass", nullable=false, length=80)

    public String getFauxClass() {
        return this.fauxClass;
    }
    
    public void setFauxClass(String fauxClass) {
        this.fauxClass = fauxClass;
    }
    
    @Column(name="FName", nullable=false, length=80)

    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    @Column(name="FConversation")

    public Integer getFconversation() {
        return this.fconversation;
    }
    
    public void setFconversation(Integer fconversation) {
        this.fconversation = fconversation;
    }
    
    @Column(name="FCoefficient", nullable=false, precision=28, scale=10)

    public Double getFcoefficient() {
        return this.fcoefficient;
    }
    
    public void setFcoefficient(Double fcoefficient) {
        this.fcoefficient = fcoefficient;
    }
    
    @Column(name="FPrecision", nullable=false)

    public Integer getFprecision() {
        return this.fprecision;
    }
    
    public void setFprecision(Integer fprecision) {
        this.fprecision = fprecision;
    }
    
    @Column(name="FBrNo", nullable=false, length=10)

    public String getFbrNo() {
        return this.fbrNo;
    }
    
    public void setFbrNo(String fbrNo) {
        this.fbrNo = fbrNo;
    }
    
    @Column(name="FItemID", nullable=false)

    public Integer getFitemId() {
        return this.fitemId;
    }
    
    public void setFitemId(Integer fitemId) {
        this.fitemId = fitemId;
    }
    
    @Column(name="FParentID")

    public Integer getFparentId() {
        return this.fparentId;
    }
    
    public void setFparentId(Integer fparentId) {
        this.fparentId = fparentId;
    }
    
    @Column(name="FDeleted", nullable=false)

    public Short getFdeleted() {
        return this.fdeleted;
    }
    
    public void setFdeleted(Short fdeleted) {
        this.fdeleted = fdeleted;
    }
    
    @Column(name="FShortNumber", length=30)

    public String getFshortNumber() {
        return this.fshortNumber;
    }
    
    public void setFshortNumber(String fshortNumber) {
        this.fshortNumber = fshortNumber;
    }
    
    @Column(name="FOperDate", length=10)

    public String getFoperDate() {
        return this.foperDate;
    }
    
    public void setFoperDate(String foperDate) {
        this.foperDate = foperDate;
    }
    
    @Column(name="FScale", nullable=false, precision=28, scale=10)

    public Double getFscale() {
        return this.fscale;
    }
    
    public void setFscale(Double fscale) {
        this.fscale = fscale;
    }
    
    @Column(name="FStandard", nullable=false)

    public Short getFstandard() {
        return this.fstandard;
    }
    
    public void setFstandard(Short fstandard) {
        this.fstandard = fstandard;
    }
    
    @Column(name="FControl", nullable=false)

    public Short getFcontrol() {
        return this.fcontrol;
    }
    
    public void setFcontrol(Short fcontrol) {
        this.fcontrol = fcontrol;
    }
    
    @Column(name="FModifyTime", nullable=false)

    public String getFmodifyTime() {
        return this.fmodifyTime;
    }
    
    public void setFmodifyTime(String fmodifyTime) {
        this.fmodifyTime = fmodifyTime;
    }
    
    @Column(name="FSystemType", nullable=false)

    public Integer getFsystemType() {
        return this.fsystemType;
    }
    
    public void setFsystemType(Integer fsystemType) {
        this.fsystemType = fsystemType;
    }
    
    @Column(name="UUID", nullable=false, length=36)

    public String getUuid() {
        return this.uuid;
    }
    
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    
    @Column(name="FNameEN")

    public String getFnameEn() {
        return this.fnameEn;
    }
    
    public void setFnameEn(String fnameEn) {
        this.fnameEn = fnameEn;
    }
    
    @Column(name="FNameEnPlu")

    public String getFnameEnPlu() {
        return this.fnameEnPlu;
    }
    
    public void setFnameEnPlu(String fnameEnPlu) {
        this.fnameEnPlu = fnameEnPlu;
    }
   








}