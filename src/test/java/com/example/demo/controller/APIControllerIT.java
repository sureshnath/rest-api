package com.example.demo.controller;

import com.example.demo.service.APIService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class APIControllerIT {

    TestRestTemplate testRestTemplate = new TestRestTemplate();
    HttpHeaders httpHeaders = new HttpHeaders();

    @LocalServerPort
    private int port;

    @Autowired
    APIService apiService;

    @Test
    public void sayHello() {

        HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);

        ResponseEntity<String> responseEntity = testRestTemplate.exchange(createURLWithPort("/hello"), HttpMethod.GET,entity,String.class);

        String expected = "Hello!!!";

//      Weak Testing
        assertEquals(expected,responseEntity.getBody());
//      Normal Testing
        assertThat(expected,is(responseEntity.getBody()));

    }


    @Test
    public void repositoryMethodIT(){
        assertThat("Hello Ravi",is(apiService.repositoryMethod("Ravi")));
    }




    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }


}