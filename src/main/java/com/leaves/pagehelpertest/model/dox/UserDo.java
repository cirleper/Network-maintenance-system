package com.leaves.pagehelpertest.model.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDo {
    private Integer userId;
    private String userName;
    private String password;
    private String coded;
    private String gid;
}
