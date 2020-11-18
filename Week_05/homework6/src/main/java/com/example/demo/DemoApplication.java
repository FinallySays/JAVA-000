package com.example.demo;

import com.example.demo.OriginalJDBC.OriginalJDBC;
import com.example.demo.batchJDBC.BatchJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableTransactionManagement
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private OriginalJDBC originalJDBC;

    @Autowired
    private BatchJDBC batchJDBC;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        batchInsert();
        selectAll();
    }

    private void batchInsert() {
        User user1 = User.builder()
                .userName("小黄")
                .password("321")
                .build();

        User user2 = User.builder()
                .userName("小蓝")
                .password("11223")
                .build();

        User user3 = User.builder()
                .userName("小绿")
                .password("32121")
                .build();
        List<User> list = Arrays.asList(user1, user2, user3);
        batchJDBC.batchInsert(list);
    }

    private void selectAll() {
        batchJDBC.selectAll().forEach(System.out::println);
    }
}
