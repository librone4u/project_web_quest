package com.project_web_quest.games_base_question.mansion_of_sercrets;

import com.project_web_quest.constants.CallbackConstants;
import com.project_web_quest.games_base_question.Database;
import com.project_web_quest.model.Question;
import com.project_web_quest.model.GameElement;

import java.util.HashMap;
import java.util.Map;

public class QuestionBase implements Database {

    private static QuestionBase instance;
    private static Map<String, GameElement> mapOfQuestions;

    public static QuestionBase getInstance() {
        if (instance == null) {
            instance = new QuestionBase();
            createMap();
        }
        return instance;
    }

    private static void createMap() {
        mapOfQuestions = new HashMap<>();

        Map<String, String> answers = new HashMap<>();
        answers.put(CallbackConstants.ENTER_THE_DOOR, "Enter through the front door.");
        answers.put(CallbackConstants.GO_AROUND, "Go around the mansion.");
        mapOfQuestions.put(CallbackConstants.START, new Question("You stand at the gates of an old abandoned mansion." +
                " Around you is a dense forest, and the silence is broken only by the wind rustling through the trees.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.EXPLORE_LIBRARY, "Explore the library on the first floor.");
        answers.put(CallbackConstants.SECOND_FLOOR, "Go up to the second floor.");
        mapOfQuestions.put(CallbackConstants.ENTER_THE_DOOR, new Question("You enter the abandoned Devereaux mansion," +
                " filled with a grim atmosphere and mystery. Inside, darkness reigns," +
                " and only your lantern lights the way through the dark corridors and halls." +
                " You feel the air thick with ominous energy," +
                " but your determination does not let you stop." +
                " You decide to explore every corner of the mansion to uncover its secrets.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.ENTER_THE_AJAR_DOOR, "Enter the ajar door.");
        answers.put(CallbackConstants.ENTER_THE_DOOR, "Go back.");
        mapOfQuestions.put(CallbackConstants.SECOND_FLOOR, new Question("You ascend the partially collapsed staircase to the second floor of the mansion." +
                " Here, the silence is broken only by the creak of wooden railings and your footsteps on the floor," +
                " covered with a layer of dust. Passing by broken windows and forgotten furniture," +
                " you notice an ajar door at the end of the corridor.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.ENTER_VAULT, "Enter the basement.");
        answers.put(CallbackConstants.START, "Go back.");
        mapOfQuestions.put(CallbackConstants.GO_AROUND, new Question("You go around the mansion and find an old wooden door leading to the basement.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.EXPLORE_VAULT, "Explore further in the basement.");
        answers.put(CallbackConstants.CALL_FOR_HELP, "Return to the surface and call for help.");
        mapOfQuestions.put(CallbackConstants.ENTER_VAULT, new Question("You descend. " +
                "In the basement, you find ancient documents and a journal telling" +
                " that the Devereaux family practiced black magic and got trapped by their own spell.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.GET_BACK, "Go back.");
        mapOfQuestions.put(CallbackConstants.EXPLORE_VAULT, new Question("You enter a secret room. " +
                "In the room, you see an altar with ancient artifacts and inscriptions in a strange language." +
                " Studying them, you understand that you have found the center of the curse." +
                " Suddenly, the spirits of the Devereaux family appear before you, begging for your help.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.SEARCH_CLUES, "Search for clues about the ritual in the records.");
        answers.put(CallbackConstants.EXPLORE_VAULT, "Go down to the basement with new knowledge.");
        mapOfQuestions.put(CallbackConstants.ENTER_THE_AJAR_DOOR, new Question("You open the door and enter a small room," +
                " lost in time. In the corner, you see an old desk covered in dust and cobwebs." +
                " On the desk lies a mossy book with faded pages." +
                " You begin to study the records left here and realize that this is the diary of Devereaux's mother." +
                " In it, she describes the last days of the family and their desperate attempts to break the curse hanging over the mansion." +
                " Her notes mention an altar in the basement that serves as the focal point of the evil.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.ENTER_VAULT, "Descend to the basement.");
        mapOfQuestions.put(CallbackConstants.SEARCH_CLUES, new Question("You study the records and find clues about a ritual" +
                " that could break the curse. In Devereaux's mother's diary, the necessary components and steps" +
                " to perform the ritual are detailed. You feel that it is time to descend to the basement and attempt" +
                " to free the Devereaux family from their torment.", answers));

        answers = new HashMap<>();
        answers.put(CallbackConstants.SECOND_FLOOR, "Go up to the second floor.");
        answers.put(CallbackConstants.GO_AROUND, "Go around the mansion.");
        mapOfQuestions.put(CallbackConstants.EXPLORE_LIBRARY, new Question("You find an ancient library, full of dusty and torn books." +
                " Among them, you discover the diary of Devereaux's eldest son." +
                " In it, he describes his research on black magic and the first signs of the curse that doomed their family." +
                " Deciding to study the records in detail, you discover that the key to solving the curse is hidden in the basement in the backyard.", answers));
    }

    @Override
    public Map<String, GameElement> getMap() {
        return mapOfQuestions;
    }
    @Override
    public GameElement getElement(String callBack) {
        return mapOfQuestions.get(callBack);
    }
    public void changeQuestionByCallBack(String callBack, Question question){
        if(mapOfQuestions.containsKey(callBack)){
            mapOfQuestions.replace(callBack, mapOfQuestions.get(callBack), question);
        }
    }
}
