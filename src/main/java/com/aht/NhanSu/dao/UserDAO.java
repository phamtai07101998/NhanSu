package com.aht.NhanSu.dao;

import com.aht.NhanSu.model.Aht_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<Aht_User,Long> {
   Optional<Aht_User> findByUserName(String username);
    Boolean existsByUserName(String username);
    Boolean existsByUserMail(String email);
}
