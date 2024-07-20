package com.example.financetracker.DAO.income;

import com.example.financetracker.entity.IncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeDAO extends JpaRepository<IncomeEntity, Integer> {

}
