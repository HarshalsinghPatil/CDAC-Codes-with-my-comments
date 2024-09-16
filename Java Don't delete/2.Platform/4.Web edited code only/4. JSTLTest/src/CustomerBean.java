package classic.web.app;

import java.sql.*;
import java.util.*;
//here we are selling the product but we are not directly selling the product using the online orders .BUT we have sales agent who convience customers and sell them at their place. But they can see the invoices online.
public class CustomerBean implements java.io.Serializable {

	private String id;
	private String password;

	public final String getId() { return id; }
	public final void setId(String value) { id = value; }

	public final String getPassword() { return password; }
	public final void setPassword(String value) { password = value; }
	//JDBC Connections
	public boolean authenticate() throws SQLException {//Here we are using the param sql
		try(var con = DB.connect()){
			var pstmt = con.prepareStatement("select count(cust_id) from customers where cust_id=? and pwd=?");//first here give "? mark" and then according to the jdbc rule and then parse them saperately 
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			var rs = pstmt.executeQuery();//If you use/ask the uname and pwd are right then you can show the new column added to the browser.And if the id and pwd don't match then it will return 0.
			rs.next();
			int count = rs.getInt(1);
			rs.close();
			pstmt.close();
			if(count == 1)//id and pwd matches
				return true;
			id = password = null;//if id and pwd don't match
			return false;
		}
	}
//It will return the list of the customer orders 
	public List<OrderEntry> getOrders() throws SQLException {
		//accept the orders and store them in Arraylist  and then return the output in the form of the list  
		var orders = new ArrayList<OrderEntry>();
		try(var con = DB.connect()){
			var pstmt = con.prepareStatement("select pno, qty, ord_date from orders where cust_id=?");
			pstmt.setString(1, id);
			var rs = pstmt.executeQuery();
			while(rs.next())
				orders.add(new OrderEntry(rs));
			rs.close();
			pstmt.close();
		}
		return orders;
	}


	public static class OrderEntry {

		private int productNo;
		private int quantity;
		private java.sql.Date orderDate;

		OrderEntry(ResultSet rs) throws SQLException {
			productNo = rs.getInt("pno");
			quantity = rs.getInt("qty");
			orderDate = rs.getDate("ord_date");
		}

		public final int getProductNo() { return productNo; }

		public final int getQuantity() { return quantity; }

		public final java.sql.Date getOrderDate() { return orderDate; }
	}
}

