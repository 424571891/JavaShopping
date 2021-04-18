package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customer;
import Bean.Merchant;
import Dao.MeDao;

/**
 * Servlet implementation class me
 */
@WebServlet("/MeServlet")
public class MeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeServlet() {
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
		if(session.getAttribute("Customer")!=null) {
			request.getRequestDispatcher("/ShoppingWebsite/jsp/me.jsp").forward(request, response);
		}else if(session.getAttribute("Merchant")!=null) {
			request.getRequestDispatcher("/ShoppingWebsite/jsp/me_merchant.jsp").forward(request, response);
		}else {
			response.sendRedirect("/Shop/ShoppingWebsite/jsp/login.jsp");
		}//else
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(("perfectMe").equals(request.getParameter("select"))) {
			perfectMe(request,response);
		}else if(("perfectMe_merchant").equals(request.getParameter("select"))) {
			perfectMe_merchant(request,response);
		}
		else {
			System.out.print("Meservlet没有执行!");
		}//
		
	}
	
	protected void perfectMe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("perfectMe");
		HttpSession session =  request.getSession();
		MeDao dao = new MeDao();
		Customer customer = (Customer)session.getAttribute("Customer");
		
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String sex = new String(request.getParameter("sex").getBytes("iso-8859-1"),"utf-8");
		String tel = new String(request.getParameter("tel").getBytes("iso-8859-1"),"utf-8");
		String address = new String(request.getParameter("address").getBytes("iso-8859-1"),"utf-8");
		String balance_1 = new String(request.getParameter("balance").getBytes("iso-8859-1"),"utf-8");
		double balance = Double.parseDouble(balance_1);
		
		dao.toPerfect(customer.getCno(),name,tel,sex,address,balance);
		//System.out.print("ssssssss"+request.getParameter("sex"));
		
		customer = dao.refresh(customer.getCno());
		session.setAttribute("Customer", customer);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/me.jsp").forward(request, response);

	}//
	
	protected void perfectMe_merchant(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("perfectMe_merchant");
		HttpSession session =  request.getSession();
		MeDao dao = new MeDao();
		Merchant merchant = (Merchant)session.getAttribute("Merchant");
		
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String tel = new String(request.getParameter("tel").getBytes("iso-8859-1"),"utf-8");

		dao.toPerfect_merchant(merchant.getMno(),name,tel);
		//System.out.print("ssssssss"+request.getParameter("sex"));
		
		merchant = dao.refresh_merchant(merchant.getMno());
		session.setAttribute("Merchant", merchant);
		request.getRequestDispatcher("/ShoppingWebsite/jsp/me_merchant.jsp").forward(request, response);

	}//
	
	

}
