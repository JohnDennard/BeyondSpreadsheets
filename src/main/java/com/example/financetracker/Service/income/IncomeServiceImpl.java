package com.example.financetracker.Service.income;

import com.example.financetracker.DAO.income.IncomeDAO;
import com.example.financetracker.entity.IncomeEntity;
import org.springframework.stereotype.Service;

@Service
public class IncomeServiceImpl implements IncomeService {
    private IncomeDAO incomeDAO;

    public IncomeServiceImpl(IncomeDAO incomeDAO) {
        this.incomeDAO = incomeDAO;

    }

    public void addIncome(IncomeEntity incomeEntity) {
        incomeDAO.save(incomeEntity);
    }
}
