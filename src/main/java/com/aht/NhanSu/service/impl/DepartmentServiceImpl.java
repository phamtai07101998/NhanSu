package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.DepartmentDAO;
import com.aht.NhanSu.model.Aht_Department;
import com.aht.NhanSu.model.Aht_Employee;
import com.aht.NhanSu.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public List<Aht_Department> findAllDepartment() {
        return departmentDAO.findAll();
    }

    @Override
    public Optional<Aht_Department> findById(int id) {
        return departmentDAO.findById(id);
    }

    @Override
    public Aht_Department createDepartment(Aht_Department ahtDepartment) {
        return departmentDAO.save(ahtDepartment);
    }

    @Override
    public Aht_Department updateDepartment(Aht_Department ahtDepartment) {
        Optional<Aht_Department> findDepartment = departmentDAO.findById(ahtDepartment.getDepartmentId());
        if (findDepartment.isPresent()){
            Aht_Department updateDepartment = findDepartment.get();
            updateDepartment.setDepartmentId(ahtDepartment.getDepartmentId());
            updateDepartment.setParts(ahtDepartment.getParts());
            updateDepartment.setDepartmentName(ahtDepartment.getDepartmentName());
            updateDepartment.setEmployeeList(ahtDepartment.getEmployeeList());
            return departmentDAO.save(updateDepartment);
        }
        return null;
    }

    @Override
    public void deleteDepartment(int id) {
        departmentDAO.deleteById(id);
    }
}
