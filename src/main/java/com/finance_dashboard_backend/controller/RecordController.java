package com.finance_dashboard_backend.controller;

import com.finance_dashboard_backend.entity.FinancialRecord;
import com.finance_dashboard_backend.service.RecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/records")
@RequiredArgsConstructor
public class RecordController {

    private final RecordService recordService;

    @PostMapping
    public FinancialRecord create(@RequestBody FinancialRecord record){
        return recordService.createRecord(record);
    }

    @GetMapping
    public List<FinancialRecord> getAll(){
        return recordService.getAllRecords();
    }

    @PutMapping("/{id}")
    public FinancialRecord update(@PathVariable Long id,
                                  @RequestBody FinancialRecord record){
        return recordService.updateRecord(id,record);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        recordService.deleteRecord(id);
    }
}




