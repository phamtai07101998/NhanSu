package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Role;
import com.aht.NhanSu.model.Aht_User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    List<Aht_User> findAllUser();

    Optional<Aht_User> findUserById(Long id);

    Aht_User createUser(Aht_User user);

    Aht_User updateUser(Aht_User user);

    void deleteUser(Long id);
}
