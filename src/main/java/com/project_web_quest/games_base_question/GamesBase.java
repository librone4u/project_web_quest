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

        GameDescription mansionOfSecrets = new GameDescription();
        mansionOfSecrets.setGameFullName("The mystery of the Abandoned Mansion");
        mansionOfSecrets.setGameShortName("mansionOfSecrets");
        mansionOfSecrets.setGameLinkPhoto("photo/mansion.jpeg");
        mansionOfSecrets.setGameLinkServlet("/TheMysteryOfTheAbandonedMansion");
        mansionOfSecrets.setAccess(true);
        list.add(mansionOfSecrets);

        GameDescription lostCityOfAtlantis = new GameDescription();
        lostCityOfAtlantis.setGameFullName("The lost city of Atlantis");
        lostCityOfAtlantis.setGameShortName("lostCityOfAtlantis");
        lostCityOfAtlantis.setGameLinkPhoto("photo/LCoA.jpeg");
        lostCityOfAtlantis.setGameLinkServlet(null);
        lostCityOfAtlantis.setAccess(false);
        list.add(lostCityOfAtlantis);

        return list;
    }
    public List<GameDescription> getGameList() {
        return gameList;
    }
}
