/*
 * StatusBean Bean
 */
package com.itcc.bean;

/**
 *
 * @author Icer
 */
public class StatusBean {
    private double money;
    private double inmoney;
    private double outmoney;
    private String username;

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getInmoney() {
        return inmoney;
    }

    public void setInmoney(double inmoney) {
        this.inmoney = inmoney;
    }

    public double getOutmoney() {
        return outmoney;
    }

    public void setOutmoney(double outmoney) {
        this.outmoney = outmoney;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
