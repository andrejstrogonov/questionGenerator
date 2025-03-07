package org.andrejstrogonov.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.andrejstrogonov.domain.Question;
import org.andrejstrogonov.exception.ExceptionIfAvailable;
import org.andrejstrogonov.service.ExaminerServicelmpl;

import java.util.Collection;

@RestController
public class ExamController {
    private final ExaminerServicelmpl examineServicelmpl;

    public ExamController(ExaminerServicelmpl examineServicelmpl) {
        this.examineServicelmpl = examineServicelmpl;
    }

    @ExceptionHandler(ExceptionIfAvailable.class)
    public ResponseEntity<String> noNunberQuestion(ExceptionIfAvailable e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("HttpStatus= "+HttpStatus.BAD_REQUEST+".    "+e.getMessage());
    }
    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examineServicelmpl.getQuestions(amount);
    }

}
