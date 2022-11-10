/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author admin
 */
public class InvoiceDetail {

    private int invoiceID;
    private int productID;
    private int quantity;

    public InvoiceDetail() {
    }

    public InvoiceDetail(int invoiceID, int productID, int quantity) {
        this.invoiceID = invoiceID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" + "invoiceID=" + invoiceID + ", productID=" + productID + ", quantity=" + quantity + '}';
    }

}
