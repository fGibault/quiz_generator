// QuizResource.java

package com.example.tpquiz;

import dao.*;
import models.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/quiz")
public class QuizResource {
    QuizDao quizDao = new QuizDao();
    QuestionDao questionDao = new QuestionDao();
    OptionDao optionDao = new OptionDao();

    QuizQuestionDao quizQuestionDao = new QuizQuestionDao();

    @Path("/{quizId}/questions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getQuizQuestions(@PathParam("quizId") int quizId) {
        return questionDao.getQuestionsForQuiz(quizId);
    }

    @Path("/questions/{questionId}/options")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Options> getOptionsForQuestion(@PathParam("questionId") int questionId) {
        return optionDao.getOptionsForQuestion(questionId);
    }
    // QuizResource.java



    @Path("/generate")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateQuiz(compteDifficulte cDif) {
        // Create new Quiz instance
        Quiz newQuiz = new Quiz();

        // Persist the Quiz to DB
        quizDao.addQuiz(newQuiz);

        // Generate questions based on the difficulty count
        List<Question> questions = questionDao.getRandomQuestions(cDif);

        // Add each question to the QuizQuestion table
        for (Question question : questions) {
            QuizQuestion quizQuestion = new QuizQuestion();
            quizQuestion.setQuiz(newQuiz);
            quizQuestion.setQuestion(question);
            quizQuestionDao.addQuizQuestion(quizQuestion);  // Use the DAO for QuizQuestion here
        }

        // Return the newly created Quiz
        return Response.status(Response.Status.CREATED).entity(newQuiz).build();
    }

    @Path("/questions")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

}
