package com.singlife.collection.reportengine.repository;

import com.singlife.collection.reportengine.entity.ProductTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductTransactionRepository extends
        JpaRepository<ProductTransaction, Long>,
        JpaSpecificationExecutor<ProductTransaction> {
}
