package com.example.demo.configuration;

import com.example.demo.componentScan.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @program: homeWork2
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:17
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Klass {
    private String name;
    private Map<String, Student> students;
}
