package com.example.demo.configuration;

import com.example.demo.componentScan.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: homeWork2
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:16
 **/

@Configuration
public class KlassConfiguration {
    @Autowired
    private Student student;

    @Bean
    @Scope(value = "prototype")
    public Klass klass() {
        student.setName("小红");
        student.setAge(18);
        student.setSex("女");
        Klass klass = new Klass("一班", new HashMap<>());
        klass.getStudents().put(student.getName(), student);
        return klass;
    }
}
