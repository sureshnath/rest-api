package com.example.demo.controller;

import com.example.demo.service.APIService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {APIService.class,APIController.class})
public class APIControllerUnitTest {

    MockMvc mockMvc;

    @Autowired
    private APIController apiController;

    @MockBean
    private APIService apiService;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void sayHello() throws Exception {
//        when(apiController.greeting()).thenReturn("Hello Ravi");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString(),is("Hello!!!"));
    }

    @Test
    public void greeting() throws Exception {

        when(apiService.greetingService(anyString())).thenReturn("Hello Ravi");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/greetings")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertThat(mvcResult.getResponse().getContentAsString(),is("Hello Ravi"));

    }
}