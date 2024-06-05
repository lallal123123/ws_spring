package com.example.jpaPrac.entity;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table( name = "bbs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bbs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bno;
	@Column(length=50 , nullable= false)

	private String title;
	@Column(length=20 , nullable = false)
	private String writer;
	@Column(length=1000 , nullable = false)
	private String content;
	

}
