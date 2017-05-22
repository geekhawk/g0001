package com.qq.k3.seOrder.entity;
// default package
 
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * EmployeeCusReleationEntry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_BOS200000001Entry2"
    ,schema="dbo"
    ,catalog="AIS20170520090131"
)

public class EmployeeCusReleationEntry  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private TOrganization TOrganization;
     private EmployeeCusReleation employeeCusReleation;


    // Constructors

    /** default constructor */
    public EmployeeCusReleationEntry() {
    }

    
    /** full constructor */
    public EmployeeCusReleationEntry(Integer id, TOrganization TOrganization, EmployeeCusReleation employeeCusReleation) {
        this.id = id;
        this.TOrganization = TOrganization;
        this.employeeCusReleation = employeeCusReleation;
    }

   
    // Property accessors
   
@Id
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="FBase1", nullable=false, insertable=false, updatable=false)

    public TOrganization getTOrganization() {
        return this.TOrganization;
    }
    
    public void setTOrganization(TOrganization TOrganization) {
        this.TOrganization = TOrganization;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="FID", nullable=false, insertable=false, updatable=false)

    public EmployeeCusReleation getEmployeeCusReleation() {
        return this.employeeCusReleation;
    }
    
    public void setEmployeeCusReleation(EmployeeCusReleation employeeCusReleation) {
        this.employeeCusReleation = employeeCusReleation;
    }
   








}