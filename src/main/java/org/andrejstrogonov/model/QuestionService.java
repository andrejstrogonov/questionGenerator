package org.andrejstrogonov.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionService extends PagingAndSortingRepository<Question, Long>, ListCrudRepository<Question, Long> {
    @Autowired
    Set<Question> addQuestion(String question, Pageable pageable);
    @Autowired
    List<Question> findAllByPrice(int i, Pageable pageRequest);
}
