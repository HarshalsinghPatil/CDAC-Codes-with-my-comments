package shopping;//in video lec sir used sales package

import java.rmi.*;
import java.util.*;
/*	==> first of all we will create interface because the services share 
	a) its operation  and b) schema of the data exchanged
	==> 
*/ 
//we need to convert it into the rmi service object
public interface OrderManager extends Remote {
//here we have two functions 
//1. to Place the order 
	int placeOrder(String customerId, int productNo, int quantity) throws RemoteException;
//2. to recieve data from database using customer id and gives output in form of List of order entity
	List<OrderEntity> fetchInvoice(String customerId) throws RemoteException;
}

