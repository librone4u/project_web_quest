package com.project_web_quest.games.mansionOfSecrets;

import com.project_web_quest.model.GameElement;
import com.project_web_quest.model.Question;

import java.util.HashMap;
import java.util.Map;

public class QuestionBase implements Database{

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
        answers.put("enterTheDoor", "Войти через парадную дверь.");
        answers.put("goAround" , "Обойти особняк ");
        mapOfQuestions.put("start", new Question("Ты стоишь у ворот старого заброшенного особняка." +
                " Вокруг — густой лес, и тишину нарушает только ветер, гуляющий среди деревьев.", answers));

        answers = new HashMap<>();
        answers.put("exploreLibrary", "Осмотреть библиотеку на первом этаже.");
        answers.put("secondFloor" , "Подняться на второй этаж.");
        mapOfQuestions.put("enterTheDoor", new Question("Ты входишь в заброшенный особняк Деверо," +
                " наполненный мрачной атмосферой и таинственностью. Внутри царит мрак," +
                " и только твой фонарь освещает путь по темным коридорам и залам." +
                " Ты чувствуешь, как воздух насыщен зловещей энергией," +
                " но твоя решимость не позволяет тебе остановиться." +
                " Ты решаешь исследовать каждый уголок особняка, чтобы раскрыть его тайны.", answers));

        answers = new HashMap<>();
        answers.put("enterTheAjarDoor", "Зайти в приоткрытую дверь.");
        answers.put("enterTheDoor" , "Вернуться назад");
        mapOfQuestions.put("secondFloor", new Question("Ты поднимаешься по полуразрушенной лестнице на второй этаж особняка." +
                " Здесь тишина нарушена только скрипом деревянных перил и твоими шагами по полу," +
                " покрытому слоем пыли. Проходя мимо разбитых окон и забытых мебельных предметов," +
                " ты замечаешь приоткрытую дверь на конце коридора.", answers));

        answers = new HashMap<>();
        answers.put("enterVault", "Войти в подвал.");
        answers.put("start" , "Вернуться назад.");
        mapOfQuestions.put("goAround", new Question("Ты обходишь особняк и находишь старую деревянную дверь, которая ведет в подвал.", answers));

        answers = new HashMap<>();
        answers.put("exploreVault", "Исследовать дальше в подвале.");
        answers.put("callForHelp" , "Подняться обратно на поверхность и позвать помощь.");
        mapOfQuestions.put("enterVault", new Question("Ты спускаешься в низ. " +
                "В подвале ты находишь старинные документы и дневник, рассказывающий о том," +
                "что семья Деверо занималась черной магией и попала в ловушку собственного заклинания.", answers));
        answers = new HashMap<>();
        answers.put("getBack", "Вернуться назад");
        mapOfQuestions.put("exploreVault", new Question("Ты заходишь в тайную комнату. " +
                "В комнате ты видишь алтарь с древними артефактами и надписями на странном языке." +
                " Изучив их, ты понимаешь, что нашел центр проклятия." +
                "Внезапно духи семьи Деверо появляются перед тобой, умоляя помочь им.", answers));
        answers = new HashMap<>();
        answers.put("searchClues", "Искать подсказки о ритуале в записях.");
        answers.put("exploreVault", "Спуститься в подвал с новыми знаниями.");
        mapOfQuestions.put("enterTheAjarDoor", new Question("Ты открываешь дверь и заходишь в маленькую комнату," +
                " затерянную во времени. В углу ты видишь старый письменный стол, покрытый пылью и паутиной." +
                " На столе лежит замшелая книга с выгоревшими страницами." +
                "Ты начинаешь изучать записи, оставленные здесь, и понимаешь, что это дневник матери Деверо." +
                " В нем она описывает последние дни семьи и их отчаянные попытки разрушить проклятие, которое нависло над особняком." +
                " В ее записях упоминается об алтаре в подвале, который служит фокусом зла.", answers));

        answers = new HashMap<>();
        answers.put("enterVault","Спуститься в подвал");
        mapOfQuestions.put("searchClues", new Question("Ты изучаешь записи и находишь подсказки о ритуале," +
                " который мог бы разрушить проклятие. В дневнике матери указаны необходимые компоненты и шаги," +
                " которые необходимо выполнить. Ты чувствуешь, что пришло время спуститься в подвал и попытаться" +
                " освободить семью Деверо от их мучений.", answers));

        answers = new HashMap<>();
        answers.put("secondFloor", "Подняться на второй этаж");
        answers.put("goAround", "Обойти особняк");
        mapOfQuestions.put("exploreLibrary", new Question("Ты находишь старинную библиотеку, полную пыльных и изорванных книг." +
                " Среди них ты обнаруживаешь дневник старшего сына Деверо." +
                " В нем он описывает свои исследования черной магии и первые признаки проклятия, которое погубило их семью." +
                " Решив изучить записи подробнее, ты обнаруживаешь, что ключ к разгадке проклятия скрыт в подвале на заднем дворе.", answers));
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
