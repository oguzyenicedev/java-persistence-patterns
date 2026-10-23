package com.oguz.repository;

import com.oguz.entity.Slot;
import com.oguz.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SlotRepository {

    private static EntityManager em = JpaUtil.getEntityManager();

    public SlotRepository() {}

    public static void save(Slot slot) {
        if (SlotRepository.allSlotNumber() == 15) {
            return;
        } else {
            try {
                em.getTransaction().begin();
                em.persist(slot);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }

    public static void update(Slot slot) {
        try {
            em.getTransaction().begin();
            em.merge(slot);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static Long allSlotNumber() {
        return em.createQuery("SELECT COUNT(s) FROM Slot s", Long.class).getSingleResult();
    }

    public static List<Slot> findAllSlots() {
        return em.createQuery("SELECT s FROM Slot s", Slot.class).getResultList();
    }

    public static List<Slot> findEmptySlots() {
        return em.createQuery("SELECT s FROM Slot s WHERE s.isOccupied = false", Slot.class).getResultList();
    }

    public int findEmptySlotsNumber() {
        return SlotRepository.findEmptySlots().size();
    }
}