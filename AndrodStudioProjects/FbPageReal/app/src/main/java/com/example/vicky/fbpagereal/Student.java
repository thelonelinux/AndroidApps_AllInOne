package com.example.vicky.fbpagereal;

public class Student {

    public Student(String name, String batch, String number, String location) {
        this.name = name;
        this.batch = batch;
        this.number = number;
        this.location = location;
    }


    //lets make this data private so no one can access
    private String name, batch, number, location;   //we are here passing all things as string to make it look easy. or you can make it integer.


    //but if you want to access this then you have to make use of getters and setters

    public String getName() {
        return name;
    }


    //in case you want to make your own get and set you can use this. as below
    //however get and set is the best practise
    //so follow get and set



//    public String getOrModifyName(String s){
//        if (s.equals("")){
//            return name;
//        }
//        else{
//            name = s;
//            return name;
//        }
//    }

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
