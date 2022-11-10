/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Invoice;
import entity.InvoiceDetail;
import entity.Item;
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
public class InvoiceDAO {

    public boolean addInvoice(int MaKH, double toal) throws SQLException {
        String sql = "insert into HOADON(MAKH,TongHD) values(?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, MaKH);
            ps.setDouble(2, toal);
            int rs = ps.executeUpdate();
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

    public boolean addInvoiceDetail(int MaHD, Item i) throws SQLException {
        String sql = "insert into CTHD values(?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, MaHD);
            ps.setInt(2, i.getProduct().getProductID());
            ps.setInt(3, i.getQuantity());
            int rs = ps.executeUpdate();
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

    public int MaxMaHD() throws SQLException {
        String sql = "select *\n"
                + "from (select MAX(MAHD) as Ma from HOADON ) as a, HOADON b\n"
                + "where a.Ma = b.MaHD";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        } finally {
            ps.close();
            conn.close();
        }
        return -1;
    }
    public List<Invoice> getHistory(int id) throws SQLException{
        String sql= "select * from HOADON where MAKH = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Invoice> invoices = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Invoice i = new Invoice(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                invoices.add(i);
            }
            
        } catch (Exception e) {
        }finally{
            rs.close();
            ps.close();
            conn.close();
        }
        return invoices;
    }
    public List<InvoiceDetail> getDetailInvoice(int id) throws SQLException{
        String sql= "select * from CTHD where MAHD = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<InvoiceDetail> invoices = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                InvoiceDetail i = new InvoiceDetail(rs.getInt(1), rs.getInt(2),rs.getInt(3));
                invoices.add(i);
            }
            
        } catch (Exception e) {
        }finally{
            rs.close();
            ps.close();
            conn.close();
        }
        return invoices;
    }
}
