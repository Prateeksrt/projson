package com.srt.projson;

import java.io.IOException;

public class ProJson {

    public static String jsonify(Object object) throws IllegalAccessException {
        return new JsonParser().parse(object);
    }

    public static String prettyJsonify(Object object) throws IllegalAccessException, IOException {
        return new JsonFormatter().prettify(jsonify(object));
    }

    public static <T> T objectify(String s, Class<T> theClass) throws IllegalAccessException, InstantiationException {
        T t = theClass.newInstance();
//        t.getClass().getDeclaredField("value").set(t,"prateek");
        return t;
    }
}
