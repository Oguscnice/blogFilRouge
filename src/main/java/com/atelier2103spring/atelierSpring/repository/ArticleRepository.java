package com.atelier2103spring.atelierSpring.repository;

import com.atelier2103spring.atelierSpring.entity.Article;
import com.atelier2103spring.atelierSpring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByCategoryId(Long id);
}