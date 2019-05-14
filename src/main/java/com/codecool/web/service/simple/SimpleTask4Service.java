package com.codecool.web.service.simple;

import com.codecool.web.dao.Task4Dao;
import com.codecool.web.model.Task4;
import com.codecool.web.service.Task4Service;

import java.sql.SQLException;
import java.util.List;

public final class SimpleTask4Service implements Task4Service {

    private final Task4Dao task4Dao;

    public SimpleTask4Service(Task4Dao task4Dao) {
        this.task4Dao = task4Dao;
    }

    @Override
    public List<Task4> getTask4() throws SQLException {
        return task4Dao.task4();
    }

    @Override
    public List<Task4> getTask4WithSearching(String company) throws SQLException {
        return task4Dao.task4WithSearching(company);
    }
}
