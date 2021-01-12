package com.portfolio.backend.article;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.GenerationType;

@Entity
@Data
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String author;
	private Date date;
	private String publication;
	private int visibility = 1;
	@Lob
	@Column(length = 50000)
	private String content;
}
