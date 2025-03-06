package org.andrejstrogonov;

import org.andrejstrogonov.model.Question;
import org.andrejstrogonov.model.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = QuestionService.class)
@EnableTransactionManagement
class AppTest {

    @Autowired
    private QuestionService questionService;

    @BeforeEach
    void setUp() {
        questionService.save(Question.from(1L, "What do you want?", "Apple"));
        questionService.save(Question.from(2L, "Who was the first president of the United States?", "George Washington"));
        questionService.save(Question.from(3L, "What is the capital of France?", "Paris"));
    }

    @Test
    void fetchQuestionsBySubjectTest() {
        questionService.addQuestion("subject", null);
        assertEquals(1, questionService.addQuestion("subject", null).size());
        // Use the questionService to fetch questions by subject
        // ...
    }

    @Test
    void whenRequestingFirstPageOfSizeTwo_ThenReturnFirstPage() {
        Pageable pageRequest = PageRequest.of(0, 2);

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(2));
        assertTrue(result.stream()
                .map(Question::getId)
                .allMatch(id -> Arrays.asList(1L, 2L)
                        .contains(id)));
    }

    @Test
    void whenRequestingSecondPageOfSizeTwo_ThenReturnSecondPage() {
        Pageable pageRequest = PageRequest.of(1, 2);

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(2));
        assertTrue(result.stream()
                .map(Question::getId)
                .allMatch(id -> Arrays.asList(3L)
                        .contains(id)));
    }

    @Test
    void whenRequestingLastPage_ThenReturnLastPageWithRemData() {
        Pageable pageRequest = PageRequest.of(2, 2);

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(0)); // Assuming there are only 3 questions in the database
    }

    @Test
    void whenSortingByNameAscAndPaging_ThenReturnSortedPagedResult() {
        Pageable pageRequest = PageRequest.of(0, 3, Sort.by("name"));

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(3));
        assertThat(result.getContent()
                .stream()
                .map(Question::getId)
                .collect(Collectors.toList()), equalTo(Arrays.asList(1L, 2L, 3L)));
    }

    @Test
    void whenSortingByPriceDescAndPaging_ThenReturnSortedPagedResult() {
        // Assuming there is a 'price' field in the Question class
        Pageable pageRequest = PageRequest.of(0, 3, Sort.by("price")
                .descending());

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(3));
        // Assuming the prices of the questions are in descending order
        assertThat(result.getContent()
                .stream()
                .map(Question::getId)
                .collect(Collectors.toList()), equalTo(Arrays.asList(3L, 2L, 1L)));
    }

    @Test
    void whenSortingByPriceDescAndNameAscAndPaging_ThenReturnSortedPagedResult() {
        // Assuming there is a 'price' field in the Question class
        Pageable pageRequest = PageRequest.of(0, 5, Sort.by("price")
                .descending()
                .and(Sort.by("name")));

        Page<Question> result = questionService.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(5));
        // Assuming the prices of the questions are in descending order and names are in ascending order
        assertThat(result.getContent()
                .stream()
                .map(Question::getId)
                .collect(Collectors.toList()), equalTo(Arrays.asList(3L, 2L, 1L)));
    }

    @Test
    void whenRequestingFirstPageOfSizeTwoUsingCustomMethod_ThenReturnFirstPage() {
        Pageable pageRequest = PageRequest.of(0, 2);

        List<Question> result = questionService.findAllByPrice(10, pageRequest);

        assertThat(result, hasSize(2));
        assertTrue(result.stream()
                .map(Question::getId)
                .allMatch(id -> Arrays.asList(1L, 2L)
                        .contains(id)));
    }
}


