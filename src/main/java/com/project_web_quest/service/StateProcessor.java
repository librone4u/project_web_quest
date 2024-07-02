package com.project_web_quest.service;

import com.project_web_quest.constants.State_Constants;

public class StateProcessor {
    public static String linkToJsp(String state){
        switch(state){
            case State_Constants.WELCOME  -> {
                return "/MoS/MoS_welcome.jsp";
            }
            case State_Constants.PLAYING, State_Constants.START -> {
                return "/MoS/MoS.jsp";
            }
            case State_Constants.CONCLUSION -> {
                return "/MoS/MoS_conclusion.jsp";
            }
            default -> {
                return "/error.jsp";
            }
        }
    }
}

