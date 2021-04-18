package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Goods;
import Dao.Goods_message_Dao;
import Dao.Goods_show_Dao;

/**
 * Servlet implementation class Goods_message_servlet
 */
@WebServlet("/Goods_message_servlet")
public class Goods_message_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Goods_message_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Goods_message_Dao dao = new Goods_message_Dao();
		String s = (String)request.getParameter("gno");
		if(s!=null) {
			System.out.print("商品编号" + s);
		}
		else {
			System.out.print("商品编号==null");
		}
		Goods g = null;
		g=dao.getGoodsMessage(s);
		request.setAttribute("goods", g);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/goods_message.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
