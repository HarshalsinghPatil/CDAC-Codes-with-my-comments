using System;

class Program 
{//This method is called from main()
	private static void Decide(ref Investment x)//recieved as the reference
	{
		//if total amount is less than 5 lakh only then it will allow the risk==> smart investment
		x.AllowRisk(x.TotalAmount() < 500000);
	}

	//in java we need to give the references form one side but here in the C# we need to declare the reference from both the sides. The one who pass the argument must know that his argument or object can be used as the reference.
	public static void Main(string[] args)
	{
		Console.WriteLine("Welcome Visitor!");

		//Taking input from console 
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);

		// creating object
		Investment inv = new Investment(p, n);
		//w/o risk
		Console.WriteLine("Future value of safe investment: {0:0.00}", inv.FutureValue());//here we are calling the method on object so no need to pass the arguments

		//with the risk
		inv.AllowRisk(true);
		Console.WriteLine("Future value of riskful investment: {0:0.00}", inv.FutureValue());

		//making the smart investment
		//passing the reference of the class to the method
		Decide(ref inv);//i.e. we are passing by reference and not by pass by value
		Console.WriteLine("Future value of smart investment: {0:0.00}", inv.FutureValue());
	}
}
