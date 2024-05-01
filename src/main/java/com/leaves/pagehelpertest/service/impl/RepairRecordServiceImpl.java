package com.leaves.pagehelpertest.service.impl;

import com.leaves.pagehelpertest.dao.RepairRecordDao;
import com.leaves.pagehelpertest.model.dox.RepairRecordDo;
import com.leaves.pagehelpertest.service.RepairRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class RepairRecordServiceImpl implements RepairRecordService {

    @Autowired
    private RepairRecordDao repairRecordDao;

    @Override
    public Integer insertRepairRecord(String adder,String clientName,String phoneNumber, String location, String note) {
        LocalDateTime registerTime=LocalDateTime.now();
        return repairRecordDao.insertRepairRecord(Integer.parseInt(adder),clientName,phoneNumber, registerTime, location, note);
    }

    @Override
    public RepairRecordDo  selectRepairByUserId(String userId){
        return repairRecordDao.selectRepairByUserId(Integer.parseInt(userId));
    }

    @Override
    public List<RepairRecordDo> selectFinishRepairByUserId(String userId) {
        return repairRecordDao.selectFinishRepairByUserId(userId);
    }

    @Override
    public List<RepairRecordDo> selectFinishRecords() {
        return repairRecordDao.selectFinishRecords();
    }

    @Override
    public List<RepairRecordDo> selectUNfinishRecords() {
        return repairRecordDao.selectUNfinishRecords();
    }

    @Override
    public Integer updateStatus(String recordId, String reporter,String solution) {
        String status="yes";
        LocalDateTime finishTime=LocalDateTime.now();
        return repairRecordDao.updateStatus(Integer.parseInt(recordId),status, finishTime, Integer.parseInt(reporter),solution);
    }

    @Override
    public Integer modifyByRecordId(String recordId, String location, String clientName, String phoneNumber, String note, String solution) {
        return repairRecordDao.modifyByRecordId(recordId,location,clientName,phoneNumber,note,solution);
    }

    @Override
    public Integer updateStatusByUserId(String userId,String recordId,String status, LocalDateTime finishTime, String reporter) {
        return repairRecordDao.updateStatusByUserId(Integer.parseInt(userId),Integer.parseInt(recordId),status, finishTime, Integer.parseInt(reporter));
    }

    @Override
    public Integer deleteRecordByUserId(String recordId) {
        return repairRecordDao.deleteRecordByRecordId(Integer.parseInt(recordId));
    }
}
