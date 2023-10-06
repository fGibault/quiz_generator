package dao;

import models.Options;
import Idao.IOptionDao;
import util.EntityManagerUtil;
import jakarta.persistence.Query;

import java.util.List;

public class OptionDao implements IOptionDao {
    EntityManagerUtil em = EntityManagerUtil.getInstance();


    @Override
    public List<Options> getAllOptions() {
        return null;
    }

    @Override
    public Options getOption(int id) {
        return em.getEntityManager().find(Options.class, id);
    }

    @Override
    public void addOption(Options options) {

    }

    @Override
    public void updateOption(Options options) {

    }

    @Override
    public void deleteOption(int id) {

    }


    public List<Options> getOptionsForQuestion(int questionId) {
        Query query = em.getEntityManager().createQuery("SELECT o FROM Options o WHERE o.question.id = :questionId", Options.class);
        query.setParameter("questionId", questionId);
        return query.getResultList();
    }

    // Add other required methods here...
}