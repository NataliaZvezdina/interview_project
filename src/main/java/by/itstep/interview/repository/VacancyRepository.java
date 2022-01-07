package by.itstep.interview.repository;

import by.itstep.interview.entity.VacancyEntity;

import java.util.List;

public interface VacancyRepository {

    VacancyEntity findById(int id);
    List<VacancyEntity> findAll();
    VacancyEntity create(VacancyEntity entity);
    VacancyEntity update(VacancyEntity entity);
    void deleteById(int id);
    void deleteAll();
}
