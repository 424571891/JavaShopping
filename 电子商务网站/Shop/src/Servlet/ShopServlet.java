package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customer;
import Bean.SCDetail;
import Dao.CartDao;
import Dao.Goods_message_Dao;
import Dao.StockDao;

/**
 * Servlet implementation class ShopServlet
 */
@WebServlet("/ShopServlet")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//String gno=request.getParameter("gno");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(("updateGoods").equals(request.getParameter("select"))) {
			updateGoods(request,response);
		}else if(("addGoods").equals(request.getParameter("select"))) {
			addGoods(request,response);
		}else {
			System.out.print("Cartservlet没有执行!");
		}
	}
	
	protected void updateGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("updateGoods");
		
		String gno = request.getParameter("gno");
		Goods_message_Dao dao = new Goods_message_Dao();
		StockDao dao_1 = new StockDao();
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String message = new String(request.getParameter("message").getBytes("iso-8859-1"),"utf-8");
		String price_1 = new String(request.getParameter("price").getBytes("iso-8859-1"),"utf-8");
		String addnum = request.getParameter("addnum");
		double price = Double.parseDouble(price_1);
		if(addnum!=null && !addnum.contentEquals("")) {
			int num=Integer.parseInt(addnum);
			dao_1.updateGoodsStock_add(gno, num);
		}
		dao.updateGoodsMessage(gno, name, price, message);
		
		request.setAttribute("gno", gno);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/goods_update_success.jsp").forward(request, response);
	
	}//
	
	protected void addGoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("addGoods");
		
		Goods_message_Dao dao = new Goods_message_Dao();
		
		String type = new String(request.getParameter("type").getBytes("iso-8859-1"),"utf-8");
		String concrete_type = new String(request.getParameter("concrete_type").getBytes("iso-8859-1"),"utf-8");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String message = new String(request.getParameter("message").getBytes("iso-8859-1"),"utf-8");
		String price_1 = new String(request.getParameter("price").getBytes("iso-8859-1"),"utf-8");
		String img = new String(request.getParameter("img").getBytes("iso-8859-1"),"utf-8");
		String addnum = request.getParameter("addnum");
		double price = Double.parseDouble(price_1);
		int num=Integer.parseInt(addnum);
		
		//System.out.print("ssss:"+name+type+ concrete_type+ price+ message+ img+num);
		dao.insertGoodsMessage(name, type, concrete_type, price, message, img,num);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/goods_insert_success.jsp").forward(request, response);
	
	}//

}
