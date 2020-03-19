package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.ContractDAO;
import com.aht.NhanSu.model.Aht_Contract;
import com.aht.NhanSu.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractDAO contractDAO;

    @Override
    public List<Aht_Contract> findAllContract() {
        return contractDAO.findAll();
    }

    @Override
    public Optional<Aht_Contract> findContractById(int idContract) {
        return contractDAO.findById(idContract);
    }

    @Override
    public Aht_Contract createContract(Aht_Contract ahtContract) {
        return contractDAO.save(ahtContract);
    }

    @Override
    public Aht_Contract updateContract(Aht_Contract ahtContract) {
        Optional<Aht_Contract> findContract = contractDAO.findById(ahtContract.getContractId());
        if(findContract.isPresent()){
            Aht_Contract updateContract = findContract.get();
            updateContract.setContractId(ahtContract.getContractId());
            updateContract.setContractCode(ahtContract.getContractCode());
            updateContract.setContractType(ahtContract.getContractType());
            updateContract.setContractEmpList(ahtContract.getContractEmpList());
            return contractDAO.save(updateContract);
        }
        return null;
    }

    @Override
    public void deleteContract(int idContract) {
        contractDAO.deleteById(idContract);
    }
}
