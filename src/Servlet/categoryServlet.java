package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Array;

import Bean.CategoryBean;
import DAO.CategoryDAO;



/**
 * Servlet implementation class productServlet
 */
@WebServlet("/CategotyServlet")
public class categoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public categoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
                              //เรียกรูปประเภทสินค้า CategoryBean
		
		byte[] imgData = null; //ประกาศตัวแปร  imgData
		
		//รับฟอร์มid
		String id = request.getParameter("id");
		
		if (id != null) { //ตัวสอบเงื่อนไข  id != null
			try {
				// สร้าง Object จาก Class CategoryDAO
				CategoryDAO DAO = new CategoryDAO();
				
				// ค้นหารูปภาพประเภทสินค้า
				imgData = DAO.getCatrgoryPicture(Integer.parseInt(id));
				
				// set picture format with jpg
				response.setContentType("image/jpg");
				OutputStream o = response.getOutputStream();
			
				o.write(imgData); // render picture
				o.flush();        // clear render picture
				o.close();        //ปิดการทำงาน
				
			} catch (Exception e) { 
				e.printStackTrace(); //ตรวจสอบข้อผิดพลาด
			}
		}
		
		try   {    
			
			 				//เรียกประเภทCategoryBean
			
			// สร้าง Object จาก Class CategoryDAO
			CategoryDAO DAO = new CategoryDAO();     
			
			//เรียกใช้ ArrayListจากDAO
			ArrayList<CategoryBean> Categories = DAO.getCategories();
			
			request.setAttribute("categoryList", Categories);
		   		            //เเสดงค่า
			String page = "CategoryPhoto.jsp";
		   		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		   		if(dispatcher != null){
		   			
		   			dispatcher.forward(request, response);
		   		}
		}    	                
		    	                      
            catch (Throwable theException)         {     
		    	   System.out.println(theException);    //ตรวจสอบค่าผิดพลาด
		    	   } 
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//TODO Auto-generated method stub
		

	}

}
