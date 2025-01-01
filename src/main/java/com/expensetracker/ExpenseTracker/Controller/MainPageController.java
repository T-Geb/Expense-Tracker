package com.expensetracker.ExpenseTracker.Controller;

import com.expensetracker.ExpenseTracker.Entities.Expenses;
import com.expensetracker.ExpenseTracker.Repositories.ExpensesRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {
   // inject the repository for handling data
    private ExpensesRepository expensesRepository;

    Expenses myExpenses = new Expenses();

    public MainPageController(ExpensesRepository expensesRepository) {
        this.expensesRepository = expensesRepository;
    }

    @GetMapping()
    public String showContents(Model theModel){
        /*Passing in our database data for expenses to be displayed in the html using the Model attribute.*/
        List<Expenses> expenses = expensesRepository.findAll();
        double sum = 0.0;
        for(Expenses expense: expenses){
            sum += expense.getAmount();
        }
        theModel.addAttribute("expenses", expenses);
        theModel.addAttribute("totalExpenses", sum);
        return "mainpage";
    }

    @GetMapping("/deleteExpense")
    public String deleteExpense(@RequestParam("expense_id") Integer id ){
        expensesRepository.deleteById(id);
        return "redirect:/";
    }



}
