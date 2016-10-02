<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="Bean.ProductsBean" %>
  <%@page import="java.util.ArrayList"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เเสดงค่า</title>
</head>
<body>
<table>
<tr>
<th>ProductID</th>
<th>ProductName</th>
<th>SupplierID</th>
<th>CategoryID</th>
<th>QuantityPerUnit</th>
<th>UnitPrice</th>
<th>UnitsInStock</th>
<th>UnitsOnOrder</th>
<th>Discontinued</th>
</tr>
	<table>
	<form action="ProductsIDServlet" method="get">
				<div align="center">
<select name="ProductID">
<% ArrayList<ProductsBean> list =(ArrayList)request.getAttribute("show");
request.setCharacterEncoding("utf-8");  
response.setCharacterEncoding("utf-8");
ProductsBean bean; 
for (int i=0; i<list.size(); i++){
	          bean = (ProductsBean) list.get(i);
%>
<OPTION VALUE=<%=bean.getProductID()%>> &nbsp;<%=bean.getProductName() %></OPTION>
<%-- <tr>
<td><%=bean.getProductID() %></td>
<td><%=bean.getProductName() %></td>
<td><%=bean.getSupplierID() %></td>
<td><%=bean.getCategoryID() %></td>
<td><%=bean.getQuantityPerUnit() %></td>
<td><%=bean.getUnitPrice() %></td>
<td><%=bean.getUnitsInStock() %></td>
<td><%=bean.getUnitsOnOrder() %></td>
<td><%=bean.getDiscontinued() %></td>
</tr> --%>



<% }%>

	</select> &nbsp;<input type="submit" value="ค้นหา">
						<p style="color: Red;">(กรุณาเลือกชื่อที่ต้องการค้นหา)</p>
						</form>
				</div>
			</table>






</body>
</html>