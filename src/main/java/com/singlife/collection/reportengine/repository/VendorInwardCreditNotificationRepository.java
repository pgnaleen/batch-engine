package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.VendorInwardCreditNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VendorInwardCreditNotificationRepository extends
        JpaRepository<VendorInwardCreditNotification, Long>,
        JpaSpecificationExecutor<VendorInwardCreditNotification> {
}
