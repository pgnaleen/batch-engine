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
import java.sql.Timestamp;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vendor_inward_credit_notification")
public class VendorInwardCreditNotification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "collection_trn_id")
    private int collectionTrnId;
    @Basic
    @Column(name = "msg_id")
    private String msgId;
    @Basic
    @Column(name = "org_id")
    private String orgId;
    @Basic
    @Column(name = "time_stamp")
    private Timestamp timeStamp;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "trn_type")
    private String trnType;
    @Basic
    @Column(name = "customer_Ref")
    private String customerRef;
    @Basic
    @Column(name = "trn_refid")
    private String trnRefid;
    @Basic
    @Column(name = "trn_dt")
    private Timestamp trnDt;
    @Basic
    @Column(name = "value_dt")
    private Timestamp valueDt;
    @Basic
    @Column(name = "receiver_nm")
    private String receiverNm;
    @Basic
    @Column(name = "receiver_account_no")
    private String receiverAccountNo;
    @Basic
    @Column(name = "receiver_virtual_account_no")
    private String receiverVirtualAccountNo;
    @Basic
    @Column(name = "receiver_virtual_account_nm")
    private String receiverVirtualAccountNm;
    @Basic
    @Column(name = "receiver_proxy_type")
    private String receiverProxyType;
    @Basic
    @Column(name = "receiver_proxy_value")
    private String receiverProxyValue;
    @Basic
    @Column(name = "trn_ccy")
    private String trnCcy;
    @Basic
    @Column(name = "trn_amt")
    private int trnAmt;
    @Basic
    @Column(name = "sender_nm")
    private String senderNm;
    @Basic
    @Column(name = "sender_account_no")
    private String senderAccountNo;
    @Basic
    @Column(name = "sender_bank_id")
    private String senderBankId;
    @Basic
    @Column(name = "sender_bank_nm")
    private String senderBankNm;
    @Basic
    @Column(name = "sender_bank_cd")
    private String senderBankCd;
    @Basic
    @Column(name = "sender_branch_cd")
    private String senderBranchCd;
    @Basic
    @Column(name = "payment_details")
    private String paymentDetails;
    @Basic
    @Column(name = "addtl_info")
    private String addtlInfo;
    @Basic
    @Column(name = "purpose_cd")
    private String purposeCd;
    @Basic
    @Column(name = "bill_no")
    private String billNo;
    @Basic
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic
    @Column(name = "store_lbl")
    private String storeLbl;
    @Basic
    @Column(name = "loyalty_no")
    private String loyaltyNo;
    @Basic
    @Column(name = "ref_lbl")
    private String refLbl;
    @Basic
    @Column(name = "cust_lbl")
    private String custLbl;
    @Basic
    @Column(name = "teriminal_lbl")
    private String teriminalLbl;
    @Basic
    @Column(name = "purp_trn")
    private Long purpTrn;
    @Basic
    @Column(name = "addtl_con_data")
    private String addtlConData;
    @Basic
    @Column(name = "proprietary_data")
    private String proprietaryData;
    @Basic
    @Column(name = "merchant_pan")
    private int merchantPan;
    @Basic
    @Column(name = "convenience_fee")
    private int convenienceFee;
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
        VendorInwardCreditNotification that = (VendorInwardCreditNotification) o;
        return id == that.id && collectionTrnId == that.collectionTrnId && trnAmt == that.trnAmt && merchantPan == that.merchantPan && convenienceFee == that.convenienceFee && version == that.version && Objects.equals(msgId, that.msgId) && Objects.equals(orgId, that.orgId) && Objects.equals(timeStamp, that.timeStamp) && Objects.equals(country, that.country) && Objects.equals(trnType, that.trnType) && Objects.equals(customerRef, that.customerRef) && Objects.equals(trnRefid, that.trnRefid) && Objects.equals(trnDt, that.trnDt) && Objects.equals(valueDt, that.valueDt) && Objects.equals(receiverNm, that.receiverNm) && Objects.equals(receiverAccountNo, that.receiverAccountNo) && Objects.equals(receiverVirtualAccountNo, that.receiverVirtualAccountNo) && Objects.equals(receiverVirtualAccountNm, that.receiverVirtualAccountNm) && Objects.equals(receiverProxyType, that.receiverProxyType) && Objects.equals(receiverProxyValue, that.receiverProxyValue) && Objects.equals(trnCcy, that.trnCcy) && Objects.equals(senderNm, that.senderNm) && Objects.equals(senderAccountNo, that.senderAccountNo) && Objects.equals(senderBankId, that.senderBankId) && Objects.equals(senderBankNm, that.senderBankNm) && Objects.equals(senderBankCd, that.senderBankCd) && Objects.equals(senderBranchCd, that.senderBranchCd) && Objects.equals(paymentDetails, that.paymentDetails) && Objects.equals(addtlInfo, that.addtlInfo) && Objects.equals(purposeCd, that.purposeCd) && Objects.equals(billNo, that.billNo) && Objects.equals(mobileNo, that.mobileNo) && Objects.equals(storeLbl, that.storeLbl) && Objects.equals(loyaltyNo, that.loyaltyNo) && Objects.equals(refLbl, that.refLbl) && Objects.equals(custLbl, that.custLbl) && Objects.equals(teriminalLbl, that.teriminalLbl) && Objects.equals(purpTrn, that.purpTrn) && Objects.equals(addtlConData, that.addtlConData) && Objects.equals(proprietaryData, that.proprietaryData) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionTrnId, msgId, orgId, timeStamp, country, trnType, customerRef, trnRefid, trnDt, valueDt, receiverNm, receiverAccountNo, receiverVirtualAccountNo, receiverVirtualAccountNm, receiverProxyType, receiverProxyValue, trnCcy, trnAmt, senderNm, senderAccountNo, senderBankId, senderBankNm, senderBankCd, senderBranchCd, paymentDetails, addtlInfo, purposeCd, billNo, mobileNo, storeLbl, loyaltyNo, refLbl, custLbl, teriminalLbl, purpTrn, addtlConData, proprietaryData, merchantPan, convenienceFee, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
