package com.portfolio.backend;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	
	/**
	 * Method to save individual articles by passing required values 
	 * @param title
	 * @param author
	 * @param date
	 * @param publication
	 * @param content
	 * @return true if Article saves successfully, false otherwise.
	 */
	public boolean addArticle(String title, String author, String date, String publication, String content) {
		try{
			Article article = new Article();
			article.setAuthor(author);
			article.setTitle(title);
			article.setDate(Date.valueOf(date));
			article.setPublication(publication);
			article.setContent(content);
			articleRepository.save(article);
			
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	/**
	 * @return All articles
	 */
	public Iterable<Article> getArticles(){
		return articleRepository.findAll();
	}
	
	/**
	 * @param id
	 * @return Article corresponding to id if found; else returns empty.
	 */
	public Optional<Article> getArticleById(int id) {
		return Optional.ofNullable(articleRepository.findById(id).orElse(null));
	}
	
	/**
	 * @param title
	 * @return Article corresponding to given title if found; else returns empty.
	 */
	public Optional<Article> getArticleByTitle(String title) {
		return Optional.ofNullable(articleRepository.findByTitle(title).orElse(null));
	}
	
	/**
	 * @return list of articles set as visible
	 */
	public Iterable<Article> getVisibleArticles(){
		return articleRepository.findByVisibility(1);
	}
	
	/**
	 * @return list of articles set as hidden
	 */
	public Iterable<Article> getHiddenArticles(){
		return articleRepository.findByVisibility(0);
	}
}
