package com.expensetracker.ExpenseTracker.Entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "expense")
public class Expenses {
   /*Fields with database mapping*/

    /*Integer better than int in Hibernate as it allows null values. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expense_id;  // this id has to match the database name or renamed with @Column annotation

    @Column(name = "expense_name", nullable = false)
    private String expenseName;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private double amount;

    @CreationTimestamp
    @Column(name = "date_of")
    private Date date;

    /*Setter and Getters*/
    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*Custom Constructor */
    public Expenses(String expenseName, String category, double amount, Date date) {
        this.expenseName = expenseName;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    /*No Args Constructor*/
    public Expenses() {}
}
