package com.example.demo.OriginalJDBC;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: homework6
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 22:19
 **/

public class OriginalJDBC {

    @Autowired
    private Connection connection;

    public boolean insert(User user) {
        Statement statement = null;
        boolean flag = false;
        try {
            statement = connection.createStatement();
            String sql = "insert into users(username, `password`) values('" + user.getUserName() + "','" + user.getPassword() + "');";
            flag = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return flag;
    }

    public boolean update(User user, Long id) {
        Statement statement = null;
        boolean flag = false;
        try {
            statement = connection.createStatement();
            String sql = "update users set username = '" + user.getUserName()
                    + "', `password` = '" + user.getPassword() + "' where id = " + id + ";";
            flag = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return flag;
    }

    public User select(Long id) {
        Statement statement = null;
        User user = new User();
        try {
            statement = connection.createStatement();
            String sql = "select * from users where id = " + id;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                user.setId(rs.getLong(1));
                user.setUserName(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return user;
    }

    public boolean delete(Long id) {
        Statement statement = null;
        boolean flag = false;
        try {
            statement = connection.createStatement();
            String sql = "delete from users where id = " + id;
            flag = statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null)
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return flag;
    }


}
