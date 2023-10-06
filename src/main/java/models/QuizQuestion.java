package models;

import jakarta.persistence.*;
@Entity
@Table(name = "QuizQuestion")
@IdClass(QuizQuestionId.class)
public class QuizQuestion {

    @Id
    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    @Id
    @ManyToOne
    @JoinColumn(name = "QuizID", nullable = false)
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "SelectedOptionID", nullable = false)
    private Options selectedOption;


        public QuizQuestion() {}

    public QuizQuestion(Options selectedOption, Question question, Quiz quiz) {
        this.selectedOption = selectedOption;
        this.question = question;
        this.quiz = quiz;
    }



    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
    public Options getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(Options selectedOption) {
        this.selectedOption = selectedOption;
    }
}
