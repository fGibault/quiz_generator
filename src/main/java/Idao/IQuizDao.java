package Idao;

import models.Quiz;

import java.util.List;

public interface IQuizDao {
    List<Quiz> getAllQuizzes();
    Quiz getQuiz(int id);
    void addQuiz(Quiz quiz);
    void updateQuiz(Quiz quiz);
    void deleteQuiz(int id);
}
