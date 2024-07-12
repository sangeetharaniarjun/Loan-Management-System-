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
@Table(name="loans")
public class loan
{
    @Id
    private Integer loanid;
    @Column(name="customerid")
    private Integer customerid;
    @Column(name="dateofdisbursement")
    private Date dateofdisbursement;
    @Column(name="loanamount")
    private Double loanamount;
    @Column(name="interestrate")
    private Float interestrate;
    @Column(name="tenure")
    private Integer tenure;
    @Column(name="repaymentfrequency")
    private String repaymentfrequency;
    @Column(name="loanstatus")
    private String loanstatus;
    @Column(name="principaloutstanding")
    private Double principaloutstanding;
    @Column(name="repaymentsopen")
    private Integer repaymentsopen;

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public Date getDateofdisbursement() {
        return dateofdisbursement;
    }

    public void setDateofdisbursement(Date dateofdisbursement) {
        this.dateofdisbursement = dateofdisbursement;
    }

    public Double getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(Double loanamount) {
        this.loanamount = loanamount;
    }

    public Float getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(Float interestrate) {
        this.interestrate = interestrate;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public String getRepaymentfrequency() {
        return repaymentfrequency;
    }

    public void setRepaymentfrequency(String repaymentfrequency) {
        this.repaymentfrequency = repaymentfrequency;
    }

    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    public Double getPrincipaloutstanding() {
        return principaloutstanding;
    }

    public void setPrincipaloutstanding(Double principaloutstanding) {
        this.principaloutstanding = principaloutstanding;
    }

    public Integer getRepaymentsopen() {
        return repaymentsopen;
    }

    public void setRepaymentsopen(Integer repaymentsopen) {
        this.repaymentsopen = repaymentsopen;
    }
}