package com.geekbang.myspringbootstarter.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: my-spring-boot-starter
 * @description:
 * @author: Shiwp
 * @create: 2020-11-18 20:48
 **/

@ConfigurationProperties(prefix = "klass")
@Data
public class KlassProperties {
    private String name;
    private Integer count;
}
