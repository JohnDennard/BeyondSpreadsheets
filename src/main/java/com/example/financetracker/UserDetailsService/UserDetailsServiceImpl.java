package com.example.financetracker.UserDetailsService;


import com.example.financetracker.DAO.user.UserDAO;
import com.example.financetracker.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDAO userRepository;


    @Transactional(readOnly = true)

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.getUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException(userName);
        }
//        return new MyUserDetails(user.getUserId(), user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getPhoneNumber(), user.getEmail(), user.getAccountType(), Collections.emptyList());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.emptyList());
    }


}
