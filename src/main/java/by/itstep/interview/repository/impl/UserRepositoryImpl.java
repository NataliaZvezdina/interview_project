package by.itstep.interview.repository.impl;

import by.itstep.interview.entity.UserEntity;
import by.itstep.interview.repository.UserRepository;
import by.itstep.interview.util.EntityManagerUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Override
    public UserEntity findById(int id) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        UserEntity foundUser = em.find(UserEntity.class, id);
        em.getTransaction().commit();
        em.close();
        return foundUser;
    }

    @Override
    public List<UserEntity> findAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        List<UserEntity> allUsers =
                em.createNativeQuery("SELECT * FROM users", UserEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return allUsers;
    }

    @Override
    public UserEntity create(UserEntity entity) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    @Override
    public UserEntity update(UserEntity entity) {
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
        UserEntity entityToDelete = em.find(UserEntity.class, id);
        em.remove(entityToDelete);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteAll() {
        EntityManager em = EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();
        em.createNativeQuery("DELETE FROM users").executeUpdate();
        em.getTransaction().commit();
        em.close();
    }
}
