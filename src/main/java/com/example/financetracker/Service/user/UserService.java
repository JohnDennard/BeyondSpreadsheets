package com.example.financetracker.Service.user;

import com.example.financetracker.entity.UserEntity;

public interface UserService {
    public void saveUser(UserEntity user);

    public boolean isUserExists(String username);

}
