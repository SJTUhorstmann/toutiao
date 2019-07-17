package com.nowcoder;

import com.nowcoder.dao.NewsDao;
import com.nowcoder.dao.UserDao;
import com.nowcoder.model.News;
import com.nowcoder.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;
import java.util.List;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ToutiaoApplication.class)
@Sql("/init-schema.sql")
public class InitialDatabaseTests {
	@Autowired
	UserDao userDao;

	@Autowired
	NewsDao newsDao;

	@Test
	public void contextLoads() {
		Random random=new Random();
		for(int i=0;i<11;i++){
			News news=new News();
			news.setTitle(String.format("%d",i));
			news.setUserId(1);
			news.setLikeCount(2);
			news.setLink(String.format("http://www.nowcoder.com/%d.html", i));
			news.setImage(String.format("http://images.nowcoder.com/head/%dm.png", random.nextInt(1000)));
			news.setCommentCount(3);
			news.setCreatedDate(new Date());
			newsDao.addNews(news);
		}
//		User user=new User();
//		user.setName("bcd");
//		user.setPassword("123");
//		user.setSalt("123");
//		user.setHeadUrl("123");
//		userDao.addUser(user);
//		User newuser=userDao.selectById(1);
//		System.out.println(newuser.getName());
		List<News> list=newsDao.selectByUserIdAndOffset(1,0,10);
		for(News news:list){
			System.out.println(news.getTitle());
		}
	}

}
