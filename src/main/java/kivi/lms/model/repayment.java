package kivi.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="repayment")
public class repayment
{
    @Id
    private Integer repaymentid;
    @Column(name="loanid")
    private Integer loanid;
    @Column(name="repaymentnumber")
    private Integer repaymentnumber;
    @Column(name="repaymentdate")
    private Date repaymentdate;
    @Column(name="demanddate")
    private Date demanddate;
    @Column(name="collectiondate")
    private Date collectiondate;
    @Column(name="principal")
    private Double principal;
    @Column(name="interest")
    private Float interest;
    @Column(name="totalpayable")
    private Double totalpayable;
    @Column(name="status")
    private String status;

    public Integer getRepaymentid() {
        return repaymentid;
    }

    public void setRepaymentid(Integer repaymentid) {
        this.repaymentid = repaymentid;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getRepaymentnumber() {
        return repaymentnumber;
    }

    public void setRepaymentnumber(Integer repaymentnumber) {
        this.repaymentnumber = repaymentnumber;
    }

    public Date getRepaymentdate() {
        return repaymentdate;
    }

    public void setRepaymentdate(Date repaymentdate) {
        this.repaymentdate = repaymentdate;
    }

    public Date getDemanddate() {
        return demanddate;
    }

    public void setDemanddate(Date demanddate) {
        this.demanddate = demanddate;
    }

    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    public Double getPrincipal() {
        return principal;
    }

    public void setPrincipal(Double principal) {
        this.principal = principal;
    }

    public Float getInterest() {
        return interest;
    }

    public void setInterest(Float interest) {
        this.interest = interest;
    }

    public Double getTotalpayable() {
        return totalpayable;
    }

    public void setTotalpayable(Double totalpayable) {
        this.totalpayable = totalpayable;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}