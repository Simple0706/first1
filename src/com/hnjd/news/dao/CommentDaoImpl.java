package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hnjd.news.entity.Comment;
import com.hnjd.news.util.DatabaseUtil;

public class CommentDaoImpl extends BaseDao implements CommentDao {
	 // 通过nid查找评论
    public List<Comment> getCommentsByNid(int nid) throws SQLException {
        List<Comment> list = new ArrayList<Comment>();
        String sql = "SELECT * FROM `comments` WHERE `cnid` = ?"
                + " ORDER BY `cdate` desc";
        ResultSet rs = null;
        try {
            rs = this.excuteQuery(sql, nid);
            Comment comment = null;
            while (rs.next()) {
                comment = new Comment();
                comment.setCid(rs.getInt("cid"));
                comment.setCnid(rs.getInt("cnid"));
                comment.setCauthor(rs.getString("cauthor"));
                comment.setCip(rs.getString("cip"));
                comment.setCcontent(rs.getString("ccontent"));
                comment.setCdate(rs.getTimestamp("cdate"));
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            DatabaseUtil.closeAll(null, null, rs);
        }
        return list;
    }

    // 添加评论
    public int addComment(Comment comment) throws SQLException {
        String sql = "INSERT INTO `comments`(`CNID`, `CCONTENT`, `CDATE`," +
        		"`CIP`,`CAUTHOR`) VALUES(?, ?, ?, ?, ?)";
//        System.out.println(comment.getCnid() + ":" + comment.getCcontent()
//                + ":" + comment.getCdate() + ":" + comment.getCip() + ":"
//                + comment.getCauthor());
        Object[] params = new Object[] { comment.getCnid(),
                comment.getCcontent(), comment.getCdate(), comment.getCip(),
                comment.getCauthor() };
        int result = 0;
        try {
            result = this.excuteUpdate(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
    // 根据新闻id删除评论
    public int deleteCommentsByNid(int nid) throws SQLException {
        String sql = "DELETE FROM `comments` WHERE `CNID` = ?";
        int result = 0;
        try {
            result = excuteUpdate(sql, nid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
    
    // 删除评论
    public int deleteCommentsById(int cid) throws SQLException {
        String sql = "DELETE FROM `comments` WHERE `CID` = ?";
        int result = 0;
        try {
            result = excuteUpdate(sql, cid);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

}
