package com.geekbang.myspringbootstarter.properties;

import com.geekbang.myspringbootstarter.components.Student;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.Random;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:46
 **/

@ConfigurationProperties(prefix = "school")
@Data
public class SchoolProperty {
    private String name;
    private Integer count;

}
