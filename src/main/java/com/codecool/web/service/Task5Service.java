package com.codecool.web.service;

import com.codecool.web.model.Task5;

import java.sql.SQLException;
import java.util.List;

public interface Task5Service {

    List<Task5> getTask5() throws SQLException;

    List<Task5> getTask5WithSearching(String company) throws SQLException;
}
