package com.example.financetracker.DAO.loan;

import com.example.financetracker.entity.DebtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanDAO extends JpaRepository<DebtEntity, Integer> {
}
