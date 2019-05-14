package com.codecool.web.service;

import com.codecool.web.model.Task2;

import java.sql.SQLException;
import java.util.List;

public interface Task2Service {

    List<Task2> getTask2() throws SQLException;

    List<Task2> getTask2WithSearching(String company) throws SQLException;
}
