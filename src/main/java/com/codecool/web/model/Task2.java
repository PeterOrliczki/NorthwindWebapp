package com.codecool.web.model;

public class Task2 {

    private String company;
    private int productAmount;

    public Task2(String company, int productAmount) {
        this.company = company;
        this.productAmount = productAmount;
    }

    public String getCompany() {
        return company;
    }

    public int getProductAmount() {
        return productAmount;
    }
}
