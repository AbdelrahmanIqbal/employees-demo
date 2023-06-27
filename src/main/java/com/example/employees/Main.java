package com.example.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    public Main() {
    }

    @GetMapping
    String welcome(){
        return "<h1>Welcome</h1>";
    }

}
