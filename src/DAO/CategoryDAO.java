package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.CategoryBean;
import Bean.ProductsBean;
import db.ConnectionManager;


public class CategoryDAO {
	//ตัวแปรเชื่อมฐานข้อมูล
	static Connection dbconConnection = null;
	ResultSet rs = null; //ตัวแปรคำสั่งSQL
	//ตัวแปร preparedStmt คําสั่ง SQL
	static PreparedStatement preparedStmt; 
	//ส่วนของการเรียกข้อมูลทั้งหมดจากตาราง ในรูป  ArrayList
	
//ประเภทสินค้าทั้งหมด
	public ArrayList<CategoryBean> getCategories() {
		ArrayList<CategoryBean> Categories = new ArrayList<CategoryBean>();

		Statement stmt = null;
				//คําสั่ง SQL
		String sql = "SELECT * FROM Categories";
		try {
			dbconConnection = ConnectionManager.getConnection();
			//เตรียมใช้คำสั่ง SQL
			stmt =  dbconConnection.createStatement();
			
			//run คําสั่ง SQL
			rs = stmt.executeQuery(sql);
			CategoryBean categoryBean;

			while (rs.next()) {
				//ประกาศเรียกใช้CategoryBean ทุกครั้งเมื่อเข้าลูป
				categoryBean = new CategoryBean();
				//เก็บข้อมูลแต่ละ column ไว้ในตัวแปร bean
				categoryBean.setCategoryID(rs.getInt("CategoryID"));
				categoryBean.setCategoryName(rs.getString("CategoryName"));
				categoryBean.setDescription(rs.getString("Description"));
				
				//เก็บข้อมูล bean ไว้ที่ categoryList
				Categories.add(categoryBean);
			}
			//ปิดการทํางาน rs
			rs.close();
		} catch (Exception ex) {
			
		}

		return Categories;

	}
	//รูปภาพประเภทสินค้า
	public byte[] getCatrgoryPicture(int empID) {
		String searchQuery = "select Picture from categories where CategoryID="+ empID;
		Blob imageBlob = null;
		byte[] imgData = null;
		
		try {
			dbconConnection = ConnectionManager.getConnection();
			//เตรียมใช้คำสั่ง SQL
			Statement stmt = dbconConnection.createStatement(); // เตรียมใช้คำสั่ง
																// SQL
			rs = stmt.executeQuery(searchQuery); 				// run คำสั่ง SQL
			if (rs.next()) {
				imageBlob = rs.getBlob(1);
				imgData = imageBlob.getBytes(1, (int) imageBlob.length());
			}
			dbconConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgData;
	}
}

