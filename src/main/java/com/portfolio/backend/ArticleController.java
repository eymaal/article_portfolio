package com.portfolio.backend;

import java.util.Optional;

import org.apache.logging.log4j.simple.SimpleLogger;
import org.apache.logging.log4j.simple.SimpleLoggerContextFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/portfolio")
public class ArticleController {

	@Autowired
	ArticleService service;
	
	/**
	 * @return list of articles visible to viewers
	 */
	@GetMapping(path="/article")
	public @ResponseBody Iterable<Article> getPublicArticles(){
		return service.getVisibleArticles();
	}
	
	/**
	 * @return list of all articles
	 */
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Article> getArticles(){
		return service.getArticles();
	}
	
	/**
	 * @return list of hidden articles
	 */
	@GetMapping(path="/hidden")
	public @ResponseBody Iterable<Article> getHiddenArticles(){
		return service.getHiddenArticles();
	}
	
	/**
	 * @param id
	 * @return article mapped to given id
	 */
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Article> getArticleById(@PathVariable int id) {
		return service.getArticleById(id);
	}
	
	/**
	 * @param id
	 * @return article mapped to given title
	 */
	@GetMapping(path="/{title}")
	public @ResponseBody Optional<Article> getArticleByTitle(@PathVariable String title) {
		return service.getArticleByTitle(title);
	}
}
