import java.lang.reflect.*;
//this is the program for late binding (i.e.class name and method are accepted at runtime from the user)
//e.g. java ReflectionTest2 500000 finance."Enter the name of loan class" "Enter the category"
class Program {
//take class name> get method name of class> then from that method create object of interest class and then calculate
	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);//we will take the classname from the user at the runtime
		//Now we are asking method to calculate interest having first para as double and other para as int 
		Method category = c.getMethod(args[2], double.class, int.class);
		Object scheme = c.getConstructor().newInstance();//here we are asking for parameterless constructor
		// c.getConstructor(double.class,int.class)==> to get the parameterised constructor
		//here first we have created the instance /object of the class using the constructor
		int limit = 10;//by default limit for loan
		for(int n = 1; n <= limit; ++n){
			float r = (float)category.invoke(scheme, p, n);//we are invoking the method==> late binding
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%16.2f%n", n, emi);
		}
	}
}

