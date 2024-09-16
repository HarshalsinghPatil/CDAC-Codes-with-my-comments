/*1
class Program {

	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		var c = Class.forName(args[1]);
		var category = c.getMethod(args[2], double.class, int.class);
		var scheme = c.getConstructor().newInstance();
		//here we are using the annotation
		// sometimes we give loan for period
		// 1. personal loan = 3 years
		// 2. Home loan = up to 25 years
		// 3. Education loan = up to 5 years
		
		int limit = 5;
		//check does annotation present in the class of c 
		if(c.isAnnotationPresentMaxDuration.class)){
			//here we asking for the value using the object c
			MaxDuration md = c.getAnnotation(MaxDuration.class);
			limit = md.value();
		}
		for(int n = 1; n <= limit; ++n){
			float r = (float)category.invoke(scheme, p, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%16.2f%n", n, emi);
		}


		}
	}
}
*/

class Program {

	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		var c = Class.forName(args[1]);
		var category = c.getMethod(args[2], double.class, int.class);
		var scheme = c.getConstructor().newInstance();
		//here we are using the annotation
		/*sometimes we give loan for period
		1. personal loan = 3 years
		2. Home loan = up to 25 years
		3. Education loan = up to 5 years
		*/
		var md = interest.getAnnotation(finance.MaxDuration.class);
		int limit = md != null ? md.value() : 10;
		for(int n = 1; n <= limit; ++n){
			float r = (float)category.invoke(scheme, p, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%16.2f%n", n, emi);
		}
	}
}



