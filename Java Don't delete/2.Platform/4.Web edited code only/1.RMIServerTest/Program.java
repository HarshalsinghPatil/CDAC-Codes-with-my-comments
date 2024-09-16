/*The logic behind this program 
1. Our salesperson travels here to there and takes the order.
Step 1 : always first create shop domain entities(orders and counters class mapped to tables using jpa) to communicate with the database.
		compile:
		javac -d . src/*.java 
Step 2 : ls ~/jars/ ==> to see all drivers eclipselink/mysql/sqlite/jakarta/oracle(ojdbc)
kim: some times micro services don't share data at that sql lite works beutifully
Step 3 : 
 */
import shopping.*;
import java.rmi.*;
//In this program we are using combined jpa
//1. Jpa using orm.xml ==> order table => to map into program create pojo of order class and map using orm.xml
//2. Jpa using annotations ==> counters table => to map into program create pojo of counter class and map using annotation

class Program {

	public static void main(String[] args) throws Exception {
		//calling the hosted Service from OrderManagerService
		var stub = (OrderManager)Naming.lookup("rmi://localhost:6000/orderManager");
		//stub as the proxy of the remote object on which we are going to perform all the operations
		
		String customerId = args[0].toUpperCase();
		if(args.length > 2){

			int productNo = Integer.parseInt(args[1]);
			int quantity = Integer.parseInt(args[2]);
			try{
				int orderNo = stub.placeOrder(customerId, productNo, quantity);//Stub is used place the order
				System.out.printf("New Order Number: %d%n", orderNo);
			}catch(Exception e){
				System.out.println("Order Failed: " + e);//if we are fail to get order
			}
		}else{
			var orders = stub.fetchInvoice(customerId);
			for(var entry : orders)//to enter the orders into the database table (Orders)
				System.out.printf("%d\t%d\t%tF%n", entry.getProductNo(), entry.getQuantity(), entry.getOrderDate());
		}
	}
}

