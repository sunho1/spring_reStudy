package com.example.study.configuration;


import java.lang.annotation.*;

@Target(ElementType.TYPE)
//@Target(ElementTyp)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
