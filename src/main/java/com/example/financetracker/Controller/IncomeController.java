package com.example.financetracker.Controller;

import com.example.financetracker.entity.IncomeEntity;
import com.example.financetracker.entity.UserEntity;
import com.example.financetracker.IncomeRepository;
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
@RequestMapping("/income")
public class IncomeController {

    private static final Logger logger = LoggerFactory.getLogger(IncomeController.class);

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addIncome")
    @ResponseBody
    public Map<String, Object> addIncome(@RequestBody IncomeEntity income) {
        Map<String, Object> response = new HashMap<>();
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentUserName = "";
            if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                currentUserName = userDetails.getUsername();
            }

            UserEntity user = userRepository.findByUsername(currentUserName);
            income.setUserId(user);

            logger.info("Received income: {}", income);
            incomeRepository.save(income);
            logger.info("Income saved successfully: {}", income);
            response.put("status", "success");
            response.put("message", "Income added successfully");
            response.put("income", income);
        } catch (Exception e) {
            logger.error("Error saving income", e);
            response.put("status", "error");
            response.put("message", "Failed to add income");
        }
        return response;
    }

    @GetMapping("/getAllIncome")
    @ResponseBody
    public List<IncomeEntity> getAllIncome() {
        List<IncomeEntity> incomeList = null;
        try {
            incomeList = incomeRepository.findAll();
            logger.info("Income fetched successfully: {}", incomeList);
        } catch (Exception e) {
            logger.error("Error fetching income", e);
        }
        return incomeList;
    }

    @GetMapping("/view")
    public String showIncomePage(Model model) {
        model.addAttribute("income", new IncomeEntity());
        return "CalculateRevenueIncome";
    }
}
