package com.hnjd.news.dao;

import java.sql.SQLException;
import java.util.List;

import com.hnjd.news.entity.News;

/**
 * 
 * @author Administrator
 * 针对user表的所有操作，定义方法
 */
public interface NewsDao {
	//1.查看所有新闻
	public List<News> getAllNews () throws Exception; 
	
	//2.根据不同的新闻类型查看新闻
	public List<News> getNewsByTopicId(int ntid);
	
	//3.根据Id查看某条新闻
	public News getNewsById(int nid) throws Exception;
	
	//4.添加一条新闻
	public int addNews(News news) throws Exception;
	
	//5.根据Id修改新闻
	public int editNews(int nid,News news) throws Exception ;
	
	//5.根据Id删除新闻
	public int deleteNews(int nid) throws SQLException;
}
