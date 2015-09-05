/*
 * 明细管理
 */
package com.itcc.dao;

import com.itcc.bean.Detail;
import com.itcc.bean.StatusBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Icer
 */
public class DetailDao {

    int sumRecord = 0;   //显示的总记录条数
    int pageRecord = 8;   //每页显示的记录数
    int pageNum = 0;      //显示的总页码数
    int showPage = 1;   //所要显示的页码数
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
                Detail detail = new Detail();
                detail.setId(rs.getInt("id"));
                detail.setItem(rs.getString("item"));
                detail.setMoney(rs.getInt("money"));
                detail.setDate(rs.getDate("indate"));
                detail.setMust(rs.getString("must"));
                detail.setInout(rs.getString("inorout"));
                detail.setDetail(rs.getString("detail"));
                detail.setUsername(rs.getString("username"));
                list.add(detail);
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
     *
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

    /**
     * 获取账户状态
     *
     * @param username
     * @return
     */
    public ArrayList getStatus(String username) {
        ArrayList list = new ArrayList();
        String sql = "select inmoney,outmoney,(inmoney-outmoney) from (select sum(money) as inmoney from detail_tb where inorout='0' and username=?) a, (select sum(money) as outmoney from detail_tb where inorout='1' and username=?) b ";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                StatusBean statusBean = new StatusBean();
                statusBean.setInmoney(rs.getDouble(1));
                statusBean.setOutmoney(rs.getDouble(2));
                statusBean.setMoney(rs.getDouble(3));
                statusBean.setUsername(username);
                if(statusBean.getInmoney() == 0){
                    statusBean.setMoney(-statusBean.getOutmoney());
                }else if(statusBean.getOutmoney() == 0){
                    statusBean.setMoney(statusBean.getInmoney());
                }
                list.add(statusBean);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取总记录数
     *
     * @param sql
     * @return
     */
    public int getSumRecord(String inorout) {
        int sumRecord = 0;
        String sql = "select *from detail_tb where inorout=?";
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, inorout);
            rs = ps.executeQuery();
            rs.last();
            sumRecord = rs.getRow();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn();
        }
        return sumRecord;
    }
    /**
     * 收入明细分页显示
     * @param n
     * @return 
     */
    public ArrayList getData_in(int n,String username) {
        ArrayList list = new ArrayList();
        sumRecord = getSumRecord("0");
        /*************计算总页数************/
        if (sumRecord % pageRecord == 0) {
            pageNum = sumRecord / pageRecord;
        } else {
            pageNum = sumRecord / pageRecord + 1;
        }
        
        String sql = "select *From detail_tb where inorout = '0' and username=?";
        if (n < 1) {
            n = 1;
        }
        if (n >= pageNum) {
            n = pageNum;
        }
        
        int begin = (n - 1) * pageRecord + 1;//获取第n页的第一条记录的位置
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.absolute(begin);
            for (int i = 0; i < pageRecord && (begin + i) <= sumRecord; i++) {
                Detail detail = new Detail();
                detail.setId(rs.getInt("id"));
                detail.setItem(rs.getString("item"));
                detail.setMoney(rs.getDouble("money"));
                detail.setDate(rs.getDate("indate"));
                detail.setMust(rs.getString("must"));
                detail.setInout(rs.getString("inorout"));
                detail.setUsername(rs.getString("username"));
                detail.setDetail(rs.getString("detail"));
                list.add(detail);
                rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 支出明细分页
     * @param n
     * @return 
     */
    public ArrayList getData_out(int n,String username) {
        ArrayList list = new ArrayList();
        sumRecord = getSumRecord("1");
        /*************计算总页数************/
        pageNum = getPageNum("1");
        String sql = "select *From detail_tb where inorout = '1' and username=?";
        if (n < 1) {
            n = 1;
        }
        if (n >= pageNum) {
            n = pageNum;
        }
        int begin = (n - 1) * pageRecord + 1;//获取第n页的第一条记录的位置
        try {
            conn = DBUtil.getConn();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            rs.absolute(begin);
            for (int i = 0; i < pageRecord && (begin + i) <= sumRecord; i++) {
                Detail detail = new Detail();
                detail.setId(rs.getInt("id"));
                detail.setItem(rs.getString("item"));
                detail.setMoney(rs.getDouble("money"));
                detail.setDate(rs.getDate("indate"));
                detail.setMust(rs.getString("must"));
                detail.setInout(rs.getString("inorout"));
                detail.setUsername(rs.getString("username"));
                detail.setDetail(rs.getString("detail"));
                list.add(detail);
                rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public int getSumRecord() {
        return sumRecord;
    }

    public void setSumRecord(int sumRecord) {
        this.sumRecord = sumRecord;
    }

    public int getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(int pageRecord) {
        this.pageRecord = pageRecord;
    }

    public int getPageNum(String inorout) {
        sumRecord = getSumRecord(inorout);
        if (sumRecord % pageRecord == 0) {
            pageNum = sumRecord / pageRecord;
        } else {
            pageNum = sumRecord / pageRecord + 1;
        }
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getShowPage() {
        return showPage;
    }

    public void setShowPage(int showPage) {
        this.showPage = showPage;
    }

    public static void main(String[] args) {
        ArrayList list = new DetailDao().getData_in(1,"nemo");
        for (int i = 0; i < list.size(); i++) {
            Detail detail = (Detail) list.get(i);
            System.out.println("item:" + detail.getItem());
            System.out.println("money：" + detail.getMoney());
        }
    }
}
