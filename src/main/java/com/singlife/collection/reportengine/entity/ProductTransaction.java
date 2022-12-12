package com.singlife.collection.reportengine.entity;

import com.singlife.collection.reportengine.config.Constants;
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
@Table(name = ProductTransaction.TABLE)
public class ProductTransaction {
    public static final String TABLE = Constants.TABLE_PREFIX + "product_transaction";
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "collection_trn_id")
    private int collectionTrnId;
    @Basic
    @Column(name = "prod_id")
    private String prodId;
    @Basic
    @Column(name = "prod_cd")
    private String prodCd;
    @Basic
    @Column(name = "prod_type")
    private String prodType;
    @Basic
    @Column(name = "prod_nm")
    private String prodNm;
    @Basic
    @Column(name = "pas_sys_id")
    private String pasSysId;
    @Basic
    @Column(name = "prod_category")
    private int prodCategory;
    @Basic
    @Column(name = "prod_desc")
    private String prodDesc;
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
        ProductTransaction that = (ProductTransaction) o;
        return id == that.id && collectionTrnId == that.collectionTrnId && prodCategory == that.prodCategory && version == that.version && Objects.equals(prodId, that.prodId) && Objects.equals(prodCd, that.prodCd) && Objects.equals(prodType, that.prodType) && Objects.equals(prodNm, that.prodNm) && Objects.equals(pasSysId, that.pasSysId) && Objects.equals(prodDesc, that.prodDesc) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collectionTrnId, prodId, prodCd, prodType, prodNm, pasSysId, prodCategory, prodDesc, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
