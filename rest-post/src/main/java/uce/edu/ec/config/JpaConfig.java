package uce.edu.ec.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces; // Fixed: Changed from JAX-RS to CDI
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class JpaConfig {

    private EntityManagerFactory emf;

    @PostConstruct
    public void init() {
        // Manually bootstrap the factory once for the application
        this.emf = Persistence.createEntityManagerFactory("progweb");
    }

    @Produces
    @ApplicationScoped // Exposes the same factory application-wide
    public EntityManagerFactory produceEmf() {
        return this.emf;
    }

    @Produces
    // Removed @RequestScoped if you want it dependent, but RequestScoped is standard for web threads
    public EntityManager produceEm() {
        return this.emf.createEntityManager();
    }

    // Clean up the EntityManager when a request/context ends
    public void closeEntityManager(@Disposes EntityManager em) {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    // Added: Clean up the Factory when the application shuts down
    @PreDestroy
    public void closeEmf() {
        if (this.emf != null && this.emf.isOpen()) {
            this.emf.close();
        }
    }
}