/*
	Code 2: Using Object (Not Type-safe)

	What's happening: The select method is now more flexible because it accepts Object as parameters. 
	This allows you to pass any type of object (e.g., String, double, etc.).
	Auto-boxing: When you pass a primitive type like double, Java automatically converts it into its 
	corresponding wrapper class (e.g., Double), because Object can only hold reference types.
	Drawback: The program loses type safety. You need to manually cast the result to the expected 
	type (e.g., casting to String or double). If you make a mistake (like passing incompatible types), 
	you'll only know at runtime, which can lead to errors and crashes (e.g., select(s, "9.5", 5.9) 
	throws a runtime error).

 */

class Program {

	private static Object select(int index, Object first, Object second) {
		if((index % 2) == 1)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = (String)select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);

			//auto-boxing - enclosing a value of primitive type (double) 
			//within an instance of its wrapper class (java.lang.Double)
			//so that it can be passed in place of java.lang.Object
			
			double sd = (double)select(s, 45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);
			double sd2 = (double)select(s, "9.5", 5.9);
		}
	}
}

