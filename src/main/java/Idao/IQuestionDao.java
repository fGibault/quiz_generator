package Idao;

import models.Question;

import java.util.List;

public interface IQuestionDao {
    List<Question> getAllQuestions();
    Question getQuestion(int id);
    void addQuestion(Question question);
    void updateQuestion(Question question);
    void deleteQuestion(int id);

}
