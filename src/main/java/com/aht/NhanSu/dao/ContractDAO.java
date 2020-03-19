package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractDAO extends JpaRepository<Aht_Contract, Integer> {
}
