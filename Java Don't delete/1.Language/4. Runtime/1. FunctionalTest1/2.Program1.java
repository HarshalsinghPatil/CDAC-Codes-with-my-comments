
class Program {

	static class SafeScheme implements InterestRate {
		
		public float forPeriod(int n) {
			return n < 3 ? 6 : 7;
		}
	}

	public static void main(String[] args) {
		//Take input from the user
		var input = new java.util.Scanner(System.in);
		System.out.print("Enter payment and years: ");
		double p = input.nextDouble();
		int y = input.nextInt();
		//create object of Investment class
		var inv = new Investment(p, y);

		
		//we are calling the method on the object of the functional interface
		System.out.printf("Future value of riskless investment = %.2f%n", inv.futureValue(new SafeScheme()));
	}
}

