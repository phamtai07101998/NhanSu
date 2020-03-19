package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContractEmpResult {
    private int empId;

    private String empAddress;

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date empDob;

    private String empName;

    private String empPhone;

    private int empSex;

    private int contractType;
}
