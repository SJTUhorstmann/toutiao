package com.nowcoder.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.nowcoder.dao.NewsDao;
import com.nowcoder.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019/7/15.
 */
@Service
public class NewsService {
    @Autowired
    private NewsDao newsDao;

    public List<News> getLatestNews(int userId,int offset,int limit){
        return newsDao.selectByUserIdAndOffset(userId,offset,limit);
    }
}
