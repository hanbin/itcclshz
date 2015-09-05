/*
 * 支出类别管理
 */
package com.itcc.dao;

import com.itcc.bean.ItemOutBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Icer
 */
public class ItemOutDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Statement stmt = null;
    /**
     * 查询方法
     *
     * @param sql 传入查询sql
     * @return
     */
    public ArrayList search(String sql) {
        ArrayList list = new ArrayList();
        try {
            conn = DBUtil.getConn();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ItemOutBean itemoutbean = new ItemOutBean();
                itemoutbean.setId(rs.getInt("id"));
                itemoutbean.setItem(rs.getString("item"));
                
                list.add(itemoutbean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
        return list;
    }
    /**
     * 更新操作
     * @param sql
     * @return 
     */
    public boolean update(String sql) {
        boolean flag = false;
        int n = 0;
        try {
            conn = DBUtil.getConn();
            stmt = conn.createStatement();
            n = stmt.executeUpdate(sql);
            if (n > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
        return flag;
    }
}
