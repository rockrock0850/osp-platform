package com.fet.crm.osp.platform.core.db.model;
// Generated 2017/5/17 下午 05:01:10 by Hibernate Tools 4.0.0


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderImageSetting generated by hbm2java
 */
@Entity
@Table(name="ORDER_IMAGE_SETTING")
public class OrderImageSetting  implements java.io.Serializable {


     private String sourceSysId;
     private String linkType;
     private String link;
     private String parameter;
     private Date createDate;
     private String createUser;
     private String browser;
     private String encryptionMethod;
     private String encryptionKey;

    public OrderImageSetting() {
    }

	
    public OrderImageSetting(String sourceSysId, String linkType, Date createDate, String createUser) {
        this.sourceSysId = sourceSysId;
        this.linkType = linkType;
        this.createDate = createDate;
        this.createUser = createUser;
    }
    public OrderImageSetting(String sourceSysId, String linkType, String link, String parameter, Date createDate, String createUser, String browser, String encryptionMethod, String encryptionKey) {
       this.sourceSysId = sourceSysId;
       this.linkType = linkType;
       this.link = link;
       this.parameter = parameter;
       this.createDate = createDate;
       this.createUser = createUser;
       this.browser = browser;
       this.encryptionMethod = encryptionMethod;
       this.encryptionKey = encryptionKey;
    }
   
     @Id 

    
    @Column(name="SOURCE_SYS_ID", unique=true, nullable=false, length=20)
    public String getSourceSysId() {
        return this.sourceSysId;
    }
    
    public void setSourceSysId(String sourceSysId) {
        this.sourceSysId = sourceSysId;
    }

    
    @Column(name="LINK_TYPE", nullable=false, length=20)
    public String getLinkType() {
        return this.linkType;
    }
    
    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    
    @Column(name="LINK", length=200)
    public String getLink() {
        return this.link;
    }
    
    public void setLink(String link) {
        this.link = link;
    }

    
    @Column(name="PARAMETER", length=200)
    public String getParameter() {
        return this.parameter;
    }
    
    public void setParameter(String parameter) {
        this.parameter = parameter;
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

    
    @Column(name="BROWSER", length=20)
    public String getBrowser() {
        return this.browser;
    }
    
    public void setBrowser(String browser) {
        this.browser = browser;
    }

    
    @Column(name="ENCRYPTION_METHOD", length=20)
    public String getEncryptionMethod() {
        return this.encryptionMethod;
    }
    
    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    
    @Column(name="ENCRYPTION_KEY", length=50)
    public String getEncryptionKey() {
        return this.encryptionKey;
    }
    
    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }




}


