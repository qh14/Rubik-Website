/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ShopListItem {

    private List<Item> list = new ArrayList<>();
    private double total;

    public ShopListItem() {
    }

    public ShopListItem(List<Item> listItem,double alltotal) {
        list = listItem;
        total = alltotal;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public String getTotalString() {
        return total+"";
    }

}
