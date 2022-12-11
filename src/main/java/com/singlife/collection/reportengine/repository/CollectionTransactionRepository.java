package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.CollectionTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CollectionTransactionRepository extends
        JpaRepository<CollectionTransaction, Long>,
        JpaSpecificationExecutor<CollectionTransaction> {
}
