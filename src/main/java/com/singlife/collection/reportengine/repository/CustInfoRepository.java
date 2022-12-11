package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.CustInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustInfoRepository extends
        JpaRepository<CustInfo, Long>,
        JpaSpecificationExecutor<CustInfo> {
}
