package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.RoleDAO;
import com.aht.NhanSu.model.Aht_Role;
import com.aht.NhanSu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDAO roleDAO;

    @Override
    public List<Aht_Role> listRole() {
        return roleDAO.findAll();
    }

    @Override
    public Optional<Aht_Role> findRoleById(Long id) {
        return roleDAO.findById(id);
    }

    @Override
    public Aht_Role createRole(Aht_Role role) {
        roleDAO.save(role);
        return role;
    }

    @Override
    public Aht_Role updateRole(Aht_Role role) {
        Optional<Aht_Role> findRole = roleDAO.findById(role.getRoleId());
        if (findRole.isPresent()){
            Aht_Role roleUpdate = findRole.get();
            roleUpdate.setRoleId(role.getRoleId());
            roleUpdate.setRoleName(role.getRoleName());
            roleDAO.save(roleUpdate);
            return roleUpdate;
        }
        return null;
    }

    @Override
    public void deleteRole(Long id) {
        roleDAO.deleteById(id);
    }
}
