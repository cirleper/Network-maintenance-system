package com.leaves.pagehelpertest.model.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MaintainerInfoDo {
    private Integer id;
    private Integer userId;
    private Integer level;
    private String phoneNumber;
    private Integer out_in;
}
