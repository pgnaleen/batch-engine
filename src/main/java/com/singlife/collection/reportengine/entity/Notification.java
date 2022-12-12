package com.singlife.collection.reportengine.entity;

import com.singlife.collection.reportengine.config.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
//@Table(name = "notification")
public class Notification {
    public static final String TABLE = Constants.TABLE_PREFIX + "notification";
    public static final String COL_COLLECTION_TRN_ID = "collection_trn_id";
    public static final String VENDOR_INWARD_CREDIT_NOTIFICATION_ID = "vendor_inward_credit_notification_id";
    public static final String CUST_INFO_ID = "cust_info_id";
    public static final String NOTIFICATION_TEMPLATE_ID = "notification_template_id";
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = COL_COLLECTION_TRN_ID, referencedColumnName = "id")
    private CollectionTransaction collectionTrn;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = VENDOR_INWARD_CREDIT_NOTIFICATION_ID, referencedColumnName = "id")
    private VendorInwardCreditNotification vendorInwardCreditNotification;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = CUST_INFO_ID, referencedColumnName = "id")
    private CustomerInformation customerInformation;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = NOTIFICATION_TEMPLATE_ID, referencedColumnName = "id")
    private NotificationTemplate notificationTemplate;
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
        return id == that.id && collectionTrn == that.collectionTrn && vendorInwardCreditNotification == that.vendorInwardCreditNotification && customerInformation == that.customerInformation && notificationTemplate == that.notificationTemplate && version == that.version && Objects.equals(statusCd, that.statusCd) && Objects.equals(statusCdVal, that.statusCdVal) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionTrn, vendorInwardCreditNotification, customerInformation, notificationTemplate, statusCd, statusCdVal, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
