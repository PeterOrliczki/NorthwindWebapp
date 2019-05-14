package com.codecool.web.service;

import com.codecool.web.model.Task4;

import java.sql.SQLException;
import java.util.List;

public interface Task4Service {

    List<Task4> getTask4() throws SQLException;

    List<Task4> getTask4WithSearching(String company) throws SQLException;
}
