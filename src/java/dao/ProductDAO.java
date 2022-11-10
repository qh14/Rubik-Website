/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Item;
import entity.Product;
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
public class ProductDAO {

    public List<Product> getAll() throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "select a.MaSP,a.TenSP, b.SubTypeName,a.DonGia,a.ThongTinSP,a.DanhGia,a.images\n"
                + "from SANPHAM a,SubTypeSP b\n"
                + "where a.MaLoai = b.SubTypeID";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                list.add(p);
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;
    }

    public Product getProductByID(int id) throws SQLException {
        String sql = "select a.MaSP,a.TenSP, b.SubTypeName,a.DonGia,a.ThongTinSP,a.DanhGia,a.images\n"
                + "from SANPHAM a,SubTypeSP b\n"
                + "where a.MaLoai = b.SubTypeID and a.MaSP=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                return p;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }

        return null;
    }

    public List<Product> searchProduct(String name) throws SQLException {
        List<Product> products = getAll();
        List<Product> search = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(name.toLowerCase())) {
                search.add(product);
            }
        }
        return search;
    }

    public List<String> getTypeProduct() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "select TenLoai\n"
                + "from TypeSP ";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;

    }

    public String getTypeID(String subtypename) throws SQLException {
        String type = null;
        String sql = "select top 1 SubTypeID\n"
                + " from SubTypeSP \n"
                + "where SubTypeName =? ";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, subtypename);
            rs = ps.executeQuery();
            if (rs.next()) {
                type = rs.getString(1);
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return type;

    }

    public List<String> getSubTypeProduct(String typename) throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "select b.SubTypeName\n"
                + "from TypeSP a, SubTypeSP b\n"
                + "where a.MaLoai = b.MaLoai and a.TenLoai = ?";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, typename);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;

    }

    public List<String> getAllSubTypeProduct() throws SQLException {
        List<String> list = new ArrayList<>();
        String sql = "select b.SubTypeName\n"
                + "from TypeSP a, SubTypeSP b\n"
                + "where a.MaLoai = b.MaLoai";

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;

    }

    public List<Product> getListByType(String name) throws SQLException {
        List<Product> products = getAll();
        List<Product> search = new ArrayList<>();
        for (Product product : products) {
            if (product.getTypeName().toLowerCase().contains(name.toLowerCase())) {
                search.add(product);
            }
        }
        return search;
    }

    public List<Product> getListSearchByType(int page, int pageSize, String name) throws SQLException, Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Product> products = new ArrayList<>();
        String query = "select *\n"
                + "from ( \n"
                + "select SP.MaSP,SP.TenSP,b.SubTypeName,SP.DonGia,SP.ThongTinSP,SP.DanhGia,SP.images, ROW_NUMBER() over (order by MaSP) as rownumber \n"
                + "from SANPHAM SP, SubTypeSP b\n"
                + "where SP.MaLoai = b.SubTypeID and b.SubTypeName = ?\n"
                + ") as tb\n"
                + "              where tb.rownumber >= ? and tb.rownumber <= ? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, from);
            ps.setInt(3, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(3).equals(name)) {
                    Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                    products.add(p);
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return products;
    }

    public List<Product> getListByName(String name) throws SQLException {
        List<Product> list = new ArrayList<>();
        String sql = "select a.MaSP,a.TenSP, b.SubTypeName,a.DonGia,a.ThongTinSP,a.DanhGia,a.images\n"
                + "from SANPHAM a,SubTypeSP b\n"
                + "where a.MaLoai = b.SubTypeID ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.executeQuery();

            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).contains(name)) {
                    Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                    list.add(p);
                }

            }
        } catch (Exception e) {
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;
    }

    public List<Product> getProductFromTo(int page, int pageSize) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Product> products = new ArrayList<>();
        String query = "select SP.MaSP,SP.TenSP,b.SubTypeName,SP.DonGia,SP.ThongTinSP,SP.DanhGia,SP.images\n"
                + "from ( select *, ROW_NUMBER() over (order by MaSP) as rownumber \n"
                + "from SANPHAM) as SP, SubTypeSP b\n"
                + "where SP.rownumber >= ? and SP.rownumber <= ? and SP.MaLoai = b.SubTypeID";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                products.add(p);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return products;
    }

    public List<Product> getProductSearchFromList(int page, int pageSize, String search) throws Exception {
        int from = page * pageSize - (pageSize - 1);
        int to = page * pageSize;
        List<Product> products = new ArrayList<>();
        String query = "select SP.MaSP,SP.TenSP,b.SubTypeName,SP.DonGia,SP.ThongTinSP,SP.DanhGia,SP.images\n"
                + "from ( select *, ROW_NUMBER() over (order by MaSP) as rownumber \n"
                + "from SANPHAM) as SP, SubTypeSP b\n"
                + "where SP.rownumber >= ? and SP.rownumber <= ? and SP.MaLoai = b.SubTypeID";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, from);
            ps.setInt(2, to);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).contains(search)) {
                    Product p = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6), rs.getString(7));
                    products.add(p);
                }

            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return products;
    }

    public String getStringListBuy(List<Item> items) {
        String listbuy = "";
        for (Item item : items) {
            String t = item.getProduct().getProductID() + "," + item.getQuantity() + ";";
            listbuy = listbuy + t;
        }
        return listbuy;
    }

    public List<Item> getListItemFromString(String s) throws SQLException {
        String[] items = s.split(";");
        List<Item> li = new ArrayList<>();
        for (String item : items) {
            String[] products = item.split(",");
            Product p = getProductByID(Integer.parseInt(products[0]));
            int quantity = Integer.parseInt(products[1]);
            Item i = new Item(p, quantity);
            li.add(i);
        }
        return li;
    }

    public List<Product> getListProductFromString(String s) throws SQLException {
        String[] products = s.split(";");
        List<Product> li = new ArrayList<>();
        for (String p : products) {

            Product pd = getProductByID(Integer.parseInt(p));
            li.add(pd);
        }
        return li;
    }

    public List<Item> getListBuyItem(String username) throws SQLException {
        CustomerDAO cdao = new CustomerDAO();
        int id = cdao.getIDFromUserName(username);
        String sql = "SELECT * from ListSPFromAccount\n"
                + "WHERE UserID = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                List<Item> list = getListItemFromString(rs.getString(3));
                return list;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            ps.close();
            con.close();
        }
        return null;
    }

    public boolean updateListBuy(int id, List<Item> items) throws SQLException {
        String sql = "UPDATE ListSPFromAccount\n"
                + "SET ListSPBuy=?\n"
                + "WHERE UserID = ?";

        Connection con = null;
        PreparedStatement ps = null;

        String buy = getStringListBuy(items);
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, buy);

            ps.setInt(2, id);

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

    public List<Product> getListFavoriteItem(String username) throws SQLException {
        CustomerDAO cdao = new CustomerDAO();
        int id = cdao.getIDFromUserName(username);
        String sql = "SELECT * from ListSPFromAccount\n"
                + "WHERE UserID = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                List<Product> list = getListProductFromString(rs.getString(2));
                return list;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {

            ps.close();
            con.close();
        }
        return null;
    }

    public List<Product> getListFavoriteFromTo(int page, int pageSize, List<Product> products) throws SQLException {

        List<Product> list = new ArrayList<>();
        int from = 0;
        int to = 1;
        if ((products.size() - (page) * pageSize) <= 0) {
            from = page * pageSize - pageSize;
            to = products.size() - 1;
            for (int i = from; i <= to; i++) {
                list.add(products.get(i));
            }
        } else {
            from = page * pageSize - pageSize;
            to = page * pageSize - 1;
            for (int i = from; i <= to; i++) {
                list.add(products.get(i));
            }
        }

        return list;
    }

    public String getStringListFavorite(List<Product> products) {
        String listbuy = "";
        for (Product product : products) {
            String s = product.getProductID() + ";";
            listbuy = listbuy + s;
        }
        return listbuy;
    }

    public boolean updateListFavorite(int id, List<Product> products) throws SQLException {
        String sql = "UPDATE ListSPFromAccount\n"
                + "SET ListSPFavorite=?\n"
                + "WHERE UserID = ?";

        Connection con = null;
        PreparedStatement ps = null;

        String favorite = getStringListFavorite(products);
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, favorite);

            ps.setInt(2, id);

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

    public int searchFavorite(List<Product> list, int id) throws SQLException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProductID() == id) {
                return i;
            }

        }
        return -1;
    }

    public String getFirstSentence(String s) throws SQLException {
        String[] words = s.split("[.]");
        return words[0];
    }

    public boolean updateProduct(Product p) throws SQLException {
        String sql = "UPDATE SANPHAM\n"
                + "SET TenSP=?,DonGia=?,MaLoai=?,ThongTinSP=?\n"
                + "WHERE MaSP= ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, new ProductDAO().getTypeID(p.getTypeName()));
            ps.setString(4, p.getInfo());
            ps.setInt(5, p.getProductID());

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

    public boolean removeProduct(int id) throws SQLException {
        String sql = "DELETE FROM SANPHAM WHERE MaSP=?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
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

    public List<Item> updateListProduct(List<Item> list) throws SQLException {
        List<Item> items = new ArrayList<>();
        for (Item i : list) {
            Product p = getProductByID(i.getProduct().getProductID());
            if (p != null) {
                Item newItem = new Item(p, i.getQuantity());
                items.add(newItem);
            }

        }
        return items;

    }

    public boolean addProduct(Product p, int sl) {
        String sql = "INSERT INTO SANPHAM (TenSP ,DonGia ,Soluongconlai ,MaLoai,ThongTinSP ,DanhGia,images) values (?,?,?,?,?,0,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProductName());
            ps.setDouble(2, p.getPrice());
            ps.setInt(3, sl);
            ps.setString(4, new ProductDAO().getTypeID(p.getTypeName()));
            ps.setString(5, p.getInfo());
            ps.setString(6, p.getImage());
            int rs = ps.executeUpdate();
            if (rs == 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }

    public List<Product> getListProductByType(String type) {
        String sql = "select a.MaSP \n"
                + "from SANPHAM a,SubTypeSP c\n"
                + "where a.MaLoai = c.SubTypeID and c.MaLoai = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> list = new ArrayList<>();
        try {
            conn = DBContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Product p = getProductByID(id);
                list.add(p);
            }

        } catch (Exception e) {
        }

        return list;
    }

    public int numberOfProduct(int id) {
        String sql = "select a.Soluongconlai\n"
                + "from SANPHAM a\n"
                + "where a.MaSP =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            ps =  conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return  -1;
    }
}
