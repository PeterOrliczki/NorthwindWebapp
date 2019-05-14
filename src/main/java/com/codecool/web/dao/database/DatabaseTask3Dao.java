package com.codecool.web.dao.database;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask3Dao extends AbstractDao implements Task3Dao {

    public DatabaseTask3Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task3> task3() throws SQLException {
        List<Task3> task3Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company FROM suppliers INNER JOIN products ON suppliers.supplier_id = products.supplier_id GROUP BY Company HAVING COUNT(products.supplier_id) >= 5 ORDER BY Company;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task3Results.add(fetchTask3(resultSet));
            }
        }
        return task3Results;
    }

    @Override
    public List<Task3> task3WithSearching(String company) throws SQLException {
        List<Task3> task3Results = new ArrayList<>();
        String sql = "SELECT company_name AS Company FROM suppliers INNER JOIN products ON suppliers.supplier_id = products.supplier_id WHERE company_name=? GROUP BY Company HAVING COUNT(products.supplier_id) >= 5 ORDER BY Company;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task3Results.add(fetchTask3(resultSet));
                }
            }
        }
        return task3Results;
    }

    private Task3 fetchTask3(ResultSet resultSet) throws SQLException {
        String company = resultSet.getString("company");
        return new Task3(company);
    }
}
