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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		               /*   ทำให้เป็นภาษาไทย */
           request.setCharacterEncoding("utf-8");  
           response.setCharacterEncoding("utf-8");
                  
		                   /*รับค่าเเก้ไข */
  String ProductID = request.getParameter("ProductID");              //1
  System.out.println("ProductID:"+ProductID);                   //เเสดงค่าที่รับมา  
  String ProductName = request.getParameter("ProductName");          //2
  System.out.println("ProductName:"+ProductName);                //เเสดงค่าที่รับมา  
  String QuantityPerUnit = request.getParameter("QuantityPerUnit");  //3
  System.out.println("QuantityPerUnit"+QuantityPerUnit);         //เเสดงค่าที่รับมา  
  String UnitPrice = request.getParameter("UnitPrice");              //4
  System.out.println("UnitPrice:"+UnitPrice);                    //เเสดงค่าที่รับมา  
  String CategoryID = request.getParameter("CategoryID");        //5
  System.out.println("CategoryName:"+CategoryID);               //เเสดงค่าที่รับมา  
  
  
  //SET Bean 
  ProductsBean Bean = new ProductsBean ();
  Bean.setProductID(Integer.parseInt(ProductID)); //1
  Bean.setProductName(ProductName);			//2
  Bean.setUnitPrice(Float.parseFloat(UnitPrice));//3
  Bean.setQuantityPerUnit(QuantityPerUnit);  //4
  Bean.setCategoryID(Integer.parseInt(CategoryID));  //5
 
  //เรียกใช้ DAO
  ProductsDAO.UpdateProduct(Bean);
	if(Bean.isValid()){
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println(" <body>");
		out.println(
				" <script>alert('สำเร็จ');window.location='CategotyServlet';</script>");
		out.println(" </body>");
		out.println("</html>");
	} else {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html>");
		out.println(" <body>");
		out.println(
				" <script>alert('ไม่สำเร็จ');window.location='CategotyServlet';</script>");
		out.println(" </body>");
		out.println("</html>");
	}
}

}

  
  
  