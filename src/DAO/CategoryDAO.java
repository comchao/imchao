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
	//ประกาศเมธอดรูปอาเรลิสต์ คลาสProductsBean ออบเจค การGetะค่าจากList
public ArrayList<ProductsBean> getList(){ 
ArrayList<ProductsBean> List = new 	ArrayList<ProductsBean>();
Statement stmt = null; //ตัวแปรเตรียมการทำงานคำสั่งSQL	ออบเจคstmt
//เขียนคำสั่ง SQL ตัวเก็บคำสั่งใว้ในselectSQL
String 	selectSQL = "select*from products Order By ProductName ASC";
try{
	                   //ส่วนของเชื่อมฐานข้อมูล
	//เรียกใช้หน้าเชื่ือมฐานข้อมูล
	dbconConnection = ConnectionManager.getConnection();
	//เตรียมใช้คำสั่ง SQL
	stmt =  dbconConnection.createStatement();
	//Queryคำสั่งSQL
	rs = stmt.executeQuery(selectSQL); 
	     //ออบเจคของคลาสProductsBean
	ProductsBean ProductsList;
	while(rs.next()){
		ProductsList = new ProductsBean();
		//กำหนดค่าให้//อ๊อบเจ็ค ProductsList
ProductsList.setProductID(rs.getInt("ProductID"));
ProductsList.setProductName(rs.getString("ProductName"));
ProductsList.setSupplierID(rs.getInt("SupplierID"));
ProductsList.setCategoryID(rs.getInt("CategoryID"));
ProductsList.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
ProductsList.setUnitPrice(rs.getFloat("UnitPrice"));
ProductsList.setUnitsInStock(rs.getInt("UnitsInStock"));
ProductsList.setUnitsOnOrder(rs.getInt("UnitsOnOrder"));
ProductsList.setReorderLevel(rs.getInt("ReorderLevel"));
ProductsList.setDiscontinued(rs.getInt("Discontinued"));		
//List ตัวแปรของ ArrayList add ProductsList set ProductsBean
List.add(ProductsList);	 
		}
	rs.close(); //ปิดการทำงาน rs
	stmt.close(); //ปิดการทำงานstmt
	dbconConnection.close();//ปิดการทำงานdbconConnection
	
}catch (Exception e){
	e.printStackTrace(); //เเสดงค่าภาษาSQL ที่เกิดของผิดพลาด
} 
	return List;
	
}

//ประเภทสินค้าทั้งหมด
	public ArrayList<CategoryBean> getCategories() {
		ArrayList<CategoryBean> Categories = new ArrayList<CategoryBean>();

		Statement stmt = null;
		String sql = "SELECT * FROM Categories";
		try {
			dbconConnection = ConnectionManager.getConnection();
			//เตรียมใช้คำสั่ง SQL
			stmt =  dbconConnection.createStatement();
			rs = stmt.executeQuery(sql);
			CategoryBean categoryBean;

			while (rs.next()) {
				categoryBean = new CategoryBean();
				categoryBean.setCategoryID(rs.getInt("CategoryID"));
				categoryBean.setCategoryName(rs.getString("CategoryName"));
				categoryBean.setDescription(rs.getString("Description"));
				categoryBean.setPicture(rs.getString("Picture"));
				categoryBean.setValue(rs.getInt("CategoryID"));
				categoryBean.setDisplayText(rs.getString("CategoryName"));
	
				Categories.add(categoryBean);
			}
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

