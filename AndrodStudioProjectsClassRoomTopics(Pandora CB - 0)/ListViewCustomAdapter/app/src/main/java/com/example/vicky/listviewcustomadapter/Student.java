package com.example.vicky.listviewcustomadapter;

public class Student {

    private String name,batch,number,location;

    public Student(String name, String batch, String number, String location) {
        this.name = name;
        this.batch = batch;
        this.number = number;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

