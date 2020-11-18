package com.geekbang.myspringbootstarter.components;

import lombok.Builder;
import lombok.Data;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:42
 **/

@Data
@Builder
public class Student {
    private String name;
    private Integer age;
}
