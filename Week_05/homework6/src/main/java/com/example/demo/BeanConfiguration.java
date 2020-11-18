package com.example.demo;

import com.example.demo.OriginalJDBC.OriginalJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @program: homework6
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 22:18
 **/

@Configuration
public class BeanConfiguration {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Connection connection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Bean
    public OriginalJDBC originalJDBC() {
        return  new OriginalJDBC();
    }

}
