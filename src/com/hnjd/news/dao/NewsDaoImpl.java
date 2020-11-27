/**
 * 
 */
package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hnjd.news.entity.News;
import com.hnjd.news.util.DatabaseUtil;

/**
 * @author Administrator
 *
 */
public class NewsDaoImpl extends BaseDao implements NewsDao {

	/* 
	 * 查询所有新闻
	 */
	@Override
	public List<News> getAllNews() throws SQLException {
		List<News> newsList = new ArrayList<News>();
		ResultSet res = excuteQuery("select * from news");
		while(res.next()) {
			News news = new News();
			news.setNid(res.getInt("nid"));
			news.setNtitle(res.getString("ntitle"));
			news.setNsummary(res.getString("nsummary"));
			news.setNpicPath(res.getString("npicPath"));
			news.setNcreateDate(res.getDate("ncreateDate"));
			news.setNmodifyDate(res.getDate("nmodifyDate"));
			news.setNcontent(res.getString("ncontent"));
			news.setNauthor(res.getString("nauthor"));
			news.setNtid(res.getInt("ntid"));
			newsList.add(news);
		}
		DatabaseUtil.closeAll( null, null, res);
		return newsList;
		
	}

	/* 
	 * 根据id查找所有新闻
	 */
	@Override
	public List<News> getNewsByTopicId(int ntid) {
		List<News> newsList = new ArrayList<News>();
		String sql = "select * from news where ntid = ?";
		ResultSet resultSet=null;
		try {
			 resultSet = excuteQuery(sql, ntid);
			while(resultSet.next()) {
				News news = new News();
				news.setNid(resultSet.getInt("nid"));
				news.setNtitle(resultSet.getString("ntitle"));
				news.setNsummary(resultSet.getString("nsummary"));
				news.setNpicPath(resultSet.getString("npicPath"));
				news.setNcreateDate(resultSet.getDate("ncreateDate"));
				news.setNmodifyDate(resultSet.getDate("nmodifyDate"));
				news.setNcontent(resultSet.getString("ncontent"));
				news.setNauthor(resultSet.getString("nauthor"));
				news.setNtid(resultSet.getInt("ntid"));
				newsList.add(news);
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
	            DatabaseUtil.closeAll(null, null, resultSet);
	        }
		
		return newsList;
	}

	/* 
	 * 根据id查找新闻
	 */
	@Override
	public News getNewsById(int nid) throws SQLException {
		String sql = "select * from news where nid = ?";
		ResultSet resultSet = excuteQuery(sql, nid);
		News news = new News();
		while(resultSet.next()) {
			news.setNid(resultSet.getInt("nid"));
			news.setNtid(resultSet.getInt("ntid"));
			news.setNtitle(resultSet.getString("ntitle"));
			news.setNcontent(resultSet.getString("ncontent"));
			news.setNauthor(resultSet.getString("nauthor"));
			news.setNcreateDate(resultSet.getDate("ncreateDate"));
			news.setNmodifyDate(resultSet.getDate("nmodifyDate"));
			news.setNsummary(resultSet.getString("nsummary"));
			news.setNpicPath(resultSet.getString("npicPath"));
		}
		DatabaseUtil.closeAll( null, null, resultSet);
		return news;
	}

	

	
	/* 
	 * 添加新闻
	 */
	@Override
	public int addNews(News news) throws SQLException {
		//���ø���basedao��excuteUpdate������ע������������������
		String sql = "insert into news (ntid,ntitle,nauthor,ncreateDate,npicPath,ncontent,nmodifyDate,nsummary) values (?,?,?,?,?,?,?,?)";
		int result = excuteUpdate(sql , 
				news.getNtid(),
				news.getNtitle(),
				news.getNauthor(),
				news.getNcreateDate(),
				news.getNpicPath(),
				news.getNcontent(),
				news.getNmodifyDate(),
				news.getNsummary());
		return result;
	}

	/* 
	 * 修改新闻
	 */
	@Override
	public int editNews(int nid,News news ) throws SQLException {
		String sql = "update news set  ntid = ?  ,ntitle = ?, nauthor = ? ,ncreateDate = ? ,npicPath = ?, "+
				"ncontent = ? ,nmodifyDate = ?,nsummary = ?  where nid = ? ";
		int result = excuteUpdate(sql, news.getNtid(),
					news.getNtitle(),
					news.getNauthor(),
					news.getNcreateDate(),
					news.getNpicPath(),
					news.getNcontent(),
					news.getNmodifyDate(),
					news.getNsummary(),
					news.getNid());
		return result;
	}

	
	
	/* 
	 * 删除新闻
	 */
	@Override
	public int deleteNews(int nid) throws SQLException {
		String sql = "delete from news where nid = ?";
		int result = excuteUpdate(sql , nid);
		return result;
	}
	/*
	 * limit查询新闻
	 */
	@Override
	public List<News> countnews(int thispage, int showpage) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from news  limit ?,?";
		List<News> newsList = new ArrayList<News>();
		ResultSet res = excuteQuery(sql,thispage,showpage);
		while(res.next()) {
			News news = new News();
			news.setNid(res.getInt("nid"));
			news.setNtitle(res.getString("ntitle"));
			news.setNsummary(res.getString("nsummary"));
			news.setNpicPath(res.getString("npicPath"));
			news.setNcreateDate(res.getDate("ncreateDate"));
			news.setNmodifyDate(res.getDate("nmodifyDate"));
			news.setNcontent(res.getString("ncontent"));
			news.setNauthor(res.getString("nauthor"));
			news.setNtid(res.getInt("ntid"));
			newsList.add(news);
		}
		DatabaseUtil.closeAll( null, null, res);
		return newsList;
		
	}
	/*
	 * 模糊查询新闻
	 */
	@Override
	public List<News> selectLinknews(String a) throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from news where ntitle like ? or nauthor like ?";
		List<News> newsList = new ArrayList<News>();
		ResultSet res = excuteQuery(sql,a,a);
		while(res.next()) {
			News news = new News();
			news.setNid(res.getInt("nid"));
			news.setNtitle(res.getString("ntitle"));
			news.setNsummary(res.getString("nsummary"));
			news.setNpicPath(res.getString("npicPath"));
			news.setNcreateDate(res.getDate("ncreateDate"));
			news.setNmodifyDate(res.getDate("nmodifyDate"));
			news.setNcontent(res.getString("ncontent"));
			news.setNauthor(res.getString("nauthor"));
			news.setNtid(res.getInt("ntid"));
			newsList.add(news);
		}
		DatabaseUtil.closeAll( null, null, res);
		return newsList;
	}
	

}
