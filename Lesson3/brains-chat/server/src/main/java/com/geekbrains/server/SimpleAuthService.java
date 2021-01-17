package com.geekbrains.server;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleAuthService implements AuthService {
    private class UserData {
        private String login;
        private String password;
        private String nickname;

        public UserData(String login, String password, String nickname) {
            this.login = login;
            this.password = password;
            this.nickname = nickname;
        }
    }

    private List<UserData> users;

    public SimpleAuthService() {
        this.users = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:brains-chat/loginDB.db");
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT * FROM users;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()){
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String nick = resultSet.getString("name");
                users.add(new UserData(login, password, nick));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String getNicknameByLoginAndPassword(String login, String password) {
        for (UserData o : users) {
            if (o.login.equals(login) && o.password.equals(password)) {
                return o.nickname;
            }
        }
        return null;
    }
}
