package com.example.financetracker.DAO.milestone;

import com.example.financetracker.entity.GoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalDAO extends JpaRepository<GoalEntity, Integer> {

}
