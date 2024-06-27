package com.project_web_quest.controller;

import com.project_web_quest.games.mansionOfSecrets.ConclusionBase;
import com.project_web_quest.games.mansionOfSecrets.QuestionBase;
import com.project_web_quest.model.GameElement;
import com.project_web_quest.model.Question;
import com.project_web_quest.service.StateProcessor;

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

        if(state.equals("playing")) {
            if (mapOfConclusion.containsKey(callback)) {
                state = "conclusion";
                session.setAttribute("state", "conclusion");
                getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
            } else {
                Question question = (Question) questionBase.getElement(callback);
                session.setAttribute("question", question);
                switch (callback) {
                    case "searchClues" -> {
                        session.setAttribute("knowledge", "true");
                    }
                    case "enterVault" -> {
                        Question questionExploreVault = (Question) questionBase.getElement("exploreVault");
                        Map<String, String> answers = questionExploreVault.getAnswers();
                        if (session.getAttribute("knowledge").equals("true")) {
                            answers.put("help", "Помочь семье.");
                            System.out.println("added help");
                        } else {
                            answers.put("helpWithoutKnowledge", "Помочь семье.");
                            System.out.println("added helpWithoutKnowledge");
                        }
                        questionBase.changeQuestionByCallBack("exploreVault", questionExploreVault);
                    }
                }
            }
        }
        getServletContext().getRequestDispatcher(StateProcessor.linkToJsp(state)).forward(req, resp);
    }
}

