package com.fet.crm.osp.platform.core.db.model;
// Generated 2017/2/24 �U�� 01:10:48 by Hibernate Tools 4.0.0


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
 * SysProdTypeMap generated by hbm2java
 */
@Entity
@Table(name="SYS_PROD_TYPE_MAP")
public class SysProdTypeMap  implements java.io.Serializable {


     private SysProdTypeMapId id;
     private String sourceProdTypeName;
     private String description;
     private Date createDate;
     private String createUser;
     private Date updateDate;
     private String updateUser;

    public SysProdTypeMap() {
    }

	
    public SysProdTypeMap(SysProdTypeMapId id, String sourceProdTypeName, Date createDate, String createUser) {
        this.id = id;
        this.sourceProdTypeName = sourceProdTypeName;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    public SysProdTypeMap(SysProdTypeMapId id, String sourceProdTypeName, String description, Date createDate, String createUser, Date updateDate, String updateUser) {
       this.id = id;
       this.sourceProdTypeName = sourceProdTypeName;
       this.description = description;
       this.createDate = createDate;
       this.createUser = createUser;
       this.updateDate = updateDate;
       this.updateUser = updateUser;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="sourceSysId", column=@Column(name="SOURCE_SYS_ID", nullable=false, length=20) ), 
        @AttributeOverride(name="sourceProdTypeId", column=@Column(name="SOURCE_PROD_TYPE_ID", nullable=false, length=50) ) } )
    public SysProdTypeMapId getId() {
        return this.id;
    }
    
    public void setId(SysProdTypeMapId id) {
        this.id = id;
    }

    
    @Column(name="SOURCE_PROD_TYPE_NAME", nullable=false, length=100)
    public String getSourceProdTypeName() {
        return this.sourceProdTypeName;
    }
    
    public void setSourceProdTypeName(String sourceProdTypeName) {
        this.sourceProdTypeName = sourceProdTypeName;
    }

    
    @Column(name="DESCRIPTION", length=500)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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


