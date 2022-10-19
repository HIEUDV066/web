package com.example.register.dao;

import com.example.register.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
    public int registerUser(User user) {
        String INSERT_USERS_SQL = "INSERT INTO user" +
                "  (first_name, last_name, username, password, address, contact) VALUES " +
                " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", "minhhai1961");

            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAddress());
            preparedStatement.setString(6, user.getContact());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException e) {
            System.out.println("Cannot find MySQL Driver");
            throw new RuntimeException(e);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            throw new RuntimeException(e);
        }

        return result;
    }
}
