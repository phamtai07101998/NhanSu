package com.aht.NhanSu;

import com.aht.NhanSu.dao.RoleDAO;
import com.aht.NhanSu.dao.UserDAO;
import com.aht.NhanSu.model.*;
import com.aht.NhanSu.service.RoleService;
import com.aht.NhanSu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@SpringBootApplication
public class NhanSuApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NhanSuApplication.class, args);
	}

	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;
	@Override
	public void run(String... args) throws Exception {
//
//		// Member account
//		if (userDAO.findByUserName("user") == null) {
//			Aht_User user = new Aht_User();
//			user.setUserName("user");
//			user.setUserMail("user@gmail.com");
//			user.setUserPass(passwordEncoder.encode("2"));
//			Set<Aht_Role> role = new HashSet<>();
//			role.add(new Aht_Role("ROLE_USER"));
//			user.setRoles(role);
//			userDAO.save(user);
//		}
	}

	}

