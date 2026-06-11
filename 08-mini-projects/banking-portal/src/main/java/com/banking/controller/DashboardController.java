package com.banking.controller;

import com.banking.model.Account;
import com.banking.model.Transaction;
import com.banking.service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private BankingService bankingService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();

        Account account = bankingService.getAccount(username);
        List<Transaction> transactions = bankingService.getTransactionHistory(username);

        model.addAttribute("account", account);
        model.addAttribute("transactions", transactions);
        model.addAttribute("username", username);

        return "dashboard";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam("amount") BigDecimal amount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        bankingService.deposit(username, amount);
        return "redirect:/dashboard";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam("amount") BigDecimal amount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        try {
            bankingService.withdraw(username, amount);
        } catch (RuntimeException e) {
            return "redirect:/dashboard?error=" + e.getMessage();
        }
        return "redirect:/dashboard";
    }

    @PostMapping("/transfer")
    public String transfer(@RequestParam("toUser") String toUser, @RequestParam("amount") BigDecimal amount) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        try {
            bankingService.transfer(username, toUser, amount);
        } catch (RuntimeException e) {
            return "redirect:/dashboard?error=" + e.getMessage();
        }
        return "redirect:/dashboard";
    }
}
