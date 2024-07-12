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
@Table(name="collection")
public class collection
{
    @Id
    private Integer collectionid;
    @Column(name="loanid")
    private Integer loanid;
    @Column(name="repaymentid")
    private Integer repaymentid;
    @Column(name="collectiondate")
    private Date collectiondate;
    @Column(name="totalcollected")
    private Double totalcollected;
    @Column(name="principal")
    private Double principal;
    @Column(name="interest")
    private Float interest;
    @Column(name="charges")
    private Double charges;
    @Column(name="modeofpayment")
    private String modeofpayment;

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
    }

    public Integer getLoanid() {
        return loanid;
    }

    public void setLoanid(Integer loanid) {
        this.loanid = loanid;
    }

    public Integer getRepaymentid() {
        return repaymentid;
    }

    public void setRepaymentid(Integer repaymentid) {
        this.repaymentid = repaymentid;
    }

    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    public Double getTotalcollected() {
        return totalcollected;
    }

    public void setTotalcollected(Double totalcollected) {
        this.totalcollected = totalcollected;
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

    public Double getCharges() {
        return charges;
    }

    public void setCharges(Double charges) {
        this.charges = charges;
    }

    public String getModeofpayment() {
        return modeofpayment;
    }

    public void setModeofpayment(String modeofpayment) {
        this.modeofpayment = modeofpayment;
    }



}