package com.example.demo.xml;

import com.example.demo.configuration.Klass;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @program: homeWork2
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:21
 **/


@Data
public class School {
    private String name;
    private Map<String, Klass> klasses;
}
