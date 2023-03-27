package com.atelier2103spring.atelierSpring.controller;

import com.atelier2103spring.atelierSpring.entity.Article;
import com.atelier2103spring.atelierSpring.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    ArticleRepository articleRepository;
    @GetMapping("/articles")
    public List<Article> index(){
        return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable long id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article article){
        article.setCreatedAt(new Date());
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

    @DeleteMapping("articles/{id}")
    public boolean delete(@PathVariable long id){
        articleRepository.deleteById(id);
        return true;
    }
}
