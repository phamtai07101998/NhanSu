package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Parts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartsDAO extends JpaRepository<Aht_Parts, Integer> {
}
