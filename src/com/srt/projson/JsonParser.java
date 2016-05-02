package com.srt.projson;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class JsonParser {
    public String parse(Object demo) throws IllegalAccessException {
        Field[] declaredFields = getNonSyntheticNonTransientDeclaredFields(demo);
        String json = "{";
        for (int i = 0; i < declaredFields.length; i++) {
            Field field = declaredFields[i];
            field.setAccessible(true);
            Class<?> objectType = field.getType();
            Object objectValue = field.get(demo);
            json += "'" + field.getName() + "':";
            json += getJsonString(objectType, objectValue);

            if (i + 1 != declaredFields.length) {
                json += ",";
            }
        }
        json += "}";
        return json;
    }

    private String getJsonString(Class<?> objectType, Object objectValue) throws IllegalAccessException {
        System.out.println();
        if (objectType.isArray()) {
            return getArrayAsJsonString((Object[]) objectValue);
        } else if (objectValue instanceof Collection) {
            return getArrayAsJsonString(((Collection) objectValue).toArray());
        } else if (objectValue instanceof Number) {
            return  objectValue.toString() ;
        } else if(objectType.equals(Boolean.TYPE)||objectType.equals(Boolean.class)){
            return objectValue.toString();
        } else if (objectType.isPrimitive()){
            return "'" + objectValue + "'";
        } else if (Arrays.asList(objectValue.getClass().getInterfaces()).contains(Serializable.class)){
            return "'"+objectValue.toString()+"'";
        } else {
            return parse(objectValue);
        }
    }

    private String getArrayAsJsonString(Object[] objects) throws IllegalAccessException {
        String json = "[";
        for (int i = 0; i < objects.length; i++) {
            Object object = objects[i];
            json += getJsonString(object.getClass(),object);
            if (i + 1 != objects.length) {
                json += ",";
            }
        }
        json += "]";
        return json;
    }

    private Field[] getNonSyntheticNonTransientDeclaredFields(Object demo) {
        return new ArrayList<>(Arrays.asList(demo.getClass().getDeclaredFields()))
                .stream()
                .filter(field -> !field.isSynthetic() && !Modifier.isTransient(field.getModifiers()))
                .toArray(Field[]::new);
    }
}
