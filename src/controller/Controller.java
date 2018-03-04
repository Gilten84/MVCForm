package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("email", "");
		request.setAttribute("user", "");
		request.setAttribute("password", "");
		request.setAttribute("message", "");
		String action = request.getParameter("action");
		if (action==null) 
		{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if (action.equals("login")) 
		{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String action = request.getParameter("action");
		if (action==null) 
		{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if (action.equals("dologin")) 
		{
			String email = request.getParameter("email");
			String user = request.getParameter("user");
			String password = request.getParameter("password");
			User userbean = new User(user,email,password);
			
			request.setAttribute("email", email);
			request.setAttribute("user", user);
			request.setAttribute("password", password);
			
			if (userbean.validate())
			{
				request.getRequestDispatcher("/loginsuccess.jsp").forward(request, response);
			}
			else{
				request.setAttribute("message", userbean.getMessage());
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}
		
	}

}
