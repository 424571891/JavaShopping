package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Bean.Customer;
import Bean.Goods;
import Bean.SCDetail;

public class CartDao {
	
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
	
	
	public SCDetail getSCDetail(String SCDno) {
		SCDetail g= new SCDetail();
		
		Connection conn = getConnection();
		String sql="select * from tb_SCDetails where SCDno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, SCDno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				g.setSCDno(rs.getString("scdno"));
				g.setSCno(rs.getString("scno"));
				g.setGno(rs.getString("gno"));
				g.setSCDnum(rs.getInt("scdnum"));
				g.setGoods(getGoodsMessage(rs.getString("gno")));//商品信息也在购物车明细表里
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
			return g;	
	}//
	
	
	
	public List<SCDetail> getCart(String SCno) {
		List<SCDetail> list = new ArrayList<SCDetail>();
		
		Connection conn = getConnection();
		String sql="select * from tb_SCDetails where SCno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, SCno);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SCDetail g = new SCDetail();
				g.setSCDno(rs.getString("scdno"));
				g.setSCno(rs.getString("scno"));
				g.setGno(rs.getString("gno"));
				g.setSCDnum(rs.getInt("scdnum"));
				g.setGoods(getGoodsMessage(rs.getString("gno")));//商品信息也在购物车明细表里
				list.add(g);
			}
			rs.close();
			ps.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
			return list;	
	}//
	
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
	}//
	
	
	public int addCart(String scno,String gno) {
		
		int row = 0;//是否成功
		
		
		int num_before = 0;
		Connection conn = getConnection();
		String sql="select * from tb_scdetails where gno=? and scno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, gno);
			ps.setString(2, scno);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				num_before=(rs.getInt("scdnum"));
			}
			//
			
			if(num_before>0) {	
				Connection conn_2 = getConnection();
				String sql_2="update tb_scdetails set scdnum=? where gno=? and scno=?";
				try {
					PreparedStatement ps_2=conn.prepareStatement(sql_2);
					ps_2.setInt(1, num_before++);
					ps_2.setString(2, gno);
					ps_2.setString(3, scno);
					row=ps_2.executeUpdate();

					ps_2.close();
					conn_2.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}	
			}else {
				Connection conn_3 = getConnection();
				String sql_2="insert into tb_scdetails values(?,?,?,?)";
			//	Timestamp time1 = new Timestamp(System.currentTimeMillis());  //获取系统时间
				String scdno = scno + System.currentTimeMillis();//订单号+系统时间搓=订单细节号
				
				try {
					PreparedStatement ps_3=conn.prepareStatement(sql_2);
					ps_3.setString(1, scdno);
					ps_3.setString(2, scno);
					ps_3.setString(3, gno);
					ps_3.setInt(4, 1);
					row = ps_3.executeUpdate();
			
					ps_3.close();
					conn_3.close();
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}//else
			
			
			
			//
			rs.close();
			ps.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return row;
	}//
	
	public void deleteCart(String scdno) {

		
		Connection conn = getConnection();
		String sql="delete from tb_scdetails where scdno=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, scdno);
			ps.executeUpdate();
			
			ps.close();
			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}//
	
	
}
