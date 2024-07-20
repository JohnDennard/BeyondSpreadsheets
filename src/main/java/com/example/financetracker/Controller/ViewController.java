package com.example.financetracker.Controller;

import com.example.financetracker.DAO.user.UserDAO;
import com.example.financetracker.entity.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final UserDAO userDAO;

    public ViewController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String index(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = "";

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            currentUserName = userDetails.getUsername(); // or getEmail() if integrated in UserDetails
        }
        UserEntity user = userDAO.getUserByUsername(currentUserName);

        model.addAttribute("username", currentUserName);
        return "BeyondExpenses";
    }

    @GetMapping("/expenses")
    public String expenses(Model model) {
        model.addAttribute("expense", new ExpenseEntity());

        return "Expenses";
    }

    @GetMapping("/LoansAndDebt")
    public String loansAndDebt(Model model) {
        model.addAttribute("loan", new DebtEntity());

        return "LoansAndDebt";
    }

    @GetMapping("/LoansUpdateAmount")
    public String loansUpdateAmount() {
        return "LoansUpdateAmount";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }

    @GetMapping("/CreateMilestone")
    public String createMilestone(Model model) {
        model.addAttribute("goal", new GoalEntity());

        return "CreateMilestone";
    }

    @GetMapping("/Profile")
    public String profile() {
        return "Profile";
    }

    @GetMapping("/CalculateRevenueIncome")
    public String calculateRevenueIncome(Model model) {
        model.addAttribute("income", new IncomeEntity());

        return "CalculateRevenueIncome";
    }

    @GetMapping("/Signup")
    public String signup(Model model) {
        model.addAttribute("user", new UserEntity());

        return "Signup";
    }

    @GetMapping("/Summary")
    public String summary() {
        return "Summary";
    }
}
