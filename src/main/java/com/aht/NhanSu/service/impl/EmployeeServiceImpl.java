package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.ContractEmpDAO;
import com.aht.NhanSu.dao.EmployeeDAO;
import com.aht.NhanSu.dao.TrainingEmpDAO;
import com.aht.NhanSu.model.*;
import com.aht.NhanSu.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private ContractEmpDAO contractEmpDAO;

    @Autowired
    private TrainingEmpDAO trainingEmpDAO;

    @Override
    public List<Aht_Employee> findAllEmployee() {
        return employeeDAO.findAll();
    }

    @Override
    public Optional<Aht_Employee> findEmployeeById(int idEmployee) {
        return employeeDAO.findById(idEmployee);
    }

    @Override
    public Aht_Employee createEmployee(Aht_Employee ahtEmployee) {
        return employeeDAO.save(ahtEmployee);
    }

    @Override
    public Aht_Employee updateEmployee(Aht_Employee ahtEmployee) {
        Optional<Aht_Employee> findEmployee = employeeDAO.findById(ahtEmployee.getEmpId());
        if (findEmployee.isPresent()){
            Aht_Employee updateEmployee = findEmployee.get();
            updateEmployee.setEmpId(ahtEmployee.getEmpId());
            updateEmployee.setDepartment(ahtEmployee.getDepartment());
            updateEmployee.setContractEmpList(ahtEmployee.getContractEmpList());
            updateEmployee.setEmpAddress(ahtEmployee.getEmpAddress());
            updateEmployee.setEmpDob(ahtEmployee.getEmpDob());
            updateEmployee.setEmpName(ahtEmployee.getEmpName());
            updateEmployee.setEmpNumberInsurance(ahtEmployee.getEmpNumberInsurance());
            updateEmployee.setEmpPhone(ahtEmployee.getEmpPhone());
            updateEmployee.setEmpSex(ahtEmployee.getEmpSex());
            updateEmployee.setEmpType(ahtEmployee.getEmpType());
            updateEmployee.setTrainingEmpList(ahtEmployee.getTrainingEmpList());
            return employeeDAO.save(updateEmployee);
        }
        return null;
    }

    @Override
    public void deleteEmployee(int idEmployee) {
        employeeDAO.remove(idEmployee);
    }

    @Override
    public List<ContractEmpResult> findEmpByTypeContract(int typeContract) {
        return contractEmpDAO.findEmpByType(typeContract);
    }

    @Override
    public List<Aht_Employee> findEmpByDepartment(int partsID,int departId) {
        return employeeDAO.findEmpByDepartment(partsID,departId);
    }

    @Override
    public List<Aht_Contract_Emp> findEmpByStatustContract() {
        return contractEmpDAO.empContractExpires();
    }

    @Override
    public List<Aht_Contract_Emp> empContract() {
        return contractEmpDAO.empContract();
    }
}
