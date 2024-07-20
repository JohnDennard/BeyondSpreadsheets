package com.example.financetracker.Controller;

import com.example.financetracker.DAO.milestone.GoalDAO;
import com.example.financetracker.DAO.user.UserDAO;
import com.example.financetracker.entity.GoalEntity;
import com.example.financetracker.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
public class GoalController {

    private GoalDAO goalDAO;
    private UserDAO userDAO;

    public GoalController(GoalDAO goalDAO, UserDAO userDAO) {
        this.goalDAO = goalDAO;
        this.userDAO = userDAO;
    }

    @PostMapping("/addGoal")
    @ResponseBody
    public Map<String, Object> addGoal(@ModelAttribute GoalEntity goal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = "";

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            currentUserName = userDetails.getUsername();
        }

        UserEntity user = userDAO.getUserByUsername(currentUserName);
        UserEntity userId = userDAO.getUserById(user.getUserId());
        goal.setUserId(userId);
        goalDAO.save(goal);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Milestone is Successfully Added");
        response.put("goal", goal);

        return response;
    }
}
