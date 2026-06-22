package uce.edu.ec.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class JpaConfig {
    private EntityManagerFactory emf;
    @PostConstruct
    public void init() {
        emf = Persistence.createEntityManagerFactory("dbposts");
    }

    @Produces
    @ApplicationScoped
    public EntityManagerFactory emf() {
        return emf;
    }

    @Produces
    @ApplicationScoped
    public EntityManager em() {
        return emf.createEntityManager();
    }

    void closeEntityManager(@Disposes EntityManager em) {
        if (em !=null && em.isOpen()) {
            em.close();
        }
    }

}
