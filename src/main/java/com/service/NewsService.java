package com.service;

import java.util.List;

import com.entity.News;
import com.github.pagehelper.PageInfo;

public interface NewsService {

	void insert(News record);
	
	List<News> findAll();
	
	public PageInfo<News> page(int pageNo,int pageSize);
}