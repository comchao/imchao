package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Bean.MemberBean;
import db.ConnectionManager;
//คลาสMemberDAO
public class MemberDAO {

	static Connection dbconConnection = null;
	static PreparedStatement pre = null;
	static ResultSet rs = null;
//ประกาศเมธอด
	public static MemberBean register(MemberBean bean) {

		String insertSQL = "insert into member (name,username,password,email)" + "values(?,?,?,?);";
		try {
			dbconConnection = ConnectionManager.getConnection();
			pre = dbconConnection.prepareStatement(insertSQL);

			pre.setString(1, bean.getName());
			pre.setString(2, bean.getUsername());
			pre.setString(3, bean.getPassword());
			pre.setString(4, bean.getEmail());

			int check = pre.executeUpdate();
			if (check == 1) {
				bean.setValid(true);
			} else {
				bean.setValid(false);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			bean.setValid(false);
		} finally {
			try {
			} catch (Exception e) {

				System.out.println("finally => " + e.getMessage());
			}
		}
		return bean;
	}

	//ประกาศเมธอด  รูปแบบอาเรยิลิสต์ ของอ๊อบเจ็คจากคลาส MemberBean ด้วยgetค่าจากลิสต์list
	public ArrayList<MemberBean> getList() {
		
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		
		Statement stmt = null; // ตัวแปรการทํางานคําสั่ง SQL  อ๊อบ เจ็ค  stmt เป็นอ๊อกเจคของคลาส   Statement พร้อมกำกนดค่าเป็น null

		String selectSQL = "SELECT * FROM อะไร   Order By อะไร  ASC"; 

		try {
			// ส่วนเชื่อมฐานข้อมูล
			dbconConnection = ConnectionManager.getConnection(); //เรียกใช้หน้าConnectionManager
			stmt = dbconConnection.createStatement(); // เตรียมใช้คําสั่ง SQL
			rs = stmt.executeQuery(selectSQL); //Queryคําสั่ง SQL
			MemberBean MemberBeanList;  //อ๊อบเจ็ค MemberBeanList เป็นอ๊อบเจ็คของคลาส  MemberBean
			
			//เริ่มต้นการวนลูป เพื่อนำข้อมูลจาก rsที่ละเร็คคอร์ดมาจัดเก็บไว้ใน  อาเรยิลิสต์list ของคลาส MemberBean
			while (rs.next()) {
				
				//สร้างออบเจคใหม่ทุกครั้งเมื่อเริ่มเพื่อใช้ในจากจัดเก็บเร็คคอร์ด  จำนำค่าจากเเต่ละฟิล์ดมากำหนดให้เเต่ละแอททริบิวต์ของ ออบเจค MemberBeanList
				MemberBeanList = new MemberBean();
				//กำหนดค่าให้//อ๊อบเจ็ค MemberBeanList
				MemberBeanList.setUserid(rs.getInt("userid"));
				
							//อะไรบ้าง
				
				list.add(MemberBeanList);

			}
			rs.close(); //ปิดการทำงานrs
			stmt.close(); //ปิดการทำงานstmt
			dbconConnection.close(); ////ปิดการทำงานdbconConnection
		} catch (Exception e) { //จากtry  catch เเสดงค่าภาษา SQL ที่เกิดผิดพลาด
			e.printStackTrace();
		}

		return list;  //รีเทรินค่าให้ list ค้นหาเเล้วเพื่อจัดเก็บข้อมูลตารางใหม่อีกครั้ง
	}
}