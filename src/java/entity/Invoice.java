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
public class Invoice {
    private int invoiceID;
    private int customerID;
    private double totalPrice;
    public Invoice() {
    }

    public Invoice(int invoiceID, int customerID, double totalPrice) {
        this.invoiceID = invoiceID;
        this.customerID = customerID;
        this.totalPrice = totalPrice;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceID=" + invoiceID + ", customerID=" + customerID + ", totalPrice=" + totalPrice + '}';
    }
    
}
