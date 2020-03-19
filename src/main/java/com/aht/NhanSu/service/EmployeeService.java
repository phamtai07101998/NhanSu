package com.aht.NhanSu.service;

import com.aht.NhanSu.model.*;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Aht_Employee> findAllEmployee();

    Optional<Aht_Employee> findEmployeeById(int idEmployee);

    Aht_Employee createEmployee(Aht_Employee ahtEmployee);

    Aht_Employee updateEmployee(Aht_Employee ahtEmployee);

    void deleteEmployee(int idEmployee);

    List<ContractEmpResult> findEmpByTypeContract(int typeContract);

    List<Aht_Employee> findEmpByDepartment(int partsId,int departId);

    List<Aht_Contract_Emp> findEmpByStatustContract();

    List<Aht_Contract_Emp> empContract();


}
