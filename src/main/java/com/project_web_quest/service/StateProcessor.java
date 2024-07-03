package com.project_web_quest.service;

import com.project_web_quest.constants.StateConstants;

public class StateProcessor {
    public static String linkToJsp(String state){
        switch(state){
            case StateConstants.WELCOME  -> {
                return "/MoS/MoS_welcome.jsp";
            }
            case StateConstants.PLAYING, StateConstants.START -> {
                return "/MoS/MoS.jsp";
            }
            case StateConstants.CONCLUSION -> {
                return "/MoS/MoS_conclusion.jsp";
            }
            default -> {
                return "/error.jsp";
            }
        }
    }
}

