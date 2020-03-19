package com.aht.NhanSu.model;

import com.aht.NhanSu.dao.ContractEmpDAO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "aht_contract_emp")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Contract_Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contractEmpId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "contract_emp_start_date")
    private Date contractEmpStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "contract_emp_end_date")
    private Date contractEmpEndDate;

    @Column(name = "contract_emp_status")
    private int contractEmpStatus;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Aht_Employee employee;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Aht_Contract contract;
}
