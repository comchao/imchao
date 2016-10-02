package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Bean.MemberBean;
import db.ConnectionManager;

public class MemberDAO1 {
	static Connection dbconConnection = null;
	static PreparedStatement pre = null;
public static MemberBean register(MemberBean bean){
	
	String insertSQL = "insert into member (name,username,password,email)" 
	+ "values(?,?,?,?);";
	 try {
		 
		 dbconConnection = ConnectionManager.getConnection(); //เรียกConnectionManager
		  pre = dbconConnection.prepareStatement(insertSQL); //เก็บตัวเเปรคำสั่ง  insertSQL
		  pre.setString(1, bean.getName());
		  pre.setString(2, bean.getUsername());
		  pre.setString(3, bean.getPassword());
		  pre.setString(4, bean.getEmail());
		   int check = pre.executeUpdate(); //ประกาศตัวแปรcheck
		   if (check == 1 ){
			   bean.setValid(true);
		   }else {
			   bean.setValid(false);
		   }   
		   } catch (SQLException ex) {
			System.out.println(ex.getMessage()); //การตรวจสอบข้อผิดพลาดคำสั่งSQL
			bean.setValid(false);
			} finally {
				try{
			} catch (Exception e){
           		System.out.println("finally => " + e.getMessage());
			}
		}
		   return bean;	     
	 }
}
	


