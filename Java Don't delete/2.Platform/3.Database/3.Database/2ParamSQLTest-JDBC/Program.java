//in previous program ,if we are taking inpute from the user  in "int" format to update database table . Then we need to take parse the information to int format. But what if the user passes the string then we cant parse it. user can pass his commands e.g drop table known as ==> "user injections" and can hack our  database .So to avoid this we use the params
//connect to MySQL database
import java.sql.*;

class Program {

	public static void main(String[] args) throws Exception {
		//to place order by a customer
		String customerId = args[0].toUpperCase();//name of customer
		int productNo = Integer.parseInt(args[1]);
		int quantity = Integer.parseInt(args[2]);
		Date today = new Date(System.currentTimeMillis());//generate todays date
		/*	IN Java for using dates we have two packages
		1. java.util.date;==> for general programs ==> new Date()
		2. java.sql.date;==> for all database operations ==> new Date(System.currentTimeMillis())
		*/
		//step 1:create the connection
		Connection con = DriverManager.getConnection("jdbc:mysql://iitdac.met.edu/sales", "dbpro", "Dbpro@789");//this is hussain sirs username and password don't use it
		con.setAutoCommit(false);//means we will commit everything from now by ourself
		try{
			//step 2 : create the statement
			// var stmt = con.createStatement();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("update counters set cur_val=cur_val+1 where ctr_name='orders'");
			//step 3: fetch info from result statement
			ResultSet rs = stmt.executeQuery("select cur_val+1000 from counters where ctr_name='orders'");//execute query don't fetch the data so don't be idiot
			rs.next();//its important to fetch the data
			int orderNo = rs.getInt(1);//get the order number
			rs.close();
			stmt.close();
			// prepare the post statement to insert 5 column of values in to the database
			PreparedStatement pstmt = con.prepareStatement("insert into orders values (?, ?, ?, ?, ?)");//parameterised sql here we have not provided  datatype inside them but we just provide the "?" in
			//then below prepared statement provide each value with its datatype carefully.this will save database of company. Otherwise if anything gets wrong then i.e hacking or deletion of database ==> you are fired and in jail( because company think you are paid by the competitors  and you deleberately made the database hacked)
			pstmt.setInt(1, orderNo);
			pstmt.setDate(2, today);
			pstmt.setString(3, customerId);
			pstmt.setInt(4, productNo);
			pstmt.setInt(5, quantity);
			pstmt.executeUpdate();//
			pstmt.close();
			con.commit();//now all the data is permanently saved
			System.out.printf("New Order Number: %d%n", orderNo);
		}catch(SQLException e){
			con.rollback();//Consistent
			System.out.println("Order Failed!");
		}
		con.close();
	}
}//this program need to be installed on saperate machine again
/*
1. Atomic:create table and drop table are  not used(which can't be cancelled by rollback)
2. Consinstent:any violation happens it will rollback  the transactions.
3. Isolated: first update (lock) and then selecting the rows(so that other person can not make changes to the database).
4. Durable : at the end of transaction commit(if transactions is successful) or rollback(if we get sql exception) must surely happen.
 */
