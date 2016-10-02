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
 * Servlet implementation class ProductsIDServlet
 */
@WebServlet("/ProductsIDServlet")
public class ProductsIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsIDServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		try{                  //รับฟอร์มหน้า๋ฆญ
			String ProductID =request.getParameter("ProductID");
			System.out.println("ProductID"+ProductID);
			
			ProductsDAO dao = new ProductsDAO(); //เรียกใช้ProductsDAO
			ArrayList<ProductsBean> list = new ArrayList <ProductsBean>();   //เรียกใช้ArrayList
			
			list = dao.selectId(Integer.parseInt(ProductID));
			request.setAttribute("show",list);  //เอาค่าไปเเสดง
			request.setCharacterEncoding("utf-8");  
			response.setCharacterEncoding("utf-8");
			
			String page = "ShowData.jsp" ;//เเสดงหน้า
			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			if(dispatcher != null){
				dispatcher.forward(request,response);
				
			}}catch (Throwable theException)
		{
				System.out.println(theException);  //เเสดงข้อผิดพลาด
		}}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
