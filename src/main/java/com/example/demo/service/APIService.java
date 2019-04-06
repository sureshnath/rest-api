package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class APIService {
    /**
     *
     * @param language
     * @return Greeting String in the specified language
     */
    public String greetingService(String language) {
        String ret = null;
        switch (language) {
            case "tamil":
                ret = "Vanakam";
                break;
            case "english":
                ret = "Hello";
                break;
            case "french":
                ret = "Bonjour";
                break;
            case "thai":
                ret = "Swastika";
                break;
            default:
                ret = "Vanakam";
        }
        return ret;
    }
}
