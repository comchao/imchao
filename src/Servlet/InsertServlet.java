package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.MemberBean;
import DAO.MemberDAO;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public InsertServlet() {
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
				 try{
					 
		        request.setCharacterEncoding("utf-8");  
				response.setCharacterEncoding("utf-8");
				String Name = request.getParameter("name");
				System.out.println("Name:"+Name);
				String Username = request.getParameter("username");
				System.out.println("Username:"+Username);
				String Password = request.getParameter("password");
				System.out.println("Password:"+Password);
				String Email = request.getParameter("email");
				System.out.println("Email:"+Email);
			
				
				MemberBean User = new MemberBean();
				User.setName(Name);
				User.setUsername(Username);
				User.setPassword(Password);
				User.setEmail(Email);
				
				MemberDAO.register(User);
				
				if (User.isValid())
				{
				HttpSession session = request.getSession(true);
				session.setAttribute("sessionUser",User);
				response.sendRedirect("Hi.jsp"); 
				}
				else
				response.sendRedirect("register.jsp"); 
				}
				catch (Throwable theException)
				{
				System.out.println(theException);
				}
				}

				
	
}
