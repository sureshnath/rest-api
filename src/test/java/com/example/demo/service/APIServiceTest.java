package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = APIService.class)
public class APIServiceTest {

    static final String VANAKAM = "Vanakam";

    @Autowired
    APIService apiService;

    @Test
    public void greetingServiceUnitTest() {
        assertThat(VANAKAM,is(apiService.greetingService("tamil")));
        assertThat("Hello",is(apiService.greetingService("english")));
        assertThat("Bonjour",is(apiService.greetingService("french")));
        assertThat("Swastika",is(apiService.greetingService("thai")));
        assertThat(VANAKAM,is(apiService.greetingService("default")));
        assertThat(VANAKAM,is(apiService.greetingService("unknown")));
    }

    @Test
    public void repositoryMethodUnitTest(){
        assertThat("Hello Java",is(apiService.repositoryMethod("Java")));
    }
}