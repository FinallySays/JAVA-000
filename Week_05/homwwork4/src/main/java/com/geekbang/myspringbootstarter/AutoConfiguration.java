package com.geekbang.myspringbootstarter;

import com.geekbang.myspringbootstarter.components.Klass;
import com.geekbang.myspringbootstarter.components.School;
import com.geekbang.myspringbootstarter.components.Student;
import com.geekbang.myspringbootstarter.properties.KlassProperties;
import com.geekbang.myspringbootstarter.properties.SchoolProperty;
import com.geekbang.myspringbootstarter.properties.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:47
 **/

@Configuration
@EnableConfigurationProperties(value = {SchoolProperty.class, KlassProperties.class, StudentProperties.class})
public class AutoConfiguration {

    @Autowired
    private SchoolProperty schoolProperty;

    @Autowired
    private KlassProperties klassProperties;

    @Autowired
    private StudentProperties studentProperties;

    @Bean
    @Scope("prototype")
    public Student student() {
        return Student.builder()
                .age(new Random().nextInt(20))
                .name(studentProperties.getName())
                .build();
    }

    @Bean
    @Scope("prototype")
    public Klass klass() {
        Klass klass = Klass.builder()
                .name(klassProperties.getName())
                .students(new HashMap<>()).build();

        IntStream.range(1, klassProperties.getCount() + 1)
                .forEach(i -> {
                    Student student = student();
                    student.setName("student" + i);
                    klass.getStudents().put(student.getName(), student);
                });

        return klass;
    }

    @Bean
    @Scope("prototype")
    public School school() {
        School school = School.builder()
                .name(schoolProperty.getName())
                .klasses(new HashMap<>()).build();

        IntStream.range(1, schoolProperty.getCount() + 1)
                .forEach(i -> {
                    Klass klass = klass();
                    klass.setName(i + "班");
                    school.getKlasses().put(klass.getName(), klass);
                });

        return school;
    }
}
