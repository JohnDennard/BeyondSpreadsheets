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
@Table(name = "income")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "IncomeEntity.findAll", query = "SELECT i FROM IncomeEntity i"),
        @NamedQuery(name = "IncomeEntity.findByIncomeId", query = "SELECT i FROM IncomeEntity i WHERE i.incomeId = :incomeId"),
        @NamedQuery(name = "IncomeEntity.findByIncomeAmount", query = "SELECT i FROM IncomeEntity i WHERE i.incomeAmount = :incomeAmount"),
        @NamedQuery(name = "IncomeEntity.findByIncomeSource", query = "SELECT i FROM IncomeEntity i WHERE i.incomeSource = :incomeSource"),
        @NamedQuery(name = "IncomeEntity.findByIncomeDate", query = "SELECT i FROM IncomeEntity i WHERE i.incomeDate = :incomeDate"),
        @NamedQuery(name = "IncomeEntity.findByTag", query = "SELECT i FROM IncomeEntity i WHERE i.tag = :tag")})
public class IncomeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "income_id")
    private Integer incomeId;
    @Column(name = "income_amount")
    private Float incomeAmount;
    @Column(name = "income_source")
    private String incomeSource;
    @Column(name = "income_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date incomeDate;
    @Column(name = "tag")
    private String tag;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private UserEntity userId;

    public IncomeEntity() {
    }

    public IncomeEntity(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Integer getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Integer incomeId) {
        this.incomeId = incomeId;
    }

    public Float getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(Float incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    public String getIncomeSource() {
        return incomeSource;
    }

    public void setIncomeSource(String incomeSource) {
        this.incomeSource = incomeSource;
    }

    public Date getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Date incomeDate) {
        this.incomeDate = incomeDate;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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
        hash += (incomeId != null ? incomeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IncomeEntity)) {
            return false;
        }
        IncomeEntity other = (IncomeEntity) object;
        if ((this.incomeId == null && other.incomeId != null) || (this.incomeId != null && !this.incomeId.equals(other.incomeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.financetracker.entity.IncomeEntity[ incomeId=" + incomeId + " ]";
    }

}
