package com.workintech.sql.dao;

import com.workintech.sql.entity.BreadType;
import com.workintech.sql.entity.Burger;

import java.util.List;

public interface BurgerDao {
    Burger save(Burger burger);
    List<Burger> findAll();
    Burger findById(int id);
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(String breadType);
    List<Burger> findByContent(String content);
    void update(Burger burger);
    void delete(Burger burger);

}
