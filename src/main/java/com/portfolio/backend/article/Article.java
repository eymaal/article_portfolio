package com.portfolio.backend.article;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import javax.persistence.GenerationType;

@Entity
@Data
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String author;
	private LocalDate date;
	private String publication;
	private int visibility = 1;
	@Column(length = 50000, columnDefinition = "TEXT")
	private String content;
}
