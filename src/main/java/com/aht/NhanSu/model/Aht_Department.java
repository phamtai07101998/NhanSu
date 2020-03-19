package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aht_department")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "parts_id")
    private Aht_Parts parts;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Employee> employeeList;

}
