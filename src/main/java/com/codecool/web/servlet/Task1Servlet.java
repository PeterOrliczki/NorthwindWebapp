package com.codecool.web.servlet;

import com.codecool.web.dao.Task1Dao;
import com.codecool.web.dao.database.DatabaseTask1Dao;
import com.codecool.web.model.Task1;
import com.codecool.web.service.Task1Service;
import com.codecool.web.service.simple.SimpleTask1Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/task1")
public class Task1Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            Task1Service task1Service = new SimpleTask1Service(task1Dao);

            List<Task1> task1 = task1Service.getTask1();
            req.setAttribute("task1", task1);

            req.getRequestDispatcher("task-1.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task1Dao task1Dao = new DatabaseTask1Dao(connection);
            Task1Service taskService = new SimpleTask1Service(task1Dao);

            String company = req.getParameter("filter");

            List<Task1> task1 = taskService.getTask1WithSearching(company);
            req.setAttribute("task1", task1);

            req.getRequestDispatcher("task-1.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
}
