package com.expensetracker.ExpenseTracker.Repositories;

import com.expensetracker.ExpenseTracker.Entities.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpensesRepository extends JpaRepository<Expenses,Integer> {
    /*Extending Jpa repository for the Expenses Class*/
}
