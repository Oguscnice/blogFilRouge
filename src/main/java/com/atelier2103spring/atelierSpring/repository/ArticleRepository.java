package com.atelier2103spring.atelierSpring.repository;

import com.atelier2103spring.atelierSpring.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}