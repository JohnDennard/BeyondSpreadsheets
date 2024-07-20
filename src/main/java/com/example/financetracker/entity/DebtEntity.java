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
@Table(name = "debt")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "DebtEntity.findAll", query = "SELECT d FROM DebtEntity d"),
        @NamedQuery(name = "DebtEntity.findByDebtId", query = "SELECT d FROM DebtEntity d WHERE d.debtId = :debtId"),
        @NamedQuery(name = "DebtEntity.findByDebtName", query = "SELECT d FROM DebtEntity d WHERE d.debtName = :debtName"),
        @NamedQuery(name = "DebtEntity.findByUpdateDebt", query = "SELECT d FROM DebtEntity d WHERE d.updateDebt = :updateDebt"),
        @NamedQuery(name = "DebtEntity.findByDueDate", query = "SELECT d FROM DebtEntity d WHERE d.dueDate = :dueDate"),
        @NamedQuery(name = "DebtEntity.findByDebtCategory", query = "SELECT d FROM DebtEntity d WHERE d.debtCategory = :debtCategory"),
        @NamedQuery(name = "DebtEntity.findByIsActive", query = "SELECT d FROM DebtEntity d WHERE d.isActive = :isActive")})
public class DebtEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "debt_id")
    private Integer debtId;
    @Column(name = "debt_name")
    private String debtName;
    // @Max(value=?)  @Min(value=?)//might use annotations to enforce field validation by using a range of numbers
    @Column(name = "update_debt")
    private Float updateDebt;


    @Column(name = "loan_amount")
    private Float loanAmount;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "due_date")


    private Date dueDate;
    @Column(name = "debt_category")
    private String debtCategory;
    @Column(name = "is_active")
    private Short isActive;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserEntity userId;

    public DebtEntity() {
    }

    public DebtEntity(Integer debtId) {
        this.debtId = debtId;
    }

    public Integer getDebtId() {
        return debtId;
    }

    public void setDebtId(Integer debtId) {
        this.debtId = debtId;
    }

    public String getDebtName() {
        return debtName;
    }

    public void setDebtName(String debtName) {
        this.debtName = debtName;
    }

    public Float getUpdateDebt() {
        return updateDebt;
    }

    public void setUpdateDebt(Float updateDebt) {
        this.updateDebt = updateDebt;
    }


    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDebtCategory() {
        return debtCategory;
    }

    public void setDebtCategory(String debtCategory) {
        this.debtCategory = debtCategory;
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

    public Float getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Float loanAmount) {
        this.loanAmount = loanAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debtId != null ? debtId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DebtEntity)) {
            return false;
        }
        DebtEntity other = (DebtEntity) object;
        if ((this.debtId == null && other.debtId != null) || (this.debtId != null && !this.debtId.equals(other.debtId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.financetracker.entity.DebtEntity[ debtId=" + debtId + " ]";
    }

}
