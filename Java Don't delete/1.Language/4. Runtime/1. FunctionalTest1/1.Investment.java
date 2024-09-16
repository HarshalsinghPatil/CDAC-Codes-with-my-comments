/* 
first program functional interface 
In java runtime if we have to achieve the things like function pointer then
this can be achieved through function callback using 
	1. Functional interface ==>  program1
	2. Method referencing ==> program2
*/
//functional interface=> we took here functional interface because we 
//are passing function inside the function see program1
interface InterestRate {
	float forPeriod(int years);
}

// for fields we hava used  "Final keyword" ==> 
//this class produces immutable object whose state cannot be changed
//after instantiation
class Investment {

	//final instance field can only be initialized in the constructor
	private final double payment;
	private final int years;
//constructors
	public Investment(double payment, int years) {
		this.payment = payment;
		this.years = years;
	}

	public double payment() {
		return payment;
	}

	public int years() {
		return years;
	}
//step 1 : " InterestRate " is functional interface of which we are using object (not creating a new object)
	public double futureValue(InterestRate interest) {
		//Step 2 : on that object of functional interface we are calling a method==> method referencing
		float i = interest.forPeriod(years) / 100;
		return (payment / i) * (Math.pow(1 + i, years) - 1);
	}
}

