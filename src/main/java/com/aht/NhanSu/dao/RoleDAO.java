package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAO extends JpaRepository<Aht_Role,Long> {
    Optional<Aht_Role> findByRoleName(String roleName);
}
