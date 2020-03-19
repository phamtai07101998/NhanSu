package com.aht.NhanSu.service;

import com.aht.NhanSu.model.Aht_Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<Aht_Role> listRole();

    Optional<Aht_Role> findRoleById(Long id);

    Aht_Role createRole(Aht_Role role);

    Aht_Role updateRole(Aht_Role role);

    void deleteRole(Long id);
}
