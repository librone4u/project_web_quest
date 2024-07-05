package com.project_web_quest.controller;

import com.project_web_quest.constants.QuestionCallbackConstants;
import com.project_web_quest.constants.StateConstants;
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
public class MoSServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String state = (String) session.getAttribute("state");
        String callback =  req.getParameter("callBack");

        QuestionBase questionBase = QuestionBase.getInstance();
        ConclusionBase conclusionBase = ConclusionBase.getInstance();
        Map<String, GameElement> mapOfConclusion = conclusionBase.getMap();

        if(StateConstants.PLAYING.equals(state)) {
            if (mapOfConclusion.containsKey(callback)) {
                state = StateConstants.CONCLUSION;
                session.setAttribute("state", StateConstants.CONCLUSION);
                getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
            } else {
                Question question = (Question) questionBase.getElement(callback);
                session.setAttribute("question", question);
                handleCallBack(callback, session, questionBase);
            }
        }
        getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
    }

    private void handleCallBack(String callback, HttpSession session, QuestionBase questionBase){
        if (QuestionCallbackConstants.SEARCH_CLUES.equals(callback)) {
            session.setAttribute("knowledge", "true");
        } else if (QuestionCallbackConstants.ENTER_VAULT.equals(callback)) {
            handleEnterVault(session, questionBase);
        }
    }
    private void handleEnterVault(HttpSession session, QuestionBase questionBase) {
        Question questionExploreVault = (Question) questionBase.getElement(QuestionCallbackConstants.EXPLORE_VAULT);
        Map<String, String> answers = questionExploreVault.getAnswers();

        if ("true".equals(session.getAttribute("knowledge"))) {
            answers.put(QuestionCallbackConstants.HELP_WITH_KNOWLEDGE, "Help family.");
        } else {
            answers.put(QuestionCallbackConstants.HELP_WITHOUT_KNOWLEDGE, "Help family.");
        }

        questionBase.changeQuestionByCallBack(QuestionCallbackConstants.EXPLORE_VAULT, questionExploreVault);
    }
}

