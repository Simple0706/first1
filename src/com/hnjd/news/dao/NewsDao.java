package com.hnjd.news.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.hnjd.news.entity.News;

/**
 * 
 * @author Administrator
 * ���user������в��������巽��
 */
public interface NewsDao {
	//1.显示查找新闻
	public List<News> getAllNews () throws Exception; 
	
	//2.根据id查找所有新闻
	public List<News> getNewsByTopicId(int ntid);
	
	//3.根据id查找新闻
	public News getNewsById(int nid) throws Exception;
	
	//4.添加新闻
	public int addNews(News news) throws Exception;
	
	//5.修改新闻
	public int editNews(int nid,News news) throws Exception ;
	
	//5.删除新闻
	public int deleteNews(int nid) throws SQLException;
	
	//6.模糊查询新闻
	public List<News> selectLinknews(String a) throws Exception;
	
	//7.limit查询新闻
	public List<News> countnews(int thispage,int showpage ) throws SQLException ;
}
	

