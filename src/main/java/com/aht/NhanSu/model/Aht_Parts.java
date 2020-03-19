package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "aht_parts")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Parts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int partsId;

    @Column(name = "parts_name")
    private String partsName;

    @OneToMany(mappedBy = "parts", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Department> departmentList;
}
