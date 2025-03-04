package org.andrejstrogonov;

import org.andrejstrogonov.model.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App 
{
    @Autowired
    private QuestionService questionService;
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    public void fetchQuestionsBySubject(String subject) {
        questionService.addQuestion("subject", null);
        // Use the questionService to fetch questions by subject
        // ...
    }


}
