package com.codecool.web.dao;

import com.codecool.web.model.Task3;

import java.sql.SQLException;
import java.util.List;

public interface Task3Dao {

    List<Task3> task3() throws SQLException;

    List<Task3> task3WithSearching(String company) throws SQLException;
}
