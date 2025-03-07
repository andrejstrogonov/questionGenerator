package org.andrejstrogonov.service;

import org.springframework.stereotype.Service;
import org.andrejstrogonov.domain.Question;
import org.andrejstrogonov.exception.ExceptionIfAvailable;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServicelmpl implements ExaminerService {
    QuestionServices questionServices;

   public ExaminerServicelmpl(QuestionServices questionServices) {
        this.questionServices = questionServices;
    }

    public Collection<Question> getQuestions(int amount) {
        if (amount > questionServices.getSizeQuestions()) {
            throw new ExceptionIfAvailable("В хранилище нет такого количества вопросов. Повторите ввод.");
        }
        Set<Question> setQuestion = new HashSet<>();
        for (int variable = 1; variable <= amount; variable++) {
            if (!setQuestion.add(questionServices.getRandomQuestion())) {
                variable--;
            }
        }
        return setQuestion;
    }
}