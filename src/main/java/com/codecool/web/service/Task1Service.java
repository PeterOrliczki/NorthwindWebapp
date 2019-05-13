package com.codecool.web.service;

import com.codecool.web.model.Task1;

import java.sql.SQLException;
import java.util.List;

public interface Task1Service {

    List<Task1> getTask1() throws SQLException;

    List<Task1> getTask1WithSearching(String company) throws SQLException;
}
