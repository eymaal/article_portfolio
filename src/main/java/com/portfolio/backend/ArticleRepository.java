package com.portfolio.backend;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer>{

	Optional<Article> findByTitle(String title);
	Iterable<Article> findByVisibility(int visibility);

}
