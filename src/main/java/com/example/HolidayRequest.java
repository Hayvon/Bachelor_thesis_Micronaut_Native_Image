package com.example;


import javax.persistence.*;

@Entity
public class HolidayRequest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="VORGESETZTER")
    private String vorgesetzter;
    @Column(name="STARTDATE")
    private  String startDate;
    @Column(name="ENDDATE")
    private String endDate;
    @Column(name="FULLNAME")
    private String fullName;

    @Column(name="STATUS")
    private  String status;


    public HolidayRequest(){
    }

    public HolidayRequest(long id, String fullName, String vorgesetzter, String startDate, String endDate, String status){
        this.id = id;
        this.fullName = fullName;
        this.vorgesetzter = vorgesetzter;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "pending";
    }

    public long getId() {
        return id;
    }

    public String getVorgesetzter() {
        return vorgesetzter;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStatus() {
        return status;
    }

    public void setVorgesetzter(String vorgesetzter) {
        this.vorgesetzter = vorgesetzter;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

