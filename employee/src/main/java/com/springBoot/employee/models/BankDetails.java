package com.springBoot.employee.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BankDetails {

    private String accountNo;
    private String ifsc;
    private String branchName;
    private String upi;
}
