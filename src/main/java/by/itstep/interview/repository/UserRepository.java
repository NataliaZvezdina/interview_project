package by.itstep.interview.repository;

import by.itstep.interview.entity.UserEntity;

import java.util.List;

public interface UserRepository {

    UserEntity findById(int id);
    List<UserEntity> findAll();
    UserEntity create(UserEntity entity);
    UserEntity update(UserEntity entity);
    void deleteById(int id);
    void deleteAll();
}
