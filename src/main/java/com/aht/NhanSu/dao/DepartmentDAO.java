package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends JpaRepository<Aht_Department, Integer> {
}
