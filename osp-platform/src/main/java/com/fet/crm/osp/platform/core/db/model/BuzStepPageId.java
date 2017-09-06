package com.fet.crm.osp.platform.core.db.model;
// Generated 2017/2/24 �U�� 01:10:48 by Hibernate Tools 4.0.0


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BuzStepPageId generated by hbm2java
 */
@Embeddable
public class BuzStepPageId  implements java.io.Serializable {


     private String flowId;
     private String stepId;
     private String contentId;

    public BuzStepPageId() {
    }

    public BuzStepPageId(String flowId, String stepId, String contentId) {
       this.flowId = flowId;
       this.stepId = stepId;
       this.contentId = contentId;
    }
   


    @Column(name="FLOW_ID", nullable=false, length=40)
    public String getFlowId() {
        return this.flowId;
    }
    
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }


    @Column(name="STEP_ID", nullable=false, length=40)
    public String getStepId() {
        return this.stepId;
    }
    
    public void setStepId(String stepId) {
        this.stepId = stepId;
    }


    @Column(name="CONTENT_ID", nullable=false, length=40)
    public String getContentId() {
        return this.contentId;
    }
    
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BuzStepPageId) ) return false;
		 BuzStepPageId castOther = ( BuzStepPageId ) other; 
         
		 return ( (this.getFlowId()==castOther.getFlowId()) || ( this.getFlowId()!=null && castOther.getFlowId()!=null && this.getFlowId().equals(castOther.getFlowId()) ) )
 && ( (this.getStepId()==castOther.getStepId()) || ( this.getStepId()!=null && castOther.getStepId()!=null && this.getStepId().equals(castOther.getStepId()) ) )
 && ( (this.getContentId()==castOther.getContentId()) || ( this.getContentId()!=null && castOther.getContentId()!=null && this.getContentId().equals(castOther.getContentId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFlowId() == null ? 0 : this.getFlowId().hashCode() );
         result = 37 * result + ( getStepId() == null ? 0 : this.getStepId().hashCode() );
         result = 37 * result + ( getContentId() == null ? 0 : this.getContentId().hashCode() );
         return result;
   }   


}

