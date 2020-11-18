package com.example.demo;

import com.geekbang.myspringbootstarter.components.Klass;
import com.geekbang.myspringbootstarter.components.School;
import com.geekbang.myspringbootstarter.components.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private Student student;

    @Autowired
    private Klass klass;

    @Autowired
    private School school;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(student);
        System.out.println(klass);
        System.out.println(school);
    }
}
