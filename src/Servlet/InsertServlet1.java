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
 * Servlet implementation class InsertServlet1
 */
@WebServlet("/InsertServlet1")
public class InsertServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet1() {
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
		try{
		  request.setCharacterEncoding("utf-8");  
		   response.setCharacterEncoding("utf-8");
		   						//รับค่ามากจากJSP
		   String Name = request.getParameter("name");
		   String Username = request.getParameter("username");
		   String Password = request.getParameter("password");
		   String Email = request.getParameter("email");
		    
		   MemberBean insert = new MemberBean(); //เรียกใช้Bean มีตัวเเปรที่ชื่อ  insert
		   insert.setName(Name); //SET ค่า Name ลง Bean insert
		   insert.setName(Username);
		   insert.setName(Password);
		   insert.setName(Email);
		   
		   MemberDAO.register(insert); //เรียกใช้MemberDAO ที่มีว่า register
		   //ตรวจความถูกต้องเเล้วนำค่าไปเเสดงหน้า JSP
		   if (insert.isValid())
			{
	
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
