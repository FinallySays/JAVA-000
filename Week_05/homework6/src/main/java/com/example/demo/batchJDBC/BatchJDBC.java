package com.example.demo.batchJDBC;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @program: homework6
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 22:55
 **/


@Component
public class BatchJDBC {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void batchInsert(List<User> users) {
        jdbcTemplate.batchUpdate("insert into users (username, password) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        User user = users.get(i);
                        preparedStatement.setString(1, user.getUserName());
                        preparedStatement.setString(2, user.getPassword());
                    }

                    @Override
                    public int getBatchSize() {
                        return users.size();
                    }
                });
    }

    public void update(User user) {
        jdbcTemplate.update("update users set username = ?, password = ? where id = ?"
                , user.getUserName(), user.getPassword(), user.getId());
    }

    public void delete(Long id) {
        jdbcTemplate.update("delete from users where  id = ?", id);
    }

    public List<User> selectAll() {
        return jdbcTemplate.query("select * from users", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                return User.builder()
                        .id(resultSet.getLong(1))
                        .userName(resultSet.getString(2))
                        .password(resultSet.getString(3))
                        .build();
            }
        });
//        return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<User>());
    }
}
