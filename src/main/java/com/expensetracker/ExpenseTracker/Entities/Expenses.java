package com.expensetracker.ExpenseTracker.Entities;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "expense")
public class Expenses {
   /*Fields with database mapping*/

    /*Integer better than int in Hibernate as it allows null values. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "expense_name", nullable = false)
    private String expenseName;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private double amount;

    @Column(name = "date_of")
    private Date date;

    /*Setter and Getters*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
