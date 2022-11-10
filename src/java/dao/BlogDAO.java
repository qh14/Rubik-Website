/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class BlogDAO {

    public List<Blog> getAll() throws SQLException {
        String sql = "select * from ShopBlog";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Blog> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Blog b = new Blog(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(b);
            }
        } catch (Exception e) {
        }finally{
            ps.close();
            conn.close();
        }
        return list;
    }

    public boolean addContent(Blog b) throws SQLException {
        String sql = "Insert into ShopBlog values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, b.getBlogName());
            ps.setString(2, b.getBlogDescription());
            ps.setString(3, b.getBlogLink());
            ps.setString(4, b.getBlogImage());
            rs = ps.executeUpdate();            
            if (rs == 1) {
                return true;
            }
        } catch (Exception e) {
        }finally{
            ps.close();
            conn.close();
        }
        return false;

    }
}
