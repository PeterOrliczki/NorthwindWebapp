package com.codecool.web.service.simple;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.model.Task1;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.Task2Service;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask2Service implements Task2Service {

    private final Task2Dao task2Dao;

    public SimpleTask2Service(Task2Dao task2Dao) {
        this.task2Dao = task2Dao;
    }

    @Override
    public List<Task2> getTask2() throws SQLException {
        return task2Dao.task2();
    }

    @Override
    public List<Task2> getTask2WithSearching(String company) throws SQLException {
        return task2Dao.task2WithSearching(company);
    }
}
