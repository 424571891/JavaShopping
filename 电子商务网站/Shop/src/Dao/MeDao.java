package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Customer;
import Bean.Merchant;

public class MeDao {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/shoppingwebsite?serverTimezone=UTC";
			String username="root";
			String password="2259416690";
			
			conn = DriverManager.getConnection(url, username, password);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void toPerfect(String no,String name,String tel,String sex,String address,double balance){
		
		Connection conn = getConnection();
		String sql="update tb_customer set cname=?,ctel=?,csex=?,caddress=?,cbalance=?  where cno=?";
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			ps.setString(3, sex);
			ps.setString(4, address);
			ps.setDouble(5, balance);
			ps.setString(6, no);
			
			row = ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(row>0) {
			System.out.println("执行更改个人信息成功！");
		}else {
			System.out.println("执行更改个人信息失败！");
		}
	}//
	
	public void toPerfect_merchant(String no,String name,String tel){
		
		Connection conn = getConnection();
		String sql="update tb_merchant set mname=?,mtel=?  where mno=?";
		int row = 0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			ps.setString(3, no);
			
			row = ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(row>0) {
			System.out.println("执行更改个人信息成功！");
		}else {
			System.out.println("执行更改个人信息失败！");
		}
	}//
	
	public Customer refresh(String no){
		
		Customer g = new Customer();
		Connection conn = getConnection();
		String sql="select * from tb_customer where cno=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, no);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g.setCno(rs.getString("Cno"));
				g.setCname(rs.getString("Cname"));
				g.setCsex(rs.getString("Csex"));
				g.setCtel(rs.getString("Ctel"));
				g.setCaddress(rs.getString("Caddress"));
				g.setCbalance(rs.getDouble("Cbalance"));
			}
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}//
	
	public Merchant refresh_merchant(String no){
		
		Merchant g = new Merchant();
		Connection conn = getConnection();
		String sql="select * from tb_merchant where mno=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, no);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g.setMno(rs.getString("Mno"));
				g.setMname(rs.getString("Mname"));
				g.setMtel(rs.getString("Mtel"));
			}
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}//
	
	
}
