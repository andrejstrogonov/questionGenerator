package org.andrejstrogonov.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "questions", path = "questions")
public interface QuestionService extends PagingAndSortingRepository<Question, Long>, ListCrudRepository<Question, Long> {
    List<Question> findBooksByAuthor(String question, Pageable pageable);
}
