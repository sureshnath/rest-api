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

    @Autowired
    APIService apiService;

    @Test
    public void greetingServiceUnitTest() {
        assertThat("Vanakam",is(apiService.greetingService("tamil")));
        assertThat("Hello",is(apiService.greetingService("english")));
        assertThat("Bonjour",is(apiService.greetingService("french")));
        assertThat("Swastika",is(apiService.greetingService("thai")));
        assertThat("Vanakam",is(apiService.greetingService("default")));
        assertThat("Vanakam",is(apiService.greetingService("unknown")));
    }
}