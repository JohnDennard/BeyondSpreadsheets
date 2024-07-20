package com.example.financetracker.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class ExpenseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private Long expenseId;

    @Column(name = "expense_amount")
    private Float expenseAmount;

    @Column(name = "expense_category")
    private String expenseCategory;

    @Column(name = "expense_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expenseDate;

    @Column(name = "expenses_merchant")
    private String expensesMerchant;

    @Column(name = "tag")
    private String tag;

    @Column(name = "is_active")
    private Short isActive;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonBackReference
    private UserEntity userId;

    // Getters and setters
    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }

    public Float getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(Float expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpensesMerchant() {
        return expensesMerchant;
    }

    public void setExpensesMerchant(String expensesMerchant) {
        this.expensesMerchant = expensesMerchant;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Short getIsActive() {
        return isActive;
    }

    public void setIsActive(Short isActive) {
        this.isActive = isActive;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }
}
