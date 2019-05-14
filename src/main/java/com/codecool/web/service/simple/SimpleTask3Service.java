package com.codecool.web.service.simple;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.model.Task3;
import com.codecool.web.service.Task3Service;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask3Service implements Task3Service {

    private final Task3Dao task3Dao;

    public SimpleTask3Service(Task3Dao task3Dao) {
        this.task3Dao = task3Dao;
    }

    @Override
    public List<Task3> getTask3() throws SQLException {
        return task3Dao.task3();
    }

    @Override
    public List<Task3> getTask3WithSearching(String company) throws SQLException {
        return task3Dao.task3WithSearching(company);
    }
}
