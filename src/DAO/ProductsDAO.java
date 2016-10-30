package DAO;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public ArrayList<ProductsBean> getAllTable(int CategoryID) {
		ArrayList<ProductsBean> List = new ArrayList<ProductsBean>();
		;
		String query = "SELECT products.*,CompanyName,CategoryName " + "FROM products,suppliers,categories "
				+ "WHERE products.SupplierID = suppliers.SupplierID "
				+ "AND products.CategoryID = categories.CategoryID " + "AND products.CategoryID=?";

		try {
			dbconConnection = ConnectionManager.getConnection();
			preparedStmt = dbconConnection.prepareStatement(query);
			preparedStmt.setInt(1, CategoryID);
			rs = preparedStmt.executeQuery();
			ProductsBean CategoryList;
			while (rs.next()) {
				CategoryList = new ProductsBean();
				CategoryList.setProductID(rs.getInt("ProductID")); // *1
				System.out.println("ProductID:=" + CategoryList.getProductID());
				CategoryList.setProductName(rs.getString("ProductName")); // *2
				System.out.println("ProductID:=" + CategoryList.getProductName());
				CategoryList.setQuantityPerUnit(rs.getString("QuantityPerUnit")); // *3
				System.out.println("ProductID:=" + CategoryList.getQuantityPerUnit());
				CategoryList.setUnitPrice(rs.getFloat("UnitPrice")); // *4
				System.out.println("ProductID:=" + CategoryList.getUnitPrice());
				CategoryList.setCompanyName(rs.getString("CompanyName")); // *5
				System.out.println("ProductID:=" + CategoryList.getCompanyName());
				CategoryList.setCategoryName(rs.getString("CategoryName")); // *6
				System.out.println("ProductID:=" + CategoryList.getCategoryName());
				List.add(CategoryList);
			}
			preparedStmt.close();
			rs.close(); // ปิดการทำงาน rs
			dbconConnection.close(); // ปิดการทำงาน dbconConnection

		} catch (Exception e) {
			e.printStackTrace(); // เเสดงค่าภาษา SQL ที่เกิดของผิดพลาด
		}
		return List;
	}

	// ส่วนของเพิ่มข้อมูล
	// 1.สร้างเมธอด ทีมีช่อว่า insertProduct

	public static ProductsBean insertProduct(ProductsBean add) {
		String insertSQL = "insert into products (ProductName,SupplierID"
				+ ",CategoryID,QuantityPerUnit,UnitPrice,UnitsInStock" + ",UnitsOnOrder,ReorderLevel,Discontinued)"
				+ "values(?,?,?,?,?,?,?,?,?);";
		try {
			// เชื่อมฐานข้อมูล
			dbconConnection = ConnectionManager.getConnection();
			preparedStmt = dbconConnection.prepareStatement(insertSQL);
			preparedStmt.setString(1, add.getProductName());
			preparedStmt.setInt(2, add.getSupplierID());
			preparedStmt.setInt(3, add.getCategoryID());
			preparedStmt.setString(4, add.getQuantityPerUnit());
			preparedStmt.setFloat(5, add.getUnitPrice());
			preparedStmt.setInt(6, add.getUnitsInStock());
			preparedStmt.setInt(7, add.getUnitsOnOrder());
			preparedStmt.setInt(8, add.getReorderLevel());
			preparedStmt.setInt(9, add.getDiscontinued());
			// สร้างตัวแปร check เช็คค่า preparedStmt
			int check = preparedStmt.executeUpdate();
			if (check == 1) {
				add.setValid(true);
			} else {
				add.setValid(false);
			}
			// เเสดงข้อผิดพลาด
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			add.setValid(false);
		} finally {
			try {
				// ปิดการทํางานเชื่อมต่อฐานข้อมูล
				dbconConnection.close();
				preparedStmt.close();
				// เเสดงข้อผิดพลาด check
			} catch (SQLException e) {
				// เเสดงข้อผิดพลาด check กรณีที่ false
				System.out.println("finally => " + e.getMessage());
			}}  
		 return add; // คืนค่าเมธอด
                  }

	
	           //1.ส่วนของเเก้ไขข้อมูล
	public static ProductsBean UpdateProduct(ProductsBean Bean) {
	        //2.คำสั่งSQLUpdate	    
		String  UpdateSQL = "update products "
				+ "set ProductName = ?,UnitPrice=?,QuantityPerUnit=?,"
				+ "CategoryName=?,CompanyName=? Where ProductID = ? ";
		try{
			// 3. เชื่อมต่อฐานข้อมูล
			 dbconConnection = ConnectionManager.getConnection(); 
             //4. run คําสั่ง preparedStmt
			 preparedStmt = dbconConnection.prepareStatement(UpdateSQL); 
			 preparedStmt.setString(1,Bean.getProductName());      //1
			 preparedStmt.setFloat(2,Bean.getUnitPrice());         //2
			 preparedStmt.setString(3,Bean.getQuantityPerUnit());  //3
			 preparedStmt.setString(4,Bean.getCategoryName());    //4
			 preparedStmt.setString(5,Bean.getCompanyName());    //5
			 preparedStmt.setInt(6,Bean.getProductID());          //6 ค่าที่  Where
			 preparedStmt.executeUpdate();
			 //เช็คค่าGET Bean
			 Bean.setValid(true);
		       //เเสดงค่าที่ผิดพลาด 
		 } catch (SQLException ex) { 
			 System.out.println(ex.getMessage());
			 Bean.setValid(false); 
		    } finally 
		   { try { 
			 preparedStmt.close(); dbconConnection.close(); }
		 
		 catch (Exception e) 
		   { System.out.println("finally => " + e.getMessage());
		  } }
     //คืนค่า เมทธอด
	 return Bean; }
	
		
		
	}