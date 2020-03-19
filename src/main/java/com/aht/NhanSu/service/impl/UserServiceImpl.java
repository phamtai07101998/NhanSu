package com.aht.NhanSu.service.impl;

import com.aht.NhanSu.dao.UserDAO;
import com.aht.NhanSu.model.Aht_User;
import com.aht.NhanSu.service.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Aht_User> findAllUser() {
        return userDAO.findAll();
    }

    @Override
    public Optional<Aht_User> findUserById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Aht_User createUser(Aht_User user) {
        user.setUserPass(passwordEncoder.encode(user.getUserPass()));
        return userDAO.save(user);
    }

    @Override
    public Aht_User updateUser(Aht_User user) {
        Optional<Aht_User> findUser = userDAO.findById(user.getUserId());
        if(findUser.isPresent()){
            Aht_User userUpdate = findUser.get();
            userUpdate.setUserId(user.getUserId());
            userUpdate.setUserMail(user.getUserMail());
            userUpdate.setUserName(user.getUserName());
            userUpdate.setUserPass(user.getUserPass());
            userDAO.save(userUpdate);
            return userUpdate;
        }else
            return null;

    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
