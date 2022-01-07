package by.itstep.interview.repository;

import by.itstep.interview.entity.InterviewEntity;

import java.util.List;

public interface InterviewRepository {

    InterviewEntity findById(int id);
    List<InterviewEntity> findAll();
    InterviewEntity create(InterviewEntity entity);
    InterviewEntity update(InterviewEntity entity);
    void deleteById(int id);
    void deleteAll();
}
