package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Contract_Emp;
import com.aht.NhanSu.model.ContractEmpResult;
import com.aht.NhanSu.model.EmpResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractEmpDAO extends JpaRepository<Aht_Contract_Emp, Integer> {
    @Query("select NEW com.aht.NhanSu.model.ContractEmpResult(emp.empId, emp.empAddress, emp.empDob, emp.empName," +
            " emp.empPhone, emp.empSex, contract.contractType) " +
            " from Aht_Contract_Emp contractEmp left outer join contractEmp.employee emp " +
            " left outer join contractEmp.contract contract" +
            " where contract.contractType = :contractType")
    List<ContractEmpResult> findEmpByType(@Param("contractType") Integer type);

    @Query("select contractEmp from Aht_Contract_Emp contractEmp" +
            " where contractEmp.contractEmpStatus = 1" +
            " and contractEmp.employee.empType = 0")
    List<Aht_Contract_Emp> empContractExpires();

    @Query("select contractEmp from Aht_Contract_Emp contractEmp" +
            " where contractEmp.contractEmpStatus = 0" +
            " and contractEmp.employee.empType = 0")
    List<Aht_Contract_Emp> empContract();

    @Query("select contractEmp from Aht_Contract_Emp contractEmp " +
            " where contractEmp.employee.empType = 0")
    List<Aht_Contract_Emp> findAll();

    @Transactional
    @Modifying
    @Query("update Aht_Contract_Emp contractEmp set contractEmp.contractEmpStatus = 1" +
            " where contractEmp.contractEmpEndDate < :dateNow")
    void upEmp(@Param("dateNow")Date dateNow);
}
