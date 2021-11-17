package com.bancamia.webapp.model;

//import java.util.Date;

/**
 * User
 */
public class User {

    private String names;
    private String lastNames;
    private String docType;
    private long docNumber;
    private String bornDate;
    private String bornCity;
    private long phone;
    private String username;
    private String password;

    public User(){

    }

    public User(String names, String lastNames, String docType, long docNumber,
        String bornDate, String bornCity, long phone, String username, String password){
            this.names = names;
            this.lastNames = lastNames;
            this.docType   = docType;
            this.docNumber = docNumber;
            this.bornDate = bornDate;
            this.bornCity = bornCity;
            this.phone = phone;
            this.username = username;
            this.password = password;
    }

    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getLastNames() {
        return lastNames;
    }
    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
    public String getDocType() {
        return docType;
    }
    public void setDocType(String docType) {
        this.docType = docType;
    }
    public long getDocNumber() {
        return docNumber;
    }
    public void setDocNumber(long docNumber) {
        this.docNumber = docNumber;
    }
    public String getBornDate() {
        return bornDate;
    }
    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }
    public String getBornCity() {
        return bornCity;
    }
    public void setBornCity(String bornCity) {
        this.bornCity = bornCity;
    }
    public long getPhone() {
        return phone;
    }
    public void setPhone(long phone) {
        this.phone = phone;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [bornCity=" + bornCity + ", bornDate=" + bornDate + ", docNumber=" + docNumber + ", docType="
                + docType + ", lastNames=" + lastNames + ", names=" + names + ", password=" + password + ", phone="
                + phone + ", username=" + username + "]";
    }

    

}