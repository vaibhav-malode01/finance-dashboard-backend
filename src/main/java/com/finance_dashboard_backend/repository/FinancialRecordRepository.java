package com.finance_dashboard_backend.repository;

import com.finance_dashboard_backend.entity.FinancialRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialRecordRepository
        extends JpaRepository<FinancialRecord, Long> {

    List<FinancialRecord> findByType(String type);

    List<FinancialRecord> findByCategory(String category);
}