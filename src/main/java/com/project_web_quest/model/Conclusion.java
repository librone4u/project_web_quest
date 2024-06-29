package com.project_web_quest.model;

import lombok.Data;

import java.net.URI;

@Data
public class Conclusion implements GameElement{
    private String name;
    private String finalText;
    private URI backGround;
    public Conclusion(String name,String finalText, URI backGround) {
        this.name = name;
        this.finalText = finalText;
        this.backGround = backGround;
    }
}