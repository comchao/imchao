<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.MemberDAO,Bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เรียกข้อมมูล</title>
</head>
<body>	
<center>
<table bgcolor="blue">
<tr>
<th>ID:</th>
<th>ชื่อ:</th>
<th>Username:</th>
<th>Password:</th>
<th>Email:</th>
<th>ล่าสุด:</th>
</tr>

<%  ArrayList<MemberBean> list = (ArrayList)request.getAttribute("show") ;%>
<%  MemberBean bean;     for (int i=0; i<list.size(); i++){
							bean = (MemberBean) list.get(i); %>

	
<tr>
					<td><%=bean.getUserid()%></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getUsername()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getEmail()%></td>
					<td><%=bean.getDatetime()%></td>
			</tr>
				<% }%>	</table>
</center>
</body>
</html>