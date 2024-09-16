import java.util.*;
//java.util.stream supports the functional programming
// we need version greater than java 16 to use the functional programming
//we had imported java.util.Record() to use the record class

class Program {

	public static void main(String[] args) {
		if(args[0].equals("items")){//print brand according to the item name
		//Declarative programming
			var items = Shop.getItems();//here we are getting complete list of items
			
			/*Imperative programming
			foreach item of Items class
			for(var item:items){
				if(item.brand().equals(args[1]))
					System.out.println(Item.name());
			}
			*/
			Arrays.stream(items)//we are converting that list in to stream of bytes
				.filter(i -> i.brand().equalsIgnoreCase(args[1]))//filter according to the brand
				.map(i -> i.name())//then map the name acc to brand
				.forEach(System.out::println);//Method referencing with functional programming
		}else if(args[0].equals("customers")){// Here are planning to sort according to the atleast minimum arg[1] amount
			double min = Double.parseDouble(args[1]);//minimum purchase amount
			var customers = Shop.getCustomers();
			customers.stream()//to increase the speed we first sort and then map
				.filter(c -> c.purchase() >= min)//lambda function
				.sorted()
				.map(c -> "*".repeat(c.rating()) + "\t" + c.id())
				.forEach(System.out::println);//method referencing
		}
	}
}

