package com.aht.NhanSu.jwt;

import com.aht.NhanSu.dao.RoleDAO;
import com.aht.NhanSu.dao.UserDAO;
import com.aht.NhanSu.model.Aht_Role;
import com.aht.NhanSu.model.Aht_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Component
public class Data implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        Optional<Aht_Role> role = roleDAO.findByRoleName("ROLE_USER");
        if (role.isPresent()){
            System.out.println("tim thay");
        }else {
            roleDAO.save(new Aht_Role("ROLE_USER"));
        }

        Optional<Aht_Role> role2 = roleDAO.findByRoleName("ROLE_ADMIN");
        if (role2.isPresent()){
            System.out.println("tim thay");
        }else {
            roleDAO.save(new Aht_Role("ROLE_ADMIN"));
        }


        Optional<Aht_User> user = userDAO.findByUserName("admin");
        if (!user.isPresent()) {
            Aht_User newUser = new Aht_User("admin",passwordEncoder.encode("1"),"admin@gmail.com");
            Set<Aht_Role> roles = new HashSet<>();
            Aht_Role adminRole = roleDAO.findByRoleName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            roles.add(adminRole);
            newUser.setRoles(roles);
            userDAO.save(newUser);
        }

        Optional<Aht_User> user1 = userDAO.findByUserName("user");
        if (!user.isPresent()) {
            Aht_User newUser = new Aht_User("user",passwordEncoder.encode("2"),"user@gmail.com");
            Set<Aht_Role> roles = new HashSet<>();
            Aht_Role adminRole = roleDAO.findByRoleName("ROLE_USER")
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy"));
            roles.add(adminRole);
            newUser.setRoles(roles);
            userDAO.save(newUser);
        }
    }
}
