package com.workintech.sql.dao;

import com.workintech.sql.entity.BreadType;
import com.workintech.sql.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{
    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery burgers= entityManager.createQuery("SELECT e FROM Burger e",Burger.class);
        return burgers.getResultList();
    }

    @Override
    public Burger findById(int id) {
        return entityManager.find(Burger.class,id);
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery burgers= entityManager.createQuery("SELECT e FROM Burger e WHERE e.price >= :price ORDER BY e.price DESC",Burger.class);
        burgers.setParameter("price",price);
        return burgers.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(String breadType) {
        BreadType burgerTypeEnum = BreadType.valueOf(breadType);
        TypedQuery<Burger> burgers = entityManager.createQuery(
                "SELECT e FROM Burger e WHERE e.breadType = :breadType ORDER BY e.breadType ASC", Burger.class);
        burgers.setParameter("breadType", burgerTypeEnum);
        return burgers.getResultList();
    }


    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> burgers = entityManager
                .createQuery("SELECT e FROM Burger e WHERE e.contents ILIKE :content", Burger.class);
        burgers.setParameter("content", "%"+content+"%");
        return burgers.getResultList();
    }

    @Transactional
    @Override
    public void update(Burger burger) {
        entityManager.merge(burger);
    }

    @Transactional
    @Override
    public void delete(Burger burger) {
        entityManager.remove(burger);
    }
}
