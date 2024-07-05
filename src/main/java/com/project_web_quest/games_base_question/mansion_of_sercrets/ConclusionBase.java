package com.project_web_quest.games_base_question.mansion_of_sercrets;

import com.project_web_quest.constants.QuestionCallbackConstants;
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
            initMap();
        }
        return instance;
    }
    private static void initMap() {
        mapOfConclusion = new HashMap<>();

        mapOfConclusion.put(QuestionCallbackConstants.HELP_WITH_KNOWLEDGE, new Conclusion("Liberation of Souls", "Without hesitation, you decide to help the souls of the Devereaux family. " +
                "You follow the instructions you learned from ancient records," +
                " and begin to perform the ritual. The altar is enveloped in a mystical light, " +
                "and the air is filled with tension. The spirits start to shimmer more brightly, " +
                "and you sense that they are on the verge of liberation.\n" +
                "\n" +
                "The Devereaux family whispers their gratitude softly, touching your mind without words." +
                " Their images slowly dissolve into the air," +
                " leaving behind a feeling of gratitude and peaceful calm." +
                " The altar, around which so many mysteries and powers are centered," +
                " gradually disintegrates as if its task has been completed.\n" +
                "\n" +
                "You leave the room, feeling mixed emotions:" +
                " pride for your actions and sadness for the departed souls." +
                " Returning to the surface, you know that you have freed not only the Devereaux family," +
                " but also yourself from the heavy burden of their curse.", URI.create("/photo/library.jpeg")));

        mapOfConclusion.put(QuestionCallbackConstants.HELP_WITHOUT_KNOWLEDGE, new Conclusion("Unsuccessful Rescue", "You begin performing the ritual as described in the journal." +
                " But your knowledge is incomplete, and something goes wrong." +
                " The curse starts to intensify, and the Devereaux spirits begin to turn into dark shadows, emitting terrible screams." +
                "You realize you made a mistake by not preparing properly. Your attempts to help only strengthen the power of the curse." +
                " The forces of the mansion literally start to collapse around you, and you understand that this is the end." +
                "Thus concludes your adventure in the Devereaux mansion, where you tried to help without sufficient knowledge and preparation." +
                " Your determination turned into tragedy, and now your fate has become part of the endless curse," +
                " which is carefully guarded by the abandoned Devereaux mansion.", URI.create("/photo/library.jpeg")));

        mapOfConclusion.put(QuestionCallbackConstants.GET_BACK, new Conclusion("The Curse Revives", "Deciding to postpone the ritual and return" +
                " to the surface, you feel the images of the Devereaux family spirits becoming unstable and sinister." +
                " They do not understand why you are not helping them and begin to distort, their forms becoming twisted" +
                " with anger and resentment.\n" +
                "\n" +
                "The altar starts to emit dark forces, and you realize that the curse is starting to envelop not only the spirits," +
                " but you as well. You try to flee the room, but the door closes behind you, and you realize" +
                " that you are now trapped within the gloomy walls of the mansion.\n" +
                "\n" +
                "With each passing second, the curse engulfs you more, you hear voices and see shadows," +
                " but cannot discern what is real and what is not. Time loses its meaning, and you understand" +
                " that your fate is now forever tied to this place.", URI.create("/photo/library.jpeg")));


        mapOfConclusion.put(QuestionCallbackConstants.CALL_FOR_HELP, new Conclusion("Unsuccessful Investigation", "You decide to return to the surface and report your findings to the experts." +
                " However, as soon as you leave the basement, the door slams shut behind you, and the mansion begins to collapse." +
                " You barely manage to escape outside. Later, the research team you informed about your findings" +
                " finds nothing in the ruins of the mansion, and your words are dismissed as fabrication. Everyone starts to consider you mentally ill.", URI.create("/photo/library.jpeg")));
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
