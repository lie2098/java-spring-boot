package com.lye.demoproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/helloWorld")
    public String helloWord() {
        return "Hello World";
    }
}
