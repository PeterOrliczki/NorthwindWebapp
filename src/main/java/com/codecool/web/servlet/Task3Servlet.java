package com.codecool.web.servlet;

import com.codecool.web.dao.Task3Dao;
import com.codecool.web.dao.database.DatabaseTask3Dao;
import com.codecool.web.model.Task3;
import com.codecool.web.service.Task3Service;
import com.codecool.web.service.simple.SimpleTask3Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/task3")
public class Task3Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service task3Service = new SimpleTask3Service(task3Dao);

            List<Task3> task3 = task3Service.getTask3();
            req.setAttribute("task3", task3);

            req.getRequestDispatcher("task-3.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task3Dao task3Dao = new DatabaseTask3Dao(connection);
            Task3Service taskService = new SimpleTask3Service(task3Dao);

            String company = req.getParameter("filter");
            List<Task3> task3 = taskService.getTask3WithSearching(company);
            req.setAttribute("task3", task3);

            req.getRequestDispatcher("task-3.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
