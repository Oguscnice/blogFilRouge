package com.atelier2103spring.atelierSpring.controller;

import com.atelier2103spring.atelierSpring.entity.Article;
import com.atelier2103spring.atelierSpring.entity.Category;
import com.atelier2103spring.atelierSpring.repository.ArticleRepository;
import com.atelier2103spring.atelierSpring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ArticleRepository articleRepository;
    @GetMapping("/categories")
    public List<Category> index(){
        return categoryRepository.findAll();
    }
    @GetMapping("/categories/{id}")
    public Category show(@PathVariable long id){
        return categoryRepository.findById(id).get();
    }
    @PostMapping("/categories")
    public Category create(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PutMapping("/categories/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category categories){
        Category categoriesToUpdate = categoryRepository.findById(id).get();
        return categoryRepository.save(categoriesToUpdate);
    }

    @DeleteMapping("categories/{id}")
    public boolean delete(@PathVariable long id){
        categoryRepository.deleteById(id);
        return true;
    }
}
