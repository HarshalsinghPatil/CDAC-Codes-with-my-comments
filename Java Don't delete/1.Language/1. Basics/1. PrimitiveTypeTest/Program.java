class Program {

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int i = Integer.parseInt(args[1]);

	//we can call static method using its classname  w/o creating an object

		System.out.printf("Future value of safe investment: %.2f%n", Investment.futureValue(p, i));
	}
}

