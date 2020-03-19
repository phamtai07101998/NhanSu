package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpResult {
    private int empId;

    private String empAddress;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date empDob;

    private String empName;

    private String empNumberInsurance;

    private String empPhone;

    private int empSex;

    private int empType;

    private Aht_Department department;
}
