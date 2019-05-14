package com.codecool.web.dao;

import com.codecool.web.model.Task5;

import java.sql.SQLException;
import java.util.List;

public interface Task5Dao {

    List<Task5> task5() throws SQLException;

    List<Task5> task5WithSearching(String company) throws SQLException;
}
