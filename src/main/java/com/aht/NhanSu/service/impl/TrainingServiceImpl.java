package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.TrainingDAO;
import com.aht.NhanSu.model.Aht_Training;
import com.aht.NhanSu.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingDAO trainingDAO;

    @Override
    public List<Aht_Training> findAllTraining() {
        return trainingDAO.findAll();
    }

    @Override
    public Optional<Aht_Training> findTrainingById(int id) {
        return trainingDAO.findById(id);
    }

    @Override
    public Aht_Training createTraining(Aht_Training ahtTraining) {
        return trainingDAO.save(ahtTraining);
    }

    @Override
    public Aht_Training updateTraining(Aht_Training ahtTraining) {
        Optional<Aht_Training> findTraining = trainingDAO.findById(ahtTraining.getTrainingId());
        if (findTraining.isPresent()){
            Aht_Training updateTraining = findTraining.get();
            updateTraining.setTrainingId(ahtTraining.getTrainingId());
            updateTraining.setAhtTrainingEmpList(ahtTraining.getAhtTrainingEmpList());
            updateTraining.setTrainingCode(ahtTraining.getTrainingCode());
            updateTraining.setTrainingName(ahtTraining.getTrainingName());
            updateTraining.setTrainingStartDate(ahtTraining.getTrainingStartDate());
            updateTraining.setTrainingStartEnd(ahtTraining.getTrainingStartEnd());
            updateTraining.setTrainingStatus(ahtTraining.getTrainingStatus());
            return trainingDAO.save(updateTraining);
        }
        return null;
    }

    @Override
    public void deleteTraining(int id) {
        trainingDAO.deleteById(id);
    }

    @Override
    public void updateStatus(Date dateNow) {
        trainingDAO.upEmp(dateNow);
    }

    @Override
    public List<Aht_Training> trainingExpires() {
        return trainingDAO.trainingExpires();
    }
}
