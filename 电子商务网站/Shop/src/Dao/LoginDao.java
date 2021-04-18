package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import Bean.Customer;
import Bean.Goods;
import Bean.Merchant;
import Bean.ShoppingCart;

public class LoginDao {

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
	
	public String checkLogin(String usertype,String userno,String pwd){
		
		Connection conn = getConnection();
		String pwd_temp = null;
		String sql=null;
		if(usertype.equals("customer")) {
			sql="select Cpassword from tb_customer where cno=?";
		}
		else{// if(usertype.equals("merchant")) {
			sql="select Mpassword from tb_merchant where mno=?";
		}
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				pwd_temp=rs.getString(1);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return pwd_temp;
	}
	
	
	public Customer InitCustomerMessage(String userno){
		
		Connection conn = getConnection();
		Customer customer = new Customer();
		try {
			String sql="select * from tb_customer where cno=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				customer.setCno(rs.getString("Cno"));
				customer.setCpassword(rs.getString("Cpassword"));
				customer.setCname(rs.getString("Cname"));
				customer.setCsex(rs.getString("Csex"));
				customer.setCtel(rs.getString("Ctel"));
				customer.setCaddress(rs.getString("Caddress"));
				customer.setCbalance(rs.getDouble("Cbalance"));		
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	

		return customer;
	}//
	
	
	public Merchant InitMerchantMessage(String userno){
		
		Connection conn = getConnection();
		Merchant merchant = new Merchant();
		try {
			String sql="select * from tb_merchant where mno=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				merchant.setMno(rs.getString("Mno"));
				merchant.setMpassword(rs.getString("Mpassword"));
				merchant.setMname(rs.getString("Mname"));
				merchant.setMtel(rs.getString("Mtel"));	
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	

		return merchant;
	}//
	
	
	public ShoppingCart InitCart(String userno){
		
		Connection conn = getConnection();
		ShoppingCart shoppingcart = new ShoppingCart();
		try {
			String sql="select * from tb_ShoppingCart where cno=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				shoppingcart.setSCno(rs.getString("SCno"));	
				shoppingcart.setCno(rs.getString("Cno"));	
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	

		return shoppingcart;
	}//
	
	public boolean checkResign(String userno){
		
		Connection conn = getConnection();
		String is_no=null;
		String sql="select cno from tb_customer where cno=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				is_no=rs.getString(1);
			}
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		if(is_no==null) {
			return true; //可注册
		}else {
			return false;
		}
		
	}
	
	public void toResign(String userno,String pwd){
		
		Connection conn = getConnection();
		String sql="insert into tb_customer  values(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ps.setString(2, pwd);
			ps.setString(3, "未命名");
			ps.setString(4, null);//sex
			ps.setString(5, null);//tel
			ps.setString(6, null);//address
			ps.setDouble(7, 0.00);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		to_give_cart(userno);
	}
	
	public void to_give_cart(String userno){
		
		Connection conn = getConnection();
		String sql="insert into tb_shoppingcart  values(?,?)";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, userno);
			ps.setString(2, userno);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
} //
