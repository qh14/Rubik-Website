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
public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String username;
    private String password;
    private boolean roleAdmin;
    public Customer() {
    }

    public Customer(String customerName, String customerAddress, String customerPhone, String username, String password) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.username = username;
        this.password = password;
        this.roleAdmin = roleAdmin;
    }

    public Customer(int customerID, String customerName, String customerAddress, String customerPhone, String username, String password, boolean roleAdmin) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.username = username;
        this.password = password;
        this.roleAdmin = roleAdmin;
    }
    
    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

   

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", username=" + username + ", password=" + password + ", roleAdmin=" + roleAdmin + '}';
    }

    
    
}
