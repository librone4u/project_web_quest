package com.project_web_quest.games_base_question;

import com.project_web_quest.model.GameDescription;

import java.util.ArrayList;
import java.util.List;

public class GamesBase {
    private static GamesBase instance;
    private static List<GameDescription> gameList;

    public static GamesBase getInstance() {
        if (instance == null) {
            instance = new GamesBase();
            gameList = initList();
        }
        return instance;
    }
    private static List<GameDescription> initList(){
        List<GameDescription> list = new ArrayList<>();

        GameDescription MoS = new GameDescription();
        MoS.setGameFullName("The mystery of the Abandoned Mansion");
        MoS.setGameShortName("MoS");
        MoS.setGameLinkPhoto("photo/mansion.jpeg");
        MoS.setGameLinkServlet("/TheMysteryOfTheAbandonedMansion");
        MoS.setAccess(true);
        list.add(MoS);

        GameDescription LSoA = new GameDescription();
        LSoA.setGameFullName("The lost city of Atlantis");
        LSoA.setGameShortName("LSoA");
        LSoA.setGameLinkPhoto("photo/LCoA.jpeg");
        LSoA.setGameLinkServlet(null);
        LSoA.setAccess(false);
        list.add(LSoA);

        return list;
    }
    public List<GameDescription> getGameList() {
        return gameList;
    }
}
