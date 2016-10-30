package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.ProductsBean;
import DAO.ProductsDAO;

/**
 * Servlet implementation class AddProductsServlet
 */
@WebServlet("/AddProductsServlet")
public class AddProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductsServlet() {
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
		//รับฟอร์ม
		request.setCharacterEncoding("utf-8");  
		response.setCharacterEncoding("utf-8");
		
		String  ProductName = request.getParameter("ProductName");  //1
		System.out.println("ชื่อสินค้า"+ProductName);
		String  SupplierID = request.getParameter("SupplierID");  //2
		String  CategoryID = request.getParameter("CategoryID");		//3
		String  QuantityPerUnit = request.getParameter("QuantityPerUnit"); //4
		String  UnitPrice = request.getParameter("UnitPrice"); 				//5
		String  UnitsInStock = request.getParameter("UnitsInStock");		//6
		String  UnitsOnOrder = request.getParameter("UnitsOnOrder");			//7
		String  ReorderLevel = request.getParameter("ReorderLevel");           //8
		String  Discontinued = request.getParameter("Discontinued");   //9
		//SET TO BEAN
		ProductsBean add = new ProductsBean();
		add.setProductName(ProductName);             //1
		add.setSupplierID(Integer.parseInt(SupplierID));//2
		add.setCategoryID(Integer.parseInt(CategoryID)); //3
		add.setQuantityPerUnit(QuantityPerUnit); //4
		add.setUnitPrice(Float.parseFloat(UnitPrice)); //5
		add.setUnitsInStock(Integer.parseInt(UnitsInStock)); //6
		add.setUnitsOnOrder(Integer.parseInt(UnitsOnOrder)); //7
		add.setReorderLevel(Integer.parseInt(ReorderLevel)); //8
		add.setDiscontinued(Integer.parseInt(Discontinued)); //9
		
		//เรียกใชเDAO
		ProductsDAO.insertProduct(add);
		if(add.isValid()){
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML>");
			out.println("<html>");
			out.println(" <body>");
			out.println(
					" <script>alert('สำเร็จ');window.location='LoginPage.jsp';</script>");
			out.println(" </body>");
			out.println("</html>");
		} else {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML>");
			out.println("<html>");
			out.println(" <body>");
			out.println(
					" <script>alert('ไม่สำเร็จ');window.location='register.jsp';</script>");
			out.println(" </body>");
			out.println("</html>");
		}
	}

}
