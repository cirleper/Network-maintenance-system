package com.leaves.pagehelpertest.model.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RepairRecordDo {
    private Integer id;
    private Integer adder;
    LocalDateTime registerTime;
    LocalDateTime finishTime;
    String location;
    String solution;
    String note;
    String show;
    String clientName;
    String phoneNumber;
    Integer reporter;
}
