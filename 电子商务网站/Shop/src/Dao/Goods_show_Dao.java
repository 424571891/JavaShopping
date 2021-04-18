package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Bean.Goods;

public class Goods_show_Dao {
	
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
	
	public List<Goods> getGoodsMessage(String goods_type) {
		List<Goods> list = new ArrayList<Goods>();
		Connection conn = getConnection();
		String sql="select * from tb_goods where gtype=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, goods_type);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Goods g = new Goods();
				g.setGno(rs.getString("gno"));
				g.setGname(rs.getString("gname"));
				g.setGtype(rs.getString("gtype"));
				g.setGconcrete_type(rs.getString("gconcrete_type"));
				g.setGprice(rs.getDouble("gprice"));
				g.setGmessage(rs.getString("gmessage"));
				g.setGimage(rs.getString("gimage"));
				list.add(g);
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}	
