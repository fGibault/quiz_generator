package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import models.Question;
import models.QuizQuestion;
import util.EntityManagerUtil;
import Idao.IQuizQuestionDao;


public class QuizQuestionDao {

    @PersistenceContext
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tpquizz");

    private EntityManager em;

    public void addQuizQuestion(QuizQuestion quizQuestion) {
        if (quizQuestion != null) {
            em.getTransaction().begin();

            // We just save the quizQuestion
            if (em.contains(quizQuestion)) {
                em.merge(quizQuestion);
            } else {
                em.persist(quizQuestion);
            }

            em.getTransaction().commit();
        }
    }
}
