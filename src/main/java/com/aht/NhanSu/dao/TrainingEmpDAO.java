package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Training_Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface TrainingEmpDAO extends JpaRepository<Aht_Training_Emp, Integer> {

    @Query("select trainingEmp from Aht_Training_Emp trainingEmp left outer join trainingEmp.training training" +
            " where training.trainingId = :trainingId" +
            " and trainingEmp.employee.empType = 0")
    List<Aht_Training_Emp> getEmpByTrainingID(@Param("trainingId") Integer id);

    @Query("select trainingEmp from Aht_Training_Emp trainingEmp" +
            " where trainingEmp.employee.empType = 0")
    List<Aht_Training_Emp> findAll();

    @Query("select trainingEmp from Aht_Training_Emp trainingEmp" +
            " where trainingEmp.training.trainingId = :trainingId" +
            " and trainingEmp.employee.empId = :empId")
    Aht_Training_Emp sameName(@Param("trainingId") int trainingId, @Param("empId") int empId);
}
