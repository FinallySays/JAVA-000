package com.geekbang.myspringbootstarter.components;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:45
 **/

@Data
@Builder
public class School {
    private String name;
    private Map<String, Klass> klasses;
}
