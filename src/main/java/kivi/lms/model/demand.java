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
@Table(name="demand")
public class demand
{
    @Id
    private Integer demandid;
    @Column(name="loanid")
    private Integer loanid;
    @Column(name="repaymentid")
    private Integer repaymentid;
    @Column(name="collectionid")
    private Integer collectionid;
    @Column(name="demanddate")
    private Date demanddate;
    @Column(name="collectiondate")
    private Date collectiondate;
    @Column(name="totalpayable")
    private Double totalpayable;
    @Column(name="status")
    private String status;
    public Integer getDemandid() {
        return demandid;
    }

    public void setDemandid(Integer demandid) {
        this.demandid = demandid;
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

    public Integer getCollectionid() {
        return collectionid;
    }

    public void setCollectionid(Integer collectionid) {
        this.collectionid = collectionid;
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