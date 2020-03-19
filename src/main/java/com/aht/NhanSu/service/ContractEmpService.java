package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Contract;
import com.aht.NhanSu.model.Aht_Contract_Emp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ContractEmpService {
    List<Aht_Contract_Emp> findAllCntractEmp();

    Optional<Aht_Contract_Emp> findById(int id);

    Aht_Contract_Emp createContractEmp(Aht_Contract_Emp ahtContractEmp);

    Aht_Contract_Emp updateContractEmp(Aht_Contract_Emp ahtContractEmp);

    void deleteEmp(int id);

    void updateStatus(Date dateNow);
}
