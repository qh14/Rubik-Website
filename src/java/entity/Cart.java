/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;

/**
 *
 * @author admin
 */
public class Cart {
    private List<Item> items;

    public Cart() {
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    public Item getItemByID(int id){
        for (Item item : items) {
            if (item.getProduct().getProductID() ==  id) {
                return item;
            }
        }
        
        return null;
    }
    public int getQuantityByID(int id){
        return getItemByID(id).getQuantity();
    }
    public void addItem(Item t){
        if (getItemByID(t.getProduct().getProductID())!= null) {
            Item i = getItemByID(t.getProduct().getProductID());
            i.setQuantity(i.getQuantity()+t.getQuantity());
        }else{
            items.add(t);
        }
    }
    public void removeItem(int id){
        if (getItemByID(id)!= null) {
            items.remove(getItemByID(id));
        }
    }
    public double getTotalMoney(){
        double t = 0;
        for (Item item : items) {
            t+=item.getQuantity()*item.getQuantity();
        }
        return t;
    }
    
}
