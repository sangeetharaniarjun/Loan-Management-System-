package kivi.lms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="customer")
public class customer
{
    @Id
    private Integer customerid;
    @Column(name="customername")
    private String customername;
    @Column(name="dob")
    private String dob;
    @Column(name="address")
    private String address;
    @Column(name="pan")
    private String pan;
    @Column(name="aadhar")
    private String aadhar;
    @Column(name="voterid")
    private String voterid;
    @Column(name="rationcard")
    private String rationcard;
    @Column(name="gender")
    private String gender;
    @Column(name="maritalstatus")
    private String maritalstatus;
    @Column(name="fathername")
    private String fathername;
    @Column(name="mothername")
    private String mothername;
    @Column(name="totalloans")
    private Integer totalloans;
    @Column(name="activeloans")
    private Integer activeloans;

    public Integer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Integer customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getVoterid() {
        return voterid;
    }

    public void setVoterid(String voterid) {
        this.voterid = voterid;
    }

    public String getRationcard() {
        return rationcard;
    }

    public void setRationcard(String rationcard) {
        this.rationcard = rationcard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public Integer getTotalloans() {
        return totalloans;
    }

    public void setTotalloans(Integer totalloans) {
        this.totalloans = totalloans;
    }

    public Integer getActiveloans() {
        return activeloans;
    }

    public void setActiveloans(Integer activeloans) {
        this.activeloans = activeloans;
    }
}