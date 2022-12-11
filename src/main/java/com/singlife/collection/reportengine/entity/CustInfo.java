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
@Table(name = "cust_info")
public class CustInfo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "doc_id")
    private String docId;
    @Basic
    @Column(name = "doc_type")
    private String docType;
    @Basic
    @Column(name = "doc_no")
    private String docNo;
    @Basic
    @Column(name = "cust_id")
    private String custId;
    @Basic
    @Column(name = "cust_cd")
    private String custCd;
    @Basic
    @Column(name = "cust_nm")
    private String custNm;
    @Basic
    @Column(name = "payer_nm")
    private String payerNm;
    @Basic
    @Column(name = "first_nm")
    private String firstNm;
    @Basic
    @Column(name = "last_nm")
    private String lastNm;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic
    @Column(name = "email_id")
    private String emailId;
    @Basic
    @Column(name = "mobile_device_type")
    private String mobileDeviceType;
    @Basic
    @Column(name = "org_nm")
    private String orgNm;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state_provience_cd")
    private String stateProvienceCd;
    @Basic
    @Column(name = "postal_cd")
    private String postalCd;
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
        CustInfo custInfo = (CustInfo) o;
        return id == custInfo.id && version == custInfo.version && Objects.equals(docId, custInfo.docId) && Objects.equals(docType, custInfo.docType) && Objects.equals(docNo, custInfo.docNo) && Objects.equals(custId, custInfo.custId) && Objects.equals(custCd, custInfo.custCd) && Objects.equals(custNm, custInfo.custNm) && Objects.equals(payerNm, custInfo.payerNm) && Objects.equals(firstNm, custInfo.firstNm) && Objects.equals(lastNm, custInfo.lastNm) && Objects.equals(address, custInfo.address) && Objects.equals(mobileNo, custInfo.mobileNo) && Objects.equals(emailId, custInfo.emailId) && Objects.equals(mobileDeviceType, custInfo.mobileDeviceType) && Objects.equals(orgNm, custInfo.orgNm) && Objects.equals(city, custInfo.city) && Objects.equals(stateProvienceCd, custInfo.stateProvienceCd) && Objects.equals(postalCd, custInfo.postalCd) && Objects.equals(createdDt, custInfo.createdDt) && Objects.equals(createdBy, custInfo.createdBy) && Objects.equals(updatedDt, custInfo.updatedDt) && Objects.equals(updatedBy, custInfo.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, docId, docType, docNo, custId, custCd, custNm, payerNm, firstNm, lastNm, address, mobileNo, emailId, mobileDeviceType, orgNm, city, stateProvienceCd, postalCd, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
