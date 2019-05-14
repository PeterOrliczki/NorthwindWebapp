package com.codecool.web.dao.database;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask2Dao extends AbstractDao implements Task2Dao {

    public DatabaseTask2Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task2> task2() throws SQLException {
        List<Task2> task2Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company, COUNT(product_name) as product_amount from products JOIN suppliers on products.supplier_id = suppliers.supplier_id GROUP BY suppliers.company_name ORDER BY product_amount DESC, Company;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task2Results.add(fetchTask2(resultSet));
            }
        }
        return task2Results;
    }

    @Override
    public List<Task2> task2WithSearching(String company) throws SQLException {
        List<Task2> task2Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company, COUNT(product_name) as product_amount from products JOIN suppliers on products.supplier_id = suppliers.supplier_id WHERE company_name=? GROUP BY suppliers.company_name ORDER BY product_amount DESC, Company;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task2Results.add(fetchTask2(resultSet));
                }
            }
        }
        return task2Results;
    }

    private Task2 fetchTask2(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        int productAmount = resultSet.getInt("product_amount");
        return new Task2(company, productAmount);
    }
}
