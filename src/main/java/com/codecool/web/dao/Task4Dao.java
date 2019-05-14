package com.codecool.web.dao;

import com.codecool.web.model.Task4;

import java.sql.SQLException;
import java.util.List;

public interface Task4Dao {

    List<Task4> task4() throws SQLException;

    List<Task4> task4WithSearching(String company) throws SQLException;
}
