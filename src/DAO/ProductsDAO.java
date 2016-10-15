package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Bean.ProductsBean;

import db.ConnectionManager;

public class ProductsDAO {

	static Connection dbconConnection = null; // ตัวแปรเชื่อมต่อฐานข้อมูล
	ResultSet rs = null; // ตัวแปรQueryคําสั่ง SQL
	static PreparedStatement preparedStmt; // ตัวแปรpreparedStmt
											// ไปเรียกใช้Queryคําสั่ง SQL

	// ประกาศเมธอด รูปเบบอาเรลิสต์ ที่มีชื่อว่า getList
	public ArrayList<ProductsBean> getList() {

		// ประกาศออบเจค List เป็นออบเจคของอาเรลิสต์เพื่อก็บข้อมูล
		// เป็นออบเจคที่ใช้ในการเเล้วส่งค่าคืนช้อมูลของเมธอด
		ArrayList<ProductsBean> List = new ArrayList<ProductsBean>();// ตัวแปรชื่อ
																		// List

		Statement stmt = null; // ตัวแปรเตรียมการทำงานคำสั่ง SQL ออบเจค stmt
		// เขียนคำสั่ง SQL ตัวเก็บคำสั่งไว้ใน selectSQL
		String selectSQL = "select*from products Order By ProductName ASC";

		try {

			dbconConnection = ConnectionManager.getConnection(); // เรียกใช้หน้าเชื่ือมฐานข้อมูล
			stmt = dbconConnection.createStatement(); // เตรียมใช้คำสั่ง SQL
			rs = stmt.executeQuery(selectSQL); // Queryคำสั่งSQL

			ProductsBean ProductsList; // อออบเจคProductsList
										// //ออบเจคของคลาสProductsBean

			while (rs.next()) {

				ProductsList = new ProductsBean(); // เรียกใช้bean
				// กำหนดค่าให้//อ๊อบเจ็ค ProductsList
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

				// List
				List.add(ProductsList); // setลงBean

			}
			rs.close(); // ปิดการทำงาน rs
			stmt.close(); // ปิดการทำงาน stmt
			dbconConnection.close(); // ปิดการทำงาน dbconConnection

		} catch (Exception e) {
			e.printStackTrace(); // เเสดงค่าภาษา SQL ที่เกิดของผิดพลาด
		}

		return List;

	}

	public ArrayList<ProductsBean> selectId(int ProductID) {
		System.out.println("มาเเล้ว" + ProductID);

		ArrayList<ProductsBean> List = new ArrayList<ProductsBean>();// ตัวแปรชื่อ
																		// List

		String selectSQL = "select*from products where ProductID = ?";
		try {

			dbconConnection = ConnectionManager.getConnection();
			preparedStmt = dbconConnection.prepareStatement(selectSQL);
			preparedStmt.setInt(1, ProductID);
			rs = preparedStmt.executeQuery();

			ProductsBean ProductsList; // อออบเจคProductsList
										// //ออบเจคของคลาสProductsBean
			while (rs.next()) {
				ProductsList = new ProductsBean();
				// กำหนดค่าให้//อ๊อบเจ็ค ProductsList
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
				List.add(ProductsList);

			}
			preparedStmt.close();
			rs.close(); // ปิดการทำงาน rs
			dbconConnection.close(); // ปิดการทำงาน dbconConnection

		} catch (Exception e) {
			e.printStackTrace(); // เเสดงค่าภาษา SQL ที่เกิดของผิดพลาด
		}
		return List;
	}

	// เอาข้อมูลของ ประเภท CategoryID ในตาราง Product
}