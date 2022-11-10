/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class CustomerDAO {

    public Customer getAccount(String username, String password) throws SQLException {
        String sql = "select * from ACCOUNT"
                + " where username = ? and userpass = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareCall(sql);
            ps.setString(1, username.trim());
            ps.setString(2, password.trim());
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return null;
    }

    

    public boolean updateUser(Customer customer) throws SQLException {
        String sql = "UPDATE KHACHHANG\n"
                + "SET HoTenKH = ?, DiaChi= ?,DienThoai=?\n"
                + "WHERE MaKH = ?";

        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getCustomerAddress());
            ps.setString(3, customer.getCustomerPhone());
            ps.setInt(4, customer.getCustomerID());

            int rs = ps.executeUpdate();
            if (rs == 1) {
                System.out.println("Success");
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            ps.close();
            con.close();
        }
        return false;
    }
    public int getIDFromUserName (String username) throws SQLException{
         String sql = "select * from ACCOUNT"
                + " where username = ? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareCall(sql);
            ps.setString(1, username.trim());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return -1;
    }
    public boolean addIDToList(String username) throws SQLException {
        String sql = "INSERT into ListSPFromAccount(UserID) values(?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            int id = getIDFromUserName(username);
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            

            ps.setInt(1, id);

            int rs = ps.executeUpdate();
            if (rs == 1) {
                System.out.println("Success");
                return true;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            ps.close();
            con.close();
        }
        return false;
    }
    public boolean updatePass(int accNo,String pass) throws SQLException {
        String sql = "Update ACCOUNT\n"
                + "SET userpass = ?\n"
                + "where MaAccount = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = -1;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, pass);
            ps.setInt(2, accNo);
            rs = ps.executeUpdate();
            if (rs == 1) {
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
