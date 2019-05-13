package com.codecool.web.model;

import java.util.List;

public class Task4 {

    private String company;
    private List<Integer> orderIds;

    public Task4(String company, List<Integer> orderIds) {
        this.company = company;
        this.orderIds = orderIds;
    }

    public String getCompany() {
        return company;
    }

    public List<Integer> getOrderIds() {
        return orderIds;
    }
}
