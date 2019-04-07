package com.example.demo.repository;

public interface APIRepository  {

    public String hello = "Hello ";

    default String greetingMethod(String string){
        return hello +string;
    }
}
