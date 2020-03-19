package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingDAO extends JpaRepository<Aht_Training, Integer> {
    @Transactional
    @Modifying
    @Query("update Aht_Training training set training.trainingStatus = 1" +
            " where training.trainingStartEnd < :dateNow")
    void upEmp(@Param("dateNow") Date dateNow);

    @Query("select training from Aht_Training training " +
            " where training.trainingStatus = 0")
    List<Aht_Training> findAll();

    @Query("select training from Aht_Training training " +
            " where training.trainingStatus = 1")
    List<Aht_Training> trainingExpires();
}
