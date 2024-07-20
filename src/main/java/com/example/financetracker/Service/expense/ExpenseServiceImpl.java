package com.example.financetracker.Service.expense;

import com.example.financetracker.DAO.expense.ExpenseDAO;
import com.example.financetracker.entity.ExpenseEntity;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseDAO expenseDAO;

    public ExpenseServiceImpl(ExpenseDAO expenseDAO) {
        this.expenseDAO = expenseDAO;
    }

    public void addExpense(ExpenseEntity expenseEntity) {
        expenseDAO.save(expenseEntity);
    }
}