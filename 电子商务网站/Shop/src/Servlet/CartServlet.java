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
import Bean.Goods;
import Bean.SCDetail;
import Bean.ShoppingCart;
import Dao.CartDao;
import Dao.Goods_message_Dao;
import Dao.Goods_show_Dao;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =  request.getSession();
		if(session.getAttribute("Customer")==null) {
			response.sendRedirect("/Shop/ShoppingWebsite/jsp/login.jsp");
		}else {
			CartDao dao = new CartDao();
			List<SCDetail> list = null;
			ShoppingCart sc= (ShoppingCart)session.getAttribute("ShoppingCart");
			String scno = sc.getSCno();
			list=dao.getCart(scno);
		
			request.setAttribute("cart_list", list);
			request.getRequestDispatcher("/ShoppingWebsite/jsp/shoppingCart.jsp").forward(request, response);
		}//else
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(("addCart").equals(request.getParameter("select"))) {
			addCart(request,response);
		}else if(("payment").equals(request.getParameter("select"))) {
			payment(request,response);
		}else if(("delete").equals(request.getParameter("select"))) {
			delete(request,response);
			System.out.print("删除购物车的商品！");
		}
		else {
			System.out.print("Cartservlet没有执行!");
		}
		
		
	}
	
	protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("addCart");
		HttpSession session =  request.getSession();
		if(session.getAttribute("Customer")==null) {
			response.sendRedirect("/Shop/ShoppingWebsite/jsp/login.jsp");
		}else {
			CartDao dao = new CartDao();
			//List<SCDetail> list = null;
			//ShoppingCart sc= (ShoppingCart)session.getAttribute("ShoppingCart");
			//String scno = sc.getSCno();
			String gno = (String)request.getParameter("gno");
			ShoppingCart sc= (ShoppingCart)session.getAttribute("ShoppingCart");
			String scno = sc.getSCno();
			int row = dao.addCart(scno,gno);
			System.out.print("row:"+row);
			if(row>0) {
				request.getRequestDispatcher("/ShoppingWebsite/jsp/addCart_success.jsp").forward(request, response);
			}
		}//else
	}//
	
	protected void payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("payment");
		HttpSession session =  request.getSession();
		Customer customer = (Customer)session.getAttribute("Customer");
		double my_balance = customer.getCbalance();
		
		String gno_check[]=request.getParameterValues("check");//获取存在check里且被选中的购物车明细号
		
		CartDao dao = new CartDao();
		List<SCDetail> list = new ArrayList<SCDetail>();
		
		for(int i=0;i<gno_check.length;i++) {
			System.out.println("第"+i+"件商品"+ gno_check[i]);
			list.add(dao.getSCDetail(gno_check[i]));
		}
		request.setAttribute("check_list", list);
		
		
		request.getRequestDispatcher("/ShoppingWebsite/jsp/create_order.jsp").forward(request, response);
	
	}//
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("delete");
		String gno_check[]=request.getParameterValues("check");//获取存在check里且被选中的购物车明细号
		
		CartDao dao = new CartDao();
		
		for(int i=0;i<gno_check.length;i++) {
			System.out.println("第"+i+"件商品"+ gno_check[i]);//不是gno是scdno
			dao.deleteCart( gno_check[i]);
		}
		
		request.getRequestDispatcher("/ShoppingWebsite/jsp/deleteCart_success.jsp").forward(request, response);
	
	}//

}
