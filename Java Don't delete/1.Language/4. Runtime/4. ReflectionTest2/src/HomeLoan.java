package finance;

public class HomeLoan {
	//@MaxDuration(value = 12)
	@MaxDuration(12)// we have kept the maxvalue interface 5 years but here we are keeping it 12 years
	public float common(double amount, int period) {
		return amount < 1000000 ? 9 : 8;
	}

	public float woman(double amount, int period) {
		return common(amount, period) - 1;
	}

	public float soldier(double amount, int period) {
		return 4;
	}
}

