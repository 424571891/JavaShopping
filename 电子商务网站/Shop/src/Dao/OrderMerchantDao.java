package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Bean.ODetail;
import Bean.Order;

public class OrderMerchantDao {
	
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
	
	public List<Order> getOrderList(String state) {
		List<Order> list = new ArrayList<Order>();
		Connection conn = getConnection();
		String sql="select * from tb_order where ostatus=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			if(state.equals("daifahuo")) {
				ps.setString(1, "待发货");
			}else if(state.equals("daishouhuo")) {
				ps.setString(1, "等待顾客收货");
			}else if(state.equals("complete")) {
				ps.setString(1, "已完成");
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Order g = new Order();
				g.setOno(rs.getString("ono"));
				g.setCno(rs.getString("cno"));
				g.setOtime_create(rs.getTimestamp("Otime_create"));
				g.setOtime_complete(rs.getTimestamp("Otime_complete"));
				g.setOstatus(rs.getString("ostatus"));
				g.setOprice(rs.getDouble("oprice"));
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
	

	//发货
	public void update_order(String ono) {
		
		Connection conn = getConnection();
		String sql="update tb_order set ostatus='等待顾客收货' where ono=?";
		try {

			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,ono);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}//
		
	}
	
	
}
