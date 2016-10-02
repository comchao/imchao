<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import="Bean.ProductsBean" %>
    <%@page import="java.util.ArrayList"%>
    
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>เเสดงค่ามูล</title>
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

<% ArrayList<ProductsBean> list =(ArrayList)request.getAttribute("show");
request.setCharacterEncoding("utf-8");  
response.setCharacterEncoding("utf-8");
ProductsBean bean; 
for (int i=0; i<list.size(); i++){
	          bean = (ProductsBean) list.get(i);
	          %> 
	<tr>          
<td><%=bean.getProductID() %></td>
<td><%=bean.getProductName() %></td>
<td><%=bean.getSupplierID() %></td>
<td><%=bean.getCategoryID() %></td>
<td><%=bean.getQuantityPerUnit() %></td>
<td><%=bean.getUnitPrice() %></td>
<td><%=bean.getUnitsInStock() %></td>
<td><%=bean.getUnitsOnOrder() %></td>
<td><%=bean.getDiscontinued() %></td>
</tr> 
	            
<% } %>
</table>








</body>
</html>