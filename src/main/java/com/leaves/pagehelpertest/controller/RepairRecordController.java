package com.leaves.pagehelpertest.controller;

import com.leaves.pagehelpertest.model.dox.RepairRecordDo;
import com.leaves.pagehelpertest.service.RepairRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/repair-records")
public class RepairRecordController {

    @Autowired
    private RepairRecordService repairRecordService;

    @PostMapping("/add")
    public Integer addRepairRecord(String adder,String clientName,String phoneNumber,String location, String note) {
        return repairRecordService.insertRepairRecord(adder,clientName,phoneNumber, location, note);
    }

    @GetMapping("/finished")
    public List<RepairRecordDo> getFinishedRepairRecords() {
        return repairRecordService.selectFinishRecords();
    }

    @GetMapping("/unfinished")
    public List<RepairRecordDo> getUnfinishedRepairRecords() {
        return repairRecordService.selectUNfinishRecords();
    }

    @GetMapping("unifinished/user-self")
    public RepairRecordDo selectUnfinishedRepairByUserId(String userId){
        System.out.println(userId);
        return repairRecordService.selectRepairByUserId(userId);
    }

    @GetMapping("finished/user-self")
    public List<RepairRecordDo> selectFinishedRepairByUserId(String userId){
        return repairRecordService.selectFinishRepairByUserId(userId);
    }

    @PutMapping("/update-status")
    public Integer updateRepairRecordStatus(String recordId,String reporter,String solution) {
        return repairRecordService.updateStatus(recordId, reporter,solution);
    }

    @PutMapping("/update-status-self")
    public Integer updateRepairRecordStatusByUserId(String userId,String recordId,String status,LocalDateTime finishTime,String reporter) {
        return repairRecordService.updateStatusByUserId(userId,recordId,status, finishTime, reporter);
    }

    @PutMapping("/modify")
    public Integer modifyByRecordId(String recordId,String location,String clientName,String phoneNumber,String note,String solution){
        System.out.println(recordId);
        return repairRecordService.modifyByRecordId(recordId,location,clientName,phoneNumber,note,solution);
    }

    @PostMapping("/delete")
    public Integer deleteRecordByReocrdId(String recordId){
        return repairRecordService.deleteRecordByUserId(recordId);
    }



}
