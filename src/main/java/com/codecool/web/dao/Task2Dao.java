package com.codecool.web.dao;

import com.codecool.web.model.Task2;

import java.sql.SQLException;
import java.util.List;

public interface Task2Dao {

    List<Task2> task2() throws SQLException;

    List<Task2> task2WithSearching(String company) throws SQLException;
}
