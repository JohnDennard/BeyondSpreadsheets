package com.example.financetracker.Service.user;

import com.example.financetracker.DAO.user.UserDAO;
import com.example.financetracker.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    private EntityManager entityManager;

    public UserServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveUser(UserEntity user) {

        userDAO.save(user);
    }


    public boolean isUserExists(String username) {
        // Implements logic to check if username exists in database
        // Example using UserDAO or EntityManager
        return userDAO.getUserByUsername(username) != null; // Assuming userDAO has a method to find by username
    }
}
