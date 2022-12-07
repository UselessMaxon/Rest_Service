package org.ibs.service.dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Employee {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Integer monthSalary;
    private Long boss;
}
