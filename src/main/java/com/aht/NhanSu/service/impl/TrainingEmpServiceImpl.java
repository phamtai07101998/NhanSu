package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.TrainingEmpDAO;
import com.aht.NhanSu.model.Aht_Training_Emp;
import com.aht.NhanSu.service.TrainingEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class TrainingEmpServiceImpl implements TrainingEmpService {

    @Autowired
    private TrainingEmpDAO trainingEmpDAO;

    @Override
    public List<Aht_Training_Emp> findAllTrainingEmp() {
        return trainingEmpDAO.findAll();
    }

    @Override
    public Optional<Aht_Training_Emp> findTrainingEmpById(int id) {
        return trainingEmpDAO.findById(id);
    }

    @Override
    public Aht_Training_Emp createTrainingEmp(Aht_Training_Emp ahtTrainingEmp) {
        return trainingEmpDAO.save(ahtTrainingEmp);
    }

    @Override
    public Aht_Training_Emp updateTrainingEmp(Aht_Training_Emp ahtTrainingEmp) {
        Optional<Aht_Training_Emp> findTrainingEmp = trainingEmpDAO.findById(ahtTrainingEmp.getTrainingEmpId());
        if (findTrainingEmp.isPresent()){
            Aht_Training_Emp updateTrainingEmp = findTrainingEmp.get();
            updateTrainingEmp.setTrainingEmpId(ahtTrainingEmp.getTrainingEmpId());
            updateTrainingEmp.setEmployee(ahtTrainingEmp.getEmployee());
            updateTrainingEmp.setTraining(ahtTrainingEmp.getTraining());
            updateTrainingEmp.setTrainingEmpResult(ahtTrainingEmp.getTrainingEmpResult());
            updateTrainingEmp.setTrainingEmpStatus(ahtTrainingEmp.getTrainingEmpStatus());
            return trainingEmpDAO.save(updateTrainingEmp);
        }
        return null;
    }

    @Override
    public void deleteTrainingEmp(int id) {
        trainingEmpDAO.deleteById(id);
    }

    @Override
    public List<Aht_Training_Emp> findEmpByTrainingId(int id) {
        return trainingEmpDAO.getEmpByTrainingID(id);
    }

    @Override
    public Aht_Training_Emp sameName(int trainingId, int empId) {
        return trainingEmpDAO.sameName(trainingId,empId);
    }


}
