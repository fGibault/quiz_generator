package dao;

import models.Question;
import Idao.IQuestionDao;
import models.compteDifficulte;
import util.EntityManagerUtil;
import jakarta.persistence.Query;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuestionDao implements IQuestionDao {
    EntityManagerUtil em = EntityManagerUtil.getInstance();

    @Override
    public List<Question> getAllQuestions() {
        return em.getEntityManager().createQuery("SELECT q FROM Question q", Question.class).getResultList();

    }

    // QuestionDao.java

    public List<Question> getRandomQuestions(compteDifficulte cDif) {
        List<Question> fQ = em.getEntityManager().createQuery(
                "SELECT q FROM Question q WHERE q.difficulte = 'Facile'",
                Question.class
        ).getResultList();

        List<Question> mQ = em.getEntityManager().createQuery(
                "SELECT q FROM Question q WHERE q.difficulte = 'Moyen'",
                Question.class
        ).getResultList();

        List<Question> hQ = em.getEntityManager().createQuery(
                "SELECT q FROM Question q WHERE q.difficulte = 'Difficile'",
                Question.class
        ).getResultList();

        Collections.shuffle(fQ);
        Collections.shuffle(mQ);
        Collections.shuffle(hQ);

        return Stream.concat(
                Stream.concat(
                        fQ.stream().limit(cDif.getFacile()),
                        mQ.stream().limit(cDif.getMoyen())),
                hQ.stream().limit(cDif.getDifficile())
        ).collect(Collectors.toList());
    }


    @Override
    public Question getQuestion(int id) {
        return em.getEntityManager().find(Question.class, id);
    }

    @Override
    public void addQuestion(Question question) {

    }

    @Override
    public void updateQuestion(Question question) {

    }

    @Override
    public void deleteQuestion(int id) {

    }


    public void getQuestionForQuiz(int quizId) {

    }


    public List<Question> getQuestionsForQuiz(int quizId) {
        Query query = em.getEntityManager().createQuery("SELECT q FROM Question q WHERE q.id = :quizId", Question.class);
        query.setParameter("quizId", quizId);
        return query.getResultList();
    }

    // Add other required methods here...
}