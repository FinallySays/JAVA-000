package com.geekbang.myspringbootstarter.components;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:44
 **/

@Data
@Builder
public class Klass {
    private String name;
    private Map<String, Student> students;
}
