package com.example.demo.controller;

import com.example.demo.service.APIService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class APIControllerUnitTest {

    @InjectMocks
    private APIController apiController;

    @Mock
    private APIService apiService;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void sayHelloToControllerShouldReturnHello(){
        assertThat(apiController.sayHello()).isEqualTo("Hello!!!");
    }

    @Test
    public void greetingToControllerShouldReturnWhateverServiceReturns() throws Exception {
        String expectedValue = "MockedServiceResponseValue";
        when(apiService.greetingService(anyString())).thenReturn(expectedValue);
        assertThat(apiController.greeting()).isEqualTo(expectedValue);
    }
}