package com.leaves.pagehelpertest.service;

import com.leaves.pagehelpertest.model.dox.RepairRecordDo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


public interface RepairRecordService {
    public Integer insertRepairRecord(String adder,String clientName,String phoneNumber, String location, String note);

    public List<RepairRecordDo>selectFinishRecords();
    public List<RepairRecordDo>selectUNfinishRecords();

    public RepairRecordDo selectRepairByUserId(String UserId);

    public List<RepairRecordDo> selectFinishRepairByUserId(String UserId);

    public Integer updateStatus(String recordId,String reporter,String solution);

    public Integer modifyByRecordId(String recordId,String location,String clientName,String phoneNumber,String note,String solution);

    public Integer updateStatusByUserId(String userId,String recordId,String status, LocalDateTime finishTime, String reporter);
    public Integer deleteRecordByUserId(String recordId);
}
