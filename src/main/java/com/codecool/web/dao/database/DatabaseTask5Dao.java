package com.codecool.web.dao.database;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask5Dao extends AbstractDao implements Task5Dao {

    public DatabaseTask5Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task5> task5() throws SQLException {
        List<Task5> task5Results = new ArrayList<>();
        String sql = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products INNER JOIN suppliers ON suppliers.supplier_id = products.supplier_id JOIN (SELECT products.supplier_id, MAX(products.unit_price) AS max_unit FROM products GROUP BY products.supplier_id) AS try ON products.supplier_id = try.supplier_id AND products.unit_price = try.max_unit ORDER BY unit_price DESC";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task5Results.add(fetchTask5(resultSet));
            }
        }
        return task5Results;
    }

    @Override
    public List<Task5> task5WithSearching(String company) throws SQLException {
        List<Task5> task5Results = new ArrayList<>();
        String sql = "SELECT suppliers.company_name, products.product_name, products.unit_price FROM products INNER JOIN suppliers on suppliers.supplier_id = products.supplier_id JOIN (SELECT products.supplier_id, MAX(products.unit_price) AS max_unit FROM products GROUP BY products.supplier_id) AS try ON products.supplier_id = try.supplier_id AND products.unit_price = try.max_unit WHERE company_name=? ORDER BY unit_price DESC";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task5Results.add(fetchTask5(resultSet));
                }
            }
        }
        return task5Results;
    }

    private Task5 fetchTask5(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company_name");
        String product = resultSet.getString("product_name");
        int price = resultSet.getInt("unit_price");
        return new Task5(company, product, price);
    }
}
