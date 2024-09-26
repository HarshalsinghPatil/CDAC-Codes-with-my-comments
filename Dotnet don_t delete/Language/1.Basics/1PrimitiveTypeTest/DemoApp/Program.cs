using System;//similar to java.lang

class Program 
{
	public static void Main(string[] args)
	{
		// Console.WriteLine("Hi I am harshalsingh");
		Console.WriteLine("Welcome Investor!");
		//Taking input from the user
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		// checking default investment==> false
		Console.WriteLine("Future value of safe investment: {0:0.00}",Investment.FutureValue(p, n));
			//changing the risk investment to true
		Console.WriteLine("Future value of riskful investment: {0:0.00}",Investment.FutureValue(p, n, true));
	}
}
