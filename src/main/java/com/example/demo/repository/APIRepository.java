package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface APIRepository extends CrudRepository<Book,Long> {

    public String hello = "Hello ";

    default String greetingMethod(String string){
        return hello +string;
    }
}
