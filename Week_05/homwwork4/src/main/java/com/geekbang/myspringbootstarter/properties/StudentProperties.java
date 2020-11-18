package com.geekbang.myspringbootstarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 21:02
 **/

@ConfigurationProperties(prefix = "student")
@Data
public class StudentProperties {
    private String name;
}
