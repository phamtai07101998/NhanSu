package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aht_contract")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int contractId;

    @Column(name = "contract_code")
    private String contractCode;

    @Column(name = "contract_type")
    private int contractType;

    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Contract_Emp> contractEmpList;

}
