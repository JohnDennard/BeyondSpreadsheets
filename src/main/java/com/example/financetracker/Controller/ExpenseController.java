package com.example.financetracker.Controller;

import com.example.financetracker.entity.ExpenseEntity;
import com.example.financetracker.entity.UserEntity;
import com.example.financetracker.ExpenseRepository;
import com.example.financetracker.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/expenses")
//Controller to handle HTTP requests related to creating, updating, and retrieving expenses via Spring Boot
public class ExpenseController {

    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addExpense")
    @ResponseBody
    public Map<String, Object> addExpense(@RequestBody ExpenseEntity expense) {
        Map<String, Object> response = new HashMap<>();
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = "";
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                currentUserName = userDetails.getUsername();
            }

            UserEntity user = userRepository.findByUsername(currentUserName);
            expense.setUserId(user);

            logger.info("Received expense: {}", expense);
            expenseRepository.save(expense);
            logger.info("Expense saved successfully: {}", expense);
            response.put("status", "success");
            response.put("message", "Expense added successfully");
            response.put("expense", expense);
        } catch (Exception e) {
            logger.error("Error saving expense", e);
            response.put("status", "error");
            response.put("message", "Failed to add expense");
        }
        return response;
    }

    @GetMapping("/getAllExpenses")
    @ResponseBody
    public List<ExpenseEntity> getAllExpenses() {
        List<ExpenseEntity> expenses = null;
        try {
            expenses = expenseRepository.findAll();
            logger.info("Expenses fetched successfully: {}", expenses);
        } catch (Exception e) {
            logger.error("Error fetching expenses", e);
        }
        return expenses;
    }

    @GetMapping("/view")
    public String showExpensesPage(Model model) {
        model.addAttribute("expense", new ExpenseEntity());
        return "Expenses";
    }
}
