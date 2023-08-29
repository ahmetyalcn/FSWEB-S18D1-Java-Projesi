package com.workintech.sql.controller;

import com.workintech.sql.dao.BurgerDao;
import com.workintech.sql.entity.BreadType;
import com.workintech.sql.entity.Burger;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burgers")
@Validated
public class BurgerController {
    private BurgerDao burgerDao;
    @Autowired
    public void init(BurgerDao burgerDao){
        this.burgerDao=burgerDao;
    }

    @GetMapping("/")
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String breadType){
        return burgerDao.findByBreadType(breadType);
    }
    @GetMapping("/findById/{id}")
    public Burger findById(@PathVariable int id){
        return burgerDao.findById(id);
    }
    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable int price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }
    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger){
        return burgerDao.save(burger);
    }
    @PutMapping ("/{id}")
    public Burger update(@RequestBody Burger burger,@PathVariable int id){
        burger.setId(id);
        burgerDao.update(burger);
        return burger;
    }
    @DeleteMapping("/{id}")
    public Burger delete(@RequestBody Burger burger, @PathVariable int id){
        Burger burgerFound = burgerDao.findById(id);
        burgerDao.delete(burgerFound);
        return burgerFound;
    }
}
