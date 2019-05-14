package com.codecool.web.dao.database;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.model.Task1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask1Dao extends AbstractDao implements Task1Dao {

    public DatabaseTask1Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task1> task1() throws SQLException {
        List<Task1> task1Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company, product_name AS Product FROM products INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id ORDER BY Product;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task1Results.add(fetchTask1(resultSet));
            }
        }
        return task1Results;
    }

    @Override
    public List<Task1> task1WithSearching(String company) throws SQLException {
        List<Task1> task1Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company, product_name AS Product FROM products INNER JOIN suppliers ON products.supplier_id = suppliers.supplier_id WHERE company_name=? ORDER BY Product;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task1Results.add(fetchTask1(resultSet));
                }
            }
        }
        return task1Results;
    }

    private Task1 fetchTask1(ResultSet resultSet) throws SQLException {
        String product = resultSet.getString("product");
        String company = resultSet.getString("company");
        return new Task1(product, company);
    }
}
