package com.project_web_quest.games.mansionOfSecrets;

import com.project_web_quest.model.GameElement;

import java.util.Map;

public interface Database {
    Map<String, GameElement> getMap();
    GameElement getElement(String callBack);
}
