package org.andrejstrogonov.service;

import org.andrejstrogonov.domain.Question;

import java.util.Collection;

public interface QuestionServices {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Question remove(String question, String answer);

    Collection<Question> getAll();

    Question getRandomQuestion();

    int getSizeQuestions();

}
