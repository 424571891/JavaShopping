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

public class OrderDao {

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
	
	public List<Order> getOrderList(String cno,String state) {
		List<Order> list = new ArrayList<Order>();
		Connection conn = getConnection();
		String sql="select * from tb_order where cno=? and ostatus=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, cno);
			if(state.equals("daifahuo")) {
				ps.setString(2, "待发货");
			}else if(state.equals("daishouhuo")) {
				ps.setString(2, "等待顾客收货");
			}else if(state.equals("complete")) {
				ps.setString(2, "已完成");
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
	
	public List<ODetail> getODetailList(String ono) {
		List<ODetail> odetailList = new ArrayList<ODetail>();
		Connection conn = getConnection();
		String sql="select * from tb_odetails where ono=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, ono);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ODetail g = new ODetail();
				g.setODno(rs.getString("odno"));
				g.setOno(rs.getString("ono"));
				g.setGno(rs.getString("gno"));
				g.setODnum(rs.getInt("odnum"));
				g.setODprice(rs.getDouble("odprice"));
				odetailList.add(g);
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return odetailList;
	}
	
	
	public String insert_order(String cno,double money) {
		String ono = cno + System.currentTimeMillis();
	//	List<Order> list = new ArrayList<Order>();
		Connection conn = getConnection();
		String sql="insert into tb_order values(?,?,?,null,'待发货',?)";
		try {
			Timestamp time = new Timestamp(System.currentTimeMillis()); 
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1,ono);
			ps.setString(2, cno);
			ps.setTimestamp(3,time);
			ps.setDouble(4,money);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}//
		
		return ono; //返回订单号
	}
	
	
	public void insert_odetails(String ono,String gno,int odnum,double odprice) {
		//List<Order> list = new ArrayList<Order>();
		Connection conn = getConnection();
		String sql="insert into tb_odetails values(?,?,?,?,?)";
		try {
		//	Timestamp time = new Timestamp(System.currentTimeMillis()); 
			String odno = "1" + System.currentTimeMillis();
			PreparedStatement ps=conn.prepareStatement(sql);
			
			
			ps.setString(1,odno);
			ps.setString(2, ono);
			ps.setString(3, gno);
			ps.setInt(4, odnum);
			ps.setDouble(5, odprice);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}//
	}
	
	//收货
	public void update_order(String ono) {
		
		Connection conn = getConnection();
		String sql="update tb_order set ostatus='已完成' where ono=?";
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
