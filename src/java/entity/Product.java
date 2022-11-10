/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.ProductDAO;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class Product {

    private int productID;
    private String productName;
    private String typeName;
    private double price;
    private String info;
    private int grade;
    private String image;

    public Product() {
    }

    public Product(int productID, String productName, String typeName, double price, String info, int grade, String image) {
        this.productID = productID;
        this.productName = productName;
        this.typeName = typeName;
        this.price = price;
        this.info = info;
        this.grade = grade;
        this.image = image;
    }

    public Product(String productName, String typeName, double price, String info, int grade, String image) {
        this.productName = productName;
        this.typeName = typeName;
        this.price = price;
        this.info = info;
        this.grade = grade;
        this.image = image;
    }
    
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() throws SQLException {
        String type = new ProductDAO().getTypeID(typeName);
        return type;

    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", typeName=" + typeName + ", price=" + price + ", info=" + info + ", grade=" + grade + ", image=" + image + '}';
    }

}
