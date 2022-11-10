/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Item;
import java.util.List;

/**
 *
 * @author admin
 */
public class ItemDAO {
    public Item getItemByID(int id,List<Item> items){
        for (Item item : items) {
            if (item.getProduct().getProductID() ==  id) {
                return item;
            }
        }
        
        return null;
    }
    public List<Item> addItem(Item t,List<Item> items){
        if (getItemByID(t.getProduct().getProductID(),items)!= null) {
            Item i = getItemByID(t.getProduct().getProductID(),items);
            i.setQuantity(i.getQuantity()+t.getQuantity());
        }else{
            items.add(t);
        }
        return items;
    }
    public int getIndex(List<Item> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProduct().getProductID() == id) {
                return i;
            }

        }
        return -1;
    }

    public List<Item> removeItem(List<Item> list, int id) {
        if (getIndex(list, id) != -1) {
            list.remove(getIndex(list, id));
        }
        return list;
    }

    public int getQuantityByID(List<Item> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getProduct().getProductID() == id) {
                return list.get(i).getQuantity();
            }

        }
        return -1;
    }

    public List<Item> addItem(List<Item> list,Item t) {
        int index = getIndex(list,t.getProduct().getProductID());
        if (index != -1) {
            Item i = list.get(index);
            i.setQuantity(i.getQuantity() + t.getQuantity());
        } else {
            list.add(t);
        }
        return list;
    }
}
