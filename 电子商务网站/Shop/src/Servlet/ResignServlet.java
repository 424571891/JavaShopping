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
import Bean.ShoppingCart;
import Dao.LoginDao;

/**
 * Servlet implementation class ResignServlet
 */
@WebServlet("/ResignServlet")
public class ResignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResignServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String userno=request.getParameter("userno");
		String pwd=request.getParameter("pwd");
		
		LoginDao loginDao = new LoginDao();
		//验证是否可注册
		boolean is_resign = loginDao.checkResign(userno);
	
		//判断状态
		if(is_resign==false) {
			request.setAttribute("error", "此用户已注册!");
			request.getRequestDispatcher("/ShoppingWebsite/jsp/login.jsp").forward(request, response);
		}else if(is_resign==true) {
			
			loginDao.toResign(userno,pwd);
			
			response.sendRedirect("/Shop/ShoppingWebsite/jsp/resign_success.jsp");
		}
	}//

}
