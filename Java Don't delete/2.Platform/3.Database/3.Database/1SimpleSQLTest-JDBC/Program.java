import java.sql.*;
//this is simple sql program which is basic and at the same time prone to the user hacking database so we use the params sql commands
class Program {

	public static void main(String[] args) throws Exception {
		//step 1 - make the connection
		Connection con = DriverManager.getConnection("jdbc:sqlite:sales.db", "", "");//takes 3 parameters
		// getconnection will pass url:"jdbc:sqlite:sales.db" to every driver in the path unless it finds match
		// System.out.println(con.getClass());
		// step 2 - create the statement
		Statement stmt = con.createStatement();
		if(args.length == 0){//only simply run the program on command line
			//step 3 - fetch the results
			ResultSet rs = stmt.executeQuery("select pno, price, stock from products");
			while(rs.next())
				System.out.printf("%d\t%.2f\t%d%n", rs.getInt(1), rs.getDouble(2), rs.getInt("stock"));
			rs.close();
		}else{//in this program we are increasing the stock by 5
			//for updating the product info
			int id = Integer.parseInt(args[0]);
			int n = stmt.executeUpdate("update products set stock=stock+5 where pno=" + id);//if its updated it will update or else it will go to next step
			//if not updated then it will print next line
			if(n == 0)
				System.out.println("No such product!");
		}
		stmt.close();
		con.close();
	}
}

