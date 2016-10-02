package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.MemberBean;
import DAO.MemberDAO;


/**
 * Servlet implementation class SelectMemberServlet
 */
@WebServlet("/SelectMemberServlet")
public class SelectMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		MemberDAO dao = new MemberDAO(); //เรียกใช้DAO 
		ArrayList<MemberBean> list = dao.getList(); //เรียกใช้ ArrayList 
		request.setAttribute("show", list);  //setAttribute "show" เ
		request.setCharacterEncoding("utf-8");  
		response.setCharacterEncoding("utf-8");
		String page= "hello.jsp"; //เเสดงหน้า
		RequestDispatcher dispatcher = request.getRequestDispatcher(page); 
		if(dispatcher != null){
	   
	    dispatcher.forward(request, response);
		
		}}catch (Throwable theException)
		{
		System.out.println(theException);
		}
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}}
