package com.example.article.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.article.dto.Article;

@Mapper
public interface IArticleDao extends IBaseDao<Article> {

	public List<Article> findAllByApprove(@Param("approve") int approve);
	
}
