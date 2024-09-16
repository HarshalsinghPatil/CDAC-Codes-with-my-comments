class Program {
//in this program we are calling the methods on the object (Specifically getters)
	public static void printAsXml(Item info) {//to call this method 2 parameters are required
		System.out.println("<Item>");
		System.out.printf("  <name>%s</name>%n", info.name());
		System.out.printf("  <brand>%s</brand>%n", info.brand());
		System.out.println("</Item>");
		System.out.println();
	}

	public static void printAsXml(Customer info) {//to call this method 3 parameters are required
		System.out.println("<Customer>");
		System.out.printf("  <id>%s</id>%n", info.id());
		System.out.printf("  <purchase>%s</purchase>%n", info.purchase());
		System.out.printf("  <rating>%s</rating>%n", info.rating());
		System.out.println("</Customer>");
		System.out.println();
	}

	public static void main(String[] args) {
		printAsXml(new Item("cpu", "intel"));
		printAsXml(new Item("ssd", "samsung"));
		printAsXml(new Customer("Alex", 45000, 3));
	}
}

