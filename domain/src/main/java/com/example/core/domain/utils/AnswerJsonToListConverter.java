package com.example.core.domain.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class AnswerJsonToListConverter implements AttributeConverter<List<String>, String> {
    @Override
    public String convertToDatabaseColumn(List<String> list) {
        StringBuilder array = new StringBuilder();
        array.append("[");
        for(int i=0;i<list.size();i++){
            array.append("{\"answer\":");
            array.append("\"");
            String answer = list.get(i);
            answer = answer.replace("\\", "\\\\");
            System.out.println(answer);
            array.append(answer);

            array.append("\"}");
            if(i != list.size() -1){
                array.append(",");
            }
        }
        array.append("]");
        System.out.println(array);
        return "{data: " + array.toString() + "}";
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        List<String> list = new ArrayList<>();
        JSONObject json;
        try {
            json = new JSONObject(dbData);
            JSONArray jsonArray = (JSONArray) json.get("data");
            jsonArray.iterator()
                    .forEachRemaining(answer -> {
                        JSONObject answerObj = new JSONObject(answer.toString());
                        list.add((String) answerObj.get("answer"));
                    });

            return list;
        } catch (JSONException e) {
            System.out.println(e);
            return null;
        }
    }
}
