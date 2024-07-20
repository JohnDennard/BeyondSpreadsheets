/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.financetracker.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author Daniel
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "UserEntity.findAll", query = "SELECT u FROM UserEntity u"),
        @NamedQuery(name = "UserEntity.findByUserId", query = "SELECT u FROM UserEntity u WHERE u.userId = :userId"),
        @NamedQuery(name = "UserEntity.findByUsername", query = "SELECT u FROM UserEntity u WHERE u.username = :username"),
        @NamedQuery(name = "UserEntity.findByFirstName", query = "SELECT u FROM UserEntity u WHERE u.firstName = :firstName"),
        @NamedQuery(name = "UserEntity.findByLastName", query = "SELECT u FROM UserEntity u WHERE u.lastName = :lastName"),
        @NamedQuery(name = "UserEntity.findByPhoneNumber", query = "SELECT u FROM UserEntity u WHERE u.phoneNumber = :phoneNumber"),
        @NamedQuery(name = "UserEntity.findByEmail", query = "SELECT u FROM UserEntity u WHERE u.email = :email"),
        @NamedQuery(name = "UserEntity.findByPassword", query = "SELECT u FROM UserEntity u WHERE u.password = :password"),
        @NamedQuery(name = "UserEntity.findByAccountType", query = "SELECT u FROM UserEntity u WHERE u.accountType = :accountType")})
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "username")
    private String username;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "account_type")
    private String accountType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<IncomeEntity> incomeEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<DebtEntity> debtEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<ExpenseEntity> expenseEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<GoalEntity> goalEntityList;

    public UserEntity() {
    }

    public UserEntity(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @XmlTransient
    public List<IncomeEntity> getIncomeEntityList() {
        return incomeEntityList;
    }

    public void setIncomeEntityList(List<IncomeEntity> incomeEntityList) {
        this.incomeEntityList = incomeEntityList;
    }

    @XmlTransient
    public List<DebtEntity> getDebtEntityList() {
        return debtEntityList;
    }

    public void setDebtEntityList(List<DebtEntity> debtEntityList) {
        this.debtEntityList = debtEntityList;
    }

    @XmlTransient
    public List<ExpenseEntity> getExpenseEntityList() {
        return expenseEntityList;
    }

    public void setExpenseEntityList(List<ExpenseEntity> expenseEntityList) {
        this.expenseEntityList = expenseEntityList;
    }

    @XmlTransient
    public List<GoalEntity> getGoalEntityList() {
        return goalEntityList;
    }

    public void setGoalEntityList(List<GoalEntity> goalEntityList) {
        this.goalEntityList = goalEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.financetracker.entity.UserEntity[ userId=" + userId + " ]";
    }

}
