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
@WebServlet("/categotyServlet")
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
		// TODO Auto-generated method stub
//เรียกรูปประเภทสินค้า CategoryBean
		byte[] imgData = null;
		//รับฟอร์มid
		String id = request.getParameter("id");
		
		if (id != null) {
			try {
			
				CategoryDAO DAO = new CategoryDAO();
			
				imgData = DAO.getCatrgoryPicture(Integer.parseInt(id));
				
				response.setContentType("image/jpg");
				OutputStream o = response.getOutputStream();
			
				o.write(imgData);
				o.flush();
				o.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try   {    
			
			//เรียกประเภทCategoryBean
			CategoryDAO DAO = new CategoryDAO();     
			ArrayList<CategoryBean> Categories = DAO.getCategories();
			request.setAttribute("categoryList", Categories);
		   		String page = "CategoryPhoto.jsp";
		   		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		   		if(dispatcher != null){
		   			
		   			dispatcher.forward(request, response);
		   		}
		}    	                
		    	                      
            catch (Throwable theException)         {     
		    	   System.out.println(theException);   
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
