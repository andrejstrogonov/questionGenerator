package org.andrejstrogonov.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionService extends ListCrudRepository<Question, Long> {
    Set<Question> addQuestion(String question, Pageable pageable);
    Set<Question> removeQuestion(String question, Pageable pageable);
    Set<Question> getRandomQuestion(String answer, Pageable pageable);

}
