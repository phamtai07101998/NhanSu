package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aht_employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_address")
    private String empAddress;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "emp_dob")
    private Date empDob;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_number_insurance")
    private String empNumberInsurance;

    @Column(name = "emp_phone")
    private String empPhone;

    @Column(name = "emp_sex")
    private int empSex;

    @Column(name = "emp_type")
    private int empType;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Aht_Department department;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Training_Emp> trainingEmpList;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Contract_Emp> contractEmpList;

    public Aht_Employee(int empId, String empAddress, Date empDob, String empName, String empNumberInsurance, String empPhone, int empSex, int empType, Aht_Department department) {
        this.empId = empId;
        this.empAddress = empAddress;
        this.empDob = empDob;
        this.empName = empName;
        this.empNumberInsurance = empNumberInsurance;
        this.empPhone = empPhone;
        this.empSex = empSex;
        this.empType = empType;
        this.department = department;
    }
}
