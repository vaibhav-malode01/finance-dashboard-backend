package com.finance_dashboard_backend.service;

import com.finance_dashboard_backend.entity.FinancialRecord;
import com.finance_dashboard_backend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final FinancialRecordRepository repo;

    public Map<String, Double> getSummary(){

        List<FinancialRecord> records = repo.findAll();

        double income = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("income"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        double expense = records.stream()
                .filter(r -> r.getType().equalsIgnoreCase("expense"))
                .mapToDouble(FinancialRecord::getAmount)
                .sum();

        Map<String,Double> result = new HashMap<>();
        result.put("totalIncome",income);
        result.put("totalExpense",expense);
        result.put("netBalance",income-expense);

        return result;
    }
}