package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import com.hnjd.news.entity.Topic;
import com.hnjd.news.util.DatabaseUtil;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public List<Topic> getAllTopics() throws SQLException {
		List<Topic> list = new ArrayList<Topic>();
        ResultSet rs = null;
        // 获取所有主题
        String sql = "select * from topic";
        try {
            rs = excuteQuery(sql);
            Topic topic = null;
            while (rs.next()) {
                topic = new Topic();
                topic.setTid(rs.getInt("tid"));
                topic.setTname(rs.getString("tname"));
                list.add(topic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil.closeAll(null, null, rs);
        }
        return list;
	}

	@Override
	public int updateTopic(Topic topic) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Topic findTopicByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addTopic(String name) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into topic(tname) values(?) ";
		
		int excuteUpdate = excuteUpdate(sql, name);
		
		return excuteUpdate;
		
		
	}

	@Override
	public int deleteTopic(int tid) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
