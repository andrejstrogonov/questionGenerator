package org.andrejstrogonov.service;

import org.andrejstrogonov.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
