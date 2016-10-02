package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.ProductsBean;
import db.ConnectionManager; 
public class ProductsDAO1 {
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
}

