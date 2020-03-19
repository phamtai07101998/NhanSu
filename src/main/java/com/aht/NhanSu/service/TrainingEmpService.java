package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Training_Emp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingEmpService {
    List<Aht_Training_Emp> findAllTrainingEmp();

    Optional<Aht_Training_Emp> findTrainingEmpById(int id);

    Aht_Training_Emp createTrainingEmp(Aht_Training_Emp ahtTrainingEmp);

    Aht_Training_Emp updateTrainingEmp(Aht_Training_Emp ahtTrainingEmp);

    void deleteTrainingEmp(int id);

    List<Aht_Training_Emp> findEmpByTrainingId(int id);

    Aht_Training_Emp sameName(int trainingId, int empId);
}
