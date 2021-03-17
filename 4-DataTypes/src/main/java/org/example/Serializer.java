package org.example;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class Serializer {
    private Gson gson = new Gson();


    public String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public Object fromJson(String data, Class type) {
        return gson.fromJson(data, type);
    }
    public String toYaml(Object obj) {
        return "";
    }

    public Object fromYaml(String data, Class type) {
        return new Object();
    }

/*
    public String toXml() {
        return "";
    }

    public Object fromXml() {
        return new Object();
    }

 */
}
