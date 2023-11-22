package com.searce.boilerplates.model;

import java.lang.reflect.Field;

public class Printable {
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Class<?> clazz = this.getClass();
        Field[] fields = clazz.getDeclaredFields();

        stringBuilder.append("[");
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); //TO REMOVE

            try {
                Object value = field.get(this);
                stringBuilder.append(field.getName()).append(": ").append(value);
                if (i != fields.length-1) stringBuilder.append(", ");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
