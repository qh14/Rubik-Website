/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Blog;
import entity.Customer;
import entity.Invoice;
import entity.InvoiceDetail;
import entity.Item;
import entity.Product;
import entity.ShopInfo;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class Main {

    public static void main(String[] args) throws SQLException, Exception {
        ProductDAO dao = new ProductDAO();
        List<Product> p = dao.getAll();
        for (Product product : p) {
            System.out.println(product);
        }
        System.out.println("------");
        List<Product> products = dao.searchProduct("Rubik");
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("-----");
        List<String> li = dao.getSubTypeProduct("Regular-shaped cubes");
        for (String string : li) {
            System.out.println(string);
        }
        System.out.println("-------");
        Product pd = dao.getProductByID(1007);

        System.out.println(pd);
        System.out.println("--");

        List<Product> pl1 = new ProductDAO().getProductFromTo(1, 6);
        for (Product product : pl1) {
            System.out.println(product);
        }
        List<Item> items = new ArrayList<>();
        items.add(new Item(pd, 4));

        System.out.println(dao.getStringListBuy(items));
        System.out.println("---------");
        dao.getListItemFromString(dao.getStringListBuy(items));
        System.out.println("-------------");
        System.out.println(dao.updateListBuy(10001, items));
        int id = new CustomerDAO().getIDFromUserName("huynq");
        System.out.println(id);
        System.out.println("-----");
        List<Item> i1 = dao.getListBuyItem("huynq");
        for (Item item : i1) {
            System.out.println(item);
        }
        System.out.println("----All---");
        List<Product> listt = dao.getListProductByType("Type01");
        for (Product product : listt) {
            System.out.println(product);
        }
        System.out.println("---");
        String s = dao.getFirstSentence("a.b.c");
        System.out.println(s);
        System.out.println("-------");
        List<Product> list2 = dao.getProductFromTo(1, 6);
        for (Product product : list2) {
            System.out.println(product);
        }
        System.out.println("------");
        int bo = dao.searchFavorite(list2, 1006);
        System.out.println(bo);
        System.out.println("-----");
        Customer c = new CustomerDAO().getAccount("huynq", "abc123");
        System.out.println(c);

        double price = Double.parseDouble("150000");
        System.out.println(price);
        List<String> lis = dao.getAllSubTypeProduct();
        for (String li1 : lis) {
            System.out.println(li1);
        }
        ShopInfo info = new ShopInfoDAO().getInfo();
        System.out.println(info);
        String si = new ProductDAO().getTypeID("Rubik 5x5x5");
        System.out.println(pd.getType());
        /*Path temp = Files.copy(Paths.get("C:\\Users\\admin\\Downloads\\bg-3.jpg"),
                Paths.get("D:\\JavaWeb\\Web\\bg-3.jpg"));

        if (temp != null) {
            System.out.println("File renamed and moved successfully");
        } else {
            System.out.println("Failed to move the file");
        }*/
        List<Blog> blog = new BlogDAO().getAll();
        for (Blog blog1 : blog) {
            System.out.println(blog1);
        }
        Product p123 = new Product("Rubik", "Rubik 2x2x2", 120000, "Inffo", 0,"abc");
        System.out.println(p123);
        System.out.println(new ProductDAO().getTypeID(p123.getTypeName()));
        int abc = new InvoiceDAO().MaxMaHD();
        System.out.println(abc);
         List<InvoiceDetail> list22 = new InvoiceDAO().getDetailInvoice(1000019);
         System.out.println(list22);
         int i = dao.numberOfProduct(1002);
         System.out.println(i);
    }
}
