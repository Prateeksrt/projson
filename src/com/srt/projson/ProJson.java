package com.srt.projson;

import java.io.IOException;
import java.lang.reflect.Field;

public class ProJson {

    public static String jsonify(Object object) throws IllegalAccessException {
        return new JsonParser().parse(object);
    }

    public static String prettyJsonify(Object object) throws IllegalAccessException, IOException {
        return new JsonFormatter().prettify(jsonify(object));
    }

    public static <T> T objectify(String s, Class<T> theClass) throws IllegalAccessException, NoSuchFieldException {

        T t;
        try {
            t = theClass.newInstance();
        } catch (InstantiationException e) {
            throw new NoDefaultConstructorException(theClass);
        }
        String s1 = removeDelimiter(s);
        for(String s2 : s1.split(",")){
            Field value = t.getClass().getDeclaredField(removeQuotes(s2.split(":")[0]));
            value.setAccessible(true);
            value.set(t,getValue(s2.split(":")[1]));
        }
        return t;
    }

    private static Object getValue(String stringValue) {
        if(stringValue.matches("[0-9]*")){
            return Integer.parseInt(stringValue);
        }
        return removeQuotes(stringValue);
    }

    private static String removeQuotes(String stringValue) {
        String newString;
        if(stringValue.endsWith("\'")||stringValue.endsWith("\"")){
            newString=stringValue.substring(0,stringValue.length()-1);
        }else newString = stringValue;
        if(newString.startsWith("\'")||newString.startsWith("\""))
            newString = newString.substring(1,newString.length());
        return newString;
    }

    private static String removeDelimiter(String s) {
        StringBuilder builder = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(JsonFormatter.backwardTabDelimiter.contains(ch)||
                    JsonFormatter.forwardTabDelimiters.contains(ch))continue;
            builder.append(ch);
        }
        return builder.toString();
    }
}
