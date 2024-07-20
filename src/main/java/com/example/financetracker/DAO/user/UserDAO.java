package com.example.financetracker.DAO.user;

import com.example.financetracker.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<UserEntity, Integer> {

    @Query("select u from UserEntity u where u.username=:username")
    public UserEntity getUserByUsername(@Param("username") String username);

    @Query("select u from UserEntity u where u.userId=:userId")
    public UserEntity getUserById(@Param("userId") Integer userId);
}
