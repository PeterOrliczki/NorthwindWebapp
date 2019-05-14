package com.codecool.web.service;

import com.codecool.web.model.Task3;

import java.sql.SQLException;
import java.util.List;

public interface Task3Service {

    List<Task3> getTask3() throws SQLException;

    List<Task3> getTask3WithSearching(String company) throws SQLException;
}
