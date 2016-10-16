package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Account;

/**
 * Servlet implementation class LoginAdminAction
 */

public class LoginAdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAdminAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();

		if (request.getParameter("submit") != null) {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			Account account=new Account(username, password); 
			if("admin".equals(account.getUsername())&& "123456".equals(account.getPassword())){
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp");
				rd.forward(request, response);
			
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/welcome.jsp?msg=Không phải là admin");
				rd.forward(request, response);
			
			}
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
