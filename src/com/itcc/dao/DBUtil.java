/*
 * 数据库操作类
 * 用 户 名 :  accesskey(应用的accesskey)
 * 密　　码 :  secretkey(应用的secretkey)
 * 主库域名 :  w.rdc.sae.sina.com.cn
 * 从库域名 :  r.rdc.sae.sina.com.cn
 * 端　　口 :  3307
 * 数据库名 :  app_appname(app_加上应用名称)
 */
package com.itcc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Icer
 */
public class DBUtil {

    private static Connection conn;

    /**
     * 关闭数据库连接
     */
    public static void closeConn() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() {
    	
        String username = "root";
        String password = "123456";
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/itcclshz?autoReconnect=true";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = null;
        conn = getConn();
        if (conn != null) {
            System.out.println("hehll");
        } else {
            System.out.println("dafsdfa");
        }
    }
}
