package com.example.study.member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Member {
    private Long id;
    private String name;
    private Grade grade;

}
