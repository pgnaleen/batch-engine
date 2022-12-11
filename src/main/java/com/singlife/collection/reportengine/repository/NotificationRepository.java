package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationRepository extends
        JpaRepository<Notification, Long>,
        JpaSpecificationExecutor<Notification> {
}
