package com.project_web_quest.games_base_question.mansion_of_sercrets;

import com.project_web_quest.games_base_question.Database;
import com.project_web_quest.model.Conclusion;
import com.project_web_quest.model.GameElement;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class ConclusionBase implements Database {
    private static ConclusionBase instance;
    private static Map<String, GameElement> mapOfConclusion;
    public static ConclusionBase getInstance() {
        if (instance == null) {
            instance = new ConclusionBase();
            createMap();
        }
        return instance;
    }
    private static void createMap() {
        mapOfConclusion = new HashMap<>();

        mapOfConclusion.put("help", new Conclusion("Освобождение душ", "Ты не колеблясь решаешь помочь душам семьи Деверо. " +
                "Ты следуешь инструкциям, которые ты узнал из древних записей," +
                " и начинаешь проводить ритуал. Алтарь замирает в мистическом свете, " +
                "и воздух наполняется напряжением. Духи начинают мерцать ярче, " +
                "и ты чувствуешь, как они находятся на грани освобождения.\n" +
                "\n" +
                "Семья Деверо тихо шепчет благодарность, касаясь твоего сознания без слов." +
                " Их образы медленно растворяются в воздухе," +
                " оставляя за собой чувство благодарности и мирного покоя." +
                " Алтарь, вокруг которого сосредоточено столько тайн и силы," +
                " постепенно разрушается, как будто его задача была выполнена.\n" +
                "\n" +
                "Ты покидает комнату, ощущая смешанные эмоции:" +
                " гордость за свои действия и грусть об ушедших душах." +
                " Возвращаясь на поверхность, ты знаешь, что освободил не только семью Деверо," +
                " но и себя от тяжкого бремени их проклятия.", URI.create("/photo/library.jpeg")));

        mapOfConclusion.put("helpWithoutKnowledge", new Conclusion("Неудачное спасение", "Ты начинаешь выполнять ритуал, как описано в дневнике." +
                " Но твои знания оказываются неполными, и что-то идет не так." +
                " Проклятие начинает усиливаться, и духи Деверо начинают превращаться в темные тени, испускающие ужасные крики." +
                "Ты понимаешь, что сделал ошибку, не подготовившись должным образом. Твои попытки оказать помощь только усиливают мощь проклятия." +
                " Силы особняка начинают буквально рушиться вокруг тебя, и ты понимаешь, что это конец." +
                "Так завершается твое приключение в особняке Деверо, где ты попытался помочь без достаточных знаний и подготовки." +
                " Твоя решимость обернулась трагедией, и теперь твоя судьба стала частью бесконечного проклятия," +
                " которое бережно охраняет заброшенный особняк Деверо.", URI.create("/photo/library.jpeg")));

        mapOfConclusion.put("getBack", new Conclusion("Проклятие возрождается", "Решив отложить ритуал и вернуться" +
                " на поверхность, ты чувствуешь, как образы духов семьи Деверо становятся нестабильными и зловещими." +
                " Они не понимают, почему ты не помогаешь им, и начинают искажаться, их обличья становятся искаженными " +
                "от гнева и обиды.\n" +
                "\n" +
                "Алтарь начинает излучать темные силы, и ты осознаешь, что проклятие начинает охватывать не только духов," +
                " но и тебя самого. Ты пытаешься бежать из комнаты, но дверь закрывается за тобой, и ты осознаешь," +
                " что теперь в ловушке среди мрачных стен особняка.\n" +
                "\n" +
                "С каждой секундой проклятие все сильнее охватывает тебя, ты слышишь голоса и видишь тени," +
                " но не можешь понять, что реально, а что нет. Время теряет свой смысл, и ты понимаешь," +
                " что твоя судьба теперь связана с этим местом навсегда.", URI.create("/photo/library.jpeg")));


        mapOfConclusion.put("callForHelp", new Conclusion("Неудачное расследование", "Ты решаешь вернуться на поверхность и рассказать о своих находках специалистам." +
                " Однако, как только ты выходишь из подвала, дверь за тобой захлопывается, и особняк начинает разрушаться." +
                " Ты едва успеваешь выбраться на улицу. Позже, исследовательская группа, которой ты сообщил о своих находках," +
                " не находит ничего в руинах особняка, и твои слова воспринимаются как выдумка. Тебя все начали считать психически больным.", URI.create("/photo/library.jpeg")));
    }
    @Override
    public Map<String, GameElement> getMap() {
        return mapOfConclusion;
    }
    @Override
    public GameElement getElement(String callBack) {
        return mapOfConclusion.get(callBack);
    }
}
