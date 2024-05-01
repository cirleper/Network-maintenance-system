package com.leaves.pagehelpertest.model.dox;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBindingAccountDo {
    private Integer id;
    private Integer userId;
    private String mailAccount;
    private String phoneNumber;
}
