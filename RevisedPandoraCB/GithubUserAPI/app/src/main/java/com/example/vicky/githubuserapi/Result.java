package com.example.vicky.githubuserapi;

import java.util.ArrayList;

public class Result {

    private ArrayList<User> items;

    public Result() {
    }

    public Result(ArrayList<User> items) {
        this.items = items;
    }

    public ArrayList<User> getItems() {
        return items;
    }
}