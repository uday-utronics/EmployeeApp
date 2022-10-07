package com.springBoot.employee.models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {

    private String street;
    private String village;
    private String city;
    private String state;
    private String pincode;
}
