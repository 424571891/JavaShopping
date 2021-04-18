package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.Goods;
import Bean.Stock;

public class Goods_message_Dao {
	
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
	
	public Goods getGoodsMessage(String gno) {
		Goods g = new Goods();
		Connection conn = getConnection();
		String sql="select * from tb_goods where gno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g.setGno(rs.getString("gno"));
				g.setGname(rs.getString("gname"));
				g.setGtype(rs.getString("gtype"));
				g.setGconcrete_type(rs.getString("gconcrete_type"));
				g.setGprice(rs.getDouble("gprice"));
				g.setGmessage(rs.getString("gmessage"));
				g.setGimage(rs.getString("gimage"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}
	
	public Stock getGoodsStock(String gno) {
		Stock g = new Stock();
		Connection conn = getConnection();
		String sql="select * from tb_stock where gno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g.setGno(rs.getString("gno"));
				g.setSno(rs.getString("sno"));
				g.setSTnum(rs.getInt("STnum"));
				g.setSTsales_num(rs.getInt("STsales_num"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return g;
	}
	
	public void updateGoodsMessage(String gno,String Gname,double Gprice,String Gmessage) {
		
		Connection conn = getConnection();
		String sql="update tb_goods set gname=?,gprice=?,gmessage=? where gno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Gname);
			ps.setDouble(2, Gprice);
			ps.setString(3, Gmessage);
			ps.setString(4, gno);
			
			ps.executeUpdate();
		
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
public void insertGoodsMessage(String Gname,String Gtype,String Gconcrete_type,double Gprice,String Gmessage,String Gimage,int num) {
		
		Connection conn = getConnection();
		long gno_1 = System.currentTimeMillis();
		String gno=gno_1+"";
		String sql="insert into tb_goods values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gno);
			ps.setString(2, Gname);
			ps.setString(3, Gtype);
			ps.setString(4, Gconcrete_type);
			ps.setDouble(5, Gprice);
			ps.setString(6, Gmessage);
			ps.setString(7, Gimage);
			ps.executeUpdate();
		
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		StockDao dao= new StockDao();
		dao.updateGoodsStock_insert(gno, num);
		
	}//
}
