package com.finance_dashboard_backend.service;

import com.finance_dashboard_backend.entity.FinancialRecord;
import com.finance_dashboard_backend.repository.FinancialRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {

    private final FinancialRecordRepository repository;

    public FinancialRecord createRecord(FinancialRecord record){
        return repository.save(record);
    }

    public List<FinancialRecord> getAllRecords(){
        return repository.findAll();
    }

    public FinancialRecord updateRecord(Long id, FinancialRecord record){
        FinancialRecord existing = repository.findById(id).orElseThrow();
        existing.setAmount(record.getAmount());
        existing.setCategory(record.getCategory());
        existing.setType(record.getType());
        existing.setNotes(record.getNotes());
        return repository.save(existing);
    }

    public void deleteRecord(Long id){
        repository.deleteById(id);
    }
}
