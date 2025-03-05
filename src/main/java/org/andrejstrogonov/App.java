package org.andrejstrogonov;

import org.andrejstrogonov.model.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = " org.andrejstrogonov")
public class App 
{
    @Autowired
    private QuestionService questionService;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
