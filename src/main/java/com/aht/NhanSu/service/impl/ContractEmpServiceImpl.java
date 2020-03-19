package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.ContractEmpDAO;
import com.aht.NhanSu.model.Aht_Contract_Emp;
import com.aht.NhanSu.service.ContractEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class ContractEmpServiceImpl implements ContractEmpService {
    @Autowired
    private ContractEmpDAO contractEmpDAO;

    @Override
    public List<Aht_Contract_Emp> findAllCntractEmp() {
        return contractEmpDAO.findAll();
    }

    @Override
    public Optional<Aht_Contract_Emp> findById(int id) {
        return contractEmpDAO.findById(id);

    }

    @Override
    public Aht_Contract_Emp createContractEmp(Aht_Contract_Emp ahtContractEmp) {

        return contractEmpDAO.save(ahtContractEmp);
    }

    @Override
    public Aht_Contract_Emp updateContractEmp(Aht_Contract_Emp ahtContractEmp) {
        Optional<Aht_Contract_Emp> findContract = contractEmpDAO.findById(ahtContractEmp.getContractEmpId());
        if (findContract.isPresent()){
            Aht_Contract_Emp updateContractEmp = findContract.get();
            updateContractEmp.setContractEmpId(ahtContractEmp.getContractEmpId());
            updateContractEmp.setContract(ahtContractEmp.getContract());
            updateContractEmp.setEmployee(ahtContractEmp.getEmployee());
            updateContractEmp.setContractEmpEndDate(ahtContractEmp.getContractEmpEndDate());
            updateContractEmp.setContractEmpStartDate(ahtContractEmp.getContractEmpStartDate());
            updateContractEmp.setContractEmpStatus(ahtContractEmp.getContractEmpStatus());
            return contractEmpDAO.save(updateContractEmp);
        }
        return null;
    }

    @Override
    public void deleteEmp(int id) {
        contractEmpDAO.deleteById(id);
    }

    @Override
    public void updateStatus(Date dateNow) {
        contractEmpDAO.upEmp(dateNow);
    }
}
