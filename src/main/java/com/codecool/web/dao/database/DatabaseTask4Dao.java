package com.codecool.web.dao.database;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseTask4Dao extends AbstractDao implements Task4Dao {

    public DatabaseTask4Dao(Connection connection) {
        super(connection);
    }

    @Override
    public List<Task4> task4() throws SQLException {
        List<Task4> task4Results = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id GROUP BY customers.company_name ORDER BY company ASC;";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                task4Results.add(fetchTask4(resultSet));
            }
        }
        return task4Results;
    }

    @Override
    public List<Task4> task4WithSearching(String company) throws SQLException {
        List<Task4> task4Results = new ArrayList<>();
        String sql = "SELECT company_name AS company, ARRAY_AGG(order_id) AS order_id FROM customers LEFT JOIN orders ON customers.customer_id = orders.customer_id WHERE company_name=? GROUP BY customers.company_name ORDER BY company ASC;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, company);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    task4Results.add(fetchTask4(resultSet));
                }
            }
        }
        return task4Results;
    }

    private Task4 fetchTask4(ResultSet resultSet) throws SQLException {
        List<Integer> orderIDs = new ArrayList<>();
        String company = resultSet.getString("company");
        Array OrderIdsFromRsSet = resultSet.getArray("order_id");
        Short[] orderIdArray = (Short[]) OrderIdsFromRsSet.getArray();
        for (Short id : orderIdArray) {
            if (id == null) {
                id = 0;
            }
            int num = Integer.valueOf(id);
            orderIDs.add(num);
        }
        return new Task4(company, orderIDs);
    }
}
