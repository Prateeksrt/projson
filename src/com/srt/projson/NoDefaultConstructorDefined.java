package com.srt.projson;

public class NoDefaultConstructorDefined extends RuntimeException {
    public <T> NoDefaultConstructorDefined(Class<T> clazz) {
        super(clazz.getSimpleName()+" Does not have a default constructor defined");
    }
}
