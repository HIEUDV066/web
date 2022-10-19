package com.example.register.dao;

import com.example.register.model.User;

import java.sql.*;

public class LoginDAO {
    public boolean validate(User user) {
        boolean status = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?useSSL=false", "root", "minhhai1961");

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT username, password FROM user WHERE username = ? and password = ?");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            status = resultSet.next();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

}
