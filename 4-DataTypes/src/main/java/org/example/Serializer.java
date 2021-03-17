package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class Serializer {
    private ObjectMapper jsonMapper = new ObjectMapper();
    private ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
    private XmlMapper xmlMapper = new XmlMapper();

    public String toJson(Object obj) throws JsonProcessingException {
        return jsonMapper.writeValueAsString(obj);
    }

    public Object fromJson(String data, Class type) throws JsonProcessingException {
        return jsonMapper.readValue(data, type);
    }
    public String toYaml(Object obj) throws JsonProcessingException {
        return yamlMapper.writeValueAsString(obj);
    }

    public Object fromYaml(String data, Class type) throws JsonProcessingException {
        return yamlMapper.readValue(data, type);
    }

    public String toXml(Object obj) throws JsonProcessingException {
        return xmlMapper.writeValueAsString(obj);
    }

    public Object fromXml(String data, Class type) throws JsonProcessingException {
        return xmlMapper.readValue(data, type);
    }
}
