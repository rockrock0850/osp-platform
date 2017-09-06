package com.fet.crm.osp.platform.core.db.model;
// Generated 2017/2/24 �U�� 01:10:48 by Hibernate Tools 4.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SysFlowReasonMap generated by hbm2java
 */
@Entity
@Table(name="SYS_FLOW_REASON_MAP")
public class SysFlowReasonMap  implements java.io.Serializable {


     private String reasonMapId;
     private String flowId;
     private String orderStatus;
     private String reasonId;
     private String reasonName;
     private String reasonType;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;

    public SysFlowReasonMap() {
    }

	
    public SysFlowReasonMap(String reasonMapId, String flowId, String orderStatus, String reasonId, String reasonName, String reasonType, Date createDate, String createUser) {
        this.reasonMapId = reasonMapId;
        this.flowId = flowId;
        this.orderStatus = orderStatus;
        this.reasonId = reasonId;
        this.reasonName = reasonName;
        this.reasonType = reasonType;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    public SysFlowReasonMap(String reasonMapId, String flowId, String orderStatus, String reasonId, String reasonName, String reasonType, Date createDate, String createUser, Date updateDate, String updateUser) {
       this.reasonMapId = reasonMapId;
       this.flowId = flowId;
       this.orderStatus = orderStatus;
       this.reasonId = reasonId;
       this.reasonName = reasonName;
       this.reasonType = reasonType;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
    }
   
     @Id 

    
    @Column(name="REASON_MAP_ID", unique=true, nullable=false, length=36)
    public String getReasonMapId() {
        return this.reasonMapId;
    }
    
    public void setReasonMapId(String reasonMapId) {
        this.reasonMapId = reasonMapId;
    }

    
    @Column(name="FLOW_ID", nullable=false, length=40)
    public String getFlowId() {
        return this.flowId;
    }
    
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    
    @Column(name="ORDER_STATUS", nullable=false, length=5)
    public String getOrderStatus() {
        return this.orderStatus;
    }
    
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    
    @Column(name="REASON_ID", nullable=false, length=20)
    public String getReasonId() {
        return this.reasonId;
    }
    
    public void setReasonId(String reasonId) {
        this.reasonId = reasonId;
    }

    
    @Column(name="REASON_NAME", nullable=false, length=100)
    public String getReasonName() {
        return this.reasonName;
    }
    
    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    
    @Column(name="REASON_TYPE", nullable=false, length=20)
    public String getReasonType() {
        return this.reasonType;
    }
    
    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
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




}

