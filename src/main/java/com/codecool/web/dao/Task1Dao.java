package com.codecool.web.dao;

import com.codecool.web.model.Task1;

import java.sql.SQLException;
import java.util.List;

public interface Task1Dao {

    List<Task1> task1() throws SQLException;

    List<Task1> task1WithSearching(String company) throws SQLException;
}
