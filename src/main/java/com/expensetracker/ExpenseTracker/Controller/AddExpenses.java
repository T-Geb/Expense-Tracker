package com.expensetracker.ExpenseTracker.Controller;

import com.expensetracker.ExpenseTracker.Entities.Expenses;
import com.expensetracker.ExpenseTracker.Repositories.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AddExpenses {

    @Value("${expenseCategory}")
    private List<String> expenseCategory;

    @Autowired
    private ExpensesRepository expensesRepository;


    @GetMapping("/addExpenses")
    public String AddExpenses(Model model, Expenses expenses) {
        model.addAttribute("expenseCategory", expenseCategory);
        model.addAttribute("expenses", new Expenses());
        return "addExpenses";
    }


    @PostMapping("/saveExpense")
    public String saveExpense(Model model, Expenses expenses){
        expensesRepository.save(expenses);
        return "redirect:/";
    }


}
