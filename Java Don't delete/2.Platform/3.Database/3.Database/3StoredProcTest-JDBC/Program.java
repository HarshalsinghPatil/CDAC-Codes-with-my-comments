import java.sql.*;
//for checking that order quatity is in stock or not
class Program {

	public static void main(String[] args) throws Exception {
		String customerId = args[0].toUpperCase();
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]); 
		//thin ==> directly connects to database
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//iitdac.met.edu/xe", "scott", "tiger");//connect to oracle on met server
		//to call stored procedure test
		CallableStatement cstmt = con.prepareCall("{call place_order(?, ?, ?, ?)}");//oracle and sql supports stored procedure test
		cstmt.setString(1, customerId);
		cstmt.setInt(2, productNo);
		cstmt.setInt(3, quantity);
		cstmt.registerOutParameter(4, Types.INTEGER);//In db it's type is "OUT"=>this value is suppossed to come from the database>> so we cant set the value >> but we are expectiong interger value here
		try{
			cstmt.execute();
			int orderNo = cstmt.getInt(4);//we are storing that int value into order no and print it.
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){//we can print exactly what type of error it is but we don't want to bother the user about our technical errors
			System.out.println("Order Failed!");
		}
		cstmt.close();
		con.close();
	}
}

