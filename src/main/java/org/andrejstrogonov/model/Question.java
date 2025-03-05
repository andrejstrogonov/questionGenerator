package org.andrejstrogonov.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;
    private String answer;

    public Question() {
        super();
    }

    private Question(Long id, String question, String answer) {
        super();
        this.id = id;
        this.question = question;
        this.answer = answer;
    }
    public static Question from(Long id, String question, String answer) {
        return new Question(id, question, answer);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Question{");
        builder.append("id=").append(id);
        builder.append(", question='").append(question).append('\'');
        builder.append(", answer='").append(answer).append('\'');
        builder.append('}');
        return builder.toString();
    }
}
