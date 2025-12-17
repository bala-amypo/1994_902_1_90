package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class Basic{
    @GetMapping("/home")
    public String name(){
        return "hello world";
    }
}