package com.qq.k3.seOrder.entity;
// default package

 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * EmployeeCusReleation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_BOS200000001"
    ,schema="dbo"
    ,catalog="AIS20170520090131"
)

public class EmployeeCusReleation  implements java.io.Serializable {


    // Fields    

     private Integer fid;
     private TBaseEmp TBaseEmp;
     private Integer fclassTypeId;
     private String fbillNo;
     private Integer fbiller;
     private List<EmployeeCusReleationEntry> employeeCusReleationEntries = new ArrayList<EmployeeCusReleationEntry>(0);


    // Constructors

    /** default constructor */
    public EmployeeCusReleation() {
    }

	/** minimal constructor */
    public EmployeeCusReleation(TBaseEmp TBaseEmp, Integer fclassTypeId, String fbillNo, Integer fbiller) {
        this.TBaseEmp = TBaseEmp;
        this.fclassTypeId = fclassTypeId;
        this.fbillNo = fbillNo;
        this.fbiller = fbiller;
    }
    
    /** full constructor */
    public EmployeeCusReleation(TBaseEmp TBaseEmp, Integer fclassTypeId, String fbillNo, Integer fbiller, List<EmployeeCusReleationEntry> employeeCusReleationEntries) {
        this.TBaseEmp = TBaseEmp;
        this.fclassTypeId = fclassTypeId;
        this.fbillNo = fbillNo;
        this.fbiller = fbiller;
        this.employeeCusReleationEntries = employeeCusReleationEntries;
    }

   
    // Property accessors
    @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="FID", unique=true, nullable=false)

    public Integer getFid() {
        return this.fid;
    }
    
    public void setFid(Integer fid) {
        this.fid = fid;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="FBase", nullable=false)

    public TBaseEmp getTBaseEmp() {
        return this.TBaseEmp;
    }
    
    public void setTBaseEmp(TBaseEmp TBaseEmp) {
        this.TBaseEmp = TBaseEmp;
    }
    
    @Column(name="FClassTypeID", nullable=false)

    public Integer getFclassTypeId() {
        return this.fclassTypeId;
    }
    
    public void setFclassTypeId(Integer fclassTypeId) {
        this.fclassTypeId = fclassTypeId;
    }
    
    @Column(name="FBillNo", nullable=false, length=30)

    public String getFbillNo() {
        return this.fbillNo;
    }
    
    public void setFbillNo(String fbillNo) {
        this.fbillNo = fbillNo;
    }
    
    @Column(name="FBiller", nullable=false)

    public Integer getFbiller() {
        return this.fbiller;
    }
    
    public void setFbiller(Integer fbiller) {
        this.fbiller = fbiller;
    }
    
    
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="employeeCusReleation")

    public List<EmployeeCusReleationEntry> getEmployeeCusReleationEntries() {
        return this.employeeCusReleationEntries;
    }
    
    public void setEmployeeCusReleationEntries(List<EmployeeCusReleationEntry> employeeCusReleationEntries) {
        this.employeeCusReleationEntries = employeeCusReleationEntries;
    }
   








}