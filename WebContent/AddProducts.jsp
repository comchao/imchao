<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="AddProductsServlet" method="post">
ชื่อสินค้า: <input type="text" name="ProductName" > <br>
ชื่อผู้ผลิต : <input type="text" name="Supplier" > <br>
ประเภทสินค้า:  <select name="CategoryID">    <br>
  <option value="1">Beverages</option>          <!--  1 -->
  <option value="2">Condiments</option>        <!--  2 -->
  <option value="3">Confections</option>      <!--  3-->
  <option value="4">Dairy Products</option> <!-- 4 -->
  <option value="5">Grains/Cereals</option>     <!--  5 -->
   <option value="6">Meat/Poultry</option>        <!--  6 -->
   <option value="7">Produce</option>     <!--  7 -->
   <option value="8">Seafood</option>  <!-- 8-->
  
</select> <br>
ขนาดสินค้า: <input type="text" name="QuantityPerUnit" > <br>
ราคาสินค้า: <input type="text" name="UnitPrice" > <br>
UnitsInStock:  <input type="text" name="UnitsInStock" > <br>
UnitsOnOrder:  <input type="text" name="UnitsOnOrder" >  <br>
ระดับการสั่งซื้อ:  <input type="text" name="ReorderLevel" >    <br>
   Discontinued:  <select>
  <option value="0">0</option>
  <option value="1">1</option>
   </select> <br>
   <input type="submit"value="เพิ่มข้อมูล">
</form>


</body>
</html>