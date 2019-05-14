package com.codecool.web.servlet;

import com.codecool.web.dao.Task2Dao;
import com.codecool.web.dao.database.DatabaseTask2Dao;
import com.codecool.web.model.Task2;
import com.codecool.web.service.Task2Service;
import com.codecool.web.service.simple.SimpleTask2Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/task2")
public class Task2Servlet extends AbstractServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service task2Service = new SimpleTask2Service(task2Dao);

            List<Task2> task2 = task2Service.getTask2();
            req.setAttribute("task2", task2);

            req.getRequestDispatcher("task-2.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task2Dao task2Dao = new DatabaseTask2Dao(connection);
            Task2Service taskService = new SimpleTask2Service(task2Dao);

            String company = req.getParameter("filter");
            List<Task2> task2 = taskService.getTask2WithSearching(company);
            req.setAttribute("task2", task2);

            req.getRequestDispatcher("task-2.jsp").forward(req, resp);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }
}
