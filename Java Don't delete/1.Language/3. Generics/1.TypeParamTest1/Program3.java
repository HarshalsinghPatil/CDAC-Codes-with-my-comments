class Program {
	/*
	Code 3: Using Generics (Type-safe and Flexible)
	Problems:
	a. Datatype - type safty but duplication of code for datatype
	b. object - here code reduced but no datatype safety
	Solution: 
	1. Here instead of datatype or object we are using Generic "T" type
	means it will check is the things are of same type e.g double-double,
	string-string , object-object.
	2. In second select method - 
	=> T extends Comparable<T> means that the method can only accept types that can be compared. 
	Examples of types that implement Comparable:
		Numbers (Integer, Double, etc.)
		Strings (String)
		Custom types that implement Comparable (like Interval in the example).
	*/

	//a generic method declaration with type-parameter T
	private static <T> T select(int index, T first, T second) {
		if((index % 2) == 1)
			return first;
		return second;
	}

	//a generic method declaration with type-parameter T
	//bounded by java.lang.Comparable<T> to extend set of 
	//members supported by T with the members of java.lang.Comparable<T>
	private static <T extends Comparable<T>> T select(T first, T second){
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0)
		{
			int s = Integer.parseInt(args[0]);
			String ss = select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			//auto-boxing - enclosing a value of primitive type (double) 
			//within an instance of its wrapper class (java.lang.Double)
			//so that it can be passed in place of java.lang.Object
			double sd = select(s, 45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);			
			//double sd2 = select(s, "9.5", 5.9);
		}
		else
		{
			String ss = select("Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(45.6, 76.5);
			System.out.printf("Selected double = %s%n", sd);
			Interval si = select(new Interval(4, 50), new Interval(3, 45));//here it is even comparing objects
			System.out.printf("Selected Interval = %s%n", si);
		}
	}
}

/*
Let's break it down further in simpler language, focusing on the key points of how generics work in this code.

What is a "Generic" Method?
A generic method allows the same method to work with different types of data, without having to rewrite the method for each type.

Key Concept:
<T>: This is a placeholder for any type (it could be a String, Integer, Double, etc.). The T acts like a "variable" that can be any data type.
The First select Method
java
Copy code
private static <T> T select(int index, T first, T second) {
    if ((index % 2) == 1)
        return first;
    return second;
}
What does it do?
This method takes three parameters:
An int (index)
Two values of type T (first and second), which could be any type (e.g., String, double, etc.).
It checks if the index is odd or even:
If odd (index % 2 == 1), it returns the first value.
If even, it returns the second value.
What's great about this?:
You can call this method with any type of values (e.g., String, double, Integer), and it will work without having to create separate methods for each type.
The Second select Method (Using Comparable)
java
Copy code
private static <T extends Comparable<T>> T select(T first, T second) {
    if (first.compareTo(second) > 0)
        return first;
    return second;
}
What does it do?
This method compares two values (first and second) to see which one is "greater."

T extends Comparable<T> means that the method can only accept types that can be compared. Examples of types that implement Comparable:

Numbers (Integer, Double, etc.)
Strings (String)
Custom types that implement Comparable (like Interval in the example).
How does it compare values?

The compareTo() method is used to compare the two values.
If first is greater than second, it returns first.
Otherwise, it returns second.
Main Method Explanation
java
Copy code
public static void main(String[] args) {
    if (args.length > 0) {
        int s = Integer.parseInt(args[0]);
        String ss = select(s, "Monday", "Friday");
        System.out.printf("Selected String = %s%n", ss);
        double sd = select(s, 45.6, 76.5);
        System.out.printf("Selected double = %s%n", sd);
    } else {
        String ss = select("Monday", "Friday");
        System.out.printf("Selected String = %s%n", ss);
        double sd = select(45.6, 76.5);
        System.out.printf("Selected double = %s%n", sd);
        Interval si = select(new Interval(4, 50), new Interval(3, 45));
        System.out.printf("Selected Interval = %s%n", si);
    }
}
If you pass an argument (like a number) when running the program, the select method chooses between values (Monday or Friday, or 45.6 or 76.5) based on whether the number is odd or even.

If you don’t pass any argument, the program:

Chooses between "Monday" and "Friday",
Chooses between 45.6 and 76.5 (based on the greater value using the second select method),
Compares two Interval objects (a custom type) to select the greater one.
Why is This Great?
No More Method Overloading:
Instead of writing one select method for each type (String, double, etc.), you now have a single method that works for any type.
Type-Safety:
You can't accidentally pass incompatible types (like a String and a double). The compiler makes sure that the types you pass are correct.
Comparison with Comparable:
For types that can be compared (like numbers or strings), you can use the second select method to choose the greater one.
Summary:
The code uses generics to allow the select method to work with any type (T can be any type).
The first select method picks between two values based on whether a number is odd or even.
The second select method picks the "greater" of two values but only works for types that can be compared (Comparable).
This makes the code more flexible and type-safe without needing many overloaded methods.

*/