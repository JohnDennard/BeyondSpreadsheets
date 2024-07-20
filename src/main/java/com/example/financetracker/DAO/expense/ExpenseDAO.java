package com.example.financetracker.DAO.expense;

import com.example.financetracker.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseDAO extends JpaRepository<ExpenseEntity, Integer> {
}
