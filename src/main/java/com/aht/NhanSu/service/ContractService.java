package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Contract;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    List<Aht_Contract> findAllContract();

    Optional<Aht_Contract> findContractById( int idContract);

    Aht_Contract createContract(Aht_Contract ahtContract);

    Aht_Contract updateContract(Aht_Contract ahtContract);

    void deleteContract(int idContract);
}
