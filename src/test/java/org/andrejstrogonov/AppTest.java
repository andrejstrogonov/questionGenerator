package org.andrejstrogonov;

import org.andrejstrogonov.model.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AppTest{
    @Autowired
    private QuestionService questionService;

    @Test
    public void fetchQuestionsBySubjectTest() {
        questionService.addQuestion("subject", null);
        assertEquals(1, questionService.addQuestion("subject", null).size());
        // Use the questionService to fetch questions by subject
        // ...
    }


}


