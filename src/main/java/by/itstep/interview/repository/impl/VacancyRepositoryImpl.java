package by.itstep.interview.repository.impl;

import by.itstep.interview.entity.VacancyEntity;
import by.itstep.interview.repository.VacancyRepository;
import by.itstep.interview.util.EntityManagerUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class VacancyRepositoryImpl implements VacancyRepository {

    @Override
    public VacancyEntity findById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        VacancyEntity foundVacancy = em.find(VacancyEntity.class, id);
        em.getTransaction().commit();
        em.close();
        return foundVacancy;
    }

    @Override
    public List<VacancyEntity> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        List<VacancyEntity> allVacancies =
                em.createNativeQuery("SELECT * FROM vacancies", VacancyEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return allVacancies;
    }

    @Override
    public VacancyEntity create(VacancyEntity entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public VacancyEntity update(VacancyEntity entity) {
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
        VacancyEntity entityToDelete = em.find(VacancyEntity.class, id);
        em.remove(entityToDelete);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM vacancies").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
