package com.oguz.repository;

import com.oguz.entity.Car;
import com.oguz.util.JpaUtil;
import jakarta.persistence.EntityManager;

public class CarRepository {

    private static final EntityManager em = JpaUtil.getEntityManager();

    public CarRepository() {}

    public static void save(Car car) {
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}