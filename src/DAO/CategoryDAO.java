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
	// ตัวแปรเชื่อมฐานข้อมูล
	static Connection dbconConnection = null;
	ResultSet rs = null; // ตัวแปรคำสั่งSQL
	// ตัวแปร preparedStmt คําสั่ง SQL
	static PreparedStatement preparedStmt;
	// ส่วนของการเรียกข้อมูลทั้งหมดจากตาราง ในรูป ArrayList

	                 // ประเภทสินค้าCategories
	//ประกาศเมธอด รูปเบบอาเรลิสต์     ที่มีชื่อว่า getCategories
	public ArrayList<CategoryBean> getCategories() {
		//เรียกใช้ArrayList
		//ประกาศออบเจค Categories เป็นออบเจคของอาเรลิสต์เพื่อก็บข้อมูล เป็นออบเจคที่ใช้ในการเเล้วส่งค่าคืนช้อมูลของเมธอด
		ArrayList<CategoryBean> Categories = new ArrayList<CategoryBean>();
		//ประกาศตัวแปร stmt
        Statement stmt = null;
        
		// คําสั่ง SQL
		String sql = "SELECT * FROM Categories";
		try {
			dbconConnection = ConnectionManager.getConnection();
			// เตรียมใช้คำสั่ง SQL
			stmt = dbconConnection.createStatement();
			// run คําสั่ง SQL
			rs = stmt.executeQuery(sql);
			//ประกาศตัวใหม่เพื่อเก็บค่า categoryBean
			CategoryBean categoryBean;
			//วนลูปเก็บข้อมูลทุก
			while (rs.next()) { 
				
				// ประกาศเรียกใช้ CategoryBean ทุกครั้งเมื่อเข้าลูป
				categoryBean = new CategoryBean();
				// เก็บข้อมูลแต่ละ column ไว้ในตัวแปร categoryBean
				categoryBean.setCategoryID(rs.getInt("CategoryID"));
				categoryBean.setCategoryName(rs.getString("CategoryName"));
				categoryBean.setDescription(rs.getString("Description"));
				// เก็บข้อมูลลง bean
				Categories.add(categoryBean);
			}
			// ปิดการทํางาน 
			rs.close();
		} catch (Exception ex) { 
			ex.printStackTrace();  //ตรวจสอบข้อผิดพลาด
		}

		return Categories;  //returnค่า

	}
	
	
	
	
	
	

	// รูปภาพประเภทสินค้า
	// ประกาศเมธอด รูปเบบbyte
	public byte[] getCatrgoryPicture(int empID) {
		String searchQuery = "select Picture from categories where CategoryID=" + empID;
		Blob imageBlob = null;
		byte[] imgData = null;

		try {
			dbconConnection = ConnectionManager.getConnection();
			// เตรียมใช้คำสั่ง SQL
			Statement stmt = dbconConnection.createStatement(); // เตรียมใช้คำสั่ง
																// SQL
			rs = stmt.executeQuery(searchQuery); // run คำสั่ง SQL
			if (rs.next()) {
				imageBlob = rs.getBlob(1); // ไปGETไฟล์รูปมาเก็บไว้ในตังแปรimageBlob
				imgData = imageBlob.getBytes(1, (int) imageBlob.length());
			}
			dbconConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgData;
	}
}
