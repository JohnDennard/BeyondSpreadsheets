/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.financetracker.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Daniel
 */
@Entity
@Table(name = "goals")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "GoalEntity.findAll", query = "SELECT g FROM GoalEntity g"),
        @NamedQuery(name = "GoalEntity.findByGoalId", query = "SELECT g FROM GoalEntity g WHERE g.goalId = :goalId"),
        @NamedQuery(name = "GoalEntity.findByGoalName", query = "SELECT g FROM GoalEntity g WHERE g.goalName = :goalName"),
        @NamedQuery(name = "GoalEntity.findByGoalAmount", query = "SELECT g FROM GoalEntity g WHERE g.goalAmount = :goalAmount"),
        @NamedQuery(name = "GoalEntity.findByGoalDate", query = "SELECT g FROM GoalEntity g WHERE g.goalDate = :goalDate"),
        @NamedQuery(name = "GoalEntity.findbySavingsAmount", query = "SELECT g FROM GoalEntity g WHERE g.savingsAmount = :savingsAmount")})
public class GoalEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "goal_id")
    private Integer goalId;
    @Column(name = "goal_name")
    private String goalName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "goal_amount")
    private Float goalAmount;
    @Column(name = "savings_amount")
    private Float savingsAmount;
    @Column(name = "goal_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date goalDate;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserEntity userId;

    public GoalEntity() {
    }

    public GoalEntity(Integer goalId) {
        this.goalId = goalId;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Float getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(Float savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public Float getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(Float goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Date getGoalDate() {
        return goalDate;
    }

    public void setGoalDate(Date goalDate) {
        this.goalDate = goalDate;
    }

    public UserEntity getUserId() {
        return userId;
    }

    public void setUserId(UserEntity userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (goalId != null ? goalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoalEntity)) {
            return false;
        }
        GoalEntity other = (GoalEntity) object;
        if ((this.goalId == null && other.goalId != null) || (this.goalId != null && !this.goalId.equals(other.goalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.financetracker.entity.GoalEntity[ goalId=" + goalId + " ]";
    }

}
