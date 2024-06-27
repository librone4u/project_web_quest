package com.project_web_quest.service;

public class StateProcessor {
    public static String linkToJsp(String state){
        switch(state){
            case "welcome" -> {
                return "/MoSWelcome.jsp";
            }
            case "playing", "start" -> {
                return "/MansionOfSecrets.jsp";
            }
            case "conclusion" -> {
                return "/conclusion.jsp";
            }
            default -> {
                return "/error.jsp";
            }
        }
    }
}

