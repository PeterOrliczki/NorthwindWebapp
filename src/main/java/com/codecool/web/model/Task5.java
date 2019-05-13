package com.codecool.web.model;

public class Task5 {

    private String company;
    private String product;
    private int price;

    public Task5(String company, String product, int price) {
        this.company = company;
        this.product = product;
        this.price = price;
    }

    public String getCompany() {
        return company;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }
}
