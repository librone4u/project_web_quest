package com.project_web_quest.model;

import lombok.Data;

@Data
public class GameDescription {
    private String gameFullName;
    private String gameShortName;
    private String gameLinkServlet;
    private String gameLinkPhoto;
    private boolean isAccess = true;
    public String isReadyForPlay(){
        if(this.isAccess){
            return "Играть";
        }else{
            return "Недоступно";
        }
    }
}
