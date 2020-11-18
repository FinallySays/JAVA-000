package com.example.demo.componentScan;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @program: homeWork2
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:04
 **/

@Component
@Scope(value = "prototype")
@Data
public class Student {
    private String name;
    private Integer age;
    private String sex;
}
