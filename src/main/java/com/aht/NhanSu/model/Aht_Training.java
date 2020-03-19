package com.aht.NhanSu.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "aht_training")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aht_Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainingId;

    @Column(name = "training_code")
    private String trainingCode;

    @Column(name = "training_name")
    private String trainingName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "training_start_date")
    private Date trainingStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "training_start_end")
    private Date trainingStartEnd;

    @Column(name = "training_status")
    private int trainingStatus;

    @OneToMany(mappedBy = "training", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Aht_Training_Emp> ahtTrainingEmpList;
}
