package com.srt.projson;

public class NoDefaultConstructorException extends RuntimeException {
    public <T> NoDefaultConstructorException(Class<T> clazz) {
        super(clazz.getSimpleName()+" Does not have a default constructor defined");
    }
}
