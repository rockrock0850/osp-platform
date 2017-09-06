package com.fet.crm.osp.platform.core.db.model;
// Generated 2017/4/19 �W�� 01:21:01 by Hibernate Tools 4.0.0


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BuzContentItemMap generated by hbm2java
 */
@Entity
@Table(name="BUZ_CONTENT_ITEM_MAP")
public class BuzContentItemMap  implements java.io.Serializable {


     private BuzContentItemMapId id;
     private BigDecimal sortSequence;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;
     private String unit;
     private String remark;

    public BuzContentItemMap() {
    }

	
    public BuzContentItemMap(BuzContentItemMapId id, BigDecimal sortSequence, Date createDate, String createUser) {
        this.id = id;
        this.sortSequence = sortSequence;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    public BuzContentItemMap(BuzContentItemMapId id, BigDecimal sortSequence, Date createDate, String createUser, Date updateDate, String updateUser, String unit, String remark) {
       this.id = id;
       this.sortSequence = sortSequence;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
       this.unit = unit;
       this.remark = remark;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="contentId", column=@Column(name="CONTENT_ID", nullable=false, length=20) ), 
        @AttributeOverride(name="itemId", column=@Column(name="ITEM_ID", nullable=false, length=20) ) } )
    public BuzContentItemMapId getId() {
        return this.id;
    }
    
    public void setId(BuzContentItemMapId id) {
        this.id = id;
    }

    
    @Column(name="SORT_SEQUENCE", nullable=false, precision=4, scale=1)
    public BigDecimal getSortSequence() {
        return this.sortSequence;
    }
    
    public void setSortSequence(BigDecimal sortSequence) {
        this.sortSequence = sortSequence;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE", nullable=false, length=7)
    public Date getCreateDate() {
        return this.createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    
    @Column(name="CREATE_USER", nullable=false, length=20)
    public String getCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATE_DATE", length=7)
    public Date getUpdateDate() {
        return this.updateDate;
    }
    
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    
    @Column(name="UPDATE_USER", length=20)
    public String getUpdateUser() {
        return this.updateUser;
    }
    
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    
    @Column(name="UNIT", length=10)
    public String getUnit() {
        return this.unit;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    
    @Column(name="REMARK", length=500)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }




}

