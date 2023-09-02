package com.example.study.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;


@Configuration
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = MyIncludeComponent.class),
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = MyExcludeComponent.class)
)
public class ComponentFilterAppConfig {
}
