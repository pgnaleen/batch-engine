package com.singlife.collection.reportengine.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Basic;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "collection_transaction")
public class CollectionTransaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "requester_ref_no")
    private String requesterRefNo;
    @Basic
    @Column(name = "transaction_mode")
    private String transactionMode;
    @Basic
    @Column(name = "collection_trn_ref_no")
    private String collectionTrnRefNo;
    @Basic
    @Column(name = "expiry_dt")
    private Date expiryDt;
    @Basic
    @Column(name = "trn_amt")
    private int trnAmt;
    @Basic
    @Column(name = "requester_id")
    private String requesterId;
    @Basic
    @Column(name = "collection_status")
    private String collectionStatus;
    @Basic
    @Column(name = "vendor_trn_status")
    private String vendorTrnStatus;
    @Basic
    @Column(name = "pas_system_status")
    private String pasSystemStatus;
    @Basic
    @Column(name = "receipt_no")
    private String receiptNo;
    @Basic
    @Column(name = "receipt_amt")
    private String receiptAmt;
    @Basic
    @Column(name = "merchant_acnt_no")
    private String merchantAcntNo;
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
        CollectionTransaction that = (CollectionTransaction) o;
        return id == that.id && trnAmt == that.trnAmt && version == that.version && Objects.equals(requesterRefNo, that.requesterRefNo) && Objects.equals(transactionMode, that.transactionMode) && Objects.equals(collectionTrnRefNo, that.collectionTrnRefNo) && Objects.equals(expiryDt, that.expiryDt) && Objects.equals(requesterId, that.requesterId) && Objects.equals(collectionStatus, that.collectionStatus) && Objects.equals(vendorTrnStatus, that.vendorTrnStatus) && Objects.equals(pasSystemStatus, that.pasSystemStatus) && Objects.equals(receiptNo, that.receiptNo) && Objects.equals(receiptAmt, that.receiptAmt) && Objects.equals(merchantAcntNo, that.merchantAcntNo) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requesterRefNo, transactionMode, collectionTrnRefNo, expiryDt, trnAmt, requesterId, collectionStatus, vendorTrnStatus, pasSystemStatus, receiptNo, receiptAmt, merchantAcntNo, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
