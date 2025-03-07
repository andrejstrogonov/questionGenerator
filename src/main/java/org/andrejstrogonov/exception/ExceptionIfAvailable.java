package org.andrejstrogonov.exception;

public class ExceptionIfAvailable extends IllegalArgumentException{
    public ExceptionIfAvailable(String s) {
        super(s);
    }
    public ExceptionIfAvailable() {
    }

}
