package Bean;
public class ProductsBean {
	 private int ProductID;                 //1
	 String ProductName;            //2
	 int SupplierID;                //3
	 int CategoryID;                //4
	 String QuantityPerUnit;        //5
	 float UnitPrice;               //6
	 int UnitsInStock;              //7
	 String CompanyName ;           //8 *  
	 String  CategoryName;          //9 *
	 public int getProductID() {
		return ProductID;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public int getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	public String getQuantityPerUnit() {
		return QuantityPerUnit;
	}
	public void setQuantityPerUnit(String quantityPerUnit) {
		QuantityPerUnit = quantityPerUnit;
	}
	public float getUnitPrice() {
		return UnitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}
	public int getUnitsInStock() {
		return UnitsInStock;
	}
	public void setUnitsInStock(int unitsInStock) {
		UnitsInStock = unitsInStock;
	}
	public int getUnitsOnOrder() {
		return UnitsOnOrder;
	}
	public void setUnitsOnOrder(int unitsOnOrder) {
		UnitsOnOrder = unitsOnOrder;
	}
	public int getReorderLevel() {
		return ReorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		ReorderLevel = reorderLevel;
	}
	public int getDiscontinued() {
		return Discontinued;
	}
	public void setDiscontinued(int discontinued) {
		Discontinued = discontinued;
	}
	int UnitsOnOrder;              //8
	 int ReorderLevel;              //9
	 int Discontinued;              //10
	 boolean valid; 				//11
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
