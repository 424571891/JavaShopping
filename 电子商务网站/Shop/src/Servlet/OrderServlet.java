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
import Bean.Order;
import Bean.SCDetail;
import Bean.ShoppingCart;
import Dao.CartDao;
import Dao.OrderDao;
import Dao.OrderMerchantDao;
import Dao.StockDao;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		Customer customer = (Customer)session.getAttribute("Customer");
		String cno = customer.getCno();
		
		OrderDao dao = new OrderDao();
		List<Order> list = null;
		
		System.out.print("select:"+request.getParameter("select"));
		if("daifahuo".equals(request.getParameter("select"))) {
			list=dao.getOrderList(cno,"daifahuo");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "daifahuo");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_c.jsp").forward(request, response);
		}else if("daishouhuo".equals(request.getParameter("select"))) {
			list=dao.getOrderList(cno,"daishouhuo");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "daishouhuo");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_c.jsp").forward(request, response);
		}else if("complete".equals(request.getParameter("select"))) {
			list=dao.getOrderList(cno,"complete");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "complete");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_c.jsp").forward(request, response);
		}
	}//

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		if("complete".equals(request.getParameter("sub"))) {
			toComplete(request, response);
		}else {
			
		HttpSession session =  request.getSession();
		Customer customer = (Customer)session.getAttribute("Customer");
		double balance = customer.getCbalance();
		double money = Double.parseDouble(request.getParameter("money"));
		OrderDao dao = new OrderDao();
		CartDao cdao = new CartDao();
		StockDao sdao = new StockDao();
		
		if(balance < money) {
			request.getRequestDispatcher("/ShoppingWebsite/jsp/pay_fail.jsp").forward(request, response);
		}else {
			
			String cno=customer.getCno();
			String ono=dao.insert_order(cno,money);//订单号
			
			String gno_check[]=request.getParameterValues("check"); //
			for(int i=0;i<gno_check.length;i++) {
				System.out.println("第"+i+"件商品"+ gno_check[i]);
				SCDetail s = cdao.getSCDetail(gno_check[i]);	
				dao.insert_odetails(ono, s.getGoods().getGno(), s.getSCDnum(), s.getSCDnum() * s.getGoods().getGprice());
				sdao.updateGoodsStock(s.getGoods().getGno(), s.getSCDnum());
				cdao.deleteCart( gno_check[i]);
			}	
			//扣钱
			customer.setCbalance(balance-money);
			session.setAttribute("Customer", customer);
			
			request.getRequestDispatcher("/ShoppingWebsite/jsp/pay_success.jsp").forward(request, response);
			
		}//else
		
		
		}
		
	}//
	
	
	protected void toComplete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ono=request.getParameter("hidden_ono");
		String bt=request.getParameter("hidden_bt");
		if("shouhuo".equals(bt)) {
			OrderDao dao = new OrderDao();
			dao.update_order(ono);
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_complete_success.jsp").forward(request, response);
		}else if("quxiao".equals(bt)) {
			
		}
	}//
	

}
