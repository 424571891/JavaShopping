package Servlet;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.Customer;
import Bean.Merchant;
import Bean.ShoppingCart;
import Dao.LoginDao;

/**
 * Servlet implementation class Login
 */ 
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//request.setCharacterEncoding("UTF-8");
		String usertype=request.getParameter("usertype");
		String userno=request.getParameter("userno");
		String pwd=request.getParameter("pwd");
		
		LoginDao loginDao = new LoginDao();
		//验证登录
		String pwd_temp = loginDao.checkLogin(usertype, userno, pwd);
	
		//判断状态
		if(pwd_temp==null) {
			request.setAttribute("login_error", "此用户未注册!");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/login.jsp").forward(request, response);
		}else if(!pwd_temp.equals(pwd)) {
			request.setAttribute("login_error", "密码错误!");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/login.jsp").forward(request, response);
		}else if(pwd_temp.equals(pwd)) {
			
			
			//初始化用户信息到session中
			HttpSession session = request.getSession();	
			
			if(usertype.equals("customer")) {
				Customer customer = loginDao.InitCustomerMessage(userno);
				session.setAttribute("Customer", customer);
				ShoppingCart shoppingcart = loginDao.InitCart(userno);
				session.setAttribute("ShoppingCart", shoppingcart);
				response.sendRedirect("/Shop/ShoppingWebsite/jsp/index.jsp");
			}else if(usertype.equals("merchant")) {
				Merchant merchant = loginDao.InitMerchantMessage(userno);
				session.setAttribute("Merchant", merchant);
				response.sendRedirect("/Shop/ShoppingWebsite/jsp/index_merchant.jsp");
			}
				
		}//else
	}//
		
}
