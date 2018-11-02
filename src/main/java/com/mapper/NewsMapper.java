package com.mapper;

import java.util.List;

import com.entity.News;

public interface NewsMapper {
    int delete(Integer id);

    int insert(News record);
    
    List<News> findAll();

    News select(Integer id);

    int update(News record);

    
}