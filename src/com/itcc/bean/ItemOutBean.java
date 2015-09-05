/*
 * 支出类别Bean
 */
package com.itcc.bean;

/**
 *
 * @author Icer
 */
public class ItemOutBean {
    private int id;
    private String item;
    private String username;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
