package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NotificationTemplateRepository extends
        JpaRepository<NotificationTemplate, Long>,
        JpaSpecificationExecutor<NotificationTemplate> {
}
