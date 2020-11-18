package com.example.demo;

import com.example.demo.componentScan.Student;
import com.example.demo.configuration.Klass;
import com.example.demo.xml.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private Student student;

    @Autowired
    private Klass klass;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(klass);
        ApplicationContext ac = new ClassPathXmlApplicationContext("school.xml");
        School school = ac.getBean("school", School.class);
        System.out.println(school);
    }
}
