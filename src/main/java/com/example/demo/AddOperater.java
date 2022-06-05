package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddOperater {
    @RequestMapping("/add/{a}/{b}")
    public int addOperater (
        @PathVariable int a
        , @PathVariable int b){
            return a + b;
        }
}
