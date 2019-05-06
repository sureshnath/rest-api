package com.example.demo.controller;

import com.example.demo.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan("com.example.demo.service")
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello!!!";
    }

    @GetMapping("/greetings")
    public String greeting(){
       return apiService.greetingService("Ravi");
    }

    @GetMapping("/jenkinsTest")
    public String JenkingsTest(){
        return "Hello from Jenkins";
    }

    @GetMapping("/helloRepo")
    public String helloFromRepo(){
     return apiService.repositoryMethod("Ravi");
    }
    
}
