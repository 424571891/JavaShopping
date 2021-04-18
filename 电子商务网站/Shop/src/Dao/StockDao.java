package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.Goods;
import Bean.Stock;

public class StockDao {

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
	
	public void updateGoodsStock(String gno,int num) {
		
		Connection conn = getConnection();
		String sql="update tb_stock  set stnum=(stnum-?),stsales_num=(stsales_num+?) where gno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, num);
			ps.setString(3, gno);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}//
	
	public void updateGoodsStock_add(String gno,int num) {
		
		Connection conn = getConnection();
		String sql="update tb_stock  set stnum=(stnum+?) where gno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, gno);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}//
	
	public void updateGoodsStock_insert(String gno,int num) {
		
		Connection conn = getConnection();
		String sql="insert into tb_stock  values(?,'S001',?,'0')";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(2, num);
			ps.setString(1, gno);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}//
}
