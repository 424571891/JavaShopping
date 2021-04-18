package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Goods;
import Dao.Goods_show_Dao;

/**
 * Servlet implementation class Goods_show_servlet
 */
@WebServlet("/Goods_show_servlet")
public class Goods_show_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Goods_show_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Goods_show_Dao dao = new Goods_show_Dao();
		String s = (String)request.getParameter("goods_type");
//		if(s!=null) {
//			System.out.print(s);
//		}
//		else {
//			System.out.print("s==null");
//		}
		List<Goods> list = null;
		if(("shuma").equals(s)) {
			list=dao.getGoodsMessage("数码");
		}
		
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/goods_show.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
