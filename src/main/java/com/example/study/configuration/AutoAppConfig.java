package com.example.study.configuration;

import com.example.study.StudyApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(
        basePackages = "com.example.study",
        basePackageClasses = StudyApplication.class,
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = Configuration.class
                )
        }

)
public class AutoAppConfig {
}
