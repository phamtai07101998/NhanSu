package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Date;

@Entity
@Table(name = "aht_training_emp")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Training_Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainingEmpId;
    @Null
    @Column(name = "training_emp_result")
    private String trainingEmpResult;

    @Column(name = "training_emp_status")
    private int trainingEmpStatus;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Aht_Employee employee;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Aht_Training training;
}
