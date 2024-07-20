package com.example.financetracker.Service.milestone;

import com.example.financetracker.DAO.milestone.GoalDAO;
import com.example.financetracker.entity.GoalEntity;


public class GoalServiceImpl implements GoalService {
    private GoalDAO goalDAO;

    public GoalServiceImpl(GoalDAO goalDAO) {
        this.goalDAO = goalDAO;
    }

    public void addGoal(GoalEntity goalEntity) {
        goalDAO.save(goalEntity);
    }
}
