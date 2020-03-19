package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Contract_Emp;
import com.aht.NhanSu.model.Aht_Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Aht_Department> findAllDepartment();

    Optional<Aht_Department> findById(int id);

    Aht_Department createDepartment(Aht_Department ahtDepartment);

    Aht_Department updateDepartment(Aht_Department ahtDepartment);

    void deleteDepartment(int id);
}
