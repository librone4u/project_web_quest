package com.project_web_quest.controller;

import com.project_web_quest.constants.Callback_Constants;
import com.project_web_quest.constants.State_Constants;
import com.project_web_quest.games_base_question.mansion_of_sercrets.ConclusionBase;
import com.project_web_quest.model.Question;
import com.project_web_quest.service.StateProcessor;
import com.project_web_quest.games_base_question.mansion_of_sercrets.QuestionBase;
import com.project_web_quest.model.GameElement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TheMysteryOfTheAbandonedMansion", value = "/TheMysteryOfTheAbandonedMansion")
public class MoS_Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String state = (String) session.getAttribute("state");
        String callback =  req.getParameter("callBack");

        QuestionBase questionBase = QuestionBase.getInstance();
        ConclusionBase conclusionBase = ConclusionBase.getInstance();
        Map<String, GameElement> mapOfConclusion = conclusionBase.getMap();

        if(State_Constants.PLAYING.equals(state)) {
            if (mapOfConclusion.containsKey(callback)) {
                state = State_Constants.CONCLUSION;
                session.setAttribute("state", State_Constants.CONCLUSION);
                getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
            } else {
                Question question = (Question) questionBase.getElement(callback);
                session.setAttribute("question", question);
                switch (callback) {
                    case Callback_Constants.SEARCH_CLUES -> {
                        session.setAttribute("knowledge", "true");
                    }
                    case Callback_Constants.ENTER_VAULT -> {
                        Question questionExploreVault = (Question) questionBase.getElement(Callback_Constants.EXPLORE_VAULT);
                        Map<String, String> answers = questionExploreVault.getAnswers();
                        if (session.getAttribute("knowledge").equals("true")) {
                            answers.put(Callback_Constants.HELP_WITH_KNOWLEDGE, "Help family.");
                        } else {
                            answers.put(Callback_Constants.HELP_WITHOUT_KNOWLEDGE, "Help family.");
                        }
                        questionBase.changeQuestionByCallBack(Callback_Constants.EXPLORE_VAULT, questionExploreVault);
                    }
                }
            }
        }
        getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
    }
}

