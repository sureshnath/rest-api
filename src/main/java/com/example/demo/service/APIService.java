package com.example.demo.service;

import com.example.demo.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
public class APIService  {

    @Autowired
    private APIRepository apiRepository;

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


    /**
     *
     * @return String from Repository method
     */
    public String repositoryMethod(String string){
        return apiRepository.greetingMethod(string);
    }

}
