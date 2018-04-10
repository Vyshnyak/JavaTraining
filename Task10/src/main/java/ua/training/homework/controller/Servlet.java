package ua.training.homework.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Максим
 * 09.04.2018
 */
public class Servlet extends HttpServlet {
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "M4523021m";
    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * from car");

            while (resultSet.next()) {
                String model = resultSet.getString(2);
                String manufacture = resultSet.getString(3);
                System.out.println(model + " " + manufacture);
                resp.getWriter().write(model + " " + manufacture);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

    /*INSERT INTO car (model, manufacture) VALUES ('A8', 'Audi');
        INSERT INTO car (model, manufacture) VALUES ('X4', 'BMW');
        INSERT INTO car (model, manufacture) VALUES ('Sonata', 'Hyundai');
        INSERT INTO car (model, manufacture) VALUES ('Mustang', 'Ford');
        INSERT INTO car (model, manufacture) VALUES ('Corola', 'Toyota');
        INSERT INTO car (model, manufacture) VALUES ('Insignia', 'Opel');
        INSERT INTO car (model, manufacture) VALUES ('Pajero', 'Mitsubihsi');*/

    /*INSERT INTO driver (name, telephone) VALUES ('Maksym', '0971856453');
        INSERT INTO driver (name, telephone) VALUES ('Igor', '0634572654');
        INSERT INTO driver (name, telephone) VALUES ('Roman', '0957674473');
        INSERT INTO driver (name, telephone) VALUES ('Vladimir', '0934567665');
        INSERT INTO driver (name, telephone) VALUES ('Artem', '0683467521');
        INSERT INTO driver (name, telephone) VALUES ('Sergey', '0630984536');
        INSERT INTO driver (name, telephone) VALUES ('Oleksey', '0975479274');*/

    /*INSERT INTO car_driver (car, driver) VALUES (1, 1);
        INSERT INTO car_driver (car, driver) VALUES (1, 3);
        INSERT INTO car_driver (car, driver) VALUES (2, 4);
        INSERT INTO car_driver (car, driver) VALUES (3, 3);
        INSERT INTO car_driver (car, driver) VALUES (4, 6);
        INSERT INTO car_driver (car, driver) VALUES (5, 2);
        INSERT INTO car_driver (car, driver) VALUES (5, 7);
        INSERT INTO car_driver (car, driver) VALUES (6, 3);
        INSERT INTO car_driver (car, driver) VALUES (7, 6);
        INSERT INTO car_driver (car, driver) VALUES (7, 1);
        INSERT INTO car_driver (car, driver) VALUES (6, 4);*/