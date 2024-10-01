class Program {
/*
Code 1: Simple Method Overloading

What's happening: The select method is overloaded for String and double types. It takes two values and 
selects one based on whether the provided index is odd or even.
Type-safety: If you try to mix types (e.g., passing a String and a double), the compiler will throw an
error. This ensures that only compatible types are passed, making the code type-safe.
Drawback: You have to write a separate method for each type (String, double, etc.), which can become 
tedious if there are many types.
 */
	// This methods are typesafe but issue is we need to write the code for each datatype.
	private static String select(int index, String first, String second) 
	{
		if((index % 2) == 1)
			return first;
		return second;
	}

	private static double select(int index, double first, double second) 
	{
		if((index % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) 
	{
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(s, 45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);
			//double sd2 = select(s, "9.5", 5.9);// here we are checking whether the program is typesafe
			//typesafe means if we are passong the string and double type then will the i/p be accepted
		}
	}
}

