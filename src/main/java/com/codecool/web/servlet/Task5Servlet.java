package com.codecool.web.servlet;

import com.codecool.web.dao.Task5Dao;
import com.codecool.web.dao.database.DatabaseTask5Dao;
import com.codecool.web.model.Task5;
import com.codecool.web.service.Task5Service;
import com.codecool.web.service.simple.SimpleTask5Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/task5")
public class Task5Servlet extends AbstractServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service task5Service = new SimpleTask5Service(task5Dao);

            List<Task5> task5 = task5Service.getTask5();
            req.setAttribute("task5", task5);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task-5.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (Connection connection = getConnection(req.getServletContext())) {
            Task5Dao task5Dao = new DatabaseTask5Dao(connection);
            Task5Service taskService = new SimpleTask5Service(task5Dao);
            String company = req.getParameter("filter");
            List<Task5> task5 = taskService.getTask5WithSearching(company);
            req.setAttribute("task5", task5);

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

        req.getRequestDispatcher("task-5.jsp").forward(req, resp);
    }
}
