package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReturnTest {
    @RequestMapping("/returntest/{a}/{b}")
    public int[] addOperater (
        @PathVariable int a
        , @PathVariable int b){
            int[] answer = new int[] {a,b};
            System.out.println(answer);
            return answer;
        }
}
