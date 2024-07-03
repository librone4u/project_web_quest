package com.project_web_quest.model;

import lombok.Data;

public class GameDescription {
    private String gameFullName;
    private String gameShortName;
    private String gameLinkServlet;
    private String gameLinkPhoto;
    private boolean isAccess = false;

    public String getGameFullName() {
        return gameFullName;
    }

    public void setGameFullName(String gameFullName) {
        this.gameFullName = gameFullName;
    }

    public String getGameShortName() {
        return gameShortName;
    }

    public void setGameShortName(String gameShortName) {
        this.gameShortName = gameShortName;
    }

    public String getGameLinkServlet() {
        return gameLinkServlet;
    }

    public void setGameLinkServlet(String gameLinkServlet) {
        this.gameLinkServlet = gameLinkServlet;
    }

    public String getGameLinkPhoto() {
        return gameLinkPhoto;
    }

    public void setGameLinkPhoto(String gameLinkPhoto) {
        this.gameLinkPhoto = gameLinkPhoto;
    }

    public boolean isAccess() {
        return isAccess;
    }

    public void setAccess(boolean access) {
        isAccess = access;
    }
}
