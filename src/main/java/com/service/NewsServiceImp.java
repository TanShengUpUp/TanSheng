package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.News;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.NewsMapper;

@Service("newsService")
public class NewsServiceImp implements NewsService {

	
	public NewsServiceImp() {
		
		System.out.println("NewsServiceImp");
		
	}
	
	
	@Resource
	private NewsMapper newsMapper;
	
	
	@Override
	public void insert(News record) {
		newsMapper.insert(record);
	}


	@Override
	public List<News> findAll() {
		List<News> list = newsMapper.findAll();
		return list;
	}


	@Override
	public PageInfo<News> page(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<News> list = newsMapper.findAll();
		PageInfo<News> page  =new PageInfo<News>(list);
		
		return page;
	}
}
