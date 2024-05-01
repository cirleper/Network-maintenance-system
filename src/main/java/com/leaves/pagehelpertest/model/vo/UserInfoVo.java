package com.leaves.pagehelpertest.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVo {
    private Integer id;
    private String userName;
    private String coded;
    private String gid;
}
