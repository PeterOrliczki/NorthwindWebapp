package com.codecool.web.service.simple;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.model.Task5;
import com.codecool.web.service.Task5Service;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask5Service implements Task5Service {

    private final Task5Dao task5Dao;

    public SimpleTask5Service(Task5Dao task5Dao) {
        this.task5Dao = task5Dao;
    }

    @Override
    public List<Task5> getTask5() throws SQLException {
        return task5Dao.task5();
    }

    @Override
    public List<Task5> getTask5WithSearching(String company) throws SQLException {
        return task5Dao.task5WithSearching(company);
    }
}
