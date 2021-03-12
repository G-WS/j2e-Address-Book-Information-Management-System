package com.amaker.dao.impl;

import com.amaker.bean.Addp;
import com.amaker.dao.AddDao;
import com.amaker.util.DButil;
import com.mysql.cj.protocol.Resultset;
import sun.net.ConnectionResetException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddpDaoImpl implements AddDao {
    public void save(Addp a) {
        String sql = "insert into Addresslist(name,phoneNumber,sex,QQ,sort) values(?,?,?,?,?)";
        DButil util = new DButil();
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getPhoneNum());
            pstmt.setString(3, a.getSex());
            pstmt.setString(4, a.getQQ());
            pstmt.setString(5,a.getSort());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
    }

    @Override
    public List seek() {
        String sql = "select sort,id,name from addresslists.new_view ";
        DButil util = new DButil();
        Connection conn = util.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List list = new ArrayList();
            while (rs.next()) {
                String sort = rs.getString(1);
                int id = rs.getInt(2);
                String name = rs.getString(3);

                Addp a = new Addp();
                a.setId(id);
                a.setName(name);
                a.setSort(sort);

                // a.setWechat(Wechat);
                list.add(a);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
        return null;
    }


    @Override
    public void update(Addp a) {
        String sql = "update Addresslist set name=?,phoneNumber=?,sex=?,QQ=? where id=?";
        DButil util = new DButil();
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, a.getName());
            pstmt.setString(2, a.getPhoneNum());
            pstmt.setString(3, a.getSex());
            pstmt.setString(4, a.getQQ());
            pstmt.setInt(5, a.getId());
            /*System.out.println("--------------------");
            System.out.println(a.getId());
*/
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
    }

    @Override
    public void delete(String[] s) {
        String sql = "delete from addresslist where id =?";
        DButil util = new DButil();
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            if (s != null && s.length > 0) {
                for (int i = 0; i < s.length; i++) {
                    int id = new Integer(s[i]).intValue();
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
    }

    @Override
    public Addp get(int id) {
        String sql = "select id,name,phoneNumber,sex,QQ from addresslist where id=?";
        DButil util = new DButil();
        System.out.println("id" +id);
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String sex = rs.getString(4);
                String QQ = rs.getString(5);

                Addp a = new Addp();
                a.setId(id);
                System.out.println("getid"+a.getId());
                a.setName(name);
                a.setPhoneNum(phoneNumber);
                a.setSex(sex);
                a.setQQ(QQ);

                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
        return null;
    }

    public List list() {
        String sql = "select id,name,phoneNumber,sex,QQ from addresslist";
        DButil util = new DButil();
        Connection conn = util.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List list = new ArrayList();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String phoneNumber = rs.getString(3);
                String sex = rs.getString(4);
                String QQ = rs.getString(5);
                //String Wechat = rs.getString(6);
                Addp a = new Addp();
                a.setId(id);
                a.setName(name);
                a.setPhoneNum(phoneNumber);
                a.setSex(sex);
                a.setQQ(QQ);
                // a.setWechat(Wechat);
                list.add(a);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.closeConnection(conn);
        }
        return null;
    }
}
