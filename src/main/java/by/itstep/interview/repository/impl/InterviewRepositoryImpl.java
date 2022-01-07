package by.itstep.interview.repository.impl;

import by.itstep.interview.entity.InterviewEntity;
import by.itstep.interview.repository.InterviewRepository;
import by.itstep.interview.util.EntityManagerUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InterviewRepositoryImpl implements InterviewRepository {

    @Override
    public InterviewEntity findById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        InterviewEntity foundInterview = em.find(InterviewEntity.class, id);
        em.getTransaction().commit();
        em.close();
        return foundInterview;
    }

    @Override
    public List<InterviewEntity> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        List<InterviewEntity> allInterviews =
                em.createNativeQuery("SELECT * FROM interviews", InterviewEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return allInterviews;
    }

    @Override
    public InterviewEntity create(InterviewEntity entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public InterviewEntity update(InterviewEntity entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public void deleteById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        InterviewEntity entityToDelete = em.find(InterviewEntity.class, id);
        em.remove(entityToDelete);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM interviews").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
