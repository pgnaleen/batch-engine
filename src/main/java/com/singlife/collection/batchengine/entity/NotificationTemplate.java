package com.singlife.collection.batchengine.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "notification_template")
public class NotificationTemplate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "notification_id")
    private int notificationId;
    @Basic
    @Column(name = "template_id")
    private String templateId;
    @Basic
    @Column(name = "template_nm")
    private String templateNm;
    @Basic
    @Column(name = "template_type")
    private String templateType;
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
        NotificationTemplate that = (NotificationTemplate) o;
        return id == that.id && notificationId == that.notificationId && version == that.version && Objects.equals(templateId, that.templateId) && Objects.equals(templateNm, that.templateNm) && Objects.equals(templateType, that.templateType) && Objects.equals(createdDt, that.createdDt) && Objects.equals(createdBy, that.createdBy) && Objects.equals(updatedDt, that.updatedDt) && Objects.equals(updatedBy, that.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notificationId, templateId, templateNm, templateType, createdDt, createdBy, updatedDt, updatedBy, version);
    }
}
