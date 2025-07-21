using System;//similar to java.lang

class Program 
{
	public static void Main(string[] args)
	{
		// Console.WriteLine("Hi I am harshalsingh");
		Console.WriteLine("Welcome Investor!");
		//Taking input from the user
		double payment = double.Parse(args[0]);//PAYMENT
		int n = int.Parse(args[1]);//HOW MANY TIMES DONE
		// checking default investment==> false
		Console.WriteLine("Future value of safe investment: {0:0.00}",Investment.FutureValue(p, n));
			//changing the risk investment to true
		Console.WriteLine("Future value of riskful investment: {0:0.00}",Investment.FutureValue(p, n, true));
	}
}
