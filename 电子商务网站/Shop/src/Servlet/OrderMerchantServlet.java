package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customer;
import Bean.Order;
import Dao.OrderDao;
import Dao.OrderMerchantDao;

/**
 * Servlet implementation class OrderMerchantServlet
 */
@WebServlet("/OrderMerchantServlet")
public class OrderMerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderMerchantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		OrderMerchantDao dao = new OrderMerchantDao();
		List<Order> list = null;
		
	//	list=dao.getOrderList();
//		request.setAttribute("all_list", list);
//		
//		request.getRequestDispatcher("/ShoppingWebsite/jsp/order_merchant.jsp").forward(request, response);
//		
		
		if("daifahuo".equals(request.getParameter("select"))) {
			list=dao.getOrderList("daifahuo");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "daifahuo");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_m.jsp").forward(request, response);
		}else if("daishouhuo".equals(request.getParameter("select"))) {
			list=dao.getOrderList("daishouhuo");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "daishouhuo");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_m.jsp").forward(request, response);
		}else if("complete".equals(request.getParameter("select"))) {
			list=dao.getOrderList("complete");
			request.setAttribute("order_list", list);
			request.setAttribute("state", "complete");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/order_m.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String ono=request.getParameter("hidden_ono");
		OrderMerchantDao dao = new OrderMerchantDao();
		dao.update_order(ono);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/order_updateSuccess.jsp").forward(request, response);
	}

}
