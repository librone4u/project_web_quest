package com.project_web_quest.model;

import lombok.Data;

import java.util.Map;
@Data
public class Question implements GameElement{
    private String question;
    private Map<String, String> answers;
    public Question(String question, Map<String, String> answers) {
        this.question = question;
        this.answers = answers;
    }
}