package util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerUtil {
    private static EntityManagerUtil instance;
    private EntityManagerFactory emf;

    private EntityManagerUtil() {
        emf = Persistence.createEntityManagerFactory("tpquizz");
    }

    public static synchronized EntityManagerUtil getInstance() {
        if (instance == null) {
            instance = new EntityManagerUtil();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
