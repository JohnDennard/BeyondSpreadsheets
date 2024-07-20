package com.example.financetracker.Controller;

import com.example.financetracker.DAO.loan.LoanDAO;
import com.example.financetracker.DAO.user.UserDAO;
import com.example.financetracker.entity.DebtEntity;
import com.example.financetracker.entity.ExpenseEntity;
import com.example.financetracker.entity.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoanController {
    private UserDAO userDAO;

    private LoanDAO loanDAO;

    public LoanController(UserDAO userDAO, LoanDAO loanDAO) {
        this.userDAO = userDAO;
        this.loanDAO = loanDAO;
    }

    @PostMapping("/addLoan")
    public String addLoan(@ModelAttribute DebtEntity debt, Model model, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = "";

        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            currentUserName = userDetails.getUsername(); // or getEmail() if integrated in UserDetails
        }

        UserEntity user = userDAO.getUserByUsername(currentUserName);
        UserEntity userId = userDAO.getUserById(user.getUserId());
        debt.setUserId(userId);
        debt.setIsActive((short) 1);

        loanDAO.save(debt);
        redirectAttributes.addFlashAttribute("debtMessage", "Debt is Successfully Added");

        return "redirect:/LoansAndDebt";
    }
}
