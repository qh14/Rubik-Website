/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Customer;
import entity.ShopInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class ShopInfoDAO {

    public ShopInfo getInfo() throws SQLException {
        String sql = "select * from ShopInfo";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareCall(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new ShopInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return null;
    }

    public boolean UpdateInfo(ShopInfo s) throws SQLException {
        String sql = "Update ShopInfo \n"
                + "SET ShopName=?,ShopPhone = ?,ShopDescription=?,ShopEmail=?,ShopAddress=? ";

        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareCall(sql);
            ps.setString(1,s.getShopName());
            ps.setString(2,s.getShopPhone());
            ps.setString(3,s.getShopDescription());
            ps.setString(4,s.getShopEmail());
            ps.setString(5,s.getShopAddress());
            rs = ps.executeUpdate();

            if (rs==1) {
                return true;
            }
        } catch (Exception e) {
        } finally {
            
            ps.close();
            conn.close();
        }
        return false;
    }
}
