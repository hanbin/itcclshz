/*
 * 收入类别数据库操作
 */
package com.itcc.dao;

import com.itcc.bean.ItemInBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Icer
 */
public class ItemInDao {
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
                ItemInBean iteminbean = new ItemInBean();
                iteminbean.setId(rs.getInt("id"));
                iteminbean.setItem(rs.getString("item"));
                list.add(iteminbean);
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
