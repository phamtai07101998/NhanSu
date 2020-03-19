package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Training;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingService {
    List<Aht_Training> findAllTraining();

    Optional<Aht_Training> findTrainingById(int id);

    Aht_Training createTraining(Aht_Training ahtTraining);

    Aht_Training updateTraining(Aht_Training ahtTraining);

    void deleteTraining(int id);

    void updateStatus (Date dateNow);

    List<Aht_Training> trainingExpires();
}
