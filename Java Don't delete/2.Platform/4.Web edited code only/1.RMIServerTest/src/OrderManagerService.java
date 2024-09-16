package shopping;
//create a class to implement interface OrderManager
import java.rmi.*;
import java.util.*;
import javax.persistence.*;
//having only rmi
public class OrderManagerService extends java.rmi.server.UnicastRemoteObject implements OrderManager {
//when u create orderManagerService u will get a remote object bcoz we are implementing atleat one remote interface
//when u create a object of the class  you will get the remote object and exported object. because having remote object is not enough but u also need to connect to endpoints on remote objects to extablish the connection
	private static final int PORT = 6000;

	public OrderManagerService() throws RemoteException {
		super(PORT); //export this object on specified TCP/IP port
	}
	//
	/* implementation of the methods declared in the OrderManager interface
			below is the bare structure of the method 
			
	1. Place Order method
	   	public int placeOrder(String customerId, int productNo, int quantity) {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();//entity manager
		try{
			var tx = em.getTransaction();
			tx.begin();
			//business logic
			tx.commit(); 
			return orderNo;
		}finally{
			em.close();
		}

		2. FetchInvoice
		public List<OrderEntity> fetchInvoice(String customerId) {
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();	
		try{	
	
		}finally{	
			em.close();
			}
		}
	}
	 */
	public int placeOrder(String customerId, int productNo, int quantity) {
		var emf = Persistence.createEntityManagerFactory("SalesPU");//factory
		var em = emf.createEntityManager();//entity manager
		try{
	//this code inside try block is the business logic
			//to place order first increment the value of counter table and then place the order.
			
			var tx = em.getTransaction();//load entities using JPQL from tables and handles persistance of these entities from in transactional manner
			tx.begin();//begin transaction
			var ctr = em.find(CounterEntity.class, "orders");//find the orders row from the counter entity table
			int orderNo = ctr.getNextValue() + 1000;//to place order we will increase the value of order according to the number of orders recieved
			var ord = new OrderEntity();//it is created on heap memory
			ord.setOrderNo(orderNo);
			ord.setOrderDate(new Date());
			ord.setCustomerId(customerId);
			ord.setProductNo(productNo);
			ord.setQuantity(quantity);
			em.persist(ord);//to save the order from heap memory to the database(Insert the state of entity referred by ord into database)
			tx.commit(); //tx will rollback if commit is not called ==> end transaction
			return orderNo;
		}finally{
			em.close();//closing the entity manager
		}
	}

	public List<OrderEntity> fetchInvoice(String customerId) {
		//It will be better if order entity don't contain something specific to JPA(It must be pojo)
		var emf = Persistence.createEntityManagerFactory("SalesPU");
		var em = emf.createEntityManager();	
		try{	
			var query = em.createQuery("SELECT e FROM OrderEntity e WHERE e.customerId=?1", OrderEntity.class);	
			query.setParameter(1, customerId);
			return query.getResultList();
		}finally{	
			em.close();
		}
	}
	//sirs reccomondation => order entity part of schema=> so it need to be shared with client programmer.
	//but we only share description of operations& schema.In this case orm.xml is very helpful
	//whereas If we use Annotation JPA -> violates service oriented architecture.

	public static void main(String[] args) throws Exception {
		// creating the webService and bind it to endpoint
		var naming = java.rmi.registry.LocateRegistry.createRegistry(PORT);
		//Hosting the OrderManagerService on the registry 
		naming.bind("orderManager", new OrderManagerService());
	}
}

