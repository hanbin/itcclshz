/*
 * 用户数据库操作类
 */
package com.itcc.dao;

import com.itcc.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Icer
 */
public class UserDao {

    User user = new User();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";

    /**
     * 根据用户名判断是否该用户是否存在
     *
     * @param username
     * @return
     */
    public boolean isExist_username(String username) {
        boolean flag = false;
        sql = "select count(*) from user_tb where username = ?";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                if (rs.getInt(1) != 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
        return flag;
    }

    /**
     * 根据邮箱判断是否该邮箱是否存在
     *
     * @param email
     * @return
     */
    public boolean isExist_email(String username) {
        boolean flag = false;
        sql = "select count(*) from user_tb where email = ?";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1));
                if (rs.getInt(1) != 0) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
        return flag;
    }

    /**
     * 用户注册时调用
     *
     * @param username
     * @param email
     * @return
     */
    public boolean insert(String username,String password, String email) {
        boolean flag = false;
        int i = 0;
        sql = "insert into user_tb values(?,?,?)";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            i = ps.executeUpdate();
            if (i != 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeConn();
        }
        return flag;
    }

    /**
     * 生成随机密码
     *
     * @param pwd_len
     * @return
     */
    public String genRandomNum(int pwd_len) {
        //35是因为数组是从0开始的，26个字母+10个数字
        final int maxNum = 36;
        int i; //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwd_len) {
            //生成随机数，取绝对值，防止生成负数，
            i = Math.abs(r.nextInt(maxNum)); //生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                pwd.append(str[i]);
                count++;
            }
        }
        return pwd.toString();
    }

    public boolean login(String username, String password) {
        boolean flag = false;
        sql = "select password,email from user_tb where username = ?";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            while (rs.next()) {
                String pwd = rs.getString(1);
                String email = rs.getString(2);
                if (pwd.equals(password)) {
                    flag = true;
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setEmail(email);
                }

            }
            setUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeConn();
        }
        return flag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList getAllUsers() {
        ArrayList list = new ArrayList();
        String sql = "select *From user_tb";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setEmail(rs.getString(3));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeConn();
        }
        return list;
    }

    public boolean changePwd(String username, String currpwd, String pwd) {
        boolean flag = false;
        PreparedStatement ps1 = null;
        String sql1 = "select username from user_tb where password=?";
        String sql2 = "update user_tb set password=? where password=?";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql1);
            ps1 = conn.prepareStatement(sql2);
            ps.setString(1, currpwd);
            ps1.setString(1, pwd);
            ps1.setString(2, currpwd);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (username.equals(rs.getString(1))) {
                    int n = ps1.executeUpdate();
                    if (n > 0) {
                        flag = true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            DBUtil.closeConn();
        }
        return flag;
    }

    public static void main(String[] args) {
        //new UserDao().isExist_username("icer");
        // new UserDao().isExist_email("hb1986ice@gmail.com");
        ArrayList list = new ArrayList();
        list = new UserDao().getAllUsers();
        User user = new User();
        for (int i = 0; i < list.size(); i++) {
            
            user = (User) list.get(i);
            System.out.println("username" + user.getUsername());
            System.out.println("password" + user.getPassword());
            System.out.println("email" + user.getEmail());
        }
    }
}
