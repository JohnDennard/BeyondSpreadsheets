package com.example.financetracker;

import com.example.financetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //provides CRUD operations for ExpenseEntity.java
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}
