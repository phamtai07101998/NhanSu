package com.aht.NhanSu.jwt;

import com.aht.NhanSu.dao.UserDAO;
import com.aht.NhanSu.model.Aht_User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Aht_User user = userDAO.findByUserName(username).orElseThrow(
                () -> new UsernameNotFoundException("Không tìm thấy : " + username));

        return UserPrinciple.build(user);
    }
}
