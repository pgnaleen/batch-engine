package com.singlife.collection.batchengine.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
//@Table(name = "notification")
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "collection_trn_id")
    private int collectionTrnId;
    @Basic
    @Column(name = "vendor_inward_credit_notification_id")
    private int vendorInwardCreditNotificationId;
    @Basic
    @Column(name = "cust_info_id")
    private int custInfoId;
    @Basic
    @Column(name = "notification_template_id")
    private int notificationTemplateId;
    @Basic
    @Column(name = "status_cd")
    private String statusCd;
    @Basic
    @Column(name = "status_cd_val")
    private String statusCdVal;
    @Basic
    @Column(name = "created_dt")
    private Timestamp createdDt;
    @Basic
    @Column(name = "created_by")
    private String createdBy;
    @Basic
    @Column(name = "updated_dt")
    private Timestamp updatedDt;
    @Basic
    @Column(name = "updated_by")
    private String updatedBy;
    @Basic
    @Column(name = "version")
    private int version;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return id == that.id && collectionTrnId == that.collectionTrnId && vendorInwardCreditNotificationId == that.vendorInwardCreditNotificationId && custInfoId == that.custInfoId && notificationTemplateId == that.notificationTemplateId && version == that.version && Objects.equals(statusCd, that.statusCd) && Objects.equals(statusCdVal, that.statusCdVal) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionTrnId, vendorInwardCreditNotificationId, custInfoId, notificationTemplateId, statusCd, statusCdVal, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
