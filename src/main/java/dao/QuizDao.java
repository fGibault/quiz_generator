package dao;

import models.Quiz;
import Idao.IQuizDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import util.EntityManagerUtil;

import java.util.List;

public class QuizDao implements IQuizDao {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("tpquizz");

    public List<Quiz> getAllQuizzes() {
        EntityManager em = EntityManagerUtil.getInstance().getEntityManager();
        try {
            Query query = em.createQuery("SELECT q FROM Quiz q", Quiz.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }


    @Override
    public Quiz getQuiz(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Quiz.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void addQuiz(Quiz quiz) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(quiz);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void updateQuiz(Quiz quiz) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(quiz);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteQuiz(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Quiz quiz = getQuiz(id);
            if (quiz != null) {
                em.getTransaction().begin();
                em.remove(quiz);
                em.getTransaction().commit();
            }
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }
}
