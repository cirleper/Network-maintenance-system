package com.leaves.pagehelpertest.dao;

import com.leaves.pagehelpertest.model.dox.RepairRecordDo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface RepairRecordDao {

    RepairRecordDo selectRepairByUserId(Integer userId);

    List<RepairRecordDo> selectFinishRecords();

    List<RepairRecordDo>selectUNfinishRecords();
    Integer insertRepairRecord(Integer adder, String clientName,String phoneNumber,LocalDateTime registerTime,String location,String note);
    Integer updateStatus(Integer recordId,String status,LocalDateTime finishTime,Integer reporter,String solution);

    Integer modifyByRecordId(String recordId,String location,String clientName,String phoneNumber,String note,String solution);
    Integer updateStatusByUserId(Integer userId,Integer recordId,String status,LocalDateTime finishTime,Integer reporter);
    Integer deleteRecordByRecordId(Integer recordId);

    List<RepairRecordDo> selectFinishRepairByUserId(String userId);
}
