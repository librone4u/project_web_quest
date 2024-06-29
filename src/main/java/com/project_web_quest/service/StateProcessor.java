package com.project_web_quest.service;

public class StateProcessor {
    public static String linkToJsp(String state){
        switch(state){
            case "welcome" -> {
                return "/MoS/MoS_welcome.jsp";
            }
            case "playing", "start" -> {
                return "/MoS/MoS.jsp";
            }
            case "conclusion" -> {
                return "/MoS/MoS_conclusion.jsp";
            }
            default -> {
                return "/error.jsp";
            }
        }
    }
}

