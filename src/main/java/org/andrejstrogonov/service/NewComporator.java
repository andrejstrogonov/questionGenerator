package org.andrejstrogonov.service;

import org.andrejstrogonov.domain.Question;

import java.util.Comparator;

public class NewComporator implements Comparator<Question> {

    @Override
    public int compare(Question o1, Question o2) {
        return Integer.compare(o1.getNumber(), o2.getNumber());
    }
}
