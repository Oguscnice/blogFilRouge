package com.atelier2103spring.atelierSpring.controller;

import com.atelier2103spring.atelierSpring.entity.Article;
import com.atelier2103spring.atelierSpring.entity.Category;
import com.atelier2103spring.atelierSpring.repository.ArticleRepository;
import com.atelier2103spring.atelierSpring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    @GetMapping("/articles/{id}")
    public Article show(@PathVariable long id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/categories/{id}/articles")
    public Article create(@PathVariable Long id,@RequestBody Article article){
        article.setCreatedAt(new Date());
        Category category = categoryRepository.findById(id).get();
        article.setCategory(category);
        return articleRepository.save(article);
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article){
        // getting blog
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setUpdateAt(new Date());
        articleToUpdate.setSlug(article.getSlug());
        articleToUpdate.setContent(article.getContent());
        articleToUpdate.setTitle(article.getTitle());
        return articleRepository.save(articleToUpdate);
    }
    @GetMapping("/categories/{categoryId}/articles")
    public List<Article> findArticleByCategory(@PathVariable Long categoryId){
        return articleRepository.findByCategoryId(categoryId);
    }
    @DeleteMapping("articles/{id}")
    public boolean delete(@PathVariable long id){
        articleRepository.deleteById(id);
        return true;
    }
}
