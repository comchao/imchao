package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ProductsBean;
import DAO.ProductsDAO;

/**
 * Servlet implementation class ProductsServlet1
 */
@WebServlet("/ProductsServlet1")
public class ProductsServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("utf-8");  
		response.setCharacterEncoding("utf-8");
		try {
			//เรียกใช้ ProductsDAO มีที่ว่า dao 
	ProductsDAO dao = new  ProductsDAO();
	                //เรียกใช้ArrayList
	ArrayList<ProductsBean> list  = dao.getList();
	request.setAttribute("show",list);
	String page = "Hi1.jsp"; //เอาค่าไปเเสดง
	RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if(dispatcher !=null){
			dispatcher.forward(request,response);
		}}catch(Throwable theException)
		{System.out.println(theException);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
    
	
}
